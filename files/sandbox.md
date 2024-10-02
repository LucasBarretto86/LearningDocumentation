# Claim Items

[Back to home](/docs/rest.md)

- [Claim Items](#claim-items)
  - [List Claim Items](#list-claim-items)
  - [Show a Claim item](#show-a-claim-item)
  - [Create new Claim Items](#create-new-claim-items)
  - [Remove a Claim Item](#remove-a-claim-item)

---

## List Claim Items

Listing claim items from a Claim.

**Request:**

```http request
GET /v2/rest/insurances/claims/:claim_id/items.json
```

**Scope parameters:**

| Parameter | type    | required | description     |
| :-------- | :------ | :------- | :-------------- |
| claimID   | integer | yes      | Id from a Claim |

**Response:**

```json
[
  {
    "id": 129,
    "quantity": 1,
    "fee": 5,
    "procedureCode": "D0120",
    "createdAt": "2024-07-18T09:28:10.662-04:00"
  },
  {
    "id": 130,
    "quantity": 1,
    "fee": 5,
    "procedureCode": "D0120",
    "createdAt": "2024-07-18T09:28:10.664-04:00"
  }
]
```

## Show a Claim item

**Request:**

```http request
GET /v2/rest/insurances/claims/:claim_id/items/:id.json
```

**Scope parameters:**

| Parameter | type    | required | description          |
| :-------- | :------ | :------- | :------------------- |
| claimId   | integer | yes      | Id from a Claim      |
| itemId    | integer | yes      | Id from a Claim item |

**Response:**

```json
{
  "id": 130,
  "quantity": 1,
  "fee": 5,
  "procedureCode": "D0120",
  "createdAt": "2024-07-18T09:28:10.664-04:00"
}
```

## Create new Claim Items

Add new claim items to an give claim

**Request:**

```http request
POST /v2/rest/insurances/claims/:claim_id/items.json
```

**Scope parameters:**

| Parameter | type    | required | description     |
| :-------- | :------ | :------- | :-------------- |
| claimId   | integer | yes      | Id from a Claim |

**Permitted parameters:**

| Parameter     | type    | required | description                                      |
| :------------ | :------ | :------- | :----------------------------------------------- |
| quantity      | integer | yes      | How many time procedure occurred                 |
| fee           | integer | yes      | fee in percentage                                |
| procedureCode | integer | yes      | Code from the procedure covered by the insurance |

**Payload:**

```json
{
  "item": {
    "quantity": 1,
    "fee": 5,
    "procedureCode": "D0180",
    "createdAt": "2024-07-18T09:28:10.664-04:00"
  }
}
```

**Response:**

```json
{}
```

## Remove a Claim Item

**Request:**

```http request
DELETE /v2/rest/insurances/claims/:claim_id/items/:id.json
```

**Scope parameters:**

| Parameter | type    | required | description          |
| :-------- | :------ | :------- | :------------------- |
| claimId   | integer | yes      | Id from a Claim      |
| itemId    | integer | yes      | Id from a Claim item |

**Response:**

```json
{
  "message": "Item Removed"
}
```
