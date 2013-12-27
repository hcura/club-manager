# --- !Ups

CREATE SEQUENCE seq;

CREATE TABLE address (
  id         BIGINT,
  createdAt  TIMESTAMP,
  updatedAt  TIMESTAMP,
  street     VARCHAR(200),
  code       VARCHAR(10),
  state      VARCHAR(10),
  city       VARCHAR(50),
  country    VARCHAR(2),
  category   VARCHAR(10),
  preference INT,
  PRIMARY KEY (id)
);

CREATE TABLE contact (
  id          BIGINT,
  createdAt   TIMESTAMP,
  updatedAt   TIMESTAMP,
  value       VARCHAR(255),
  type_id     BIGINT,
  category_id BIGINT,
  preference  INT,
  PRIMARY KEY (id)
);

CREATE TABLE contact_type (
  id        BIGINT,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE contact_category (
  id        BIGINT,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE member (
  id          BIGINT,
  createdAt   TIMESTAMP,
  updatedAt   TIMESTAMP,
  member      VARCHAR(50),
  name        VARCHAR(255),
  birth       DATE,
  gender      VARCHAR(6),
  country     VARCHAR(2),
  admission   DATE,
  category_id BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE member_address (
  member_id  BIGINT,
  address_id BIGINT
);

CREATE TABLE member_contact (
  member_id  BIGINT,
  contact_id BIGINT
);

CREATE TABLE member_custom_attribute (
  id        BIGINT,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  value     VARCHAR(255),
  typeId    BIGINT,
  member_id BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE member_custom_attribute_type (
  id        BIGINT,
  createdAt TIMESTAMP,
  updatedAt TIMESTAMP,
  name      VARCHAR(255),
  PRIMARY KEY (id)
);

# --- !Downs

DROP SEQUENCE seq;

DROP TABLE address;
DROP TABLE contact;
DROP TABLE contact_type;
DROP TABLE contact_category;
DROP TABLE member;
DROP TABLE member_address;
DROP TABLE member_contact;
DROP TABLE member_custom_attribute;
DROP TABLE member_custom_attribute_type;