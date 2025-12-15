
insert into resources values (3, 'Ortodoncija-M', 'bul Jane Sandanski br. 78-2/7', 'Orthodontist', 1),
                             (4, 'Nikol Dent', 'Majka Teresa (Vodjnanska) 5/4', 'Orthodontist', 1),
                             (5, 'Ortodoks Studio Art', '20ti Oktomvri br. 19', 'Orthodontist', 1);


insert into resource_service values (2, 1,50000),
                                    (2, 2, 40000),
                                    (2, 3, 45000),
                                    (2, 4, 60000),
                                    (2, 5, 70000),
                                    (2, 6, 38000),
                                    (2, 7, 52000),
                                    (2, 8, 40000),
                                    (2, 9, 62000),
                                    (2, 10, 40000),
                                    (2, 11, 58000),
                                    (2, 12, 40000),
                                    (2, 13, 72000);

insert into resource_service values (3, 1,48000),
                                    (3, 2, 39000),
                                    (3, 3, 46000),
                                    (3, 4, 61000),
                                    (3, 5, 72000),
                                    (3, 6, 35000),
                                    (3, 7, 51000),
                                    (3, 8, 45000),
                                    (3, 9, 62000),
                                    (3, 10, 40000),
                                    (3, 11, 58000),
                                    (3, 12, 44000),
                                    (3, 13, 71000);

insert into resource_service values (4, 1,57500),
                                    (4, 2, 43000),
                                    (4, 3, 41000),
                                    (4, 4, 62500),
                                    (4, 5, 73000),
                                    (4, 6, 39000),
                                    (4, 7, 50000),
                                    (4, 8, 43500),
                                    (4, 9, 65000),
                                    (4, 10, 51000),
                                    (4, 11, 58500),
                                    (4, 12, 48000),
                                    (4, 13, 76000);

insert into resource_service values (5, 1,50000),
                                    (5, 2, 40000),
                                    (5, 3, 45000),
                                    (5, 4, 60000),
                                    (5, 5, 70000),
                                    (5, 6, 38000),
                                    (5, 7, 52000),
                                    (5, 8, 40000),
                                    (5, 9, 62000),
                                    (5, 10, 40000),
                                    (5, 11, 58000),
                                    (5, 12, 40000),
                                    (5, 13, 72000);

drop table if exists booking_location;

alter table if exists appointments add column location_id bigint references locations(id);
alter table if exists bookings add column location_id bigint references locations(id);
