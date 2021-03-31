# Phase3-Assessment-TaskManager
Create a task manager application with spring boot and spring Data JPA.

## SQL Setup

#### Creating Task table
```
create table task(
    id int not null auto_increment primary key,
    task_name varcahr(255) not null,
    severity enum('low','medium','high') default 'low',
    description varchar(255) not null,
    start_date datetime(6) not null,
    end_date datetime(6) not null,
    user_id default null);
    
    alter table task add foreign key (user_id) references user(id);
```

### Creating User table
```
create table user(
    id int auto_increment not null primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null);
```
### Adding preset Users into DB
```
insert into user(name,email,password) values ('Bobby', 'Idgits@gmail.com', 'SingerIdgits4'), ('Dean', 'NotMicheal@outlook.com', 'AngelsBoy67'),('Sam', 'Sammy@hotmail.com', 'LucifersMeatSuit66'), ('Crowley', 'KingCrowley@hotmail.com', 'KingofHell'), ('Castiel', 'Cass@myspace.com', 'LostmyMojo');
```

## Using the Application
Task manager allows the user to login either as a normal user or a admin (Reference preset users for Roles). Users role can see what tasks they have been assigned though they cannot edit their tasks for the day. This was going to be implemented as a additional feature but time prevented this. The edit would have allowed the user to change the status of the task (complete or incomplete).

Admins are the main director of the application and can add tasks to users, delete users and tasks from the manage (tasks|users), and would have been able to edit them (fell flat due to time). 

New users can also register themselves to be able to recieve tasks and manage their own personal tasks. The registration is added to the db then can be seen and modified or deleted afterwards.
