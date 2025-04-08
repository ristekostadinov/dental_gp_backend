create table location_service(
    location_id bigint,
    service_id bigint,
    primary key (location_id, service_id),
    foreign key (location_id) references locations(id),
    foreign key (service_id) references services (id)
);

