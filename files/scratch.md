# Payment Methods

[Back to home](/docs/rest.md)

- [Payment Methods](#payment-methods)
  - [Update Invoice Payment Method](#update-invoice-payment-method)

---

## Update Invoice Payment Method

This endpoint enables you to update the payment method for a specific invoice.
You can also set this payment method as the preferred method for other payable
invoices within the same payment plan. Additionally, you can trigger a
processing queue for related invoices to ensure automatic processing on their
due dates.

**Endpoint:**

```http request
PUT /v2/rest/billing/invoices/:invoice_id/payment_method.json
```

**Scope Parameters:**

| Parameter  | Type | Required | Description                                              |
|:-----------|:-----|:---------|:---------------------------------------------------------|
| invoice_id | int  | yes      | The ID of the invoice to have the payment method updated |

**Permitted Parameters:**

| Parameter         | Type    | Required | Description                                                                                                                                                         |
|:------------------|:--------|:---------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| payment_method_id | string  | yes      | The payment method token ID obtained from the Gateway API. It must not contain sensitive card details.                                                              |
| preferred_method  | boolean | no       | If `true`, all payable invoices from the same payment plan will have their payment method updated to match the provided `payment_method_id`.                        |
| process_queue     | boolean | no       | If `true`, it updates the status of upcoming invoices within the same payment plan to "awaiting_process," ensuring automatic payment processing on their due dates. |

**Payload Example (Updating Payment Method):**

```json
{
  "invoice": {
    "payment_method_id": "pm_card_mastercard"
  }
}
```

**Payload Example (Updating Payment Method as Preferred and Triggering Queue):**

```json
{
  "invoice": {
    "payment_method_id": "pm_card_visa",
    "preferred_method": true,
    "process_queue": true
  }
}
```

**Response:**

```http
200 OK
```

**Errors:**

- If there are no payable invoices to be updated from the payment plan scoped to
  the invoice, the response will be:

```json
{
   "error": "Payment method can't be updated."
}
```

**Important Note:**

Sensitive card details should never be included in the `payment_method_id`
field, as this API does not handle card details. Ensure that you obtain
the `payment_method_id` from a secure source, such as the Gateway API.

**Explanation of `process_queue` flag:**

The `process_queue` flag, when set to `true` in the payload, updates the status
of upcoming invoices within the same payment plan to "awaiting_process." This
action ensures that these invoices will be queued for processing by a scheduled
job on their respective due dates. Each day, the job collects all invoices
marked as "awaiting_process" that are due on the current date and initiates
their payment processing. Setting the `process_queue` flag is a convenient way
to guarantee that invoices will be processed automatically on their due dates,
streamlining the payment collection process.
