```mermaid
erDiagram
    Account }|..o| User : user_id
    Account {
        bigint id
        bigint clinic_id
        bigint user_id

    }
    User {
        bigint id
        string email
        string first_name
        string last_name
        bool admin
        string roles
        int notify_on
        bigint account_id
    }
    User ||..|| Account : account_id
    Account ||--o| Clinic : clinic_id
    Clinic {
      bigint id
      string name
      string time_zone
      string twilio_phone_number
      string subdomain
      string address
      string zip_code
      string phone_number
      string city
      string state
      string google_analytics_id
      string facebook_pixel_id
      bigint subscription_id
      string facebook_conversion_token
      string tag_manager_key
      string reply_to_email
      string phone_country_code    
 }
```
