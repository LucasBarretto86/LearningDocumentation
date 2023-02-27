# Calendar engine

The Calendar engine is created to assemble different types of calendars using the relation between dates and specific clinic ActiveRecord models such as time-offs, doctor, rooms.  

Depending on the calendar strategy we set we can organize collection of 'events' related a date range by using the concept of `EventOrganizer`.

## Calendar Handler Types

We have 3 types of Calendars.

| Calendar handler type                      | Usage                                                                                                                                                         |
|:-------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Calendar::Handler::Old                     | used to render days for CalendarApp and get warnings in appointments.                                                                                         |
| Calendar::Handler::Month                   | used to render the month in the settings of the clinic.                                                                                                       |
| Calendar::Handler::SlotAvailability        | used to verify if we have available slots for schedule appointments in `BookingPage` and Iframe of Smilebar Site. Into the calendar we have event organizers. |
| Calendar::Handler::DoctorAvailability      ||
| Calendar::Handler::BookingPageAvailability ||

### Calendar::Handler::Old usage

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments }
  }
})
```

## Event Organizers

`EventOrganizer` are responsible to organize the ActiveRecords into the calendar we produced within a specific handler/strategy, however not handler uses `EventOrganizer`

The default `EventOrganizer` allows injects ORM data.

| Event Organizer                                       | Usage                                                                                                                                                         |
|:------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Calendar::EventOrganizer::Handler::TimeOffs           | used to render days for CalendarApp and get warnings in appointments.                                                                                         |
| Calendar::EventOrganizer::Handler::DayHours           | used to render the month in the settings of the clinic.                                                                                                       |
| Calendar::EventOrganizer::Handler::Occupations        | used to verify if we have available slots for schedule appointments in `BookingPage` and Iframe of Smilebar Site. Into the calendar we have event organizers. |
| Calendar::EventOrganizer::Handler::FullfilmentRates   ||
| Calendar::EventOrganizer::Handler::RoomDay            ||
| Calendar::EventOrganizer::Handler::DoctorDay          ||
| Calendar::EventOrganizer::Handler::SlotAvailability   ||
| Calendar::EventOrganizer::Handler::HourlyFulfillments ||

### Calendar::EventOrganizer::Handler::TimeOffs usage

A pure event organizer; It depend only data injected into him.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    time_offs: { type: :time_offs, events: time_offs }
  }
})
```

### Calendar::EventOrganizer::Handler::DayHours

A pure event organizer; It depend only data injected into him.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    }
  }
})
```

### Calendar::EventOrganizer::Handler::Occupations

is not a pure event organizer;
Calendar::EventOrganizer::Handler::Occupations It depends on data into `Calendar::EventOrganizer::Handler::Default` with name
appointments and `Calendar::EventOrganizer::Handler::TimeOffs`.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    occupations: { type: :occupations }
  }
})
```

### Calendar::EventOrganizer::Handler::FullfilmentRates

`Calendar::EventOrganizer::Handler::FullfilmentRates` is not a pure event
organizer;
It depends on data into`Calendar::EventOrganizer::Handler::Occupations` with
name appointments and `Calendar::EventOrganizer::Handler::DayHours`.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    },
    occupations: { type: :occupations },
    fullfilment_rates: { type: :fullfilment_rates, rooms: rooms }
  }
})
```

### Calendar::EventOrganizer::Handler::RoomDay

`` is not a pure event organizer; It
depends on data into `Calendar::EventOrganizer::Handler::Occupations`
and `Calendar::EventOrganizer::Handler::DayHours`.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    },
    occupations: { type: :occupations },
    room_day: { type: :room_day, rooms: rooms }
  }
})
```

### Calendar::EventOrganizer::Handler::DoctorDay

`Calendar::EventOrganizer::Handler::DoctorDay` is not a pure event organizer; It
depends on data into `Calendar::EventOrganizer::Handler::Occupations`
and `Calendar::EventOrganizer::Handler::DayHours` if you dont need the
occupation, you can use only with day hours.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    },
    occupations: { type: :occupations },
    doctor_day: { type: :doctor_day, doctor_day_hours: clinic_doctors_day_hours }
  }
})
```

Without doctor fulfillment_rate

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    doctor_day: { type: :doctor_day, doctor_day_hours: clinic_doctors_day_hours }
  }
})
```

### Calendar::EventOrganizer::Handler::SlotAvailability

`Calendar::EventOrganizer::Handler::SlotAvailability` is not a pure event
organizer; It depends on data into `Calendar::EventOrganizer::Handler::Default`
with name appointments and `Calendar::EventOrganizer::Handler::TimeOffs`
and  `Calendar::EventOrganizer::Handler::DayHours`.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    },
    slot_availability: { type: :slot_availability }
  }
})
```

### Calendar::EventOrganizer::Handler::HourlyFulfillments

`Calendar::EventOrganizer::Handler::HourlyFulfillments`  is not a pure event
organizer; It depends on data into `Calendar::EventOrganizer::Handler::Default`
with name appointments and `Calendar::EventOrganizer::Handler::RoomDay`.

```rb
Calendar.new({
  strategy: :old,
  start_date: start_date,
  end_date: end_date,
  event_organizers: {
    appointments: { events: clinic_appointments },
    time_offs: { type: :time_offs, events: time_offs },
    day_hours: {
      type: :day_hours,
      events: { default_week_hour: clinic.default_week_hour, week_hours: clinic_week_hours, day_hours_grouped_by_day: clinic_day_hours }
    },
    occupations: { type: :occupations },
    room_day: { type: :room_day, rooms: rooms },
    hourly_fulfillments: { type: :hourly_fulfillments, time_zone: time_zone }
  }
})
```

You can see how it really we use and works in
concern `Clinic::AssembleFromCalendar`.
  