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
    date_audit DATE,
    minutes INT,
    data INT,
    CONSTRAINT pk_audit PRIMARY KEY (id_audit)
);

DESCRIBE brands;
DESCRIBE plans;
DESCRIBE mobiles;

-- INSERTS TABLES
INSERT INTO brands (brand) 
    VALUES ('Huawei'), ('LG'), ('Motorola'), ('Nokia'), ('Samsung'), ('Sony'), ('Apple');
 
INSERT INTO mobiles (imei, id_brand, model, operating_system, antivirus, mobile_number) 
    VALUES ('302630225147395', 3, 'Moto C', 'Google Android', false, '52554212'),
           ('019760268943311', 1, '', 'Google Android', false, '55628749'),
           ('498998282215874', 1, '', 'Google Android', true, '98131103'),
           ('305077538701889', 1, '', 'Google Android', true, '82073923'),
           ('105650854472574', 2, '', 'Google Android', false, '54001671'),
           ('506224090422275', 3, '', 'Google Android', false, '52345042'),
           ('542462612496429', 3, '', 'Google Android', true, '65651022'),
           ('999087794528521', 5, '', 'Google Android', false, '99580838'),
           ('860290949543033', 4, '', 'Windows Phone', true, '86314302'),
           ('535703704655631', 4, '', 'Windows Phone', true, '96912652'),
           ('985987604840907', 3, '', 'Google Android', false, '77504261');

INSERT INTO plan_type (type)
    VALUES ('Plan de datos'), ('Plan de voz'), ('Plan de SMS');

INSERT INTO plans (plan, description, id_plan_type)
    VALUES ('Plan básico de datos', '25 GB de datos con límite velocidad', 1),
           ('Plan normal de datos', '45 GB de datos sin límite de velocidad', 1 ),
           ('Plan premium de datos', '60 GB de datos sin límite de velocidad', 1),
           ('Plan básico de voz', '200 minutos a cualquier destino dentro del territorio nacional', 2),
           ('Plan normal de voz', '700 minutos a cualquier destino dentro y fuera del territorio nacional', 2),
           ('Plan premium de voz', '1.000 minutos a cualquier destino dentro y fuera del territorio nacional', 2),
           ('Plan básico de SMS', '300 SMS a todo destino', 3),
           ('Plan normal de SMS', '500 SMS a todo destino', 3),
           ('Plan premium de SMS', '1.000 SMS a todo destino', 3);

INSERT INTO profiles (profile)
    VALUES ('Administrador'), ('Encargado'), ('Consultor');

INSERT INTO departments (department)
    VALUES ('Administración general'),
           ('Departamento de operaciones'),
           ('Asesoría de calidad'),
           ('Planificación y control'),
           ('Soporte técnico'),
           ('Asesoría jurídica'),
           ('Logística'),
           ('Almacen e inventario'),
           ('Recursos humanos'),
           ('Informática');

INSERT INTO cities (city)
    VALUES ('Santiago'), ('Valparaíso'), ('Concepción'), ('Antofagasta'),
           ('Temuco'), ('Puerto Montt'), ('Iquique'), ('Talca'), ('Valdivia');

INSERT INTO users (run, name, last_name, id_profile, email, password)
    VALUES ('16909497-7', 'Enrique', 'Costa', 1, 'enrique.costa@at.com', MD5('enrique.costa')),
           ('17237336-5', 'Alan', 'Turing', 2, 'alan.turing@at.com', MD5('alan.turing'));

INSERT INTO employees (run, name, last_name, id_department, position, email, address, id_city, incorporation_date, id_mobile) 
    VALUES ('5666644-3', 'Camilla', 'Rutledge', 4, '', 'camilla.rutledge@at.com', null, 3, null, 9),
           ('6112142-0', 'Keelie', 'Wooten', 6, '', 'keelie.wooten@at.com', null, 4, null, 2),
           ('21839128-1', 'Blythe', 'Dean', 8, '', 'blythe.dean@at.com', null, 5, null, 5),
           ('16791923-5', 'Troy', 'Boyer', 3, '', 'troy.boyer@at.com', null, 2, null, 1),
           ('27758202-3', 'Miranda', 'Daniel', 7, '', 'miranda.daniel@at.com', null, 3, null, 8),
           ('15433588-9', 'Cain', 'Sharp', 8, '', 'cain.sharp@at.com', null, 9, null, 6),
           ('8089876-2', 'Alika', 'Gillespie', 2, '', 'alika.gillespie@at.com', null, 7, null, 7),
           ('26914198-0', 'Constance', 'Lancaster', 6, '', 'constance.lancaster@at.com', null, 8, null, 4),
           ('50190022-2', 'Kellie', 'Heath', 6, '', 'kellie.heath@at.com', null, 8, null, 3),
           ('27486843-0', 'Fuller', 'Clark', 1, '', 'fuller.clark@at.com', null, 8, null, 10);


