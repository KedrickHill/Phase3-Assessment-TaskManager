# Phase3-Assessment-TaskManager
Create a task manager application with spring boot and spring Data JPA.

## SQL Setup

#### Creating Task table
```
create table task(
    id int not null auto_increment primary key,
    name varchar(255) default null,
    email varchar(255) default null,
    severity enum('low','medium','high') default 'low',
    description varchar(255) default null,
    start_date datetime(6) default null,
    end_date datetime(6) default null)
    user_id foriegn key default null;
```

#### Creating User table
```
create table user(
    id int auto_increment not null primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null);
```
#### Adding preset Users into DB
```
insert into user(name,email,password) values ('Bobby', 'Idgits@gmail.com', 'SingerIdgits4'), ('Dean', 'NotMicheal@outlook.com', 'AngelsBoy67'),('Sam', 'Sammy@hotmail.com', 'LucifersMeatSuit66'), ('Crowley', 'KingCrowley@hotmail.com', 'KingofHell'), ('Castiel', 'Cass@myspace.com', 'LostmyMojo');
```
### Adding preset Tasks (Dont have to)
coming soon!
```
```
