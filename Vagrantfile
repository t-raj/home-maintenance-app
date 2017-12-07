# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "centos/7"
  config.vm.provision "file", source: "./app/", destination: "/tmp/app/" #maybe we can put all our app files in a folder and move the whole folder at once
  config.vm.provision "shell", path: "provision.sh"
end
