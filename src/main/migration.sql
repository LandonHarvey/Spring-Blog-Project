

USE adventures_db;
DROP DATABASE adventures_db;
CREATE DATABASE adventures_db;

DROP TABLE IF EXISTS adventure;
DROP TABLE IF EXISTS orc;
DROP TABLE IF EXISTS adventurer;
DROP TABLE IF EXISTS user;

INSERT INTO user(username, password, email)
  VALUE ('123', 'jeff3', 'swagdude@bob.com');

INSERT INTO adventure(body, imgurl, title)
VALUE ('adventure of a lifetime','totallyurl','hello');

INSERT INTO adventurer(arrows, healing, health, imgurl, level, name, user_id)
  VALUE (2,3,4,'hello',1,'jeff',1);

INSERT INTO adventurer(arrows, healing, health, imgurl, level, name, user_id)
  VALUE (2,3,4,'asdfasdfasd',1,'dafsdfasdfsadfdsafdasfsdafa',1);

INSERT INTO adv_adventurers(adventure_id, adventurer_id)
VALUES (1,1);

INSERT INTO adv_adventurers(adventure_id, adventurer_id)
VALUES (1,2);

INSERT INTO orc(health,healing,arrows,imgurl)
VALUES (10, 2,20,'/resources/static/img/orc.jpg');

INSERT INTO orc(health,healing,arrows,imgurl)
VALUES (5, 2,50,'/resources/static/img/orc2.jpg');

INSERT INTO orc(health,healing,arrows,imgurl)
VALUES (15, 1,0,'/resources/static/img/urak1,jpg');

SELECT
      a.id as id, adv.id as advid, adv.body as advbody, adv.imgurl as advimage, adv.title as advtitle, adv.adventurelog_id as adid,
       advr.id as advrid, advr.arrows as advrarrows, advr.healing as advrhealing, advr.health as advrhealth, advr.imgurl as advrimg,
       advr.level as advrlvl, advr.name as advrname, advr.user_id as advruser
FROM adventure_log AS a
JOIN adventurer as advr on advr.adventurelog_id = a.id
JOIN adventure adv on a.id = adv.adventurelog_id
WHERE a.id =1;

SELECT
  a.id as id, a.postion as postion, adv.id as advid, adv.body as body, adv.imgurl as advimage, adv.title as title, adv.adventurelog_id as adid,
  advr.id as advrid, advr.arrows as advrarrows, advr.healing as advrhealing, advr.health as advrhealth, advr.imgurl as advrimage,
  advr.level as advrlvl, advr.name as advrname, advr.user_id as advruser
FROM adventure_log AS a
JOIN adventurer as advr on advr.adventurelog_id = a.id
JOIN adventure adv on a.id = adv.adventurelog_id
WHERE a.id = 1;

SELECT *
FROM adventure
WHERE adventurelog_id = 1
