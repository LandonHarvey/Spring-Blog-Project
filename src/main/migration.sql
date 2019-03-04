

USE adventures_db;
DROP DATABASE adventures_db;
CREATE DATABASE adventures_db;


DROP TABLE IF EXISTS adventure;
DROP TABLE IF EXISTS orc;
DROP TABLE IF EXISTS adventurer;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS adventurelog;

INSERT INTO adventure_log(postion)
  VALUE (95);

INSERT INTO user(password, username)
  VALUE ('123', 'jeff3');

INSERT INTO adventure(body, imgurl, title, adventurelog_id)
VALUE ('adventure of a lifetime','totallyurl','hello',1);

INSERT INTO adventurer(arrows, healing, health, imgurl, level, name, user_id, adventurelog_id)
  VALUE (2,3,4,'hello',1,'jeff',1, 1);

INSERT INTO adventurer(arrows, healing, health, imgurl, level, name, user_id, adventurelog_id)
  VALUE (2,3,4,'asdfasdfasd',1,'dafsdfasdfsadfdsafdasfsdafa',1, 1);


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
