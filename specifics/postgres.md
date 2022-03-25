# POSTGRES Learning

- [POSTGRES Learning](#postgres-learning)
  - [Installation and Setup](#installation-and-setup)
    - [Installing on Linux](#installing-on-linux)
    - [Enabling](#enabling)
    - [Starting](#starting)
    - [Stopping](#stopping)
    - [Checking status](#checking-status)
    - [Creating a password](#creating-a-password)
    - [Staging Posgres shell](#staging-posgres-shell)
    - [Creating a User, database and acessing](#creating-a-user-database-and-acessing)
    - [Update Owner](#update-owner)
    - [Grating access to User](#grating-access-to-user)
    - [Listing databases](#listing-databases)
    - [Using a database](#using-a-database)
  - [SQL](#sql)

## Installation and Setup

### Installing on Linux

```shell
sudo apt install postgresql postgresql-client
```

### Enabling

```shell
sudo systemctl enable postgresql.service
```

### Starting

```shell
sudo systemctl start postgresql.service
```

### Stopping

```shell
sudo systemctl stop postgresql.service
```

### Checking status

```shell
sudo systemctl status postgresql.service
```

### Creating a password

```shell
sudo passwd postgres
```

### Staging Posgres shell

```shell
sudo su -l postgres
psql
```

### Creating a User, database and acessing

```shell
CREATEUSER user_name
$ CREATEDB database_name -O user_name
$ psql database_name
```

### Update Owner

```shell
ALTER DATABASE database_name OWNER TO user_name;
```

### Grating access to User

```shell
GRANT CONNECT ON DATABASE socratica TO mohamed28;

GRANT USAGE ON SCHEMA public TO mohamed28;
```

### Listing databases

```shell
/l
```

### Using a database

```shell
/C database_name;
```

## SQL
