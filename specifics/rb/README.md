# Ruby Language Learning

- [Ruby Language Learning](#ruby-language-learning)
  - [Rails](#rails)
    - [Creating new Rails App](#creating-new-rails-app)
      - [For older Rails versions](#for-older-rails-versions)
      - [Configured as API app](#configured-as-api-app)
      - [Configured with React lilbs (Rails 6 or above)](#configured-with-react-lilbs-rails-6-or-above)
    - [Dependecies setup](#dependecies-setup)
    - [Generators](#generators)
      - [Models generator](#models-generator)
    - [Helpers](#helpers)
      - [ApplicationHelper](#applicationhelper)
    - [Current class and ActiveSupport::CurrentAttributes](#current-class-and-activesupportcurrentattributes)
      - [Basic Implementation](#basic-implementation)
      - [Create `current.rb` class](#create-currentrb-class)
      - [Create controller concern `set_current_attributes.rb` to load attributes](#create-controller-concern-set_current_attributesrb-to-load-attributes)
      - [Include concern to the `application_controller.rb`](#include-concern-to-the-application_controllerrb)
      - [Adding Current variables on Mailer previews](#adding-current-variables-on-mailer-previews)
        - [Basic implementation for mailer initializer `config/initializers/action_mailer.rb`](#basic-implementation-for-mailer-initializer-configinitializersaction_mailerrb)
  - [Postgres](#postgres)
    - [Fixing PG Error for new rails apps](#fixing-pg-error-for-new-rails-apps)
  - [PUMA](#puma)
    - [Check PUMA PORTS](#check-puma-ports)
    - [Kill PUMA](#kill-puma)
  - [Redis](#redis)
    - [Check Redis status](#check-redis-status)
    - [Restarting Redis](#restarting-redis)
  - [GraphQL](#graphql)
    - [Adding gem `graphiql-rails`](#adding-gem-graphiql-rails)
    - [`graphiql-rails` initial configuration](#graphiql-rails-initial-configuration)
    - [Mounting GraphQl engine to routes](#mounting-graphql-engine-to-routes)
    - [Generating ObjectTypes](#generating-objecttypes)
  - [RSPEC](#rspec)
  - [Webpack](#webpack)
  - [Rubocop](#rubocop)
  - [Brakeman](#brakeman)
  - [Foreman](#foreman)
  - [React](#react)
    - [Installing Rspec](#installing-rspec)
  - [Apollo](#apollo)
  - [MailCatcher](#mailcatcher)
  - [Snippets](#snippets)
    - [Digest Images](#digest-images)
    - [Generate unique BLOB Token](#generate-unique-blob-token)
    - [Testing REST API](#testing-rest-api)
  - [References](#references)

## Rails

### Creating new Rails App

```shell
rails new my-app --database=postgresql
```

#### For older Rails versions

```shell
rails _5.2.7_ new my-flights-app --webpack=react --database=postgresql
```

#### Configured as API app

```shell
rails new my_api -d=postgresql -T --api
```

#### Configured with React lilbs (Rails 6 or above)

```shell
rails new my-app --webpack=react --database=postgresql
```

### Dependecies setup

With the new app folder

Add Webpacker (DEPRECATED USED ONLY FOR Rails 5 or bellow)

```shell
rails  webpacker:install
```

Adding Stimulus

```shell
rails  webpacker:install:stimulus
```

### Generators

To check available generators native and from dependecies

```shell
rails generate
```

OR

```shell
rails g
```

#### Models generator

```shell
rails g model Airline name:string image_url:string slug:string
```

Model with reference:

```shell
rails g model Review title:string description:string score:integer airline:belongs_to
```

### Helpers

#### ApplicationHelper

```rb
def view_class_dom_tag(options = {})
  classes = []
  classes << "grid wrapper" if controller_name.eql?("appointments") && %w[new create].include?(action_name)
  classes << "wrapper-#{controller_name}"
  options.merge!({ class: classes.compact.join(" ") })
  "class=#{options[:class]}"
end

def view_id_dom_tag(prefix: nil, suffix: nil)
  "id=#{[prefix || controller_name, suffix || action_name].compact.join("-")}"
end
```

### Current class and ActiveSupport::CurrentAttributes

CurrentAttributes came out on Rails 5.2 allow us to control session variables, bellow follow steps

#### Basic Implementation

#### Create `current.rb` class

```rb
# frozen_string_literal: true

class Current < ActiveSupport::CurrentAttributes
  attribute :request_id, :user_agent, :ip_address, :user, :request, :clinic
end
```

#### Create controller concern `set_current_attributes.rb` to load attributes

```rb
# frozen_string_literal: true

module SetCurrentAttributes
  extend ActiveSupport::Concern

  included do
    before_action do
      Current.request_id = request.uuid
      Current.user_agent = request.user_agent
      Current.ip_address = request.ip
      Current.request = request
    end
  end
end

```

#### Include concern to the `application_controller.rb`

```rb
class ApplicationController < ActionController::Base
  ...
  
  include SetCurrentAttributes
end

```

#### Adding Current variables on Mailer previews

Since mailer preview uses Rails classes and itself is required to add initializer configs to be able to set data coming from session request

##### Basic implementation for mailer initializer `config/initializers/action_mailer.rb`

```rb
# frozen_string_literal: true

Rails.application.reloader.to_prepare do
  class Rails::MailersController
    before_action :set_current_clinic

    private

    def set_current_clinic
      Current.clinic = Clinic.find_by(subdomain: request.subdomain)
    end
  end
end
```

## Postgres

### Fixing PG Error for new rails apps

An error occurred while installing pg (1.2.3), and Bundler cannot continue.

```shell
sudo apt install postgresql-contrib libpq-dev
```

## PUMA

### Check PUMA PORTS

```shell
sudo netstat -ntlp | grep LISTEN
```

### Kill PUMA

```shell
lsof -wni tcp:3000
```

## Redis

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

### Check Redis status

```shell
redis-cli ping
systemctl status redis
```

### Restarting Redis

```shell
/etc/init.d/redis-server restart
```

## GraphQL

### Adding gem `graphiql-rails`

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

### `graphiql-rails` initial configuration

As long as the gem is installed `graphiql-rails` will provide specfic generators configure your project to graphql

Run the generator unless you want to config your project manually

```shell
rails g graphql:install
```

### Mounting GraphQl engine to routes

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

### Generating ObjectTypes

```shell
rails generate graphql:object Note id:ID! title:String! body:String!
```

*Note that `!` means that field os required to the query*

## RSPEC

## Webpack

with application directory

```shell
./bin/webpack-dev-server
```

## Rubocop

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

Custom configs for rubocop

You can add custom rules for cops, for that be sure to create a `.rubocop.yml` file inside the project

Check the default configs bellow
[RuboCop’s default configuration](https://github.com/rubocop/rubocop/blob/master/config/default.yml)

Simple referece:

## Brakeman

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

## Foreman

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

## React

### Installing Rspec

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

## Apollo

## MailCatcher

MailCatcher runs a super simple SMTP server which catches any message sent to it to display in a web interface. Run mailcatcher, set your favourite app to deliver to smtp://127.0.0.1:1025 instead of your default SMTP server, then check out <http://127.0.0.1:1080> to see the mail.

```shell
gem install mailcatcher
```

## Snippets

### Digest Images

```rb
Digest::MD5.file('test/fixtures/files/groomsman.jpg').base64digest
```

### Generate unique BLOB Token

```rb
ActiveStorage::Blob.generate_unique_secure_token
```

### Testing REST API

```shell
curl -u marcondesv:a24d4e50c2c4298e34789fa84b0296f330ab7bdd 'https://api.name.com/v4/domains:checkAvailability' -X POST -H 'Content-Type: application/json' --data '{"domainNames":["marcosemariaw.us"]},'
{"results":[{"domainName":"marcosemariaw.us","sld":"marcosemariaw","tld":"us","purchasable":true,"purchasePrice":8.99,"purchaseType":"registration","renewalPrice":10.99},]},

]
```

## References

| Ruby on Rails |
| :---- |
|[Foreman](https://www.theforeman.org/introduction.html)|
|[Rubocop](https://docs.rubocop.org/rubocop/installation.html)|
|[brakeman.org](https://brakemanscanner.org/)|
| [Create Rails App with GraphQL](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-ruby-on-rails-graphql-ap>) |
