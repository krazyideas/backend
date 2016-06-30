create table IF NOT EXISTS idea(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) not null,
    description VARCHAR(255),
    short_description VARCHAR(255),
    html VARCHAR(4000)
);

create table IF NOT EXISTS user_type(
  id BIGSERIAL PRIMARY KEY,
  type_name VARCHAR(255) not null
);

create table IF NOT EXISTS person(
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) not null,
  email VARCHAR(255),
  auth_id varchar(255) not null,
  user_type_Id BIGINT,
  FOREIGN KEY (user_type_Id) REFERENCES user_type(id)
);

create unique index person_u1 on person(auth_id);

create table IF NOT EXISTS vote(
  id BIGSERIAL,
  person_Id BIGINT not null,
  idea_Id BIGINT not null,
  PRIMARY KEY (person_Id, idea_Id),
  FOREIGN KEY (person_Id) REFERENCES person(id),
  FOREIGN KEY (idea_Id) REFERENCES idea(id)
);

