create table idea(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

create table user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

create table vote(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_Id BIGINT,
  idea_Id BIGINT,
  FOREIGN KEY (user_Id) REFERENCES user(id),
  FOREIGN KEY (idea_Id) REFERENCES idea(id)
);
