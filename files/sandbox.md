# Calendar App

Calendar App is basically a prove of concept to show how to use Database to
generate static data to improve applications that uses Calendar to handle
appointments or events.

- [Calendar App](#calendar-app)
  - [Stack](#stack)
  - [Tasks](#tasks)
    - [Calendar Tasks](#calendar-tasks)
    - [Util Tasks](#util-tasks)
    - [Development](#development)

## Stack

- Ruby 3.1.0
- Rails edge, latest commit
- PostgreSQL 15
- Node 18.12.1
- Yarn 1.22.19
- Gems
  - RSpec
  - Brakeman
  - Rubocop

## Tasks

### Calendar Tasks

| Task                      | Description                                                                   |
|:--------------------------|:------------------------------------------------------------------------------|
| `rails calendar:populate` | Used to populate database, most like to be never used if app is on production |

### Util Tasks

| Task                       | Description                            |
|:---------------------------|:---------------------------------------|
| `rails calendar:util:kill` | To kill database in case it get frozen |

### Development

| Task                               | Description                          |
|:-----------------------------------|:-------------------------------------|
| `rails calendar:development:setup` | User to rebuild development database |
