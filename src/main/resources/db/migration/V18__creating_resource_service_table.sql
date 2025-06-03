create table resource_service(
    resource_id bigint references resources(id),
    service_id bigint references services(id),
    price int,
    primary key (resource_id, service_id)
)
