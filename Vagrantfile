# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.
  config.vm.synced_folder "c:/Users/aleksandrs.sins/work", "/home/vagrant/work"
  # config.vm.network "private_network", type: "dhcp", virtualbox__intnet: "private_network"

  config.vm.define "ansible" do |ansible|
    ansible.vm.box = "bento/centos-6.9"
    ansible.vm.hostname = 'ansible'
    ansible.vm.network :forwarded_port, guest: 22, host: 2022
    ansible.vm.network "private_network", ip: "172.10.2.22"
  end

  config.vm.define "dut_rhel6" do |dut_rhel6|
    dut_rhel6.vm.box = "inviqa/centos-6-minimal"
    dut_rhel6.vm.hostname = 'dut.rhel6'
    dut_rhel6.vm.network :forwarded_port, guest: 22, host: 2023
    dut_rhel6.vm.network "private_network", ip: "172.10.2.3"
  end

  config.vm.define "dut_rhel7" do |dut_rhel7|
    dut_rhel7.vm.box = "puppetlabs/centos-7.2-64-nocm"
    dut_rhel7.vm.hostname = 'dut.rhel7'
    dut_rhel7.vm.network :forwarded_port, guest: 22, host: 2024
    dut_rhel7.vm.network "private_network", ip: "172.10.2.4"
  end

  config.vm.define "win" do |win|
    win.vm.box = "opentable/win-2012r2-foundation-amd64-nocm"
    win.vm.hostname = 'win'
    win.vm.network :forwarded_port, guest: 5985, host: 25985
    win.vm.network :forwarded_port, guest: 5986, host: 25986
    win.vm.network "private_network", ip: "172.10.2.5"
  end

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  # #   # Display the VirtualBox GUI when booting the machine
  #   vb.customize ['modifyvm', :id, '--usb', 'on']
  #   vb.gui = true
  # #   # Customize the amount of memory on the VM:
  # #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   apt-get update
  #   apt-get install -y apache2
  # SHELL
end
