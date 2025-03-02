create table appointments(
    id bigserial primary key,
    time timestamp,
    appointment_date date,
    patient_id bigint,
    user_id bigint,
    foreign key (patient_id) references patients(id),
    foreign key (user_id) references users(id)
);