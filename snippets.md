# Snippets

- [Snippets](#snippets)
  - [Ruby on Rails](#ruby-on-rails)

## Ruby on Rails

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
