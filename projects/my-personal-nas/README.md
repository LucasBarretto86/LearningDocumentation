# Creating my personal NAS

- [Creating my personal NAS](#creating-my-personal-nas)
  - [What I want?](#what-i-want)
  - [Setup NAS Machine](#setup-nas-machine)
    - [Hardware](#hardware)
    - [Install](#install)
  - [Share content between NAS and my other devices](#share-content-between-nas-and-my-other-devices)
    - [Samba setup](#samba-setup)
  
## What I want?

1. I want have place where I can save my file so that I can access from any device
2. I want have a place where I can play around with Docker and Kubernetes on the feature
3. I want to now more about NAS and metrics

## Setup NAS Machine

### Hardware

- Beelink Intel Celeron J4125 8GB DDR4, M2 128GB

### Install

- First step will be to define which OS to use
  - Ubuntu Server
  - Debian
  - Open Media Vault

I have decided to use Ubuntu Server because I'm familiar with Ubuntu

**Ubuntu server installation:**

1. Download [Ubuntu Server 24.04](https://ubuntu.com/download/server)
2. Download [Etcher](https://etcher.balena.io/)
3. Create bootable
4. Setup NAS hardware bios to UEFI
5. Run the Ubuntu Installer
    - On the installation set the SSD as LVM to allow storage to be extended
    - From the canonical snaps I only added `Docker` the other I want be able to install as study
    - Added WIFI and allow Installer and Ubuntu to be updated to 24.08 version

6. After first initialization run:

   1. ```shell
      sudo apt updated
      sudo apt upgrade -Y
      sudo apt autoclean
      sudo apt autoremove
      ```

   2. Some dependencies might require installation as it cannot be upgrade using `apt upgrade`, so I personally needed to run additionally:

    ```sh
    sudo apt install python3-distupgrade ubuntu-release-upgrade-core
    ```

## Share content between NAS and my other devices

### Samba setup

To be able to share content between the NAS and other devices we'll need:

1. Install Samba
2. Create share folder
3. Configure Samba to allow sharing

**Install Samba:**

```sh
sudo apt install samba
```

To test installation

```sh
samba --version
```

**Create `share` folder:**

After installing samba we need to create the directories we will use as shared space between all devices

```sh
mkdir ~/<your-username>
mkdir ~/<your-username>/share/
```

> Replace the your-username for the name of the user you created with the installation

**Configure Samba to allow sharing:**

After having the directories created we need to add the share folder to the samba configuration

```sh
sudo nano /etc/samba/smd.conf
```

on the editor we need to add the following

```mono
[share]
  path= /home/<your-username>/share/
  browseable = yes
  ready only = no
  guest ok = yes
```

After adding the share configs section, we need to restart samba service

```sh
sudo systemctl restart smbd
```

Now we are up and running, next step will be to use the shared folder

**Adding NAS `share` folder to client device:**

Here I want to configure the share folder between my NAS and my notebook that also runs Linux, I will the POP_OS!
