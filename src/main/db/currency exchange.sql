create table currency (
	currency_id smallint(4) auto_increment,
    short_name varchar(5) not null,
    long_name varchar(50) not null,
    country varchar(50) not null,
    sell float,
    buy float,
	primary key(currency_id)
);

create table user_types (
	usrtype_id smallint(4) auto_increment,
    type_name varchar(50) not null,
    primary key(usrtype_id)
);


create table users (
	user_id smallint(4),
    login varchar(50) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    password varchar(50) not null,
    usrtype_id smallint(4) not null,
    primary key(user_id),
    foreign key(usrtype_id) references user_types(usrtype_id)
);

create table transactions (
	tr_id smallint(4) auto_increment,
    currency_id smallint(4) not null,
    tr_date timestamp not null,
    amount float not null,
    type smallint(1) not null,
    user_id smallint(4) not null,
    client_id smallint(4) not null,
    info varchar(200),
    primary key(tr_id),
    foreign key(currency_id) references currency(currency_id),
    foreign key(user_id) references users(user_id),
    foreign key(client_id) references users(user_id)
);

