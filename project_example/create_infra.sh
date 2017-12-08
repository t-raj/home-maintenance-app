#!/bin/bash

region="us-west-2"
vpc_block="10.0.0.0/16"
profile="lanerda"
public_subnet="10.0.1.0/24"
private_subnet="10.0.0.0/24"
main_tag="Intro_Home_App"
endfile="all_instances.txt"
destroy_file="generated_destroy_infra.sh"


test -e $endfile && rm -rf $endfile
touch $endfile

test -e $destroy_file && rm -rf $destroy_file
touch $destroy_file

# Create VPC
aws ec2 create-vpc --cidr-block ${vpc_block} --region ${region} --profile ${profile}
echo -n "Please enter the VPC ID to tag it correctly"
read $vpc
echo -n "VPC: $vpc\n" >> $endfile
aws ec2 create-tags --resources $vpc --tags Key=Name, Value=${main_tag} --profile ${profile}

# Create All Subnets
aws ec2 create-subnet --vpc-id ${vpc} --cidr-block ${public_subnet}
aws ec2 create-subnet --vpc-id ${vpc} --cidr-block ${private_subnet}
echo -n "Please enter the public_subnet id"
read $pubsub_id
echo -n "PUBSUBSID: $pubsub_id\n" >> $endfile
aws ec2 create-tags --resources $pubsub_id --tags Key=Name, Value=${main_tag} --profile ${profile}
echo -n "Please enter the private_subnet id"
read $privsub_id
echo -n "PRIVSUBID: $privsub_id\n" >> $endfile
aws ec2 create-tags --resources $privsub_id --tags Key=Name, Value=${main_tag} --profile ${profile}


# Create IGW
aws ec2 create-internet-gateway --region ${region} --profile ${profile}
echo -n "Please enter the igw id"
read $igw_id
echo -n "IGWID: $igw_id\n" >> $endfile
aws ec2 attach-internet-gateway --vpc-id $vpc --internet-gateway-id $igw_id --profile ${profile} --region ${region}
aws ec2 create-tags --resources $igw_id --tags Key=Name, Value=${main_tag} --profile ${profile}

#Create Custom Route Table for VPC and Assign to IGW
aws ec2 create-route-table --vpc-id $vpc --region ${region} --profile ${profile}
echo -n "Please enter the route table id"
read $pub_route_id
echo -n "PUBROUTEID: $pub_route_id\n" >> $endfile
aws ec2 create-route --route-table-id $pub_route_id --destination-cidr-block 0.0.0.0/0 --gateway-id $igw_id --profile ${profile} --region ${region}
aws ec2 create-tags --resources $pub_route_id --tags Key=Name, Value=public_${main_tag} --profile ${profile}
aws ec2 associate-route-table  --subnet-id $pubsub_id --route-table-id $pub_route_id --profile ${profile} --region ${region}
aws ec2 describe-route-tables --route-table-id $pub_route_id  --profile ${profile} --region ${region}


# Create Private RouteTable and Associate it to private subnet
aws ec2 create-route-table --vpc-id $vpc --region ${region} --profile ${profile}
echo -n "Please enter the route table id"
read $priv_route_id
echo -n "PRIVROUTEID: $priv_route_id\n" >> $endfile
aws ec2 create-tags --resources $priv_route_id --tags Key=Name, Value=private_${main_tag} --profile ${profile} --region ${region}
aws ec2 associate-route-table  --subnet-id $privsub_id --route-table-id $priv_route_id --profile ${profile} --region ${region}
aws ec2 describe-route-tables --route-table-id $priv_route_id  --profile ${profile} --region ${region}

# Create NATGateway and ElasticIP as well as Associate to Private Route Table
aws ec2 allocate-address  --profile ${profile} --region ${region}
echo -n "Please enter the elasticip id"
read $elastic_id
echo -n "ELASTICID: $elastic_id\n" >> $endfile
aws ec2 create-nat-gateway --profile ${profile} --region ${region}
echo -n "Please enter the nat gateway id"
read $natgw_id
echo -n "NATGWID: $natgw_id\n" >> $endfile
aws ec2 create-tags --resources $natgw_id --profile ${profile} --region ${region}
aws ec2 create-nat-gateway --subnet-id $pubsub_id --allocation-id $elastic_id
aws ec2 create-route --route-table-id $priv_route_id --destination-cidr-block 0.0.0.0/0 --gateway-id $natgw_id --profile ${profile} --region ${region}



# Create 1 EC2 Instance
aws ec2 create-key-pair --key-name DemoKeyPair --query 'KeyMaterial' --output text > DemoKeyPair.pem
chmod 400 DemoKeyPair.pem


aws ec2 create-security-group --group-name SSHAccess --description "Security group for SSH access" --vpc-id $vpc
echo -n "Please enter the security group id"
read $security_group_id
echo -n "SECURITYGROUPID: $security_group_id\n" >> $endfile
aws ec2 authorize-security-group-ingress --group-id $security_group_id --protocol tcp --port 22 --cidr 0.0.0.0/0
aws ec2 run-instances --image-id $vpc --count 1 --instance-type t2.micro --key-name  DemoKeyPair.pem--security-group-ids $security_group_id --subnet-id $public_subnet --profile ${profile} --region ${region}


echo -n "Please enter the ec2 instance id"
read $ec2instance_id
echo -n "EC2ID: $security_group_id\n" >> $endfile
aws ec2 create-tags --resources $ec2instance_id --profile ${profile} --region ${region}

#setting up destory_infra.sh, need to destroy ec2 first
echo -n "aws ec2 terminate-instances --instance-ids ${ec2instance_id}\n" >> $destroy_file
echo -n "aws ec2 delete-security-group --group-id $security_group_id\n" >> $destroy_file
echo -n "aws ec2 delete-subnet --subnet-id $privsub_id\n" >> $destroy_file
echo -n "aws ec2 delete-subnet --subnet-id $pubsub_id\n" >> $destroy_file
echo -n "aws ec2 delete-route-table --route-table-id $pub_route_id\n" >> $destroy_file
echo -n "aws ec2 delete-route-table --route-table-id $priv_route_id\n" >> $destroy_file
echo -n "aws ec2 detach-internet-gateway --internet-gateway-id $igw_id --vpc-id $vpc\n" >> $destroy_file
echo -n "aws ec2 delete-internet-gateway --internet-gateway-id $igw_id\n" >> $destroy_file
echo -n "aws ec2 delete-nat-gateway --nat-gateway-id $natgw_idn" >> $destroy_file
echo -n "aws ec2 delete-vpc --vpc-id $vpc\n" >> $destroy_file
