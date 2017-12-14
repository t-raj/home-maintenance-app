#!/bin/bash

aws ec2 terminate-instances --instance-ids i-02fc93fbf3cb77c04

sleep 1m

aws ec2 delete-security-group --group-id sg-345fd348

aws ec2 delete-subnet --subnet-id subnet-bc6f82e6

aws ec2 delete-route-table --route-table-id rtb-ee9ea397

aws ec2 delete-vpc --vpc-id vpc-27fa115e

aws iam remove-user-from-group --user-name home --group-name Home_App

aws iam delete-access-key --access-key AKIAIXAWJUSX7SS2O6KQ --user-name home

aws iam delete-user --user-name home

