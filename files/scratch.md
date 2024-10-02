## Class Diagram

```mermaid
classDiagram
    class Patient {
        +id: Integer
        +name: String
        +dateOfBirth: Date
        +ssn: String
        +address: String
        +phone: String
        +email: String
        +healthHistory: String
        +insuranceInfo: Insurance
        +consentFormSigned: Boolean
    }

    class Clinic {
        +id: Integer
        +name: String
        +address: String
        +phone: String
        +email: String
        +doctors: Doctor[]
        +patients: Patient[]
        +treatments: Treatment[]
    }

    class Doctor {
        +id: Integer
        +name: String
        +specialization: String
        +licenseNumber: String
        +phone: String
        +email: String
        +clinic: Clinic
    }

    class Treatment {
        +id: Integer
        +name: String
        +description: String
        +cost: Decimal
        +treatmentPlan: String
        +doctor: Doctor
        +patient: Patient
        +appointments: Appointment[]
        +preAuthorization: InsuranceEligibility
    }

    class Appointment {
        +id: Integer
        +date: Date
        +time: Time
        +status: String
        +notes: String
        +treatment: Treatment
        +doctor: Doctor
        +patient: Patient
    }

    class Insurance {
        +id: Integer
        +companyName: String
        +policyNumber: String
        +groupNumber: String
        +subscriberName: String
        +subscriberDOB: Date
        +subscriberSSN: String
        +coverageDetails: String
        +patients: Patient[]
    }

    class InsuranceEligibility {
        +id: Integer
        +insurance: Insurance
        +patient: Patient
        +isEligible: Boolean
        +eligibleAmount: Decimal
        +preAuthRequired: Boolean
    }

    class ClaimForm {
        +id: Integer
        +claimNumber: String
        +insurance: Insurance
        +patient: Patient
        +treatment: Treatment
        +amountBilled: Decimal
        +amountPaid: Decimal
        +status: String
        +submissionDate: Date
        +responseDate: Date
    }

    Patient "1" -- "0..*" Insurance: has
    Clinic "1" -- "0..*" Doctor: employs
    Clinic "1" -- "0..*" Patient: serves
    Clinic "1" -- "0..*" Treatment: offers
    Doctor "1" -- "0..*" Treatment: performs
    Doctor "1" -- "0..*" Appointment: schedules
    Patient "1" -- "0..*" Treatment: receives
    Patient "1" -- "0..*" Appointment: attends
    Treatment "1" -- "0..*" Appointment: consists of
    Treatment "1" -- "1" InsuranceEligibility: requires
    Insurance "1" -- "0..*" Patient: covers
    InsuranceEligibility "1" -- "1" Insurance: verifies
    InsuranceEligibility "1" -- "1" Patient: verifies for
    Treatment "1" -- "1" ClaimForm: results in
    ClaimForm "1" -- "1" Insurance: billed to
    ClaimForm "1" -- "1" Patient: billed for

```

## Flow chart

```mermaid
flowchart TD
    subgraph Patient
        PatientInfo["Patient: Provide Personal Information"]
        HealthHistory["Patient: Provide Health History"]
        InsuranceInfo["Patient: Provide Insurance Information"]
        ConsentForm["Patient: Sign Consent Form"]
        PatientInfo --> HealthHistory
        HealthHistory --> InsuranceInfo
        InsuranceInfo --> ConsentForm
    end

    subgraph Clinic
        InitialConsult["Clinic/Doctor: Initial Consultation"]
        TreatmentPlan["Doctor: Create Treatment Plan"]
        PreAuth["Clinic: Submit Pre-Authorization Request"]
        ScheduleAppointments["Clinic: Schedule Appointments"]
        PerformAppointment["Clinic/Doctor: Perform Appointment"]
        DocAppointment["Clinic: Document Appointment Details"]
        CollectDocs["Clinic: Collect Supporting Documentation"]
        FillClaimForm["Clinic: Fill Claim Form"]
        AttachDocs["Clinic: Attach Supporting Documents"]
        SubmitClaim["Clinic: Submit Claim"]
        TrackStatus["Clinic: Track Claim Status"]
        AddressIssues["Clinic: Address Denials/Underpayments"]
        ReceivePayment["Clinic: Receive Payment"]
        BillPatient["Clinic: Bill Patient"]
    end

    subgraph Insurance
        InsuranceEligibility["Insurance: Verify Eligibility"]
        ReviewPreAuth["Insurance: Review Pre-Authorization"]
        ProcessClaim["Insurance: Process Claim"]
        DenialReview["Insurance: Review Denials/Underpayments"]
    end

    Patient --> Clinic
    Clinic --> Insurance

    %% Patient Flow
    PatientInfo --> HealthHistory
    HealthHistory --> InsuranceInfo
    InsuranceInfo --> ConsentForm
    ConsentForm --> InitialConsult

    %% Clinic Flow
    InitialConsult --> TreatmentPlan
    TreatmentPlan --> PreAuth
    PreAuth -->|Submit| InsuranceEligibility
    InsuranceEligibility -->|Verified| ReviewPreAuth
    ReviewPreAuth -->|Approved| ScheduleAppointments
    ScheduleAppointments --> PerformAppointment
    PerformAppointment --> DocAppointment
    DocAppointment --> CollectDocs
    CollectDocs --> FillClaimForm
    FillClaimForm --> AttachDocs
    AttachDocs --> SubmitClaim
    SubmitClaim --> TrackStatus
    TrackStatus --> AddressIssues
    AddressIssues -->|Resolved| ReceivePayment
    ReceivePayment --> BillPatient

    %% Insurance Flow
    ReviewPreAuth -->|Denied| AddressIssues
    ProcessClaim -->|Denied| AddressIssues
    AddressIssues -->|Resolved| ProcessClaim
    DenialReview -->|Resolved| ProcessClaim

    style PatientInfo fill:#f9f,stroke:#333,stroke-width:2px
    style HealthHistory fill:#ff9,stroke:#333,stroke-width:2px
    style InsuranceInfo fill:#9f9,stroke:#333,stroke-width:2px
    style ConsentForm fill:#9ff,stroke:#333,stroke-width:2px
    style InitialConsult fill:#f99,stroke:#333,stroke-width:2px
    style TreatmentPlan fill:#99f,stroke:#333,stroke-width:2px
    style PreAuth fill:#9ff,stroke:#333,stroke-width:2px
    style ScheduleAppointments fill:#f9f,stroke:#333,stroke-width:2px
    style PerformAppointment fill:#ff9,stroke:#333,stroke-width:2px
    style DocAppointment fill:#9f9,stroke:#333,stroke-width:2px
    style CollectDocs fill:#9ff,stroke:#333,stroke-width:2px
    style FillClaimForm fill:#f99,stroke:#333,stroke-width:2px
    style AttachDocs fill:#99f,stroke:#333,stroke-width:2px
    style SubmitClaim fill:#9ff,stroke:#333,stroke-width:2px
    style TrackStatus fill:#f9f,stroke:#333,stroke-width:2px
    style AddressIssues fill:#ff9,stroke:#333,stroke-width:2px
    style ReceivePayment fill:#9f9,stroke:#333,stroke-width:2px
    style BillPatient fill:#9ff,stroke:#333,stroke-width:2px
    style InsuranceEligibility fill:#f99,stroke:#333,stroke-width:2px
    style ReviewPreAuth fill:#99f,stroke:#333,stroke-width:2px
    style ProcessClaim fill:#9ff,stroke:#333,stroke-width:2px
    style DenialReview fill:#f9f,stroke:#333,stroke-width:2px
```

