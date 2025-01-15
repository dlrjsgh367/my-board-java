create table member (
  id number primary key,
  name varchar2(20) not null,
  sex varchar2(6) not null check (sex in ('Male', 'Female')),
  age number(3) not null check (age >= 0),
  job varchar2(20) not null,
  hobby varchar2(255),
  created_at date default sysdate
);

create sequence member_seq start with 1 increment by 1;
create or replace trigger member_trigger
before insert on member
for each row
begin
  :new.id := member_seq.nextval;
end;
/

insert into member (name, sex, age, job, hobby) values ('이건호', 'male', '20', 'employee', 'sing')