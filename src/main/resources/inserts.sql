CREATE TABLE Employee (id SERIAL NOT NULL, document_nr varchar(30) NOT NULL UNIQUE, surname varchar(30) NOT NULL, first_name varchar(30) NOT NULL, second_name varchar(30), sex char(1), department varchar(30), login varchar(30) NOT NULL UNIQUE, password varchar(100) NOT NULL CHECK(length(password) >=8), fk_institution_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Program (id SERIAL NOT NULL, title varchar(100) NOT NULL, days_nr int4, transport_type varchar(30), is_abroad int2 NOT NULL, is_for_children int2, description varchar(2000) NOT NULL, PRIMARY KEY (id), CONSTRAINT min_characters_number_in_description CHECK (length(description) >= 100));
CREATE TABLE Tour (id SERIAL NOT NULL, price float4 NOT NULL, date date, max_participants_nr int4 NOT NULL, fk_program_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Attraction (id SERIAL NOT NULL, title varchar(30) NOT NULL, price float4, description varchar(2000) NOT NULL, fk_program_id bigint unsigned NOT NULL, fk_institution_id bigint unsigned NOT NULL, PRIMARY KEY (id), CONSTRAINT description_min_length CHECK (length(description) >= 100), CONSTRAINT non_negative_price CHECK (price >= 0));
CREATE TABLE Institution (id SERIAL NOT NULL, name varchar(50) NOT NULL, type varchar(30) NOT NULL, description varchar(2000), hours varchar(500), address varchar(50) NOT NULL, tel varchar(20) NOT NULL, PRIMARY KEY (id), CONSTRAINT min_description_length CHECK (length(description) >= 100));
CREATE TABLE Delegation (id SERIAL NOT NULL, role varchar(30), fk_employee_id bigint unsigned NOT NULL, fk_tour_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Participant (id SERIAL NOT NULL, document_nr varchar(30) NOT NULL UNIQUE, surname varchar(30) NOT NULL, first_name varchar(30) NOT NULL, second_name varchar(30), sex char(1), email varchar(255), fk_booking_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Payment (id SERIAL NOT NULL, fk_customer_id bigint unsigned NOT NULL, fk_booking_id bigint unsigned NOT NULL, value float4 NOT NULL, PRIMARY KEY (id), CONSTRAINT positive_nr_value CHECK (value > 0));
CREATE TABLE Review (id SERIAL NOT NULL, title varchar(30) NOT NULL, points int4, description varchar(2000), fk_booking_id bigint unsigned NOT NULL, fk_program_id bigint unsigned NOT NULL, PRIMARY KEY (id), CONSTRAINT available_points CHECK (1 or 2 or 3 or 4 or 5));
CREATE TABLE Booking (id SERIAL NOT NULL, date date NOT NULL, is_paid int2, participants_nr int4 NOT NULL, fk_tour_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Enrollment (id SERIAL NOT NULL, fk_booking_id bigint unsigned NOT NULL, fk_attraction_id bigint unsigned NOT NULL, PRIMARY KEY (id));
CREATE TABLE Customer (id SERIAL NOT NULL, document_nr varchar(30) NOT NULL UNIQUE, surname varchar(30) NOT NULL, first_name varchar(30) NOT NULL, second_name varchar(30), sex char(1), login varchar(30) NOT NULL UNIQUE, password varchar(100) NOT NULL, email varchar(255), PRIMARY KEY (id), CONSTRAINT pass_min_length CHECK (length(password) >= 8));
CREATE TABLE Photo (id SERIAL NOT NULL, path_name varchar(255) NOT NULL UNIQUE, fk_institution_id  bigint unsigned, fk_program_id  bigint unsigned, PRIMARY KEY (id));
CREATE TABLE Language (id SERIAL NOT NULL, language varchar(30) NOT NULL, level char(2) NOT NULL, PRIMARY KEY (id), CONSTRAINT language_level_format CHECK (level in('A1', 'A2', 'B1', 'B2', 'C1', 'C2')));
CREATE TABLE KnowledgeOfLanguages (id SERIAL NOT NULL, fk_employee_id bigint unsigned NOT NULL, fk_language_id bigint unsigned NOT NULL, PRIMARY KEY (id));

ALTER TABLE Attraction ADD CONSTRAINT FKAttraction383532 FOREIGN KEY (fk_institution_id) REFERENCES Institution (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Attraction ADD CONSTRAINT FKAttraction651690 FOREIGN KEY (fk_program_id) REFERENCES Program (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Tour ADD CONSTRAINT FKTours627152 FOREIGN KEY (fk_program_id) REFERENCES Program (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Employee ADD CONSTRAINT FKEmployee358603 FOREIGN KEY (fk_institution_id) REFERENCES Institution (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Delegation ADD CONSTRAINT FKDelegation736122 FOREIGN KEY (fk_tour_id) REFERENCES Tour (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Delegation ADD CONSTRAINT FKDelegation63455 FOREIGN KEY (fk_employee_id) REFERENCES Employee (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Enrollment ADD CONSTRAINT FKEnrollment989483 FOREIGN KEY (fk_attraction_id) REFERENCES Attraction (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Enrollment ADD CONSTRAINT FKEnrollment466613 FOREIGN KEY (fk_booking_id) REFERENCES Booking (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Booking ADD CONSTRAINT FKBookings775995 FOREIGN KEY (fk_tour_id) REFERENCES Tour (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Review ADD CONSTRAINT FKReviews462455 FOREIGN KEY (fk_booking_id) REFERENCES Booking (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Review ADD CONSTRAINT FKReviews983338 FOREIGN KEY (fk_program_id) REFERENCES Program (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Payment ADD CONSTRAINT FKPayments818779 FOREIGN KEY (fk_booking_id) REFERENCES Booking (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Payment ADD CONSTRAINT FKPayments699536 FOREIGN KEY (fk_customer_id) REFERENCES Customer (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Photo ADD CONSTRAINT FKPhotos112970 FOREIGN KEY (fk_institution_id) REFERENCES Institution (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Photo ADD CONSTRAINT FKPhotos176602 FOREIGN KEY (fk_program_id) REFERENCES Program (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE KnowledgeOfLanguages ADD CONSTRAINT FKKnowledgeO546476 FOREIGN KEY (fk_employee_id) REFERENCES Employee (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE KnowledgeOfLanguages ADD CONSTRAINT FKKnowledgeO300347 FOREIGN KEY (fk_language_id) REFERENCES Language (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Participant ADD CONSTRAINT FKParticipan429663 FOREIGN KEY (fk_booking_id) REFERENCES Booking (Id)
    ON DELETE CASCADE ON UPDATE CASCADE;
