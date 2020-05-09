insert into Blogger (id,age,name) VALUES (2,21, 'Gyula');
insert into Blogger (id,age,name) VALUES (3,26, 'Krisz');
insert into STORY (id,title,content,posted,blogger_id) values (2,'Teszt cím','Teszt tartalom', '2018-07-07', (select id FROM BLOGGER where name = 'Gyula') );
insert into STORY (id,title,content,posted,blogger_id) values (3,'Teszt2 cím','Teszt2 tartalom2', '2018-07-07', (select id FROM BLOGGER where name = 'Gyula') );
insert into STORY (id,title,content,posted,blogger_id) values (4,'Krisz cím','Krisz tartalom', '2018-07-07', (select id FROM BLOGGER where name = 'Krisz') );
insert into STORY (id,title,content,posted,blogger_id) values (5,'Krisz2 cím','Krisz2 tartalom2', '2018-07-07', (select id FROM BLOGGER where name = 'Krisz') );
insert into STORY (id,title,content,posted,blogger_id) values (6,'szia','Szia tartalom2', '2018-07-07', (select id FROM BLOGGER where name = 'Krisz') );