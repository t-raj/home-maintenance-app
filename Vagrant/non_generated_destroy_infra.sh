#!/bin/bash

#reading data from output of create_infra.sh
ec2instance_id=""
security_group_id=""
privsub_id=""
pubsub_id=""
pubsub_id="" #don't think we need this one without an RDS
priv_route_id=""
igw_id=""
vpc=""
natgw_id=""

#destroying infrastructure
aws ec2 terminate-instances --instance-ids ${ec2instance_id}
aws ec2 delete-security-group --group-id ${security_group_id}
aws ec2 delete-subnet --subnet-id ${privsub_id}
aws ec2 delete-subnet --subnet-id ${pubsub_id}
aws ec2 delete-route-table --route-table-id ${pub_route_id}
aws ec2 delete-route-table --route-table-id ${priv_route_id}
aws ec2 detach-internet-gateway --internet-gateway-id ${igw_id} --vpc-id ${vpc}
aws ec2 delete-internet-gateway --internet-gateway-id ${igw_id}
aws ec2 delete-nat-gateway --nat-gateway-id ${natgw_idn}
aws ec2 delete-vpc --vpc-id ${vpc}
