# Payment

1. Create Stripe Account Express
   1. Onboarding
2. Create payment plan with a payment_method
   1. Create each Invoice
3. Create payment / create payment_intent
   1. Capture payment / Confirm payment_intent
      1. Record payload from payment_intent associated with payment
   2. Create transaction
      1. Record payload from payment transaction associated with transaction
4. Create refund
   1. Create transaction
      1. Record payload from refund transaction associated with transaction
5. Create payout
   1. Create transaction
      1. Record payload from payout transaction associated with transaction

## Ledger

- Create account - OK
- List payloads - OK
- List transactions - OK
- Sync Ledger Balance - OK
- Onboarding - OK
-
