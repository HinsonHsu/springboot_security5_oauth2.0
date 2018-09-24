CREATE TABLE sys_user (
  id            int  auto_increment PRIMARY KEY,
  username      VARCHAR (80),
  password      VARCHAR (80),
  twitterid     VARCHAR (30),
  facebookid    VARCHAR (30),
  githubid      VARCHAR (30)
);
CREATE TABLE sys_role (
  id            int auto_increment primary key,
  name varchar(80)
);
create table sys_role_user(
  id int auto_increment primary key,
  sys_user_id int,
  sys_role_id int,
  foreign key(sys_user_id) references sys_user(id),
  foreign key(sys_role_id) references sys_role(id)
);