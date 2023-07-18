# Awaiting Processes

[Back to home](/docs/rest.md)

- [Awaiting Processes](#awaiting-processes)
  - [Update Invoice status from `awaiting_payment` to `awaiting_process`](#update-invoice-status-from-awaiting_payment-to-awaiting_process)

## Update Invoice status from `awaiting_payment` to `awaiting_process`

Used to send an invoice to the queue of invoices awaiting payment to be
processed instead to awaiting staff or patient to pay invoice manually.

**Request:**

```http request
PUT /v2/rest/billing/invoices/:invoice_id/awaiting_process.json
```

**Scope parameters:**

| Parameter  | type | required | description                                         |
|:-----------|:-----|:---------|:----------------------------------------------------|
| invoice_id | int  | yes      | id from the invoice to be set as `awaiting_process` |

**Response:**

```http
{
  "id": 1507,
  "paymentPlanId": 560,
  "installmentNumber": 2,
  "paymentMethodId": "pm_card_mastercard",
  "dueDate": "2023-08-04",
  "status": "awaiting_process",
  "amount": "500.0",
  "interest": "22.5",
  "discount": "50.0",
  "finalAmount": "472.5",
  "dueAmount": "472.5",
  "refundedAmount": "0.0",
  "total": "472.5",
  "paidWith": ",
  "payments": [],
  "paidAt": "",
  "createdAt": "2023-06-04T13:28:05.548-04:00",
  "updatedAt": "2023-06-04T13:28:11.332-04:00"
}
```

**Errors:**

> If invoice due_date is today we cannot sent it to the queue for future payment
> process

```json
{
   error: "due_date needs to be further than today."
}
```

> If invoice isn't awaiting_payment we cannot move it to `awaiting_process`

```json
{
   error: "status needs to be 'awaiting_payment' in order to move it to process queue."
}
```

> If invoice payment_method_id is null we don't have how to process it's payment
> as the job runs over every invoice `awaiting_process`

```json
{
   error: "payment_method_id can't be undefined."
}
```
