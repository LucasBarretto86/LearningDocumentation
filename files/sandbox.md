# Archives

[Back to home](/docs/rest.md)

- [Archives](#archives)
  - [Create Archive](#create-archive)
  - [Update Archive](#update-archive)
  - [Delete Archive](#delete-archive)

**URL:**

```http
/v2/rest/patients/:patient_id/documents/folders/:folder_id/archives
```

---

## Create Archive

Create new Archive for a specific `Folder` from a specific `Patient`.

**Request:**

```http
POST /v2/rest/patients/:patient_id/documents/folders/:folder_id/archives
```

**Scope parameters:**

| Parameter  | type    | required | description                  |
|:-----------|:--------|:---------|:-----------------------------|
| patient_id | integer | yes      | id of patient                |
| folder_id  | integer | yes      | id of folders from a patient |

**Permitted Parameters:**

| Parameter | type   | required | description       |
|:----------|:-------|:---------|:------------------|
| file      | file   | yes      | file from folders |
| name      | string | no       | archive name      |

**Payload:**

```json
{
  "archive": {
    "file": /document.pdf/,
    "name": "new document",
    "createdAt": "2022-11-29T16:09:19.624-05:00",
    "updatedAt": "2022-11-29T16:09:19.624-05:00"
  }
}
```

**Response:**

*Success:*

```json
{
  {
    "id": 1,
    "name": "new document"
    "url": /document.pdf/,
    "createdAt": "2022-11-29T16:09:19.624-05:00",
    "updatedAt": "2022-11-29T16:09:19.624-05:00"
  }
}
```

*Error:*

```json
{
  {
    "file": "No file has been uploaded",
  }
}
```

---

## Update Archive

Update Archive for a specific `Folder` from a specific `Patient`.

**Request:**

```http
POST /v2/rest/patients/:patient_id/documents/folders/:folder_id/archives/:id
```

**Scope parameters:**

| Parameter  | type    | required | description         |
|:-----------|:--------|:---------|:--------------------|
| patient_id | integer | yes      | id of patient       |
| folder_id  | integer | yes      | id of parent folder |
| id         | integer | yes      | id of archive       |

**Permitted Parameters:**

| Parameter | type   | required | description       |
|:----------|:-------|:---------|:------------------|
| file      | file   | yes      | file from folders |
| name      | string | no       | file name         |

**Payload:**

```json
{
  "archive": {
    "file": /document.pdf/,
    "name": "another document",
  }
}
```

**Response:**

*Success:*

```json
{
  {
    "id": 1,
    "name": "another document"
    "url": /document.pdf/,
    "createdAt": "2022-11-29T16:09:19.624-05:00",
    "updatedAt": "2022-11-29T16:09:19.624-05:00"
  }
}
```

*Error:*

```json
{
  {
    "file": "No file has been uploaded",
  }
}
```

---

## Delete Archive

Delete an Archive from a specific `Folder`.

**Request:**

```http
DELETE /v2/rest/patients/:patient_id/documents/folders/:folder_id/archives/:id
```

**Scope parameters:**

| Parameter  | type    | required | description         |
|:-----------|:--------|:---------|:--------------------|
| patient_id | integer | yes      | id of patient       |
| folder_id  | integer | yes      | id of parent folder |
| id         | integer | yes      | id of archive       |

**Response:**

```http
204 No Content
```
