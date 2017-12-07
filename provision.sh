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

function setup_daemon {
   service_file=$1
   cd etc
   mkdir systemd
   cd systemd
   mkdir system
   cd /
   mv /tmp/app/$service_file /etc/systemd/system/$service_file #move our app to systemD TODO move all classes
   systemctl enable $service_file
   systemctl start $service_file
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
  app_name="menu.java"
  user="app.svc"
  create_service_user $user
  untar_application $app_name
  change_ownership $user $app_name
  # move daemon config flask_app.service to correct spot in function below
  setup_daemon "app.service"
}

main_daemon
