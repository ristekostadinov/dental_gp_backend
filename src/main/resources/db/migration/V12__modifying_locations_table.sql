alter table locations add column resource_id bigint;
alter table locations add constraint fk_resource foreign key (resource_id) references resources(id);