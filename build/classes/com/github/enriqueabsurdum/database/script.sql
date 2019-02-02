-- CREATE DATABASE
CREATE DATABASE adelta_technology;
USE adelta_technology;

-- CREATE TABLES
CREATE TABLE brands (
    id_brand INT(11) AUTO_INCREMENT NOT NULL,
    brand VARCHAR(64) NOT NULL,
    CONSTRAINT pk_brand PRIMARY KEY (id_brand),
    CONSTRAINT uc_brand UNIQUE (brand)
);

CREATE TABLE plan_type (
    id_plan_type INT(11) AUTO_INCREMENT NOT NULL,
    type VARCHAR(64) NOT NULL,
    CONSTRAINT pk_plan_type PRIMARY KEY (id_plan_type),
    CONSTRAINT uc_plan_type UNIQUE (type)
);

CREATE TABLE plans (
    id_plan INT(11) AUTO_INCREMENT NOT NULL,
    plan VARCHAR(32) NOT NULL,
    description VARCHAR(64) NOT NULL,
    id_plan_type INT(11) NOT NULL,
    CONSTRAINT pk_plan PRIMARY KEY (id_plan),
    CONSTRAINT uc_plan UNIQUE (plan),
    CONSTRAINT fk_plan_type FOREIGN KEY (id_plan_type) REFERENCES plan_type (id_plan_type)
);

CREATE TABLE mobiles (
    id_mobile INT(11) AUTO_INCREMENT NOT NULL,
    imei VARCHAR(16) NOT NULL,
    id_brand INT(11) NOT NULL,
    model VARCHAR(64) NOT NULL,
    storage_capacity VARCHAR(16) NULL,
    front_camera VARCHAR(16) NULL,
    back_camera VARCHAR(16) NULL,
    internal_storage VARCHAR(16) NULL,
    operating_system VARCHAR(32) NOT NULL,
    antivirus TINYINT(1) NOT NULL,
    mobile_date DATE NULL,
    mobile_number VARCHAR(16) NOT NULL,
    CONSTRAINT pk_mobile PRIMARY KEY (id_mobile),
    CONSTRAINT uc_mobile_imei UNIQUE (imei),
    CONSTRAINT uc_mobile_number UNIQUE (mobile_number),
    CONSTRAINT fk_mobile_brand FOREIGN KEY (id_brand) REFERENCES brands (id_brand)
);

CREATE TABLE profiles (
    id_profile INT(11) AUTO_INCREMENT NOT NULL,
    profile VARCHAR(16) NOT NULL,
    CONSTRAINT pk_profile PRIMARY KEY (id_profile),
    CONSTRAINT uc_profile UNIQUE (profile)
);

CREATE TABLE users (
    id_user INT(11) AUTO_INCREMENT NOT NULL,
    run VARCHAR(16) NOT NULL,
    name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    id_profile INT(11) NOT NULL,
    email VARCHAR(64) NOT NULL,
    password VARCHAR(32) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id_user),
    CONSTRAINT uc_user_email UNIQUE (email),
    CONSTRAINT uc_user_run UNIQUE (run),
    CONSTRAINT fk_user_profile FOREIGN KEY (id_profile) REFERENCES profiles (id_profile)
);

CREATE TABLE departments (
    id_department INT(11) AUTO_INCREMENT NOT NULL,
    department VARCHAR(64) NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (id_department),
    CONSTRAINT uc_department UNIQUE (department)
);

CREATE TABLE cities (
    id_city INT(11) AUTO_INCREMENT NOT NULL,
    city VARCHAR(32) NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (id_city),
    CONSTRAINT uc_city UNIQUE (city)
);

CREATE TABLE employees (
    id_employee INT(11) AUTO_INCREMENT NOT NULL,
    run VARCHAR(16) NOT NULL,
    name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    id_department INT(11) NOT NULL,
    position VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    address VARCHAR(128) NULL,
    id_city INT(11) NOT NULL,
    incorporation_date DATE NULL,
    id_mobile INT(11) NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id_employee),
    CONSTRAINT uc_employee_run UNIQUE (run),
    CONSTRAINT uc_employee_email UNIQUE (email),
    CONSTRAINT fk_employee_department FOREIGN KEY (id_department) REFERENCES departments (id_department),
    CONSTRAINT fk_employee_city FOREIGN KEY (id_city) REFERENCES cities (id_city),
    CONSTRAINT fk_employee_mobile FOREIGN KEY (id_mobile) REFERENCES mobiles (id_mobile)
);

CREATE TABLE mobiles_plans (
    id_mobile_plan INT(11) AUTO_INCREMENT NOT NULL,
    id_mobile INT(11) NOT NULL,
    id_plan INT(11) NOT NULL,
    CONSTRAINT pk_mobile_plan PRIMARY KEY (id_mobile_plan), 
    CONSTRAINT fk_mobile_plan_mobile FOREIGN KEY (id_mobile) REFERENCES mobiles (id_mobile),
    CONSTRAINT fk_mobile_plan_plan FOREIGN KEY (id_plan) REFERENCES plans (id_plan)
);

CREATE TABLE audit (
    id_audit INT(11) AUTO_INCREMENT NOT NULL,
    id_mobile INT(11) NOT NULL,
    date_audit DATE,
    minutes INT,
    data INT,
    CONSTRAINT pk_audit PRIMARY KEY (id_audit)
);
