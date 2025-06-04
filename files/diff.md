# Diff snippet

```diff
diff --git a/app/canuk/assets/components/appointments/Book.svelte b/app/canuk/assets/components/appointments/Book.svelte
index e4e4d5a..fb74463 100644
--- a/app/canuk/assets/components/appointments/Book.svelte
+++ b/app/canuk/assets/components/appointments/Book.svelte
@@ -8 +8 @@
-  let cal_event_type = null
+  let cal_event_type = get_cal_event_type(user.state)
@@ -12,6 +12,4 @@
-  $: {
-    if (appt_kind == "medsrec" || appt_kind == "followup") {
-      cal_event_type = "hcp"
-    } else if (appt_kind == "initial" || appt_kind == "specfu") {
-      cal_event_type = `${user.pathway}-specialist`
-    }
+  $: console.log(cal_event_type)
+
+  $: if (cal_event_type) {
+    embed_cal()
@@ -67,0 +66,15 @@
+  function get_cal_event_type(patient_state) {
+    switch (patient_state) {
+      case 'medsrec':
+        return 'eligibility-check'
+      case 'initial':
+        return `initial-consultation-${user.pathway}`
+      case 'followup':
+        return 'hcp'
+      case 'specfu':
+        return `${user.pathway}-specialist`
+      default:
+        return null
+    }
+  }
+
@@ -80,4 +92,0 @@
-    if (!can_opt_hcp()) {
-      embed_cal()
-    }
-
@@ -90 +99 @@
-{#if can_opt_hcp() && !embedded}
+{#if !cal_event_type && can_opt_hcp() && !embedded}
@@ -94 +103 @@
-      <option value="hcp">Healthcare professional (£29)</option>
+      <option value="quarterly-consultation">Healthcare professional (£29)</option>
```
