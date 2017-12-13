Final Project Childs, Raj
=========================

This application is a prototype in Java that is user interactive and helps homeowners/renters keep track of routine maintenance information.

App Instructions
================

1. Set up your account by entering `setup`
2. Set up your heater by entering the model of the heater.
3. Enter the last serviced date of the heater.
4. Enter `radiators` if your heating system is radiators, or `furnace` if its furnace.
5. Set up your light bulbs by entering the model of the light bulbs.
6. Enter the last serviced date of the light bulbs.
7. Set up your windows by entering the model of your windows.
8. Enter the last serviced date of the windows.
9. You have now set up your account. You can look through the list of objects that you saved by entering `list`.
10. You can add more objects to the list by entering `add` and entering the object name, model number, and last serviced date.
11. You can view the details of each object by entering `details` and entering which object you would like to view.
12. You can save by entering `save`.
13. You can exit by entering `exit`.

Infrastructure Instructions
===========================

## Vagrant

###Run the following commands:

`vagrant up --provision`    *...to create a vagrant machine and set it up for app use*

`vagrant ssh`    *...to log into the machine*

###You are now logged in to vagrant, in vagrant vm run commands:

`sudo su home`    *...to log in as the service user "home"*

`cd /opt/home_app`    *...to move to the directory where the app is located*

`java Menu`    *...to run the app*

###You are now using the app, see instructions above for details. When you have exited the app run commands:

`ls`    *...to see your saved info in a .txt file (YourName.txt)*

`exit`    *...to exit the service user login*

`logout`    *...to exit the vagrant machine*

`vagrant destroy`    *...to remove the vagrant machine and all of it's files*

## AWS

`aws iam create-user --user-name home` *...to create the user "home"*

`aws iam create-access-key --user-name home` *...to get access keys for "home"*

`aws configure` *...to create a profile for "home"*

AWS Access Key ID [None]: *...use Access Key ID output to console after last command*

AWS Secret Access Key [None]: *...use Secret Access Key output to console after last command*

Default region name [None]: *...enter "us-west-2"*

Default output format [None]: *... enter "json"*

`./create_infra.sh` *...to setup AWS infrastructure. Follow prompts in the console.*
