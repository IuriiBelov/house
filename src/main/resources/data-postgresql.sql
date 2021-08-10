insert into blocks (number) values (1);
insert into blocks (number) values (2);
insert into blocks (number) values (3);

insert into flats (floor, all_area, living_area, number, block_id) values (1, 20.0, 15.0, 1, 1);
insert into flats (floor, all_area, living_area, number, block_id) values (2, 50.0, 40.0, 2, 1);
insert into flats (floor, all_area, living_area, number, block_id) values (1, 50.0, 40.0, 3, 2);
insert into flats (floor, all_area, living_area, number, block_id) values (2, 50.0, 40.0, 4, 2);
insert into flats (floor, all_area, living_area, number, block_id) values (1, 50.0, 40.0, 5, 3);
insert into flats (floor, all_area, living_area, number, block_id) values (2, 50.0, 40.0, 6, 3);

insert into owners (name, phone_number) values ('Ivanov Ivan', '123');
insert into owners (name, phone_number) values ('Petrov Petr', '456');
insert into owners (name, phone_number) values ('Petrov Ivan', '789');

insert into flats_owners (flat_id, owner_id) values (1, 1);
insert into flats_owners (flat_id, owner_id) values (1, 2);
insert into flats_owners (flat_id, owner_id) values (1, 3);