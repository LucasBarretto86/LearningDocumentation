# Cantourage Pharma

- [Cantourage Pharma](#cantourage-pharma)
  - [Getting Started](#getting-started)
    - [1. Install dependencies](#1-install-dependencies)
      - [Install dependencies on linux](#install-dependencies-on-linux)
    - [2. Setup Environment Variables](#2-setup-environment-variables)
      - [Setup `direnv` on Linux](#setup-direnv-on-linux)
    - [3. Setup Database](#3-setup-database)
    - [4. Setup AWS S3/MinIO Service](#4-setup-aws-s3minio-service)
    - [5. Running application](#5-running-application)

## Getting Started

1. Install dependencies
2. Setup Environment Variables
3. Setup Postgres Database
4. Setup AWS S3/MinIO
5. Running Project

---

Ruby version manager alternatives:

- [ASDF](https://asdf-vm.com/)
- [rbenv](https://rbenv.org/)
- [RVM](https://rvm.io/)

Node version manger alternatives:

- [ASDF](https://asdf-vm.com/)
- [NVM](https://github.com/nvm-sh/nvm)

### 1. Install dependencies

**Versions:**

- [Ruby version](https://github.com/cantourage/clinic/blob/main/.ruby-version)
- [Node version](https://github.com/cantourage/clinic/blob/main/.node-version)

#### Install dependencies on linux

**1. Ruby Installation:**

Keep in mind to replace `<VERSION>` with the correct Ruby and Nodejs version from the application

**Using ASDF:**

```sh
asdf plugin-add ruby https://github.com/asdf-vm/asdf-ruby.git
asdf install ruby <VERSION>
asdf global ruby <VERSION>
```

**2. Node Installation:**

**Using ASDF:**

```sh
asdf plugin add nodejs https://github.com/asdf-vm/asdf-nodejs.git
asdf install nodejs <VERSION>
asdf global nodejs <VERSION>
```

> Replace `<VERSION>` with the correct Ruby version from the application.

**3. Setup Services:**

Within the project we have a `docker-compose.yml` to handle basic services, such as postgres, redis and minIO.

**Docker Installation (Skip if you already have installed):**

<https://docs.docker.com/engine/install/>

**Build and putting Up container:**

```sh
# Option --build is used on the first installation, it can be removed after
docker-compose -f docker-compose.dev.yml up --build
```

### 2. Setup Environment Variables

On Cantourage we use [direnv](https://direnv.net/) it handles ENVs loading and unloading as we
access directories that has defined a set of envs on `.envrc` file

#### Setup `direnv` on Linux

**1. Install `direnv` on Debian/Ubuntu:**

```sh
sudo apt update
sudo apt install direnv
```

**2. Setup `direnv` on terminal:**

```sh
# FOR for BASH configuration
echo 'eval "$(direnv hook bash)"' >> ~/.bashrc
source ~/.bashrc

# OR for ZSH configuration
echo 'eval "$(direnv hook zsh)"' >> ~/.zshrc
source ~/.zshrc
```

**3 Check `direnv` setup:**

```sh
direnv --version
```

**4. Configure project `.envrc`:**

Within the root folder of project create the file `.envrc`

This file must be filled initially like this:

```mono
export APP_DOMAIN=localhost
export APP_ENV=development
export APP_URL=http://localhost:3000
export DATABASE_URL=postgres://postgres@localhost/canuk_development
export RACK_ENV=development
export TZ=UTC
```

Every time this file gets changed we need to run `direnv allow`, to allow direnv the changes and reload the ENVs

### 3. Setup Database

**1. Access postgres on container:**

```sh
docker exec -it postgres psql -U postgres
```

**2. Create Databases:**

```sh
DATABASE CREATE canuk_development;
DATABASE CREATE canuk_test;
```

**3. Run migration:**

```sh
rake db:migrate
```

### 4. Setup AWS S3/MinIO Service

On development instead of using AWS S3 staging which might be troublesome we're going to use MinIO service.

**1. Login on MinIO service:**

If you are using the docker-compose template, and you have services up and running, you already have minIO
environment working at `http://localhost:9001/`

Use `admin123` or any `username/password` defined on the compose file as `MINIO_ROOT_USER`, `MINIO_ROOT_PASSWORD`

**2. Create bucket:**

Soon as you get in you can create a bucket, normally called `development`

**3. Create Access key:**

After bucket is created go to `Access Key` option and add a new key and save your access key and it's secret

**4. Update `.envrc` AWS credentials:**

On `.envrc` lets use minIO bucket name, access_key and secret as AWS credentials:

```mono
# Example: Replace values `<>` with the correct MinIO values

export AWS_ACCESS_KEY_ID=<MINIO_ACCESS_KEY>
export AWS_SECRET_ACCESS_KEY=<MINIO_ACCESS_KEY_SECRET>
export AWS_REGION=us-east-1
export AWS_S3_BUCKET=<MINIO_BUCKET_NAME>
export AWS_S3_ENDPOINT=<MINIO_LOCALHOST_URL>
export AWS_S3_FORCE_PATH_STYLE=true
 ```

### 5. Running application

**Install gem Foreman globally:**

```sh
gem install foreman
```

**Run Foreman for development:**

```sh
foreman start -f Procfile.dev
```

Alternatively you can run the application using the [Hivemind](https://github.com/DarthSim/hivemind#installation)

> Keep in mind that you will have to add additional ENVs to make the application works, request them to the
> Engineering team

---