### Claim Form Diagram

```mermaid
flowchart TD
    subgraph Clinic
        Start["Start: Document Treatment Details"]
        CollectDocs["Collect Supporting Documentation"]
        FillClaimForm["Fill Claim Form"]
        AttachDocs["Attach Supporting Documents"]
        SubmitClaim["Submit Claim"]
        TrackStatus["Track Claim Status"]
        AddressIssues["Address Denials/Underpayments"]
        ReceivePayment["Receive Payment"]
        BillPatient["Bill Patient"]
    end

    subgraph Insurance
        ReviewClaim["Review Claim"]
        ApproveClaim["Approve Claim"]
        DenyClaim["Deny Claim"]
        UnderpayClaim["Underpay Claim"]
        ProcessPayment["Process Payment"]
    end

    %% Clinic Flow
    Start --> CollectDocs
    CollectDocs --> FillClaimForm
    FillClaimForm --> AttachDocs
    AttachDocs --> SubmitClaim
    SubmitClaim --> TrackStatus
    TrackStatus --> ReviewClaim
    AddressIssues --> TrackStatus
    ReceivePayment --> BillPatient

    %% Insurance Flow
    ReviewClaim --> ApproveClaim
    ReviewClaim --> DenyClaim
    ReviewClaim --> UnderpayClaim
    ApproveClaim --> ProcessPayment
    ProcessPayment --> ReceivePayment
    DenyClaim --> AddressIssues
    UnderpayClaim --> AddressIssues

    %% Styling
    style Start fill:#f9f,stroke:#333,stroke-width:2px
    style CollectDocs fill:#ff9,stroke:#333,stroke-width:2px
    style FillClaimForm fill:#9f9,stroke:#333,stroke-width:2px
    style AttachDocs fill:#9ff,stroke:#333,stroke-width:2px
    style SubmitClaim fill:#f99,stroke:#333,stroke-width:2px
    style TrackStatus fill:#99f,stroke:#333,stroke-width:2px
    style AddressIssues fill:#9ff,stroke:#333,stroke-width:2px
    style ReceivePayment fill:#f9f,stroke:#333,stroke-width:2px
    style BillPatient fill:#ff9,stroke:#333,stroke-width:2px
    style ReviewClaim fill:#9f9,stroke:#333,stroke-width:2px
    style ApproveClaim fill:#9ff,stroke:#333,stroke-width:2px
    style DenyClaim fill:#f99,stroke:#333,stroke-width:2px
    style UnderpayClaim fill:#99f,stroke:#333,stroke-width:2px
    style ProcessPayment fill:#9ff,stroke:#333,stroke-width:2px

```

### State diagram for Claim

```mermaid
stateDiagram
    [*] --> Created
    Created --> Filled: Fill out claim form
    Filled --> SupportingDocsAttached: Attach supporting documents
    SupportingDocsAttached --> Submitted: Submit claim form to insurance
    Submitted --> UnderReview: Insurance reviews the claim
    UnderReview --> Approved: Claim approved by insurance
    UnderReview --> Denied: Claim denied by insurance
    UnderReview --> Underpaid: Claim underpaid by insurance
    Approved --> PaymentProcessed: Payment processed by insurance
    PaymentProcessed --> Paid: Payment received by clinic
    Denied --> Resubmitted: Issues addressed and claim resubmitted
    Underpaid --> Resubmitted: Issues addressed and claim resubmitted
    Resubmitted --> UnderReview: Insurance reviews the resubmitted claim
    Paid --> [*]

```

- Payer can be the InsuranceCompany, it covers most cases
- Provider can be the Doctor, it covers most cases
- Can AppointmentTypes be considered as ProcedureIDs?
