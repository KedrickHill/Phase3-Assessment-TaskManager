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

## What is TaskManager
Task Manager is a simple application that allows users and admins to manipulate the populace of its users while users can view the tasks that they have been assigned. New users are allowed to register and admins can remove the users if needed. Main drive for the project was to ensure that workers could view their details and tasks.

## Task Managers Features
Task manager allows the user to login either as a normal user or a admin (Reference preset users for Roles). 

Key Features:
- User Registration
- User Display to see tasks
- Admins can add tasks to users
- Admins can delete users from their application
- Admins can delete tasks from the tasks list
    - can see which tasks are done and remove them from the database
    - can see who they are assigned to
- All Users can logout of the system and sign back into the applcation

## The Roles

### User Entity
Users role can see what tasks they have been assigned though they cannot edit their tasks for the day. This was going to be implemented as a additional feature but time prevented this. The edit would have allowed the user to change the status of the task (complete or incomplete).

### Task Entity
Admins are the main director of the application and can add tasks to users, delete users and tasks from the manage (tasks|users), and would have been able to edit them (fell flat due to time). 

### Registration
New users can also register themselves to be able to recieve tasks and manage their own personal tasks. The registration is added to the db then can be seen and modified or deleted afterwards.

## Repositories and Services
Each entity has its own personal repoository and service that it can call methods from and utilize when attempting to collect tasks, users, or both in order to display them to the User interface.

## Controller
TaskController controls all functionality throughout the application (Probably should have been split up now that I look back). When logging in the users entered password is checked to the attached username object from the database to ensure equality between the given password and the users password.

