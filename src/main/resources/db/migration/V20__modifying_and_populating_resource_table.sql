alter table if exists resources drop column if exists location_id;
alter table resources add column if not exists location_id bigint references locations(id);

create table if not exists resource_service (
                                                resource_id bigint references resources(id),
                                                service_id bigint references services(id),
                                                price int,
                                                primary key (resource_id, service_id)
);

insert into resources (id, name, address, description, location_id)
select 2, 'PZU Dr. Antovska', 'Anton Popov br. 13', 'Orthodontist', 1
where not exists (select 1 from resources where id = 2);