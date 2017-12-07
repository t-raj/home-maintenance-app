Example Final Project Part 2
============================

DIRECTIONS
==========

This is the minimum. \**PLEASE REPLACE my comments with yours about how to do everything. \**You will be graded on the README.md and how well you have written it for me to test (in vagrant), create, and destroy your infrastructure.

### Vagrant Testing

-	**MODIFY FOR YOUR PROJECT**

Part of the project is that I can create a vagrant instance that installs your whole project. This is separate from the infrastructure part. This is a very important step to make sure prior to deployment, that your linux environment works. This is needed to be a fully working vagrant environment for full points.

Steps to test flask_app on Vagrant VM:

-	vagrant up --provision - vagrant ssh
-	In vagrant vm run commands:
	-	sudo su -
	-	service flask_app status (should say active and green)
	-	lynx localhost:5000 (you should see a home page and like a signup and all that)
-	Exit out of Vagrant
-	Run: vagrant destroy

**FOR YOUR PROJECT make sure you RECREATE the deploy.tar.gz**

### Provisioner.

-	**MODIFY FOR YOUR PROJECT**

You app should be setup like I have mine in this script, unless you do not need a service but a crontab. If that is the case then modify accordingly to fit your *application needs*.

-	If you need a crontab please add a function to handle the adding of that crontab AND log cleanup!
-	Any other files you need to should to in the *linux_setup* folder, just like I did with the service files
-	Any extra scripts for log clean up as well should go to 'linux_setup' b/c that is what it is, setting up your linux environment to be workable.

This should be easy part, since you can take this script and just modify to your application.

### Setting Up Production Environment

-	**MODIFY FOR YOUR PROJECT**

-	Now that you know your application works lets setup the environment.

-	Although this script is not a *runnable script* you should be able to copy and paste the commands in the terminal and the user should replace the variable with the specified value it is expecting (this can be done by hand, no worries).

-	Each command should be able to create the infrastructure part you need (except for the RDS instance)

-	Please let the user know what type of RDS instance they need to create. And mention in the README the steps to do it.

#### RDS

-	*MODIFY FOR YOUR PROJECT*

-	If you have sql exported to created your databases, tables, and mock data please put it in the **sql** folder and **create a readme there**.

### Destroying Production Environment

-	*MODIFY FOR YOUR PROJECT*

-	Although this script is not a *runnable script* you should be able to copy and paste the commands in the terminal and the user should replace the variable with the specified value it is expecting (this can be done by hand, no worries).

-	Ideally the create_infra.sh script should be able to generate a destroy_infra.sh script. I added that in there, if that is something you want to work on if you have time. However I also added a *non_generated_destroy_infras.sh* script that users should be able to run by hand and replace with the data they need.

### Running provisioner on EC2 Instance

-	Just like the Vagrant file, you should scp the deploy.tar.gz to the EC2 instance via script

Example: scp deploy.tar.gz ec2-user@somehost:/tmp -i ~/.ssh/somekeypair.pem - now ssh into the ec2 instance and cd into tmp folder - run tar -xvzf deploy.tar.gz (just like the Vagrant does) - run ./provisioner.sh and it should setup your linux environment

MORE CLASS INFORMATION
----------------------

### Provisioner and Setting up Vagrant and/or Linux

*Note:* Every project is different some of you might have to include:

-	A crontab for you can clear logfiles out
-	Therefore your provisioner script will have to install a crontab and have a log_crontab file in folder linux_setup
-	If you install apache web service which is called httpd, make sure to run the chckconfig command with 'on' to have the service restart at boot. This willalso be down in your provisioner script.
-	Your project should be called via git cloning as oppose to untarring like the provisioner script.

If you have any inquiries please ASK!

### Vagrantfile

The vagrant file I provided sums up how I would like it setup for yourselves. Please modify it accordingly *FOR YOUR APP*

### SetUp and Destroy Scripts

I don't expect them to work as in I call the script and *BAM* it runs and everything is created. I **DO** expect to be able to call each command in these scripts line by line individually and create and/or destroy the infrastructure entirely! The reason for this is, b/c some commands need information from other commands and ideally using python or ansible a better configuration management tool is best. But since this class is a primer at least you having the commands in places for others to run is a step forward towards automation.