INSERT INTO employees (run,name,last_name,email) VALUES ("19916015-K","Nigel","Miranda","Mauris.molestie.pharetra@sed.net"),("13752392-2","Yoshio","Cox","dictum@atfringillapurus.edu"),("26733498-6","Melissa","Guzman","convallis@eget.ca"),("26095591-8","Uta","Cochran","Cum.sociis@sagittislobortismauris.co.uk"),("37317002-K","Jerome","Slater","eget@maurisInteger.edu"),("21846894-2","Kibo","Kline","dolor.Quisque.tincidunt@etarcuimperdiet.co.uk"),("7265131-6","Blaze","Stuart","blandit.at@magnisdisparturient.net"),("36308246-7","Germaine","Merrill","est@est.ca"),("24792403-5","Aidan","Gregory","amet.risus.Donec@ullamcorpermagnaSed.co.uk"),("31124316-0","Sharon","Erickson","quam.a.felis@Fusce.co.uk");
INSERT INTO employees (run,name,last_name,email) VALUES ("8865461-7","Yuri","Welch","conubia@perinceptoshymenaeos.org"),("47170683-3","Amethyst","Everett","per@mollisduiin.ca"),("8270905-3","Dustin","Nicholson","sapien.imperdiet.ornare@ametconsectetuer.org"),("10790925-7","Edan","Mathews","luctus.aliquet.odio@VivamusnisiMauris.ca"),("24262752-0","Caleb","Bauer","dapibus.id@tinciduntpede.ca"),("8267086-6","Astra","Anthony","interdum.Curabitur@egetmetusIn.edu"),("19582117-8","Gavin","Sears","vel.mauris@Suspendissenonleo.net"),("11864661-4","Germane","Guerra","et@natoquepenatibuset.co.uk"),("44045865-3","Thaddeus","Brennan","adipiscing@ornareelit.edu"),("47687162-K","Hilary","Koch","Nunc@commodoipsumSuspendisse.com");
INSERT INTO employees (run,name,last_name,email) VALUES ("29498986-2","Caryn","Anthony","hendrerit.consectetuer.cursus@ultricies.com"),("37605322-9","Addison","Vang","malesuada.id.erat@risusat.ca"),("44684871-2","Joshua","Burns","volutpat@egestasFusce.org"),("30504673-6","Candice","Mcdowell","vulputate.posuere@velitPellentesqueultricies.org"),("25540563-2","Ann","Bradford","vehicula.aliquet@non.co.uk"),("10772784-1","Patricia","Sharp","nulla.at.sem@turpisegestas.com"),("6619051-K","Audrey","Clark","sit@nunc.co.uk"),("31390322-2","Gabriel","Hodge","quam@massalobortis.ca"),("16845978-5","Gabriel","Hawkins","luctus.et.ultrices@Proin.co.uk"),("33270759-0","Duncan","Solis","Proin.dolor@amet.edu");
INSERT INTO employees (run,name,last_name,email) VALUES ("37377789-7","Cheyenne","Emerson","Nullam.ut.nisi@quistristique.ca"),("13971922-0","Tanek","Roy","mattis.semper@amagna.co.uk"),("31588680-5","Emmanuel","Holt","egestas.Aliquam.nec@pharetranibhAliquam.ca"),("11223247-8","Wynne","Wilkerson","purus.in.molestie@vulputateduinec.co.uk"),("49566021-4","Graiden","Buckley","ut.nulla@Maecenasmalesuadafringilla.co.uk"),("20071058-4","Autumn","Collins","ligula@ametconsectetueradipiscing.net"),("49419006-0","Leah","Cooke","placerat.velit@dictumultricies.net"),("15640447-0","Geoffrey","Walter","in@elitpellentesque.com"),("34622607-2","Ezekiel","Bernard","aliquet@neque.edu"),("38787381-3","Micah","Farley","feugiat@nunc.org");
INSERT INTO employees (run,name,last_name,email) VALUES ("44887883-K","Anne","Mcintosh","Proin.nisl@aarcu.org"),("47593536-5","Cedric","Mcbride","iaculis.quis.pede@nonummyFusce.net"),("24650928-K","Barrett","Bullock","arcu@urnajusto.ca"),("12543751-6","Eric","Barron","Donec@Morbiaccumsanlaoreet.edu"),("6501840-3","MacKenzie","Cline","fermentum.arcu@gravidamolestie.edu"),("26769485-0","Dieter","Brady","quis@felis.ca"),("24819019-1","Whoopi","Holder","natoque@ultricesa.edu"),("35944587-3","Cadman","Gregory","vestibulum.massa.rutrum@tinciduntcongueturpis.com"),("29781616-0","Boris","Levy","turpis@diamatpretium.co.uk"),("32901620-K","Lana","Walter","enim@ultricies.org");
INSERT INTO employees (run,name,last_name,email) VALUES ("31356912-8","Joy","Brady","lacus.Cras@dolorsit.edu"),("36139204-3","Ignacia","Clayton","quis@lobortis.org"),("17755868-0","Karyn","Le","elit@egestasblanditNam.co.uk"),("16953374-1","Dean","Kramer","Nulla.eget.metus@etarcuimperdiet.org"),("37708073-4","Walter","Buckner","molestie.sodales@ametanteVivamus.net"),("48504947-9","Harlan","Hobbs","amet@magnaLorem.com"),("34936519-7","Ria","Harrington","at.velit.Pellentesque@risus.co.uk"),("49779488-9","Shafira","Carpenter","et.magnis@Donec.edu"),("17244432-6","Denton","Good","ligula.Aliquam.erat@tincidunt.co.uk"),("48010967-8","Slade","Goodman","Vivamus.non@facilisisloremtristique.co.uk");
INSERT INTO employees (run,name,last_name,email) VALUES ("24412246-9","Rahim","Guerrero","enim@sapienmolestie.com"),("17618335-7","Dawn","Burt","lorem.auctor.quis@dolor.com"),("6396046-2","Alvin","Benson","eleifend@blanditmattisCras.org"),("43471832-5","Flynn","Greer","at.sem@nisl.ca"),("31337760-1","Cade","Finch","eu.metus@acfacilisis.net"),("12970325-3","Zephania","House","pede.Nunc.sed@bibendumullamcorperDuis.edu"),("31626349-6","Illana","Stewart","quis.tristique.ac@cursuseteros.com"),("50808499-4","TaShya","Jarvis","aliquet.magna.a@cursusinhendrerit.net"),("13848917-5","Victor","Albert","vitae.sodales@tristiqueneque.com"),("5994872-5","Zachery","Fisher","Proin.dolor.Nulla@In.edu");
INSERT INTO employees (run,name,last_name,email) VALUES ("29891095-0","Kimberly","Townsend","Quisque.libero.lacus@Etiamimperdiet.net"),("6427820-7","Nita","Sutton","consectetuer.adipiscing.elit@Maurisquis.net"),("28466212-1","Allistair","Olsen","ipsum.dolor@loremeget.ca"),("15012134-5","Nora","Knowles","non@ultriciesadipiscing.co.uk"),("31283873-7","Nevada","Marks","bibendum.Donec.felis@etmagnisdis.co.uk"),("16076233-0","Gisela","Rodgers","Morbi.vehicula.Pellentesque@arcuCurabitur.edu"),("9089808-6","Barry","Wilkerson","interdum.Nunc@arcu.co.uk"),("50784599-1","Hillary","Mckenzie","tellus@pharetraNam.edu"),("40809374-0","Valentine","Aguirre","metus@lacinia.co.uk"),("28499900-2","Lael","Smith","non.quam@eueleifendnec.net");
INSERT INTO employees (run,name,last_name,email) VALUES ("23085241-3","Dante","Hooper","vitae.risus@lectusante.net"),("22156087-6","Stuart","Webb","at.iaculis@posuere.co.uk"),("10685005-4","Jamal","Crane","sit.amet.ultricies@euultricessit.com"),("34144330-K","Nerea","Christensen","quis.diam.Pellentesque@ridiculus.com"),("22426922-6","Noelani","Pugh","at.libero@dictum.edu"),("25699731-2","George","Mathews","elit.Nulla@pede.org"),("33036744-K","Laurel","Petty","Nulla.eu@euismod.edu"),("36795444-2","Oprah","Porter","tellus@molestieSedid.net"),("11839963-3","Angela","Brewer","arcu.et@Duisdignissimtempor.ca"),("33140259-1","Berk","Ratliff","non@lobortisnisinibh.co.uk");


SELECT id_employee AS id,run,name,last_name,id_department AS department,position,email,address,id_city AS city,incorporation_date AS incorporation,id_mobile AS mobile FROM employees;
SELECT id_mobile AS id,imei,id_brand AS brand,model,storage_capacity AS capacity,front_camera AS f_camera,back_camera AS b_camera,internal_storage,operating_system AS os,antivirus,mobile_date,mobile_number AS number,mobile_status AS status FROM mobiles;

