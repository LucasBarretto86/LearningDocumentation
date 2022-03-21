# Learning Documentation

- [Learning Documentation](#learning-documentation)
  - [General Setups](#general-setups)
    - [SSH](#ssh)
    - [Installing ASDF](#installing-asdf)
      - [ASDF Plugins](#asdf-plugins)
        - [Adding ASDF Plugins](#adding-asdf-plugins)
        - [Listing ASDF Plugins](#listing-asdf-plugins)
        - [Installing ASDF Plugins](#installing-asdf-plugins)
        - [Updating ASDF Plugins](#updating-asdf-plugins)
        - [Setting version for ASDF Plugins](#setting-version-for-asdf-plugins)
    - [Installing POSTGRES](#installing-postgres)
      - [Creating postgres role](#creating-postgres-role)
  - [Git and Github](#git-and-github)
    - [Git commands table](#git-commands-table)
  - [LANGUANGES](#languanges)
    - [Python](#python)
    - [Ruby on Rails](#ruby-on-rails)
      - [Creating new Rails App](#creating-new-rails-app)
        - [For older Rails versions](#for-older-rails-versions)
        - [Configured as API app](#configured-as-api-app)
        - [Configured with React lilbs (Rails 6 or above)](#configured-with-react-lilbs-rails-6-or-above)
      - [Rails PUMA](#rails-puma)
        - [Check PUMA PORTS](#check-puma-ports)
        - [Kill PUMA](#kill-puma)
      - [Rails Redis](#rails-redis)
        - [Installing Redis](#installing-redis)
        - [Check Redis status](#check-redis-status)
        - [Restarting Redis](#restarting-redis)
      - [Rails Webpack](#rails-webpack)
      - [Rails Rubocop](#rails-rubocop)
      - [Rails Brakeman](#rails-brakeman)
      - [Rails Foreman](#rails-foreman)
      - [Rails GraphQL](#rails-graphql)
        - [Adding gem `graphiql-rails`](#adding-gem-graphiql-rails)
        - [`graphiql-rails` initial configuration](#graphiql-rails-initial-configuration)
        - [Mounting GraphQl engine to routes](#mounting-graphql-engine-to-routes)
        - [Generating ObjectTypes](#generating-objecttypes)
      - [Rails Rspec](#rails-rspec)
        - [Installing Rspec](#installing-rspec)
      - [Rails Mailcatcher](#rails-mailcatcher)
      - [Ruby on Rails Appends](#ruby-on-rails-appends)
        - [Checking Computer Hostname](#checking-computer-hostname)
        - [Fixing PG Error for new rails apps](#fixing-pg-error-for-new-rails-apps)
        - [Digest Images](#digest-images)
        - [Generate unique BLOB Token](#generate-unique-blob-token)
        - [Testing REST API](#testing-rest-api)
      - [Dependecies setup](#dependecies-setup)
  - [Handling Images](#handling-images)
    - [Installing ImageMagick](#installing-imagemagick)
      - [SVG TO PNG](#svg-to-png)
      - [PSD TO PNG](#psd-to-png)
    - [Installing Potrace](#installing-potrace)
      - [BMP to SVG](#bmp-to-svg)
  - [Concepts](#concepts)
    - [Serialization](#serialization)
  - [References](#references)
    - [General references](#general-references)
    - [Ruby on Rails references](#ruby-on-rails-references)

## General Setups

### SSH

Create SSH

```bash
ssh-keygen -t rsa -b 4096 -C "joe@example.com"
```

Validate SSH

```bash
eval "$(ssh-agent -s)"
```

Check SSH public key

```bash
cat ~/.ssh/id_rsa.pub
```

### Installing ASDF

```shell
git clone https://github.com/asdf-vm/asdf.git ~/.asdf --branch v0.4.0
echo -e '\n. $HOME/.asdf/asdf.sh' >> ~/.bashrc
echo -e '\n. $HOME/.asdf/completions/asdf.bash' >> ~/.bashrc
```

#### ASDF Plugins

Adding plugin dependencies

Each plugin has dependencies so we need to check the plugin repo where they should be listed. For asdf-nodejs they are:

```shell
apt-get install dirmngr gpg curl gawk
```

##### Adding ASDF Plugins

```shell
asdf plugin add nodejs https://github.com/asdf-vm/asdf-nodejs.git
asdf plugin-add python https://github.com/tuvistavie/asdf-python.git
asdf plugin-add ruby https://github.com/asdf-vm/asdf-ruby.git
asdf plugin-add lua https://github.com/Stratus3D/asdf-lua.git
```

##### Listing ASDF Plugins

```shell
asdf list-all ruby
```

##### Installing ASDF Plugins

```shell
asdf  install ruby 3.1.0
```

##### Updating ASDF Plugins

```shell
asdf plugin-update --all
```

##### Setting version for ASDF Plugins

```shell
asdf global nodejs 16.5.0
```

```shell
asdf local nodejs 12.23.0
```

### Installing POSTGRES

```shell
sudo apt-get update
sudo apt-get upgrade
sudo apt install postgresql-13 postgresql-client-13
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add 
echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" | sudo tee  /etc/apt/sources.list.d/pgdg.list
```

#### Creating postgres role

```shell
sudo su - postgres
```

```sql
CREATE USER user_name SUPERUSER
```

## Git and Github

### Git commands table

| Command|Description |
| :--- |:---- |
|`git rm -r --cached .`| Clear git cache for all files |
|`git branch -M main`| Renaming branch and origin
|`git branch -m newname`| Renaming branch locally |
|`git reset --soft HEAD~1`| Retrieve one commit `~1`  and return it to stage |
|`git push --force`| Force push in case it diverge from origin - Careful, no rollback |

## LANGUANGES

### Python

### Ruby on Rails

#### Creating new Rails App

```shell
rails new my-app --database=postgresql
```

##### For older Rails versions

```shell
rails _5.2.7_ new my-flights-app --webpack=react --database=postgresql
```

##### Configured as API app

```shell
rails new my_api -d=postgresql -T --api
```

##### Configured with React lilbs (Rails 6 or above)

```shell
rails new my-app --webpack=react --database=postgresql
```

#### Rails PUMA

##### Check PUMA PORTS

```shell
sudo netstat -ntlp | grep LISTEN
```

##### Kill PUMA

```shell
lsof -wni tcp:3000
```

#### Rails Redis

##### Installing Redis

```shell
sudo add-apt-repository ppa:redislabs/redis
sudo apt-get update
sudo apt-get install redis
```

OR

```shell
sudo snap install redis
redis-server --port 6380 --daemonize yes
```

##### Check Redis status

```shell
redis-cli ping
systemctl status redis
```

##### Restarting Redis

```shell
/etc/init.d/redis-server restart
```

#### Rails Webpack

with application directory

```shell
./bin/webpack-dev-server
```

#### Rails Rubocop

```Gemfile
group :development do
  ...

  gem 'rubocop', require: false
  gem 'rubocop-minitest', require: false
  gem 'rubocop-performance', require: false
  gem 'rubocop-rails', require: false
end
```

```shell
bundle exec rubocop -a
```

To enforce corrections

```shell
bundle exec rubocop -A
```

#### Rails Brakeman

Brakeman: Is a free vulnerability scanner specifically designed for Ruby on Rails applications. It statically analyzes Rails application code to find security issues at any stage of development

```Gemfile
group :development do
  ...

  gem 'brakeman', '>= 4.0', require: false
end
```

```shell
bundle exec brakeman
```

#### Rails Foreman

Foreman is a tool that run all required services needed to run a project

Installing Foreman gem

```shell
gem install foreman
```

Create a manifest file called `Procfile` within the root of the project and define the required services you need to run as Foreman starts

```txt
web: bin/rails server -p 3000
js: yarn build --watch
css: bin/rails dartsass:watch
```

To start Foreman simple run the command

```shell
foreman start
```

#### Rails GraphQL

##### Adding gem `graphiql-rails`

To add graphQL gem go to the Gemfile and add:

```Gemfile
group :development do
  ...

  gem 'graphiql-rails'
end

...

gem 'graphql', ' ~> 1.9.18'
```

then run the bundler

```shell
bundle install
```

##### `graphiql-rails` initial configuration

As long as the gem is installed `graphiql-rails` will provide specfic generators configure your project to graphql

Run the generator unless you want to config your project manually

```shell
rails g graphql:install
```

##### Mounting GraphQl engine to routes

Before you can test the GraphQL endpoint, you need to mount the GraphiQL engine to the routes file so you can access the GraphiQL in-browser IDE. To do this open the routes file located at `config/routes.rb`:

```rb
Rails.application.routes.draw do
  if Rails.env.development?
    mount GraphiQL::Rails::Engine, at: "/graphiql", graphql_path: "graphql#execute"
  end

  post "/graphql", to: "graphql#execute"
  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
end
```

##### Generating ObjectTypes

```shell
rails generate graphql:object Note id:ID! title:String! body:String!
```

*Note that `!` means that field os required to the query*

#### Rails Rspec

##### Installing Rspec

```shell
gem install rspec
```

Adding to the project

Add on gem file and run bundle

```Gemfile
group :test do
  ...

  gem "rspec"
  gem "rspec-rails"
end
```

Generate Rspect required files

```shell
rails g rspec:install
```

#### Rails Mailcatcher

MailCatcher runs a super simple SMTP server which catches any message sent to it to display in a web interface. Run mailcatcher, set your favourite app to deliver to smtp://127.0.0.1:1025 instead of your default SMTP server, then check out <http://127.0.0.1:1080> to see the mail.

```shell
gem install mailcatcher
```

#### Ruby on Rails Appends

##### Checking Computer Hostname

```shell
hostname --fqdn
```

##### Fixing PG Error for new rails apps

An error occurred while installing pg (1.2.3), and Bundler cannot continue.

```shell
sudo apt install postgresql-contrib libpq-dev
```

##### Digest Images

```rb
Digest::MD5.file('test/fixtures/files/groomsman.jpg').base64digest
```

##### Generate unique BLOB Token

```rb
ActiveStorage::Blob.generate_unique_secure_token
```

##### Testing REST API

```shell
curl -u marcondesv:a24d4e50c2c4298e34789fa84b0296f330ab7bdd 'https://api.name.com/v4/domains:checkAvailability' -X POST -H 'Content-Type: application/json' --data '{"domainNames":["marcosemariaw.us"]},'
{"results":[{"domainName":"marcosemariaw.us","sld":"marcosemariaw","tld":"us","purchasable":true,"purchasePrice":8.99,"purchaseType":"registration","renewalPrice":10.99},]},

]
```

#### Dependecies setup

With the new app folder

Add Webpacker (DEPRECATED USED ONLY FOR Rails 5 or bellow)

```shell
rails  webpacker:install
```

Adding Stimulus

```shell
rails  webpacker:install:stimulus
```

## Handling Images

### Installing ImageMagick

```shell
sudo apt install Imagemagick
```

#### SVG TO PNG

```shell
convert -background -quality 100 *.svg -set filename:base "%[basename]" "%[filename:base].png"
```

#### PSD TO PNG

```shell
convert  *.psd -set filename:base "%[basename]" -quality 100 "%[filename:base].png"
convert cover.ai cover.png
```

### Installing Potrace

Potrace(TM) is a tool for tracing a bitmap, which means, transforming a bitmap into a smooth, scalable image. It only traces black and white input images

```shell
sudo apt install potrace
```

#### BMP to SVG

```shell
potrace example.bmp -s -o example.svg
```

![original BMP](assets/images/example.bmp)
![Converted](assets/images/example.svg)

## Concepts

### Serialization

Basically serialize is the process to convert data to a byte stream that will represent an object to another end

[What is serialization](https://www.freecodecamp.org/news/what-is-serialization/)

## References

### General references

| General |
| :---- |
| [S.O.L.I.D](https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design) |
| [GraphQL vs REST](https://www.imaginarycloud.com/blog/graphql-vs-rest/) |
| [Learning Markdown](https://github.com/LucasBarretto86/LearningMarkdown#readme) |
| [Serialization](https://www.freecodecamp.org/news/what-is-serialization/) |

### Ruby on Rails references

| Ruby on Rails |
| :---- |
|[Foreman](https://www.theforeman.org/introduction.html)|
|[Rubocop](https://docs.rubocop.org/rubocop/installation.html)|
|[brakeman.org](https://brakemanscanner.org/)|
| [Create Rails App with GraphQL](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-ruby-on-rails-graphql-ap>) |
