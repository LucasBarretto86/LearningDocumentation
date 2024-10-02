
# Design patterns

- [Design patterns](#design-patterns)
  - [Creational Patterns](#creational-patterns)
    - [Singleton Pattern](#singleton-pattern)
    - [Factory Pattern](#factory-pattern)
    - [Builder Pattern](#builder-pattern)
    - [Prototype Pattern](#prototype-pattern)
  - [Structural Patterns](#structural-patterns)
    - [Adapter Pattern](#adapter-pattern)
    - [Presenter Pattern](#presenter-pattern)
    - [Decorator Pattern](#decorator-pattern)
    - [Bridge Pattern](#bridge-pattern)
    - [Composite Pattern](#composite-pattern)
    - [Facade Pattern](#facade-pattern)
    - [Proxy Pattern](#proxy-pattern)
    - [Flyweight Pattern](#flyweight-pattern)
  - [Behavioral Patterns](#behavioral-patterns)
    - [Strategy Pattern](#strategy-pattern)
    - [State Pattern](#state-pattern)
    - [Command Pattern](#command-pattern)
    - [Interpreter Pattern](#interpreter-pattern)
    - [Iterator Pattern](#iterator-pattern)
    - [Mediator Pattern](#mediator-pattern)
    - [Observer Pattern](#observer-pattern)
    - [Visitor Pattern](#visitor-pattern)
    - [Service Object Pattern](#service-object-pattern)
    - [Form Object Pattern](#form-object-pattern)
    - [Query Object Pattern](#query-object-pattern)
    - [Template Method Pattern](#template-method-pattern)
    - [Repository Pattern](#repository-pattern)
    - [Memento Pattern](#memento-pattern)
    - [Null Object Pattern](#null-object-pattern)
    - [Service Pattern](#service-pattern)
    - [Specification Pattern](#specification-pattern)
    - [Service Locator Pattern](#service-locator-pattern)
    - [Registry Pattern](#registry-pattern)
    - [Dependency Injection (DI) Pattern](#dependency-injection-di-pattern)
  
## Creational Patterns

### Singleton Pattern

**Explanation:**

The Singleton Pattern ensures a class has only one instance and provides a global point of access to it.

**When to use:**

Use the Singleton Pattern when you need to ensure only one instance of a class is created and provide a global point of access to that instance.

**Example 1:**

```ruby
# app/models/logger.rb
class Logger
  @instance = new

  private_class_method :new

  def self.instance
    @instance
  end

  def log(message)
    puts "Log: #{message}"
  end
end

# Usage
Logger.instance.log('This is a log message')
```

**Example 2:**

```ruby
# app/models/configuration.rb
class Configuration
  @instance = new

  private_class_method :new

  def self.instance
    @instance
  end

  def settings
    @settings ||= {}
  end
end

# Usage
config = Configuration.instance
config.settings[:app_name] = 'MyApp'
puts Configuration.instance.settings[:app_name] # Output: MyApp
```

### Factory Pattern

**Explanation:**

The Factory Pattern provides a way to create objects without specifying the exact class of the object that will be created.

**When to use:**

Use the Factory Pattern to decouple the object creation process from the specific class implementations.

**Example 1:**

```ruby
# app/factories/user_factory.rb
class UserFactory
  def self.create_admin(attrs)
    User.new(attrs.merge(role: 'admin'))
  end

  def self.create_guest(attrs)
    User.new(attrs.merge(role: 'guest'))
  end
end

# Usage
admin = UserFactory.create_admin(name: 'Admin User')
guest = UserFactory.create_guest(name: 'Guest User')
```

**Example 2:**

```ruby
# app/models/notification.rb
class Notification
  attr_accessor :message, :recipient

  def initialize(message, recipient)
    @message = message
    @recipient = recipient
  end

  def deliver
    raise NotImplementedError, 'Subclasses must implement deliver method'
  end
end

# app/models/email_notification.rb
class EmailNotification < Notification
  def deliver
    # Code to send email
    puts "Email sent to #{@recipient}: #{@message}"
  end
end

# app/models/sms_notification.rb
class SmsNotification < Notification
  def deliver
    # Code to send SMS
    puts "SMS sent to #{@recipient}: #{@message}"
  end
end

# app/factories/notification_factory.rb
class NotificationFactory
  def self.create_email_notification(message, recipient)
    EmailNotification.new(message, recipient)
  end

  def self.create_sms_notification(message, recipient)
    SmsNotification.new(message, recipient)
  end
end

# Usage
email_notification = NotificationFactory.create_email_notification('Hello Email', 'user@example.com')
sms_notification = NotificationFactory.create_sms_notification('Hello SMS', '123-456-7890')

email_notification.deliver
sms_notification.deliver
```

### Builder Pattern

The Builder Pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

**When to use:**
Use the Builder Pattern when you need to construct a complex object step by step and want to be able to create different representations of this object using the same construction code.

**Example 1:**

```rb
# app/models/house.rb
class House
  attr_accessor :walls, :roof, :doors, :windows

  def initialize
    @walls = []
    @roof = nil
    @doors = []
    @windows = []
  end

  def details
    "House with #{walls.count} walls, #{roof}, #{doors.count} doors, and #{windows.count} windows."
  end
end

# app/builders/house_builder.rb
class HouseBuilder
  def initialize
    @house = House.new
  end

  def build_wall
    @house.walls << 'wall'
    self
  end

  def build_roof
    @house.roof = 'roof'
    self
  end

  def build_door
    @house.doors << 'door'
    self
  end

  def build_window
    @house.windows << 'window'
    self
  end

  def get_result
    @house
  end
end

# Usage
builder = HouseBuilder.new
house = builder.build_wall.build_wall.build_roof.build_door.build_window.get_result
puts house.details # Output: House with 2 walls, roof, 1 doors, and 1 windows.
```

**Example 2:**

```rb
# app/models/pizza.rb
class Pizza
  attr_accessor :dough, :sauce, :topping

  def initialize
    @dough = nil
    @sauce = nil
    @topping = nil
  end

  def details
    "Pizza with #{dough} dough, #{sauce} sauce, and #{topping} topping."
  end
end

# app/builders/pizza_builder.rb
class PizzaBuilder
  def initialize
    @pizza = Pizza.new
  end

  def set_dough(dough)
    @pizza.dough = dough
    self
  end

  def set_sauce(sauce)
    @pizza.sauce = sauce
    self
  end

  def set_topping(topping)
    @pizza.topping = topping
    self
  end

  def get_result
    @pizza
  end
end

# Usage
builder = PizzaBuilder.new
pizza = builder.set_dough('thin').set_sauce('tomato').set_topping('cheese').get_result
puts pizza.details # Output: Pizza with thin dough, tomato sauce, and cheese topping.
```

### Prototype Pattern

The Prototype Pattern is used to create new objects by copying an existing object, known as the prototype. This pattern is useful when creating a new instance of a class is costly or complex.

**When to use:**

Use the Prototype Pattern when the cost of creating a new object is expensive or when you need to create a new object that is a copy of an existing object.

**Example 1:**

```rb
# app/models/employee.rb
class Employee
  attr_accessor :name, :position, :salary

  def initialize(name, position, salary)
    @name = name
    @position = position
    @salary = salary
  end

  def clone
    Employee.new(@name, @position, @salary)
  end
end

# Usage
original = Employee.new('John Doe', 'Manager', 50000)
clone = original.clone
puts clone.name # Output: John Doe
puts clone.position # Output: Manager
puts clone.salary # Output: 50000
```

**Example 2:**

```rb
# app/models/book.rb
class Book
  attr_accessor :title, :author, :pages

  def initialize(title, author, pages)
    @title = title
    @author = author
    @pages = pages
  end

  def clone
    Book.new(@title, @author, @pages)
  end
end

# Usage
original = Book.new('Design Patterns', 'GoF', 395)
clone = original.clone
puts clone.title # Output: Design Patterns
puts clone.author # Output: GoF
puts clone.pages # Output: 395
```

## Structural Patterns

### Adapter Pattern

**Explanation:**

The Adapter Pattern allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.

**When to use:**

Use the Adapter Pattern when you need to convert the interface of a class into another interface that a client expects.

**Example 1:**

```ruby
# app/adapters/xml_parser_adapter.rb
class XmlParserAdapter
  def initialize(xml_parser)
    @xml_parser = xml_parser
  end

  def parse(data)
    @xml_parser.parse_xml(data)
  end
end

# Usage
class XmlParser
  def parse_xml(data)
    # XML parsing logic
  end
end

xml_parser = XmlParser.new
adapter = XmlParserAdapter.new(xml_parser)
adapter.parse('<data></data>')
```

**Example 2:**

```ruby
# app/adapters/json_parser_adapter.rb
class JsonParserAdapter
  def initialize(json_parser)
    @json_parser = json_parser
  end

  def parse(data)
    @json_parser.parse_json(data)
  end
end

# Usage
class JsonParser
  def parse_json(data)
    # JSON parsing logic
  end
end

json_parser = JsonParser.new
adapter = JsonParserAdapter.new(json_parser)
adapter.parse('{"data": "value"}')
```

### Presenter Pattern

**Explanation:**

The Presenter Pattern separates the presentation logic from the view, providing a way to organize code that prepares data for display.

**When to use:**

Use the Presenter Pattern when you have complex presentation logic that doesn't belong in the view or model.

**Example 1:**

```ruby
# app/presenters/user_presenter.rb
class UserPresenter
  def initialize(user)
    @user = user
  end

  def full_name
    "#{@user.first_name} #{@user.last_name}"
  end

  def formatted_email
    "<#{@user.email}>"
  end
end

# Usage in a view
<%= UserPresenter.new(@user).full_name %>
<%= UserPresenter.new(@user).formatted_email %>
```

**Example 2:**

```ruby
# app/presenters/order_presenter.rb
class OrderPresenter
  def initialize(order)
    @order = order
  end

  def formatted_total
    "$#{'%.2f' % @order.total}"
  end

  def status_label
    case @order.status
    when 'pending'
      'Pending'
    when 'shipped'
      'Shipped'
    when 'delivered'
      'Delivered'
    else
      'Unknown'
    end
  end
end

# Usage in a view
<%= OrderPresenter.new(@order).formatted_total %>
<%= OrderPresenter.new(@order).status_label %>
```

### Decorator Pattern

**Explanation:**

The Decorator Pattern allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

**When to use:**

Use the Decorator Pattern to extend the functionality of objects in a flexible and reusable way.

**Example 1:**

```ruby
# app/decorators/user_decorator.rb
class UserDecorator < SimpleDelegator
  def full_name
    "#{first_name} #{last_name}"
  end

  def formatted_email
    "<#{email}>"
  end
end

# Usage
user = User.find(1)
decorated_user = UserDecorator.new(user)
puts decorated_user.full_name
puts decorated_user.formatted_email
```

**Example 2:**

```ruby
# app/decorators/product_decorator.rb
class ProductDecorator < SimpleDelegator
  def formatted_price
    "$#{'%.2f' % price}"
  end

  def display_name
    "#{name} (#{category})"
  end
end

# Usage
product = Product.find(1)
decorated_product = ProductDecorator.new(product)
puts decorated_product.formatted_price
puts decorated_product.display_name
```

### Bridge Pattern

The Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently.

**When to use:**

Use the Bridge Pattern when you want to separate an abstraction from its implementation and when both the abstractions and implementations should be extensible by sub-classing.

**Example 1:**

```rb
# app/models/color.rb
class Color
  def fill
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/red.rb
class Red < Color
  def fill
    'Filling with red color'
  end
end

# app/models/blue.rb
class Blue < Color
  def fill
    'Filling with blue color'
  end
end

# app/models/shape.rb
class Shape
  attr_accessor :color

  def initialize(color)
    @color = color
  end

  def draw
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/circle.rb
class Circle < Shape
  def draw
    "Drawing Circle with #{color.fill}"
  end
end

# app/models/square.rb
class Square < Shape
  def draw
    "Drawing Square with #{color.fill}"
  end
end

# Usage
red = Red.new
blue = Blue.new

circle = Circle.new(red)
puts circle.draw # Output: Drawing Circle with red color

square = Square.new(blue)
puts square.draw # Output: Drawing Square with blue color
```

**Example 2:**

```rb
# app/models/message_sender.rb
class MessageSender
  def send_message(message)
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/email_sender.rb
class EmailSender < MessageSender
  def send_message(message)
    "Sending email: #{message}"
  end
end

# app/models/sms_sender.rb
class SmsSender < MessageSender
  def send_message(message)
    "Sending SMS: #{message}"
  end
end

# app/models/notification.rb
class Notification
  attr_accessor :sender

  def initialize(sender)
    @sender = sender
  end

  def notify(message)
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/alert.rb
class Alert < Notification
  def notify(message)
    sender.send_message(message)
  end
end

# app/models/reminder.rb
class Reminder < Notification
  def notify(message)
    sender.send_message(message)
  end
end

# Usage
email_sender = EmailSender.new
sms_sender = SmsSender.new

alert = Alert.new(email_sender)
puts alert.notify('Alert message') # Output: Sending email: Alert message

reminder = Reminder.new(sms_sender)
puts reminder.notify('Reminder message') # Output: Sending SMS: Reminder message
```

### Composite Pattern

The Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

**When to use:**

Use the Composite Pattern when you want to represent part-whole hierarchies of objects and treat both individual objects and compositions of objects uniformly.

**Example 1:**

```rb
# app/models/component.rb
class Component
  def operation
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/leaf.rb
class Leaf < Component
  def operation
    'Leaf'
  end
end

# app/models/composite.rb
class Composite < Component
  def initialize
    @children = []
  end

  def add(component)
    @children << component
  end

  def remove(component)
    @children.delete(component)
  end

  def operation
    results = @children.map(&:operation)
    "Branch(#{results.join('+')})"
  end
end

# Usage
leaf1 = Leaf.new
leaf2 = Leaf.new
composite = Composite.new
composite.add(leaf1)
composite.add(leaf2)

puts composite.operation # Output: Branch(Leaf+Leaf)
```

**Example 2:**

```rb
# app/models/menu_component.rb
class MenuComponent
  def display
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/menu_item.rb
class MenuItem < MenuComponent
  attr_reader :name

  def initialize(name)
    @name = name
  end

  def display
    name
  end
end

# app/models/menu.rb
class Menu < MenuComponent
  def initialize
    @items = []
  end

  def add(item)
    @items << item
  end

  def remove(item)
    @items.delete(item)
  end

  def display
    @items.map(&:display).join(', ')
  end
end

# Usage
menu = Menu.new
menu.add(MenuItem.new('Item 1'))
menu.add(MenuItem.new('Item 2'))

submenu = Menu.new
submenu.add(MenuItem.new('Subitem 1'))
submenu.add(MenuItem.new('Subitem 2'))

menu.add(submenu)
puts menu.display # Output: Item 1, Item 2, Subitem 1, Subitem 2
```

### Facade Pattern

The Facade Pattern provides a simplified interface to a complex subsystem. It makes a complex system easier to use by providing a unified interface.

**When to use:**

Use the Facade Pattern when you need to provide a simple interface to a complex subsystem, making the subsystem easier to use and reducing the dependency of external code on the subsystem.

**Example 1:**

```rb
# app/services/order_facade.rb
class OrderFacade
  def initialize(order)
    @order = order
  end

  def place_order
    charge_payment
    send_confirmation
    update_inventory
  end

  private

  def charge_payment
    PaymentGateway.charge(@order.amount)
  end

  def send_confirmation
    OrderMailer.confirmation(@order).deliver_later
  end

  def update_inventory
    InventoryService.update(@order)
  end
end

# Usage
order = Order.new(amount: 100)
order_facade = OrderFacade.new(order)
order_facade.place_order
```

**Example 2:**

```rb
# app/services/user_facade.rb
class UserFacade
  def initialize(user)
    @user = user
  end

  def register
    create_account
    send_welcome_email
    track_sign_up
  end

  private

  def create_account
    @user.save
  end

  def send_welcome_email
    UserMailer.welcome(@user).deliver_later
  end

  def track_sign_up
    AnalyticsService.track('User Sign up', user_id: @user.id)
  end
end

# Usage
user = User.new(email: 'user@example.com')
user_facade = UserFacade.new(user)
user_facade.register
```

### Proxy Pattern

The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

**When to use:**

Use the Proxy Pattern when you need to control access to an object, add additional functionality, or delay the creation and initialization of expensive objects.

**Example 1:**

```rb
# app/models/image.rb
class Image
  def display
    'Displaying image'
  end
end

# app/models/image_proxy.rb
class ImageProxy
  def initialize(image)
    @image = image
  end

  def display
    @image.display
  end
end

# Usage
image = Image.new
image_proxy = ImageProxy.new(image)
puts image_proxy.display # Output: Displaying image
```

**Example 2:**

```rb
# app/models/document.rb
class Document
  def read
    'Reading document'
  end
end

# app/models/document_proxy.rb
class DocumentProxy
  def initialize(document)
    @document = document
  end

  def read
    @document.read
  end
end

# Usage
document = Document.new
document_proxy = DocumentProxy.new(document)
puts document_proxy.read # Output: Reading document
```

### Flyweight Pattern

**Explanation:**

The Flyweight Pattern is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects. It is particularly useful when dealing with a large number of objects that have identical state or behavior, allowing you to share common parts among them to save resources.

**Example 1:**

```ruby
# app/models/font.rb
class Font
  attr_reader :name

  def initialize(name)
    @name = name
  end
end

# app/models/font_factory.rb
class FontFactory
  def initialize
    @fonts = {}
  end

  def get_font(name)
    @fonts[name] ||= Font.new(name)
  end
end

# Usage
factory = FontFactory.new

font1 = factory.get_font('Arial')
font2 = factory.get_font('Arial')

puts font1.object_id == font2.object_id # Output: true
```

**Example 2:**

In a game with many trees, each tree might have the same type, color, and texture but different positions. Using the Flyweight Pattern, you can share tree objects with the same appearance while only varying their positions.

```ruby
# app/models/tree.rb
class Tree
  attr_reader :type, :color

  def initialize(type, color)
    @type = type
    @color = color
  end

  def render(position)
    puts "Rendering #{@color} #{@type} tree at position #{position}"
  end
end

# app/models/tree_factory.rb
class TreeFactory
  def initialize
    @trees = {}
  end

  def get_tree(type, color)
    @trees[[type, color]] ||= Tree.new(type, color)
  end
end

# Usage
factory = TreeFactory.new

tree1 = factory.get_tree('Oak', 'Green')
tree2 = factory.get_tree('Oak', 'Green')
tree3 = factory.get_tree('Pine', 'Dark Green')

tree1.render([10, 20])
tree2.render([15, 25])
tree3.render([20, 30])

puts tree1.object_id == tree2.object_id # Output: true
puts tree1.object_id == tree3.object_id # Output: false
```

In the second example, the `TreeFactory` class manages instances of `Tree` objects, ensuring that only one instance of each unique type and color combination is created. This approach helps reduce memory usage when dealing with a large number of similar objects.

## Behavioral Patterns


### Strategy Pattern

**Explanation:**

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

**When to use:**

Use the Strategy Pattern when you have multiple algorithms for a specific task and want to switch between them dynamically.

**Example 1:**

```ruby
# app/strategies/credit_card_payment.rb
class CreditCardPayment
  def pay(amount)
    # Implementation for credit card payment
    "Paid #{amount} using Credit Card"
  end
end

# app/strategies/paypal_payment.rb
class PaypalPayment
  def pay(amount)
    # Implementation for PayPal payment
    "Paid #{amount} using PayPal"
  end
end

# app/models/payment_processor.rb
class PaymentProcessor
  def initialize(strategy)
    @strategy = strategy
  end

  def process_payment(amount)
    @strategy.pay(amount)
  end
end

# Usage
processor = PaymentProcessor.new(CreditCardPayment.new)
puts processor.process_payment(100) # Output: Paid 100 using Credit Card

processor = PaymentProcessor.new(PaypalPayment.new)
puts processor.process_payment(200) # Output: Paid 200 using PayPal
```

**Example 2:**

```ruby
# app/strategies/json_formatter.rb
class JsonFormatter
  def format(data)
    data.to_json
  end
end

# app/strategies/xml_formatter.rb
class XmlFormatter
  def format(data)
    data.to_xml
  end
end

# app/models/report.rb
class Report
  def initialize(formatter)
    @formatter = formatter
  end

  def output(data)
    @formatter.format(data)
  end
end

# Usage
report = Report.new(JsonFormatter.new)
puts report.output({ name: 'John', age: 30 }) # Output: {"name":"John","age":30}

report = Report.new(XmlFormatter.new)
puts report.output({ name: 'John', age: 30 }) # Output: <hash><name>John</name><age>30</age></hash>
```

### State Pattern

**Explanation:**

The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

**When to use:**

Use the State Pattern when an object's behavior depends on its state, and it must change its behavior at runtime depending on that state.

**Example 1:**

```ruby
# app/states/order_state.rb
class OrderState
  def next_state
    raise NotImplementedError, 'This method should be overridden'
  end

  def status
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/states/new_order_state.rb
class NewOrderState < OrderState
  def next_state
    ProcessedOrderState.new
  end

  def status
    'New'
  end
end

# app/states/processed_order_state.rb
class ProcessedOrderState < OrderState
  def next_state
    ShippedOrderState.new
  end

  def status
    'Processed'
  end
end

# app/states/shipped_order_state.rb
class ShippedOrderState < OrderState
  def next_state
    DeliveredOrderState.new
  end

  def status
    'Shipped'
  end
end

# app/states/delivered_order_state.rb
class DeliveredOrderState < OrderState
  def next_state
    self
  end

  def status
    'Delivered'
  end
end

# app/models/order.rb
class Order
  attr_accessor :state

  def initialize
    @state = NewOrderState.new
  end

  def next_state
    @state = @state.next_state
  end

  def status
    @state.status
  end
end

# Usage
order = Order.new
puts order.status # Output: New
order.next_state
puts order.status # Output: Processed
order.next_state
puts order.status # Output: Shipped
order.next_state
puts order.status # Output: Delivered
```

**Example 2:**

```ruby
# app/states/light_state.rb
class LightState
  def press_button
    raise NotImplementedError, 'This method should be overridden'
  end

  def status
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/states/on_state.rb
class OnState < LightState
  def press_button
    OffState.new
  end

  def status
    'Light is ON'
  end
end

# app/states/off_state.rb
class OffState < LightState
  def press_button
    OnState.new
  end

  def status
    'Light is OFF'
  end
end

# app/models/light.rb
class Light
  attr_accessor :state

  def initialize
    @state = OffState.new
  end

  def press_button
    @state = @state.press_button
  end

  def status
    @state.status
  end
end

# Usage
light = Light.new
puts light.status # Output: Light is OFF
light.press_button
puts light.status # Output: Light is ON
light.press_button
puts light.status # Output: Light is OFF
```

### Command Pattern

**Explanation:**

The Command Pattern encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

**When to use:**

Use the Command Pattern when you need to decouple objects that produce commands from those that execute them or when you need to create a sequence of commands.

**Example 1:**

```ruby
# app/commands/turn_on_light_command.rb
class TurnOnLightCommand
  def execute
    'Light turned on'
  end
end

# app/commands/turn_off_light_command.rb
class TurnOffLightCommand
  def execute
    'Light turned off'
  end
end

# app/models/switch.rb
class Switch
  def initialize
    @commands = []
  end

  def store_and_execute(command)
    @commands << command
    command.execute
  end
end

# Usage
switch = Switch.new
puts switch.store_and_execute(TurnOnLightCommand.new) # Output: Light turned on
puts switch.store_and_execute(TurnOffLightCommand.new) #

 Output: Light turned off
```

**Example 2:**

```ruby
# app/commands/open_command.rb
class OpenCommand
  def execute
    'Document opened'
  end
end

# app/commands/close_command.rb
class CloseCommand
  def execute
    'Document closed'
  end
end

# app/models/menu_item.rb
class MenuItem
  def initialize
    @commands = []
  end

  def store_and_execute(command)
    @commands << command
    command.execute
  end
end

# Usage
menu_item = MenuItem.new
puts menu_item.store_and_execute(OpenCommand.new) # Output: Document opened
puts menu_item.store_and_execute(CloseCommand.new) # Output: Document closed
```

### Interpreter Pattern

The Interpreter Pattern defines a grammatical representation for a language and an interpreter to interpret the grammar.

**When to use:**

Use the Interpreter Pattern when you have a language to interpret, and you can represent statements in the language as abstract syntax trees.

**Example 1:**

```rb
# app/models/expression.rb
class Expression
  def interpret(context)
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/terminal_expression.rb
class TerminalExpression < Expression
  def initialize(data)
    @data = data
  end

  def interpret(context)
    context.include?(@data)
  end
end

# app/models/or_expression.rb
class OrExpression < Expression
  def initialize(expr1, expr2)
    @expr1 = expr1
    @expr2 = expr2
  end

  def interpret(context)
    @expr1.interpret(context) || @expr2.interpret(context)
  end
end

# app/models/and_expression.rb
class AndExpression < Expression
  def initialize(expr1, expr2)
    @expr1 = expr1
    @expr2 = expr2
  end

  def interpret(context)
    @expr1.interpret(context) && @expr2.interpret(context)
  end
end

# Usage
expr1 = TerminalExpression.new('Hello')
expr2 = TerminalExpression.new('World')

or_expr = OrExpression.new(expr1, expr2)
puts or_expr.interpret('Hello Ruby') # Output: true

and_expr = AndExpression.new(expr1, expr2)
puts and_expr.interpret('Hello World') # Output: true
puts and_expr.interpret('Hello Ruby')  # Output: false
```

**Example 2:**

```rb
# app/models/context.rb
class Context
  attr_reader :input

  def initialize(input)
    @input = input
  end
end

# app/models/numeric_expression.rb
class NumericExpression < Expression
  def interpret(context)
    context.input.to_i
  end
end

# app/models/add_expression.rb
class AddExpression < Expression
  def initialize(left, right)
    @left = left
    @right = right
  end

  def interpret(context)
    @left.interpret(context) + @right.interpret(context)
  end
end

# app/models/subtract_expression.rb
class SubtractExpression < Expression
  def initialize(left, right)
    @left = left
    @right = right
  end

  def interpret(context)
    @left.interpret(context) - @right.interpret(context)
  end
end

# Usage
context = Context.new('10')
left_expr = NumericExpression.new
right_expr = NumericExpression.new

add_expr = AddExpression.new(left_expr, right_expr)
puts add_expr.interpret(context) # Output: 20

subtract_expr = SubtractExpression.new(left_expr, right_expr)
puts subtract_expr.interpret(context) # Output: 0
```

### Iterator Pattern

The Iterator Pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

**When to use:**

Use the Iterator Pattern when you need to traverse a collection of objects without exposing its internal structure.

**Example 1:**

```rb
# app/models/collection.rb
class Collection
  attr_reader :items

  def initialize
    @items = []
  end

  def add_item(item)
    @items << item
  end

  def iterator
    CollectionIterator.new(self)
  end
end

# app/models/collection_iterator.rb
class CollectionIterator
  def initialize(collection)
    @collection = collection
    @index = 0
  end

  def has_next?
    @index < @collection.items.size
  end

  def next_item
    item = @collection.items[@index]
    @index += 1
    item
  end
end

# Usage
collection = Collection.new
collection.add_item('Item 1')
collection.add_item('Item 2')
collection.add_item('Item 3')

iterator = collection.iterator
while iterator.has_next?
  puts iterator.next_item
end
```

**Example 2:**

```rb
# app/models/book.rb
class Book
  attr_reader :title

  def initialize(title)
    @title = title
  end
end

# app/models/library.rb
class Library
  attr_reader :books

  def initialize
    @books = []
  end

  def add_book(book)
    @books << book
  end

  def iterator
    LibraryIterator.new(self)
  end
end

# app/models/library_iterator.rb
class LibraryIterator
  def initialize(library)
    @library = library
    @index = 0
  end

  def has_next?
    @index < @library.books.size
  end

  def next_book
    book = @library.books[@index]
    @index += 1
    book
  end
end

# Usage
library = Library.new
library.add_book(Book.new('Book 1'))
library.add_book(Book.new('Book 2'))
library.add_book(Book.new('Book 3'))

iterator = library.iterator
while iterator.has_next?
  book = iterator.next_book
  puts book.title
end
```

### Mediator Pattern

The Mediator Pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly.

**When to use:**

Use the Mediator Pattern when you want to centralize complex communication and control logic between related objects.

**Example 1:**

```rb
# app/models/mediator.rb
class Mediator
  def initialize
    @colleagues = []
  end

  def add_colleague(colleague)
    @colleagues << colleague
    colleague.mediator = self
  end

  def send_message(message, colleague)
    @colleagues.each do |col|
      col.receive_message(message) unless col == colleague
    end
  end
end

# app/models/colleague.rb
class Colleague
  attr_accessor :mediator

  def initialize(name)
    @name = name
  end

  def send_message(message)
    @mediator.send_message(message, self)
  end

  def receive_message(message)
    puts "#{@name} received message: #{message}"
  end
end

# Usage
mediator = Mediator.new
colleague1 = Colleague.new('Colleague 1')
colleague2 = Colleague.new('Colleague 2')

mediator.add_colleague(colleague1)
mediator.add_colleague(colleague2)

colleague1.send_message('Hello, colleague 2!')
# Output: Colleague 2 received message: Hello, colleague 2!
```

**Example 2:**

```rb
# app/models/chat_room.rb
class ChatRoom
  def initialize
    @users = []
  end

  def add_user(user)
    @users << user
    user.chat_room = self
  end

  def send_message(message, user)
    @users.each do |usr|
      usr.receive_message(message) unless usr == user
    end
  end
end

# app/models/user.rb
class User
  attr_accessor :chat_room

  def initialize(name)
    @name = name
  end

  def send_message(message)
    @chat_room.send_message(message, self)
  end

  def receive_message(message)
    puts "#{@name} received message: #{message}"
  end
end

# Usage
chat_room = ChatRoom.new
user1 = User.new('User 1')
user2 = User.new('User 2')

chat_room.add_user(user1)
chat_room.add_user(user2)

user1.send_message('Hello, user 2!')
# Output: User 2 received message: Hello, user 2!
```

### Observer Pattern

**Explanation:**

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

**When to use:**

Use the Observer Pattern when an object needs to notify other objects without making assumptions about who those objects are.

**Example 1:**

```ruby
# app/observers/order_observer.rb
class OrderObserver
  def update(order)
    puts "Order #{order.id} has been updated"
  end
end

# app/models/order.rb
class Order
  attr_accessor :id, :status, :observers

  def initialize(id)
    @id = id
    @observers = []
  end

  def add_observer(observer)
    @observers << observer
  end

  def remove_observer(observer)
    @observers.delete(observer)
  end

  def notify_observers
    @observers.each { |observer| observer.update(self) }
  end

  def update_status(new_status)
    @status = new_status
    notify_observers
  end
end

# Usage
order = Order.new(1)
observer = OrderObserver.new
order.add_observer(observer)
order.update_status('shipped') # Output: Order 1 has been updated
```

**Example 2:**

```ruby
# app/observers/stock_observer.rb
class StockObserver
  def update(product)
    puts "Stock for product #{product.name} has changed to #{product.stock}"
  end
end

# app/models/product.rb
class Product
  attr_accessor :name, :stock, :observers

  def initialize(name)
    @name = name
    @observers = []
  end

  def add_observer(observer)
    @observers << observer
  end

  def remove_observer(observer)
    @observers.delete(observer)
  end

  def notify_observers
    @observers.each { |observer| observer.update(self) }
  end

  def change_stock(new_stock)
    @stock = new_stock
    notify_observers
  end
end

# Usage
product = Product.new('Laptop')
observer = StockObserver.new
product.add_observer(observer)
product.change_stock(20) # Output: Stock for product Laptop has changed to 20
```

### Visitor Pattern

The Visitor Pattern allows you to add further operations to objects without having to modify them. This pattern involves a visitor class that changes the executing algorithm of an element class. This way, the execution algorithm can be varied as and when needed.

**When to use:**

Use the Visitor Pattern when you need to perform operations across a set of objects with varying classes without changing the classes themselves.

**Example 1:**

```rb
# app/models/visitor.rb
class Visitor
  def visit(element)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# app/models/element.rb
class Element
  def accept(visitor)
    raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
  end
end

# app/models/concrete_element_a.rb
class ConcreteElementA < Element
  def accept(visitor)
    visitor.visit(self)
  end

  def operation_a
    puts 'Operation A'
  end
end

# app/models/concrete_element_b.rb
class ConcreteElementB < Element
  def accept(visitor)
    visitor.visit(self)
  end

  def operation_b
    puts 'Operation B'
  end
end

# app/models/concrete_visitor.rb
class ConcreteVisitor < Visitor
  def visit(element)
    if element.is_a?(ConcreteElementA)
      element.operation_a
    elsif element.is_a?(ConcreteElementB)
      element.operation_b
    end
  end
end

# Usage
elements = [ConcreteElementA.new, ConcreteElementB.new]
visitor = ConcreteVisitor.new

elements.each do |element|
  element.accept(visitor)
end
# Output:
# Operation A
# Operation B
```

**Example 2:**

```rb
# app/models/product.rb
class Product
  attr_reader :name, :price

  def initialize(name, price)
    @name = name
    @price = price
  end

  def accept(visitor)
    visitor.visit(self)
  end
end

# app/models/service.rb
class Service
  attr_reader :name, :rate

  def initialize(name, rate)
    @name = name
    @rate = rate
  end

  def accept(visitor)
    visitor.visit(self)
  end
end

# app/models/pricing_visitor.rb
class PricingVisitor
  def visit(item)
    if item.is_a?(Product)
      puts "Product #{item.name} costs $#{item.price}"
    elsif item.is_a?(Service)
      puts "Service #{item.name} is $#{item.rate} per hour"
    end
  end
end

# Usage
items = [Product.new('Laptop', 1000), Service.new('Consulting', 200)]
visitor = PricingVisitor.new

items.each do |item|
  item.accept(visitor)
end
# Output:
# Product Laptop costs $1000
# Service Consulting is $200 per hour
```

### Service Object Pattern

**Explanation:**

The Service Object Pattern organizes business logic into single-purpose objects, making the codebase cleaner and easier to maintain.

**When to use:**

Use the Service Object Pattern to encapsulate complex business logic or workflows that don't fit neatly into models or controllers.

**Example 1:**

```ruby
# app/services/create_order.rb
class CreateOrder
  def initialize(user, order_params)
    @user = user
    @order_params = order_params
  end

  def call
    order = Order.new(@order_params)
    order.user = @user
    if order.save
      # Perform other actions, e.g., send confirmation email
      true
    else
      false
    end
  end
end

# Usage
user = User.find(1)
order_params = { product_id: 2, quantity: 1 }
service = CreateOrder.new(user, order_params)
if service.call
  puts "Order created successfully"
else
  puts "Order creation failed"
end
```

**Example 2:**

```ruby
# app/services/charge_credit_card.rb
class ChargeCreditCard
  def initialize(order)
    @order = order
  end

  def call
    # Logic to charge credit card
    if payment_successful?
      @order.update(status: 'paid')
      true
    else
      false
    end
  end

  private

  def payment_successful?
    # Simulate payment process
    true
  end
end

# Usage
order = Order.find(1)
service = ChargeCreditCard.new(order)
if service.call
  puts "Payment processed successfully"
else
  puts "Payment processing failed"
end
```

### Form Object Pattern

**Explanation:**

The Form Object Pattern encapsulates form-related logic in a single class, improving the separation of concerns and making the code easier to test.

**When to use:**

Use the Form Object Pattern to handle complex form submissions, validations, and other form-related logic that involves multiple models.

**Example 1:**

```ruby
# app/forms/registration_form.rb
class RegistrationForm
  include ActiveModel::Model

  attr_accessor :user, :profile

  validates :user, presence: true
  validates :profile, presence: true

  def initialize(params = {})
    @user = User.new(params[:user])
    @profile = Profile.new(params[:profile])
  end

  def save
    if valid?
      ActiveRecord::Base.transaction do
        @user.save!
        @profile.user = @user
        @profile.save!
      end
      true
    else
      false
    end
  end
end

# Usage
params = {
  user: { email: 'user@example.com', password: 'password' },
  profile: { first_name: 'John', last_name: 'Doe' }
}
form = RegistrationForm.new(params)
if form.save
  puts "Registration successful"
else
  puts "Registration failed"
end
```

**Example 2:**

```ruby
# app/forms/order_form.rb
class OrderForm
  include ActiveModel::Model

  attr_accessor :order, :payment

  validates :order, presence: true
  validates :payment, presence: true

  def initialize(params = {})
    @order = Order.new(params[:order])
    @payment = Payment.new(params[:payment])
  end

  def save
    if valid?
      ActiveRecord::Base.transaction do
        @order.save!
        @payment.order = @order
        @payment.save!
      end
      true
    else
      false
    end
  end
end

# Usage
params = {
  order: { product_id: 2, quantity: 1 },
  payment: { credit_card_number: '1234-5678-9012-3456', expiration_date: '12/24' }
}
form = OrderForm.new(params)
if form.save
  puts "Order placed successfully"
else
  puts "Order placement failed"
end
```

### Query Object Pattern

**Explanation:**

The Query Object Pattern encapsulates database queries in separate objects, making complex queries easier to understand and reuse.

**When to use:**

Use the Query Object Pattern for complex or reusable queries that don't fit neatly into scopes or model methods.

**Example 1:**

```ruby
# app/queries/recent_orders_query.rb
class RecentOrdersQuery
  def initialize(user)
    @user = user
  end

  def call
    Order.where(user: @user).where('created_at > ?', 1.month.ago)
  end
end

# Usage
user = User.find(1)
query = RecentOrdersQuery.new(user)
recent_orders = query.call
```

**Example 2:**

```ruby
# app/queries/expensive_products_query.rb
class ExpensiveProductsQuery
  def call
    Product.where('price > ?', 100)
  end
end

# Usage
query = ExpensiveProductsQuery.new
expensive_products = query.call
```

### Template Method Pattern

**Explanation:**

The Template Method Pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

**When to use:**

Use the Template Method Pattern when you have an algorithm that varies only slightly across subclasses.

**Example 1:**

```ruby
# app/models/report.rb
class Report
  def generate
    fetch_data
    format_data
    print_report
  end

  def fetch_data
    raise NotImplementedError, 'This method should be overridden'
  end

  def format_data
    raise NotImplementedError, 'This method should be overridden'
  end

  def print_report
    raise NotImplementedError, 'This method should be overridden'
  end
end

# app/models/csv_report.rb
class CsvReport < Report
  def fetch_data
    # fetch data logic
  end

  def format_data
    # format data as CSV logic
  end

  def print_report
    # print CSV report logic
  end
end

# Usage
report = CsvReport.new
report.generate
```

**Example 2:**

```ruby
# app/models/json_report.rb
class JsonReport < Report
  def fetch_data
    # fetch data logic
  end

  def format_data
    # format data as JSON logic
  end

  def print_report
    # print JSON report logic
  end
end

# Usage
report = JsonReport.new
report.generate
```

### Repository Pattern

**Explanation:**

The Repository Pattern separates the logic that retrieves data from the data source and maps it to the entity model. It bridges the gap between the domain and the data mapping layers using a collection-like interface for accessing domain objects.

**When to use:**

Use the Repository Pattern to create a more flexible and testable data access layer.

**Example 1:**

```ruby
# app/repositories/user_repository.rb
class UserRepository
  def find_by_email(email)
    User.find_by(email: email)
  end

  def save(user)
    user.save
  end
end

# Usage
repository = UserRepository.new
user = repository.find_by_email('user@example.com')
repository.save(user)
```

**Example 2:**

```ruby
# app/repositories/order_repository.rb
class OrderRepository
  def find_pending_orders
    Order.where(status: 'pending')
  end

  def save(order)
    order.save
  end
end

# Usage
repository = OrderRepository.new
pending_orders = repository.find_pending_orders
repository.save(Order.new(status: 'pending'))
```

### Memento Pattern

**Explanation:**

The Memento Pattern provides the ability to restore an object to its previous state without revealing the details of its implementation.

**When to use:**

Use the Memento Pattern when you need to capture and restore an object's state without exposing its internal structure.

**Example 1:**

```ruby
# app/models/editor.rb
class Editor
  attr_accessor :content

  def initialize(content = '')
    @content = content
  end

  def create_memento
    EditorMemento.new(@content)
  end

  def restore_memento(memento)
    @content = memento.content
  end
end

# app/models/editor_memento.rb
class EditorMemento
  attr_reader :content

  def initialize(content)
    @content = content
  end
end

# Usage
editor = Editor.new('Initial content')
memento = editor.create_memento
editor.content = 'Changed content'
editor.restore_memento(memento)
puts editor.content # Output: Initial content
```

**Example 2:**

```ruby
# app/models/game.rb
class Game
  attr_accessor :state

  def initialize(state = 'start')
    @state = state
  end

  def save_state
    GameMemento.new(@state)
  end

  def load_state(memento)
    @state = memento.state
  end
end

# app/models/game_memento.rb
class GameMemento
  attr_reader :state

  def initialize(state)
    @state = state
  end
end

# Usage
game = Game.new('Level 1')
memento = game.save_state
game.state = 'Level 2'
game.load_state(memento)
puts game.state # Output: Level 1
```

### Null Object Pattern

**Explanation:**

The Null Object Pattern provides an object that implements the expected interface but

 does nothing, avoiding the need for null checks.

**When to use:**

Use the Null Object Pattern when you want to avoid null checks and provide a default behavior.

**Example 1:**

```ruby
# app/models/null_logger.rb
class NullLogger
  def log(message)
    # Does nothing
  end
end

# app/models/application.rb
class Application
  def initialize(logger = NullLogger.new)
    @logger = logger
  end

  def run
    @logger.log('Application started')
  end
end

# Usage
app = Application.new
app.run
```

**Example 2:**

```ruby
# app/models/null_payment.rb
class NullPayment
  def process(amount)
    # Does nothing
  end
end

# app/models/order.rb
class Order
  def initialize(payment_processor = NullPayment.new)
    @payment_processor = payment_processor
  end

  def complete_order(amount)
    @payment_processor.process(amount)
  end
end

# Usage
order = Order.new
order.complete_order(100)
```

### Service Pattern

**Explanation:**

The Service Pattern encapsulates the business logic and complex operations in service classes.

**When to use:**

Use the Service Pattern to keep your models thin and clean, and to make your code more

modular and easier to test.

**Example:**

```rb
# app/services/user_signup_service.rb
class UserSignupService
  def initialize(user_params)
    @user_params = user_params
  end

  def call
    user = User.new(@user_params)
    if user.save
      send_welcome_email(user)
    end
    user
  end

  private

  def send_welcome_email(user)
    UserMailer.welcome_email(user).deliver_later
  end
end

# Usage
user_params = { name: 'John Doe', email: 'john@example.com', password: 'password' }
signup_service = UserSignupService.new(user_params)
user = signup_service.call
```

### Specification Pattern

**Explanation:**

The Specification Pattern allows you to encapsulate business rules in a reusable and combinable way.

**When to use:**

Use the Specification Pattern when you need to express complex business rules that can be reused and combined in different ways.

**Example:**

```rb
# app/specifications/user_specification.rb
class UserSpecification
  def self.admin
    ->(user) { user.role == 'admin' }
  end

  def self.active
    ->(user) { user.active? }
  end

  def self.and(*specs)
    ->(user) { specs.all? { |spec| spec.call(user) } }
  end

  def self.or(*specs)
    ->(user) { specs.any? { |spec| spec.call(user) } }
  end
end

# Usage
admin_spec = UserSpecification.admin
active_spec = UserSpecification.active
combined_spec = UserSpecification.and(admin_spec, active_spec)

users = User.all.select(&combined_spec)
```

### Service Locator Pattern

The Service Locator Pattern provides a central registry where services can be looked up. This pattern helps manage dependencies and decouple the implementation of a service from its use.

**When to use:**

Use the Service Locator Pattern when you need a global point of access for services and want to decouple service consumers from service implementations.

**Example 1:**

```rb
# app/services/service_locator.rb
class ServiceLocator
  def self.instance
    @instance ||= new
  end

  def initialize
    @services = {}
  end

  def register(service_name, service)
    @services[service_name] = service
  end

  def get(service_name)
    @services[service_name]
  end
end

# app/services/logger_service.rb
class LoggerService
  def log(message)
    puts message
  end
end

# Usage
service_locator = ServiceLocator.instance
service_locator.register(:logger, LoggerService.new)

logger = service_locator.get(:logger)
logger.log('This is a log message')
# Output: This is a log message
```

**Example 2:**

```rb
# app/services/payment_service.rb
class PaymentService
  def charge(amount)
    puts "Charging #{amount}"
  end
end

# app/services/service_locator.rb
class ServiceLocator
  def self.instance
    @instance ||= new
  end

  def initialize
    @services = {}
  end

  def register(service_name, service)
    @services[service_name] = service
  end

  def get(service_name)
    @services[service_name]
  end
end

# Usage
service_locator = ServiceLocator.instance
service_locator.register(:payment, PaymentService.new)

payment_service = service_locator.get(:payment)
payment_service.charge(50)
# Output: Charging 50
```

### Registry Pattern

The Registry Pattern provides a central place to store and retrieve instances of classes. It is often used to keep track of objects that need to be globally accessible.

**When to use:**

Use the Registry Pattern when you need a global point of access to objects or services, and you want to avoid passing these objects around explicitly.

**Example 1:**

```rb
# app/services/registry.rb
class Registry
  def self.instance
    @instance ||= new
  end

  def initialize
    @items = {}
  end

  def add(key, item)
    @items[key] = item
  end

  def get(key)
    @items[key]
  end
end

# app/services/configuration.rb
class Configuration
  attr_accessor :setting

  def initialize(setting)
    @setting = setting
  end
end

# Usage
registry = Registry.instance
config = Configuration.new('some_setting')
registry.add(:config, config)

retrieved_config = registry.get(:config

)
puts retrieved_config.setting
# Output: some_setting
```

**Example 2:**

```rb
# app/models/user_registry.rb
class UserRegistry
  def self.instance
    @instance ||= new
  end

  def initialize
    @users = {}
  end

  def add(user)
    @users[user.id] = user
  end

  def find(user_id)
    @users[user_id]
  end
end

# app/models/user.rb
class User
  attr_reader :id, :name

  def initialize(id, name)
    @id = id
    @name = name
  end
end

# Usage
user_registry = UserRegistry.instance
user1 = User.new(1, 'John Doe')
user2 = User.new(2, 'Jane Doe')

user_registry.add(user1)
user_registry.add(user2)

found_user = user_registry.find(1)
puts found_user.name
# Output: John Doe
```

Yes, there are a few additional design patterns that are commonly used in software development, including Ruby on Rails applications. Here are some of them:

1. **Repository Pattern**:

   - This pattern separates the logic that retrieves the data and maps it to the entity model from the business logic that acts on the model.
   - Use this pattern to create a clean separation between the data access and business logic.

2. **Factory Pattern**:

   - This pattern defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.
   - Use this pattern to decouple the object creation process from the specific class implementations.

3. **Service Pattern**:

   - This pattern encapsulates the business logic and complex operations in service classes.
   - Use this pattern to keep your models thin and clean, and to make your code more modular and easier to test.

4. **Specification Pattern**:

   - This pattern allows you to encapsulate business rules in a reusable, combinable way.
   - Use this pattern when you need to express complex business rules that can be reused and combined in different ways.

5. **Active Record Pattern**:
   - This pattern is a common design pattern used in Rails itself, where an object wraps a row in a database table or view, encapsulates the database access, and adds domain logic.
   - Use this pattern for simple CRUD operations and when your business logic is simple.

Here's a brief example for each:

### Dependency Injection (DI) Pattern

The Dependency Injection (DI) Pattern involves passing dependencies (objects or services) into a class rather than creating them inside the class. This makes it easier to manage and test dependencies.

**When to use:**

Use Dependency Injection to decouple classes and improve code testability and maintainability.

**Example 1:**

```rb
# app/models/payment_processor.rb
class PaymentProcessor
  def initialize(payment_gateway)
    @payment_gateway = payment_gateway
  end

  def process(amount)
    @payment_gateway.charge(amount)
  end
end

# app/models/payment_gateway.rb
class PaymentGateway
  def charge(amount)
    puts "Charging #{amount}"
  end
end

# Usage
gateway = PaymentGateway.new
processor = PaymentProcessor.new(gateway)
processor.process(100)
# Output: Charging 100
```

**Example 2:**

```rb
# app/services/message_sender.rb
class MessageSender
  def initialize(messaging_service)
    @messaging_service = messaging_service
  end

  def send_message(message)
    @messaging_service.send_message(message)
  end
end

# app/services/email_service.rb
class EmailService
  def send_message(message)
    puts "Sending email: #{message}"
  end
end

# app/services/sms_service.rb
class SMSService
  def send_message(message)
    puts "Sending SMS: #{message}"
  end
end

# Usage
email_service = EmailService.new
sms_service = SMSService.new

email_sender = MessageSender.new(email_service)
sms_sender = MessageSender.new(sms_service)

email_sender.send_message('Hello via email!')
# Output: Sending email: Hello via email!

sms_sender.send_message('Hello via SMS!')
# Output: Sending SMS: Hello via SMS!
```
