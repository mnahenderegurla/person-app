 CREATE TABLE IF NOT EXISTS PERSON (
  pid VARCHAR(250) NOT NULL,
  first_name VARCHAR(250),
  last_name VARCHAR(250),
  PRIMARY KEY (pid)
);

CREATE TABLE IF NOT EXISTS ADDRESS (
  aid VARCHAR(250) NOT NULL,
  street VARCHAR(250),
  city VARCHAR(250),
  state VARCHAR(250),
  postal VARCHAR(250),
  PRIMARY KEY (aid),
  pid VARCHAR(250) NOT NULL,
  FOREIGN KEY (pid) references PERSON(pid) ON DELETE CASCADE
);