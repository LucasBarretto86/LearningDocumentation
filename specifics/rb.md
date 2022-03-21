# Ruby Language Learning

- [Ruby Language Learning](#ruby-language-learning)
  - [GraphQL](#graphql)
  - [Rspec](#rspec)
  - [React](#react)
  - [Apollo](#apollo)
  - [MailCatcher](#mailcatcher)
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
