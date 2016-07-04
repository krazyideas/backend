create table idea(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) not null,
    description VARCHAR(255),
    short_description VARCHAR(255),
    html VARCHAR(4000)
);

create table user_type(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  type_name VARCHAR(255) not null
);

create table person(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) not null,
  email VARCHAR(255),
  auth_id varchar(255) not null,
  user_type_Id BIGINT,
  FOREIGN KEY (user_type_Id) REFERENCES user_type(id)
);

create unique index person_u1 on person(auth_id);

create table vote(
  id BIGINT AUTO_INCREMENT,
  person_Id BIGINT not null,
  idea_Id BIGINT not null,
  PRIMARY KEY (person_Id, idea_Id),
  FOREIGN KEY (person_Id) REFERENCES person(id),
  FOREIGN KEY (idea_Id) REFERENCES idea(id)
);

