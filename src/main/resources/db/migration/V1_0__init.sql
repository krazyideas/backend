create table idea(
    id bigserial primary key,
    name varchar(255) not null,
    description varchar(255),
    short_description varchar(255),
    html varchar(4000)
);

create table person(
  id bigserial primary key,
  name varchar(255) not null,
  email varchar(255),
  auth_id varchar(255) not null,
  admin_flag char not null default 'N' check (admin_flag in ('Y', 'N'))
);

create unique index person_u1 on person(auth_id);

create table vote(
  id bigserial,
  person_id bigint not null,
  idea_id bigint not null,
  primary key (person_id, idea_id),
  foreign key (person_id) references person(id),
  foreign key (idea_id) references idea(id)
);
