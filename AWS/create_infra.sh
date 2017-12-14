#!/bin/bash

region="us-west-2"
vpc_block="10.0.0.0/16"
profile="home"
private_subnet="10.0.0.0/24"
main_tag="Home_App"
endfile="all_instances.txt"
destroy_file="generated_destroy_infra.sh"


test -e $endfile && rm -rf $endfile
touch $endfile

test -e $destroy_file && rm -rf $destroy_file
touch $destroy_file

# Create user and get access keys
aws iam create-user --user-name $profile
aws iam create-access-key --user-name home
echo -n "Please enter the AWS Access Key ID and Secret Access Key when prompted."
echo -n "For the default region name enter: " $region " for the default output format enter: json"
aws configure

# Create group and add permissions
aws iam create-group --group-name Admins
aws iam attach-group-policy --group-name Admins --policy-arn arn:aws:iam::aws:policy/AdministratorAccess
aws iam add-user-to-group --user-name home --group-name Admins

# Create VPC
aws ec2 create-vpc --cidr-block ${vpc_block} --region ${region} --profile ${profile}
echo -n "Please enter the VPC ID to tag it correctly: "
read vpc
echo -n "VPC: $vpc\n" >> $endfile
aws ec2 create-tags --resources ${vpc} --tags Key=Name,Value=${main_tag} --profile ${profile}

# Create Subnet
aws ec2 create-subnet --vpc-id ${vpc} --cidr-block ${private_subnet}
echo -n "Please enter the subnet id: "
read privsub_id
echo -n "PRIVSUBID: $privsub_id\n" >> $endfile
aws ec2 create-tags --resources $privsub_id --tags Key=Name,Value=${main_tag} --profile ${profile}

# Create Private RouteTable and Associate it to private subnet
aws ec2 create-route-table --vpc-id $vpc --region ${region} --profile ${profile}
echo -n "Please enter the route table id: "
read priv_route_id
echo -n "PRIVROUTEID: $priv_route_id\n" >> $endfile
aws ec2 create-tags --resources $priv_route_id --tags Key=Name,Value=private_${main_tag} --profile ${profile} --region ${region}
aws ec2 associate-route-table  --subnet-id $privsub_id --route-table-id $priv_route_id --profile ${profile} --region ${region}
aws ec2 describe-route-tables --route-table-id $priv_route_id  --profile ${profile} --region ${region}

# Create 1 EC2 Instance
aws ec2 create-key-pair --key-name MyKeyPair --query 'KeyMaterial' --output text > MyKeyPair.pem
chmod 400 MyKeyPair.pem


aws ec2 create-security-group --group-name SSHAccess --description "Security group for SSH access" --vpc-id $vpc
echo -n "Please enter the security group id: "
read security_group_id
echo -n "SECURITYGROUPID: $security_group_id\n" >> $endfile
aws ec2 authorize-security-group-ingress --group-id ${security_group_id} --protocol tcp --port 22 --cidr 0.0.0.0/0
aws ec2 run-instances --image-id ami-bf4193c7 --count 1 --instance-type t2.micro --key-name MyKeyPair.pem --security-group-ids $security_group_id --subnet-id $privsub_id --profile ${profile} --region ${region}


echo -n "Please enter the ec2 instance id: "
read ec2instance_id
echo -n "EC2ID: $security_group_id\n" >> $endfile
aws ec2 create-tags --resources $ec2instance_id --profile ${profile} --region ${region}
aws ec2 describe-instances --instance-id $ec2instance_id

echo -n "Please enter the public IP: "
read public_ip
echo -n "PUBLICIP: $public_ip\n" >> $endfile

#setting up destory_infra.sh, need to destroy ec2 first
echo -n "aws ec2 terminate-instances --instance-ids ${ec2instance_id}\n" >> $destroy_file
echo -n "aws ec2 delete-security-group --group-id $security_group_id\n" >> $destroy_file
echo -n "aws ec2 delete-subnet --subnet-id $privsub_id\n" >> $destroy_file
echo -n "aws ec2 delete-route-table --route-table-id $priv_route_id\n" >> $destroy_file
echo -n "aws ec2 delete-vpc --vpc-id $vpc\n" >> $destroy_file

echo -n "You are now logging in to your EC2 instance."
ssh -i "MyKeyPair.pem" ec2-user@ec2-$public_ip.us-west-2.compute.amazonaws.com
