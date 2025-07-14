alter table resources drop column location_id;
alter table resources add column location_id bigint references locations(id);

create table if not exists resource_service(
                                 resource_id bigint references resources(id),
                                 service_id bigint references services(id),
                                 price int,
                                 primary key (resource_id, service_id)
);

insert into resources values (2, 'PZU Dr. Antovska', 'Anton Popov br. 13', 'Orthodontist', 1);
