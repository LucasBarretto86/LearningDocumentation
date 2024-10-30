# Claims

[Back to home](/docs/rest.md)

- [Claims](#claims)
  - [List Claims](#list-claims)
  - [Create New Claim](#create-new-claim)
  - [Show a Claim](#show-a-claim)

---

## List Claims

Listing existing claims from a specific eligibility record.

**Request:**

```http request
GET /v2/rest/insurances/:insurance_id/claims.json
```

**Scope parameters:**

| Parameter     | Type    | Required | Description                                    |
|:--------------|:--------|:---------|:-----------------------------------------------|
| insuranceId   | integer | yes      | ID of the insurance for the patient.          |

**Response:**

```json
[
  {
    "id": 115,
    "status": "pending",
    "items": [
      {
        "id": 57,
        "quantity": 1,
        "fee": 5.00,
        "procedureCode": "D0120"
      },
      {
        "id": 58,
        "quantity": 1,
        "fee": 5.00,
        "procedureCode": "D0120"
      }
    ],
    "createdAt": "2024-07-17T17:57:34.331-04:00",
    "updatedAt": "2024-07-17T17:57:34.331-04:00"
  },
  {
    "id": 116,
    "status": "pending",
    "items": [
      {
        "id": 59,
        "quantity": 1,
        "fee": 5.00,
        "procedureCode": "D0120"
      },
      {
        "id": 60,
        "quantity": 1,
        "fee": 5.00,
        "procedureCode": "D0120"
      }
    ],
    "createdAt": "2024-07-17T17:57:34.334-04:00",
    "updatedAt": "2024-07-17T17:57:34.334-04:00"
  }
]
```

## Create New Claim

Create a new claim given an insurance eligibility.

**Request:**

```http request
POST /v2/rest/insurances/:insurance_id/claims.json
```

**Scope parameters:**

| Parameter     | Type    | Required | Description                                    |
|:--------------|:--------|:---------|:-----------------------------------------------|
| insuranceId   | integer | yes      | ID of the insurance for the patient.          |

**Permitted Parameters:**

| Parameter            | Type   | Required | Description                              |
|----------------------|--------|----------|------------------------------------------|
| subscriberAttributes | object | yes      | Object containing subscriber information.|
| itemsAttributes      | array  | no       | Array of item objects.                   |
| providersAttributes  | array  | yes      | Array of provider objects.               |

**Subscriber Object:**

| Parameter    | Type                | Required | Description                                      |
|--------------|---------------------|----------|--------------------------------------------------|
| dob          | string (YYYY-MM-DD) | true     | Date of birth of the subscriber.                 |
| firstName    | string              | true     | First name of the subscriber.                    |
| lastName     | string              | true     | Last name of the subscriber.                     |
| gender       | string              | true     | Gender of the subscriber (e.g., "male", "female"). |
| relationship | string              | true     | Relationship to the patient (e.g., "self", "spouse"). |
| sequenceCode | string              | true     | Sequence code for the subscriber (e.g., "primary"). |
| memberId     | string              | true     | Unique member ID for the subscriber.             |

**Item Object:**

| Parameter      | Type    | Description                                      |
|----------------|---------|--------------------------------------------------|
| quantity       | integer | Number of items for the claim.                   |
| fee            | decimal | Fee associated with the item (e.g., `5.00`).     |
| procedureCode   | string  | Code for the procedure (e.g., "D0180").          |

**Provider Object:**

| Parameter           | Type   | Required | Description                                          |
|---------------------|--------|----------|------------------------------------------------------|
| kind                | string | true     | Type of provider (e.g., "RENDERING").                |
| npi                 | string | true     | National Provider Identifier of the provider.        |
| npiType             | string | true     | Type of NPI (e.g., "individual").                    |
| specialty           | string | true     | Provider's specialty (e.g., "ORTHO").                |
| taxonomy            | string | true     | Taxonomy code for the provider (e.g., "1223X0400X"). |
| taxId               | string | true     | Tax identification number of the provider.           |
| addressesAttributes | array  | true     | Array of address objects for the provider.           |

**Address Object:**

| Parameter  | Type    | Required | Description                                       |
|------------|---------|----------|---------------------------------------------------|
| address1   | string  | true     | Primary address line.                             |
| address2   | string  | false    | Secondary address line (optional).                |
| city       | string  | true     | City of the provider's address.                   |
| state      | string  | true     | State of the provider's address.                  |
| zipcode    | string  | true     | Zip code of the provider's address.               |
| kind       | string  | true     | Type of address (e.g., "primary").                |

**Payload:**

```json
{
  "insuranceId": 1,
  "claim": {
    "subscriberAttributes": {
      "dob": "1990-01-01",
      "firstName": "John",
      "lastName": "Doe",
      "gender": "male",
      "relationship": "self",
      "sequenceCode": "primary",
      "memberId": "123456789"
    },
    "providersAttributes": [
      {
        "kind": "RENDERING",
        "npi": "0123456789",
        "npiType": "individual",
        "specialty": "ORTHO",
        "taxonomy": "1223X0400X",
        "taxId": "123456789",
        "addressesAttributes": [
          {
            "address1": "303 Groovy Street",
            "address2": "Apartment 2",
            "city": "Boston",
            "state": "MA",
            "zipcode": "021789",
            "kind": "primary"
          }
        ]
      }
    ],
    "itemsAttributes": [
      {
        "quantity": 1,
        "fee": 5.00,
        "procedureCode": "D0180"
      }
    ]
  }
}
```

**Response:**

```json
{
  "id": 23,
  "status": "pending",
  "items": [
    { 
      "id": 17, 
      "quantity": 1, 
      "fee": 5.00, 
      "procedureCode": "D0180" 
    }
  ],
  "subscriber": {
    "id": 23,
    "dob": "1990-01-01",
    "firstName": "John",
    "lastName": "Doe",
    "gender": "male",
    "relationship": "self",
    "sequenceCode": "primary",
    "memberId": "123456789"
  },
  "providers": [
    {
      "id": 28,
      "kind": "RENDERING",
      "npi": "0123456789",
      "npiType": "individual",
      "specialty": "ORTHO",
      "taxonomy": "1223X0400X",
      "taxId": "123456789",
      "addresses": [
        {
          "id": 80,
          "address1": "303 Groovy Street",
          "address2": "Apartment 2",
          "city": "Boston",
          "state": "MA",
          "zipcode": "021789",
          "kind": "primary"
        }
      ]
    }
  ],
  "createdAt": "2024-10-14T16:39:34.169-04:00",
  "updatedAt": "2024-10-14T16:39:34.169-04:00"
}
```

## Show a Claim

Get a Claim record by ID.

**Request:**

```http request
GET /v2/rest/insurances/:insurance_id/claims/:id.json
```

**Scope parameters:**

| Parameter     | Type    | Required | Description                                    |
|:--------------|:--------|:---------|:-----------------------------------------------|
| insuranceId   | integer | yes      | ID of the insurance for the patient.          |
| id            | integer | yes      | ID of the claim.                              |

**Response:**

```json
{
  "id": 23,
  "status": "pending",
  "items": [
    { 
      "id": 17, 
      "quantity": 1, 
      "fee": 5.00, 
      "procedureCode": "D0180" 
    }
  ],
  "subscriber": {
    "id": 23,
    "dob": "1990-01-01",
    "firstName": "John",
    "lastName": "Doe",
    "gender": "male",
    "relationship": "self",
    "sequenceCode": "primary",
    "memberId": "123456789"
  },
  "providers": [
    {
      "id": 28,
      "kind": "RENDERING",
      "npi": "0123456789",
      "npiType": "individual",
      "specialty": "ORTHO",
      "taxonomy": "1223X0400X",
      "taxId": "123456789",
      "addresses": [
        {
          "id": 80,
          "address1": "303 Groovy Street",
          "address2": "Apartment 2",
          "city": "Boston",
          "state": "MA",
          "zipcode": "021789",
          "kind": "primary"
        }
      ]
    }
  ],
  "createdAt": "2024-10-14T16:39:34.169-04:00",
  "updatedAt": "2024-10-14T16:39:34.169-04:00"
}
```
