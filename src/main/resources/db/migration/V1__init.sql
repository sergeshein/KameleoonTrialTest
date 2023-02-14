DROP SEQUENCE IF EXISTS quote_seq;
create sequence quote_seq start with 1 increment by 1;
create table quotes (
    id bigserial not null,
     content varchar(255) not null,
      created_at timestamp(6) not null,
       updated_at timestamp(6),
        votes int default 0 not null,
         user_id bigint, primary key (id));

DROP SEQUENCE IF EXISTS user_seq;
create sequence user_seq start with 1 increment by 1;
create table users (
    id bigserial not null,
     created_at timestamp(6) not null,
      email varchar(255) not null,
       name varchar(255) not null,
        password varchar(255) not null, primary key (id));

DROP SEQUENCE IF EXISTS vote_seq;
create sequence vote_seq start with 1 increment by 1;
create table votes (
    id bigserial not null,
     vote_type smallint not null,
      quote_id bigint, user_id bigint,
       primary key (id));

alter table if exists users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

alter table if exists quotes
    add constraint quote_with_users foreign key (user_id) references users;

alter table if exists votes
    add constraint votes_with_quotes foreign key (quote_id) references quotes;

alter table if exists votes
    add constraint votes_with_users foreign key (user_id) references users;