drop table appointments;
drop table materials;
drop table treatment_service;
drop table resource_treatment;
drop table resource_types;

alter table resources
    add column address text,
    add column description text;

create table locations(
    id bigserial primary key,
    name text
);

create table categories(
    id bigserial primary key ,
    name text
);

create type appointment_status as enum ('AVAILABLE', 'BOOKED', 'CANCELED');

create type booking_status as enum ('CREATED', 'IN_PROGRESS', 'BOOKED', 'CANCELED', 'REALIZED');

create table appointments(
    id bigserial primary key,
    date_time_from timestamptz,
    date_time_to timestamptz,
    patient_id bigint,
    resource_id bigint,
    status appointment_status,
    foreign key (patient_id) references patients(id),
    foreign key (resource_id) references resources(id)
);

create table bookings(
    id             bigserial primary key,
    date_time_from timestamptz,
    date_time_to   timestamptz,
    patient_id     bigint,
    resource_id    bigint,
    status booking_status,
    foreign key (patient_id) references patients (id),
    foreign key (resource_id) references resources (id)
);

create table booking_location(
    booking_id bigint,
    location_id bigint,
    primary key (booking_id, location_id),
    foreign key (booking_id) references bookings(id),
    foreign key (location_id) references locations(id)
)
