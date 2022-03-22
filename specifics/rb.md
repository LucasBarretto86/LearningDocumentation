# Ruby Language Learning

- [Ruby Language Learning](#ruby-language-learning)
  - [GraphQL](#graphql)
  - [Rspec](#rspec)
  - [React](#react)
  - [Apollo](#apollo)
  - [MailCatcher](#mailcatcher)
  - [Current class and ActiveSupport::CurrentAttributes](#current-class-and-activesupportcurrentattributes)
    - [Basic mplementation](#basic-mplementation)
      - [Create `current.rb` class](#create-currentrb-class)
      - [Create controller concern `set_current_attributes.rb` to load attributes](#create-controller-concern-set_current_attributesrb-to-load-attributes)
      - [Include concern to the `application_controller.rb`](#include-concern-to-the-application_controllerrb)
      - [Adding Current variables on Mailer previews](#adding-current-variables-on-mailer-previews)
        - [Basic implementation for mailer initializer `config/initializers/action_mailer.rb`](#basic-implementation-for-mailer-initializer-configinitializersaction_mailerrb)
  - [Snippets](#snippets)
    - [Generators](#generators)
      - [Models generator](#models-generator)
    - [Helpers](#helpers)
      - [ApplicationHelper](#applicationhelper)

## GraphQL

## Rspec

## React

## Apollo

## MailCatcher

## Current class and ActiveSupport::CurrentAttributes

CurrentAttributes came out on Rails 5.2 allow us to control session variables, bellow follow steps

### Basic mplementation

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

## Snippets

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
