CREATE SCHEMA IF NOT EXISTS TOOLS;
SET SCHEMA TOOLS;
CREATE SEQUENCE mt_accounts_account_id_seq START WITH 1 INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;
CREATE TABLE mt_accounts (
  account_id bigint NOT NULL default mt_accounts_account_id_seq.nextval primary key,
  account_name varchar(100) NOT NULL,
  account_tariff_plan_id bigint
);
CREATE SEQUENCE mt_users_user_id_seq START WITH 1 INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;
CREATE TABLE mt_users (
  user_id integer NOT NULL default mt_users_user_id_seq.nextval primary key,
  user_name varchar(320) NOT NULL,
  user_account_id bigint,
  user_role_id bigint,
  user_firstname varchar(100),
  user_lastname varchar(100),
  user_locked_system boolean default false,
  user_locked_admin boolean default false,
  user_created date not null default CURRENT_DATE,
  user_modified date not null default CURRENT_DATE
);
CREATE SEQUENCE mt_roles_role_id_seq START WITH 1 INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;
CREATE TABLE mt_roles (
  role_id integer NOT NULL default mt_roles_role_id_seq.nextval primary key,
  role_name varchar(100) NOT NULL
);
CREATE SEQUENCE mt_tariff_plans_tariff_plan_id_seq START WITH 1 INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;
CREATE TABLE mt_tariff_plans (
  tariff_plan_id integer NOT NULL default mt_tariff_plans_tariff_plan_id_seq.nextval primary key,
  tariff_plan_name varchar(100) NOT NULL,
  tariff_plan_description varchar(500)
);
ALTER TABLE mt_accounts ADD CONSTRAINT account_tariff_plan_id_fkey FOREIGN KEY (account_tariff_plan_id) REFERENCES mt_tariff_plans(tariff_plan_id);
ALTER TABLE mt_users ADD CONSTRAINT user_account_id_fkey FOREIGN KEY (user_account_id) REFERENCES mt_accounts(account_id);
ALTER TABLE mt_users ADD CONSTRAINT user_role_id_fkey FOREIGN KEY (user_role_id) REFERENCES mt_roles(role_id);

INSERT INTO mt_tariff_plans(tariff_plan_name, tariff_plan_description) VALUES ('Basic', 'Basic tariff');
INSERT INTO mt_tariff_plans(tariff_plan_name, tariff_plan_description) VALUES ('Advanced', 'Advanced tariff');
INSERT INTO mt_tariff_plans(tariff_plan_name, tariff_plan_description) VALUES ('Super', 'Super tariff');
INSERT INTO mt_roles (role_name) VALUES ('AccountAdministrator');
INSERT INTO mt_roles (role_name) VALUES ('Administrator');
INSERT INTO mt_roles (role_name) VALUES ('User');
INSERT INTO mt_accounts (account_name, account_tariff_plan_id) VALUES ('account1', (SELECT tariff_plan_id FROM mt_tariff_plans WHERE tariff_plan_name = 'Basic'));
INSERT INTO mt_accounts (account_name, account_tariff_plan_id) VALUES ('account2', (SELECT tariff_plan_id FROM mt_tariff_plans WHERE tariff_plan_name = 'Advanced'));
INSERT INTO mt_accounts (account_name, account_tariff_plan_id) VALUES ('account3', (SELECT tariff_plan_id FROM mt_tariff_plans WHERE tariff_plan_name = 'Super'));
INSERT INTO mt_users (user_name, user_account_id, user_role_id, user_firstname, user_lastname) VALUES (
  'user1@mawashi.tools', (SELECT account_id FROM mt_accounts WHERE account_name = 'account1'),
  (SELECT role_id FROM mt_roles WHERE role_name = 'AccountAdministrator'),
  'Vasya', 'Vasilyev'
);
INSERT INTO mt_users (user_name, user_account_id, user_role_id, user_firstname, user_lastname) VALUES (
  'user2@mawashi.tools', (SELECT account_id FROM mt_accounts WHERE account_name = 'account1'),
  (SELECT role_id FROM mt_roles WHERE role_name = 'Administrator'),
  'Petya', 'Petrov'
);
INSERT INTO mt_users (user_name, user_account_id, user_role_id, user_firstname, user_lastname) VALUES (
  'user3@mawashi.tools', (SELECT account_id FROM mt_accounts WHERE account_name = 'account1'),
  (SELECT role_id FROM mt_roles WHERE role_name = 'User'),
  'Ivan', 'Ivanov'
);
INSERT INTO mt_users (user_name, user_account_id, user_role_id, user_firstname, user_lastname) VALUES (
  'user4@mawashi.tools', (SELECT account_id FROM mt_accounts WHERE account_name = 'account2'),
  (SELECT role_id FROM mt_roles WHERE role_name = 'AccountAdministrator'),
  'Kolya', 'Kolev'
);
INSERT INTO mt_users (user_name, user_account_id, user_role_id, user_firstname, user_lastname) VALUES (
  'user5@mawashi.tools', (SELECT account_id FROM mt_accounts WHERE account_name = 'account3'),
  (SELECT role_id FROM mt_roles WHERE role_name = 'AccountAdministrator'),
  'Misha', 'Mishin'
);
CREATE VIEW mt_users_view AS
SELECT U.user_id, U.user_name, A.account_name, T.tariff_plan_name, R.role_name, U.user_firstname, U.user_lastname
FROM mt_users U, mt_accounts A, mt_roles R, mt_tariff_plans T
WHERE U.user_account_id = A.account_id AND U.user_role_id = R.role_id
AND A.account_tariff_plan_id = T.tariff_plan_id
GROUP BY U.user_name, A.account_name ORDER BY U.user_id;
