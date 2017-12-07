#!/bin/bash


function create_service_user {
 user=$1
 #check to make sure user and group dont exist
 #if user exists, do nothing
 if getent passwd $user > /dev/null 2>&1; then
   echo "user exist"
 else
   #create service user
   echo "user does not exist"
   useradd -r $user
   echo "service user" $user "added"
 fi
}

function install_crontab {
 crontab=$1
 #move crontab to root crontab location
 mkdir /var/spool/cron/root
 mv /tmp/app/configs/$crontab /var/spool/cron/root/$crontab
 #override crontab to run with file
 cd /var/spool/cron/root
 crontab -u checker.svc $crontab
 cd /
}

function setup_daemon {
   service_file=$1
   cd etc
   mkdir systemd
   cd systemd
   mkdir system
   cd /
   mv /tmp/app/configs/$service_file /etc/systemd/system/$service_file
   systemctl enable $service_file
   systemctl start $service_file
}

function create_opt_folder {
  foldername=$1
  user=$2
  echo "user: " $user "creates folder: " $foldername
  change_ownership $user $foldername
}


function change_ownership {
  user=$1
  foldername=$2
  #change the ownership of the folder and files in the folder
  #-R makes it recursive
  echo "user: " $user "will now have ownership of: " $foldername
  chown -R $user /opt/$foldername
}

function untar_application {
  tarfile=$1
  #untar from /tmp
  cd /tmp
  tar -zxvf app.tar.gz
  cd /
  #mv app/* to /opt/<appname>
  mv /tmp/app/$tarfile/* /opt/$tarfile
}

function main_daemon {
  app_name="flask_app"
  user="flask.svc"
  create_service_user $user
  #create_opt_folder $app_name $user
  untar_application $app_name
  change_ownership $user $app_name
  # move daemon config flask_app.service to correct spot in function below
  setup_daemon "flask_app.service"
}

function main_cron {
  app_name="checker"
  user="checker.svc"
  create_service_user $user
  #create_opt_folder $app_name $user
  untar_application $app_name
  change_ownership $user $app_name
  # move crontab to crontab for root to correct spot in function below
  install_crontab "checker_crontab"
}

yum -y install $(cat /tmp/yum_pkgs.txt)
main_cron
main_daemon
