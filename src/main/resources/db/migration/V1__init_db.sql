drop table if exists users cascade ;
create table users(
                      id bigserial primary key,
                      username text,
                      first_name text,
                      last_name text,
                      email text,
                      password text
);

drop table if exists resources cascade ;
create table resources(
                          id bigserial primary key
);

drop table if exists patients cascade ;
create table patients(
                         id bigserial primary key,
                         first_name text,
                         last_name text,
                         email text,
                         password text,
                         phone_number text,
                         insurance boolean,
                         doctor_id bigint,
                         foreign key (doctor_id) references doctor_patient(user_id) on delete cascade
);

drop table if exists roles cascade ;
create table roles(
                      id bigserial primary key,
                      name text
);

drop table if exists resource_types;
create table resource_types(
                               type text primary key,
                               resource_id bigint
);

drop table if exists treatments cascade ;
create table treatments(
                           id bigserial primary key,
                           name text,
                           price int,
                           patient_id bigint,
                           foreign key (patient_id) references patients(id) on delete cascade
);

drop table if exists services cascade ;
create table services(
                         id bigserial primary key,
                         name text,
                         price int
);

drop table if exists materials;
create table materials(
                          id bigserial primary key,
                          name text,
                          price int,
                          service_id bigint,
                          foreign key(service_id) references services(id) on delete cascade
);

drop table if exists treatment_service;
create table if not exists treatment_service(
                                                service_id bigint,
                                                treatment_id bigint,
                                                primary key (service_id, treatment_id),
    foreign key (service_id) references services(id) on delete cascade ,
    foreign key (treatment_id) references treatments(id) on delete cascade
    );

drop table if exists user_role;
create table if not exists user_role(
                                        user_id bigint,
                                        role_id bigint,
                                        primary key (user_id, role_id),
    foreign key (user_id) references users(id) on delete cascade ,
    foreign key (role_id) references roles(id) on delete cascade
    );

drop table if exists doctor_patient cascade ;
create table if not exists doctor_patient(
                                             user_id bigint,
                                             primary key (user_id)
    );

drop table if exists resource_treatment;
create table if not exists resource_treatment(
                                                 resource_id bigint,
                                                 treatment_id bigint,
                                                 primary key (resource_id, treatment_id),
    foreign key(resource_id) references resources(id) on delete cascade ,
    foreign key(treatment_id) references treatments(id) on delete cascade
    )


