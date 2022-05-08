# POSTGRES SQL COURSE

### LINUX INSTALL
~~~
sudo apt install postgresql postgresql-client
~~~

### ENABLING
~~~
sudo systemctl enable postgresql.service
~~~ 

### STARTING
~~~
sudo systemctl start postgresql.service
~~~

### STOPING
~~~
sudo systemctl stop postgresql.service
~~~ 

### VERIFY STATUS
~~~
sudo systemctl status postgresql.service
~~~

### CREATING PASSWORD
~~~
sudo passwd postgres
~~~

### STARTING POSTGRES SHELL
~~~
sudo su -l postgres
psql
~~~

### CREATING NEW USER, NEW DB AND ACCESING IT
~~~
CREATEUSER user_name
$ CREATEDB database_name -O user_name
$ psql database_name
~~~

### UPDATE DATABASE OWNER
###### POSTGRES
~~~
ALTER DATABASE database_name OWNER TO user_name;
~~~

### GRANT ACCESS TO USER
###### POSTGRES
~~~
GRANT CONNECT ON DATABASE socratica TO mohamed28;

GRANT USAGE ON SCHEMA public TO mohamed28;
~~~

### LISTING DATABASES
###### POSTGRES
~~~
/l
~~~

###### MYSQL
~~~
SHOW DATABASES;
~~~

### USE DATABASE
###### POSTGRES
~~~
/C database_name;
~~~

###### MYSQL
~~~
USE DATABASE database_name;
~~~