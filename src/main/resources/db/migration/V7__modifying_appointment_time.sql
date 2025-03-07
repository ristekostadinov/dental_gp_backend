alter table appointments drop column time;
alter table appointments alter column appointment_date type timestamptz;
