alter table appointments drop column time;
alter table appointments add column appointment_date timestamptz;
