create table idea(
    id bigint AUTO_INCREMENT primary key,
    name varchar(255) not null,
    description varchar(255),
    short_description varchar(255),
    html varchar(4000),
    creation_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table person(
  id bigint AUTO_INCREMENT primary key,
  name varchar(255) not null,
  email varchar(255),
  auth_id varchar(255) not null,
  admin_flag char not null default 'N' check (admin_flag in ('Y', 'N')),
  creation_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

create unique index person_u1 on person(auth_id);

create table vote(
  id bigint AUTO_INCREMENT,
  person_id bigint not null,
  idea_id bigint not null,
  index (id),
  primary key (person_id, idea_id),
  foreign key (person_id) references person(id),
  foreign key (idea_id) references idea(id),
  creation_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table comment(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  person_Id BIGINT not null,
  idea_Id BIGINT not null,
  FOREIGN KEY (person_Id) REFERENCES person(id),
  FOREIGN KEY (idea_Id) REFERENCES idea(id),
  content VARCHAR(4000) not null,
  creation_time DATETIME DEFAULT CURRENT_TIMESTAMP
);
