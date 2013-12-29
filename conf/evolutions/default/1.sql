# --- !Ups

CREATE SEQUENCE seq;

CREATE TABLE address (
  id         BIGINT PRIMARY KEY,
  createdAt  TIMESTAMP,
  updatedAt  TIMESTAMP,
  street     VARCHAR(200) NOT NULL,
  code       VARCHAR(10)  NOT NULL,
  state      VARCHAR(10),
  city       VARCHAR(50)  NOT NULL,
  country    VARCHAR(2)   NOT NULL,
  category   VARCHAR(10),
  preference INT
);

CREATE TABLE contact_type (
  id        BIGINT PRIMARY KEY,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255) NOT NULL
);

CREATE TABLE contact_category (
  id        BIGINT PRIMARY KEY,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255) NOT NULL
);

CREATE TABLE contact (
  id          BIGINT PRIMARY KEY,
  createdAt   TIMESTAMP,
  updatedAt   TIMESTAMP,
  value       VARCHAR(255) NOT NULL,
  type_id     BIGINT REFERENCES contact_type (id),
  category_id BIGINT REFERENCES contact_category (id),
  preference  INT
);

CREATE INDEX contact_type_index ON contact (type_id);
CREATE INDEX contact_category_index ON contact (category_id);

CREATE TABLE member_category (
  id        BIGINT PRIMARY KEY,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255) NOT NULL
);

CREATE TABLE member (
  id          BIGINT PRIMARY KEY,
  createdAt   TIMESTAMP,
  updatedAt   TIMESTAMP,
  member      VARCHAR(50)  NOT NULL UNIQUE,
  name        VARCHAR(255) NOT NULL,
  birth       DATE         NOT NULL,
  gender      VARCHAR(6)   NOT NULL,
  country     VARCHAR(2)   NOT NULL,
  admission   DATE         NOT NULL,
  category_id BIGINT REFERENCES member_category (id)
);

CREATE INDEX member_category_index ON member (category_id);

CREATE TABLE member_address (
  member_id  BIGINT REFERENCES member (id),
  address_id BIGINT REFERENCES address (id)
);

CREATE TABLE member_contact (
  member_id  BIGINT REFERENCES member (id),
  contact_id BIGINT REFERENCES contact (id)
);

CREATE TABLE member_custom_attribute_type (
  id        BIGINT PRIMARY KEY,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255) NOT NULL
);

CREATE TABLE member_custom_attribute (
  id        BIGINT PRIMARY KEY,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  value     VARCHAR(255) NOT NULL,
  member_id BIGINT REFERENCES member (id),
  type_id   BIGINT REFERENCES member_custom_attribute_type (id)
);

CREATE INDEX member_custom_attribute_member_index ON member_custom_attribute (member_id);
CREATE INDEX member_custom_attribute_type_index ON member_custom_attribute (type_id);

# --- !Downs

DROP SEQUENCE seq;

DROP TABLE address;
DROP TABLE contact;
DROP TABLE contact_type;
DROP TABLE contact_category;
DROP TABLE member;
DROP TABLE member_address;
DROP TABLE member_contact;
DROP TABLE member_category;
DROP TABLE member_custom_attribute;
DROP TABLE member_custom_attribute_type;