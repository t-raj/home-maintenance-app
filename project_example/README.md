Final Childs, Raj Project Part 2
============================

DIRECTIONS
==========

## Vagrant

###Run the following commands:

vagrant up --provision    *...to create a vagrant machine and set it up for app use*

vagrant ssh    *...to log into the machine*

###You are now logged in to vagrant, in vagrant vm run commands:

sudo su home    *...to log in as the service user "home"*

cd /opt/home_app    *...to move to the directory where the app is located*

java Menu    *...to run the app*

###You are now using the app, when you have entered your info run commands:

save    *...to save your info in the app*

exit    *...to exit the app*

ls    *...to see your saved info in a .txt file (YourName.txt)*

exit    *...to exit the service user login*

logout    *...to exit the vagrant machine*

vagrant destroy    *...to remove the vagrant machine*

## AWS

