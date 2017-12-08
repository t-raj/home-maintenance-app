##############################################################
# This file helps with creating the environment on a linux machine
###############################################################

yum_filename="/tmp/deploy/linux_setup/yum-pkgs.txt"
app_dir="/opt/home_app"
app_user="home.svc"
app_group="homers"
app_name="awesome_app"
reqs_filename="requirements.txt"
service_file="home_app.service"

function service_install_enable {
	# NOTE: When you care a service for httpd make sure you do a chkconfig on it
	cd /tmp/deploy/linux_setup/
	if [ -e $service_file ]; then
	  cp $service_file /lib/systemd/system/
	  systemctl enable $service_file
	  systemctl start $service_file
	else
	 echo "Service file doesn't exist, will exit"
	 exit 1
	fi
}

function create_group {
	 if [ $(getent group $app_group) ]; then
		 echo "$app_group already exists."
	 else
		 groupadd $app_group
		 echo "$app_group has been created."
	 fi
}

function create_svc_user {
    if [ $(getent passwd $app_user) ]; then
	    echo "$app_user already exists."
	  else
	     useradd -r $app_user
	    echo "$app_user has been created."
	    fi
}

function dirapp_setup {
	test -d $app_dir && echo "Directory exists" || (mkdir $app_dir; echo "Created Directory $app_dir") #app_dir="/opt/home_app"app_name="awesome_app"
	test -d /tmp/deploy/${app_name}/ && cp -avr /tmp/deploy/${app_name}/ ${app_dir} || (echo "Application is not found"; exit 1)
	chown -R $app_user:$app_group $app_dir
        test -e ${app_dir}/${app_name}/$reqs_filename && pip install -r ${app_dir}/${app_name}/$reqs_filename || (echo "$reqs_filename is not found can't conitnue"; exit 1)
}

function main {
    test -e $yum_filename && yum -y install $(cat $yum_filename) || (echo " $yum_filename is not found, can't continue"; exit 1)
    create_group && create_svc_user && usermod -a -G $app_group $app_user
    dirapp_setup
    service_install_enable
}

main
