SELECT "appointments"."id", "appointments"."start_at", "appointments"."kind", "appointments"."state", "appointments"."data", "appointments"."created_at", "appointments"."updated_at", "appointments"."patient_id", "appointments"."host" 
FROM (
SELECT 
DISTINCT ON (appointments.patient_id) "appointments"."id", "appointments"."start_at", "appointments"."kind", "appointments"."state", "appointments"."data", "appointments"."created_at", "appointments"."updated_at", "appointments"."patient_id", "appointments"."host" 
FROM "appointments" 
INNER JOIN "patients" 
ON ("appointments"."patient_id" = "patients"."id") 
WHERE ("patients"."state" != 'discharged') 
ORDER BY "appointments"."patient_id", "appointments"."start_at" DESC
) 
AS "appointments" 
WHERE ("appointments"."start_at" = '2024-11-12') 
ORDER BY "appointments"."id"
