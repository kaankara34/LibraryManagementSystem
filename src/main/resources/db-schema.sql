DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS checks;
DROP TABLE IF EXISTS cleaning;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS userType;
DROP TABLE IF EXISTS roomsamenities;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS roomtype;
DROP TABLE IF EXISTS amenity;

CREATE TABLE userType (
                          userTypeID INT NOT NULL,
                          userTypeName varchar(50) NOT NULL,
                          PRIMARY KEY (userTypeID)
);

CREATE TABLE users (
                       userID INT NOT NULL AUTO_INCREMENT,
                       userTypeID INT,
                       user_name varchar(50) not null,
                       PRIMARY KEY (userID),
                       FOREIGN KEY (userTypeID) REFERENCES userType(userTypeID) ON DELETE SET NULL
);
ALTER TABLE users AUTO_INCREMENT=1;

CREATE TABLE roomType (
                          roomTypeID INT NOT NULL,
                          roomTypeName varchar(50) NOT NULL,
                          peopleSize INT NOT NULL,
                          PRIMARY KEY (roomTypeID)
);

CREATE TABLE rooms(
                      roomID INT NOT NULL AUTO_INCREMENT,
                      roomTypeID INT,
                      room_name varchar(50) NOT NULL,
                      UNIQUE (room_name),
                      PRIMARY KEY (roomID),
                      FOREIGN KEY (roomTypeID) REFERENCES roomType(roomTypeID) ON DELETE SET NULL
);
ALTER TABLE users AUTO_INCREMENT=1;

CREATE TABLE booking(
                        userID INT,
                        roomID INT,
                        bookingID INT NOT NULL AUTO_INCREMENT,
                        start_date DATE NOT NULL,
                        end_date DATE NOT NULL,
                        is_canceled boolean,
                        PRIMARY KEY (bookingID),
                        FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE SET NULL,
                        FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE SET NULL
);
ALTER TABLE booking AUTO_INCREMENT=100;

CREATE TABLE payments(
                         bookingID INT,
                         price INT NOT NULL,
                         paid boolean,
                         PRIMARY KEY (bookingID),
                         FOREIGN KEY (bookingID) REFERENCES booking(bookingID) ON DELETE cascade
);

CREATE TABLE checks (
                        userID INT,
                        roomID INT,
                        check_in DATETIME NOT NULL,
                        check_out DATETIME NOT NULL,
                        PRIMARY KEY (roomID, check_in),
                        FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE SET NULL,
                        FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE cascade
);

CREATE TABLE cleaning (
                          userID INT,
                          roomID INT,
                          cleaned boolean NOT NULL,
                          cleaining_date DATE NOT NULL,
                          PRIMARY KEY (userID,roomID,cleaining_date),
                          FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE CASCADE,
                          FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE CASCADE
);

CREATE TABLE amenity(
                        amenityID INT NOT NULL AUTO_INCREMENT,
                        amenityName VARCHAR(100) NOT NULL,
                        PRIMARY KEY(amenityID)
);
ALTER TABLE amenity AUTO_INCREMENT=1;

CREATE TABLE roomsAmenities(
                               roomID INT,
                               amenityID INT,
                               PRIMARY KEY(roomID,amenityID),
                               FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE CASCADE,
                               FOREIGN KEY (amenityID) REFERENCES amenity(amenityID) ON DELETE CASCADE
);
INSERT INTO userType (userTypeID, userTypeName) VALUES ('1','Guest');
INSERT INTO userType (userTypeID, userTypeName) VALUES ('2','Receptionist');
INSERT INTO userType (userTypeID, userTypeName) VALUES ('3','Housekeeping');
INSERT INTO userType (userTypeID, userTypeName) VALUES ('4','Administrator');

INSERT INTO roomType (roomTypeID, roomTypeName,peopleSize) VALUES ('1','One bed','1');
INSERT INTO roomType (roomTypeID, roomTypeName,peopleSize) VALUES ('2','Two bed','2');
INSERT INTO roomType (roomTypeID, roomTypeName,peopleSize) VALUES ('3','Family-sized (for 4 people)','4');

INSERT INTO amenity (amenityName) VALUES ('Coffe Maker');
INSERT INTO amenity (amenityName) VALUES ('Air Conditioning');
INSERT INTO amenity (amenityName) VALUES ('Jacuzzi');
INSERT INTO amenity (amenityName) VALUES ('Alarm Clock');
INSERT INTO amenity (amenityName) VALUES ('Iron');

INSERT INTO rooms (roomTypeID,room_name) VALUES ("1","100");
INSERT INTO rooms (roomTypeID,room_name) VALUES ("2","101");
INSERT INTO rooms (roomTypeID,room_name) VALUES ("3","102");
INSERT INTO rooms (roomTypeID,room_name) VALUES ("3","103");

INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("1","1");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("1","2");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("1","3");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("1","4");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("1","5");

INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("2","1");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("2","2");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("2","3");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("2","4");

INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("3","1");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("3","2");
INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("3","3");

INSERT INTO users (userTypeID, user_name) VALUES (4, "oguz");
INSERT INTO users (userTypeID, user_name) VALUES (3, "kemal");
INSERT INTO users (userTypeID, user_name) VALUES (2, "emir");

INSERT INTO checks (userID, roomID, check_in, check_out) VALUES (1, 1, '2022-01-01 09:00:00', '2022-01-01 12:00:00');
INSERT INTO checks (userID, roomID, check_in, check_out) VALUES (2, 1, '2022-01-02 14:00:00', '2022-01-02 18:00:00');
INSERT INTO checks (userID, roomID, check_in, check_out) VALUES (3, 2, '2022-01-03 16:00:00', '2022-01-03 20:00:00');
INSERT INTO checks (userID, roomID, check_in, check_out) VALUES (1, 3, '2022-01-04 10:00:00', '2022-01-04 14:00:00');
INSERT INTO checks (userID, roomID, check_in, check_out) VALUES (2, 1, '2022-01-05 08:00:00', '2022-01-05 12:00:00');

INSERT INTO booking (userID, roomID, start_date, end_date) VALUES (1, 1, '2022-02-01', '2022-02-03');
INSERT INTO booking (userID, roomID, start_date, end_date) VALUES (2, 1, '2022-02-05', '2022-02-08');
INSERT INTO booking (userID, roomID, start_date, end_date) VALUES (3, 2, '2022-02-10', '2022-02-12');
INSERT INTO booking (userID, roomID, start_date, end_date) VALUES (1, 3, '2022-02-15', '2022-02-17');
INSERT INTO booking (userID, roomID, start_date, end_date) VALUES (2, 1, '2022-02-20', '2022-02-22');




