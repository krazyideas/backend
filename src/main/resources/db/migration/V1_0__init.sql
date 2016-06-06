create table idea(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    short_description VARCHAR(255)
);

create table user_type(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  type_name VARCHAR(255)
);

create table person(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  user_type_Id BIGINT,
  FOREIGN KEY (user_type_Id) REFERENCES user_type(id)
);

create table vote(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  person_Id BIGINT,
  idea_Id BIGINT,
  FOREIGN KEY (person_Id) REFERENCES person(id),
  FOREIGN KEY (idea_Id) REFERENCES idea(id)
);



