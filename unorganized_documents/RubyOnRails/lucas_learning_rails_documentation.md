# Lucas Tools - A Ruby on Rails learning history documentation

## General
### Killing Puma Server
~~~
pkill -9 -f 'rb-fsevent|rails|spring|puma'
~~~

#### To list any process listening to the port 8080:
~~~
lsof -i:8080
~~~

####  To kill any process listening to the port 8080:
~~~
kill $(lsof -t -i:8080)
~~~

#### or more violently:
~~~
kill -9 $(lsof -t -i:8080)
~~~

## Database
### PostgreSQL
#### Creating application with postgres database
##### On linux terminal
~~~
rails new appname -d=postgresql
~~~
#### Installing PostgreSQL on Ubuntu
##### On linux terminal
~~~
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
sudo apt install postgresql postgresql-contrib -y
~~~

#### Creating a super user to use on Rails 
##### On linux terminal
~~~
sudo -u postgres createuser -s ubuntu_user -P
~~~

#### Storing password as a environment_variable
##### On linux terminal
~~~
echo 'export lucas_tools_DATABASE_PASSWORD="user_password"' >> ~/.bashrc
~~~

#### Exporting the enviroment_variable to the current session
~~~
source ~/.bashrc
~~~

#### Updating database.yml to use as default custom user
~~~
username: user
password: <%= ENV['app_name_DATABASE_PASSWORD'] %>
~~~
##### On linux terminal
~~~
rails db:setup
~~~

## Javascript
### YARN
#### Installing Yarn and initializing
##### On linux terminal
> inside project's folder

~~~
curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt update && sudo apt install yarn   
~~~

###### to initialize Yarn on a project
~~~
yarn init
~~~
###### to update Yarn on a project
~~~
yarn
~~~

### Webpacker
##### On Gemfile 
~~~
> all enviroments
gem 'webpacker', git: 'https://github.com/rails/webpacker.git'
~~~
##### On linux terminal
~~~
bundle exec rails webpacker:install
~~~
### Stimulus
##### On linux terminal
~~~
bundle exec rails webpacker:install:stimulus
~~~
## Updating Project
##### 1. Updating RBENV
~~~
cd ~/.rbenv/
git pull
~~~
##### 2. Updating RUBY
~~~
cd plugins/ruby-build
git pull
~~~

##### 3. Install new Ruby version
~~~
rbenv install -l
rbenv install 2.8.0
~~~
##### 4. Setting Ruby as global version
~~~
rbenv global 2.8.0 
ruby -v
~~~

###### 4.2 In some projects you have to change ruby version locally
~~~
rbenv local 2.8.0 
ruby -v
~~~
##### 5. Remove old version
~~~
rbenv uninstall 2.6.3
~~~
##### 6. Reinstalling Gems
~~~
gem update --system
~~~
##### 7. rehash rails commands
~~~
cd ~/.Rubymine/'project_folder'
rbenv rehash
~~~

##### 8. Change SDK on Rubymine settings to version installed

## PostgreSQL Commands
##### Accessing postgres
~~~
sudo -u postgres -i
psql
~~~

##### Lists users
~~~
\du
~~~

##### Lists databases
~~~
\li
~~~

##### Testing database listener
~~~
> postgres@computer-name:~$ 
ss -atulpn | grep postgres
~~~

##### Checking conn status
~~~
 \conninfo
~~~
##### Drop USER
~~~
DROP USER user_name_to_be_dropped;-  
~~~

## JOBS
### Redis
#### Installing and configuring
##### 1. Installing Redis
~~~
sudo apt install redis-server
~~~

##### 2. Configuring Redis, redis.conf 
~~~
sudo gedit /etc/redis/redis.conf
~~~

##### 3. On redis.conf, change 'supervised no' to
~~~
supervised systemd
~~~

##### 4. Restarting Redis
~~~
sudo systemctl restart redis.service
~~~

##### 5. Adding to Gemfile
~~~
gem 'redis'
~~~

#### Testing Redis
##### 1. Checking Redis status
~~~
sudo systemctl restart redis.service
sudo systemctl status redis
~~~
##### 2. Open Redis on console 
~~~
redis-cli
~~~
##### 3. Testing Redis response
~~~
ping
~~~
##### 4. Exit redis console
~~~
exit
~~~

#### Deactivate dangerous commands
##### 1. Open redis.conf
~~~
sudo gedit /etc/redis/redis.conf
~~~
##### 2. Renaming dangerous commands
~~~
> On SECURITY section add these lines
rename-command FLUSHDB ""
rename-command FLUSHALL ""
rename-command DEBUG ""
rename-command SHUTDOWN SHUTDOWN_MENOT
rename-command CONFIG ASC12_CONFIG
~~~

#### 3. Save, close and restart Redis
~~~
sudo systemctl restart redis.service
~~~
### Sidekiq
##### 1. Installing sidekiq
~~~
sudo apt-get install -y ruby-sidekiq
~~~
##### 2. Adding sidekiq to the Gemfile
~~~
gem 'sidekiq'
~~~
##### 3. Add to the application.rb
~~~
> This line inform to our application that sidekiq will handle the active_jobs
config.active_job.queue_adapter = :sidekiq
~~~
##### 3. Running sidekiq on a specific queue
~~~
bundle exec sidekiq -q reports -c 1
  |  |_______ reduz numero de threads para 3, valor default é 25
  |______________ queue name
~~~