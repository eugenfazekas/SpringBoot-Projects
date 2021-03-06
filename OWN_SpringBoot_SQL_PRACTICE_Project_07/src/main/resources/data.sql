INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Aa-1111','113','2018-4-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Ab-1234','113','2018-1-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Ba-0000','113','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Bz-9999','113','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Cd-0114','117','2018-1-11');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Cx-1111','117','2016-11-5');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Cx-1234','120','2018-1-31');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Cx-1235','120','2017-1-21');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xx-0000','113','2017-1-11');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xx-0001','113','2018-1-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xx-1234','113','2018-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xx-9999','113','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xy-0000','113','2018-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xy-1234','117','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xy-9998','113','2016-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xy-9999','113','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Xz-9999','113','2017-9-01');
INSERT INTO RENDELESFEJ (rend_szam,partner_kod,rend_datum) VALUES ('Zz-9999','113','2017-9-01');

INSERT INTO TERMEK (kod,nev,ar) VALUES ('AA1','Halaszbot',12.00	);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('AA2','Gyertyatarto',12.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('AA3','Ungyujto',20.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('AA6','Golyostol',10.00	);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('BB2','MagnesvasutSzelvedo',24.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('BB3','Szemoldokcsipesz',110.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('BB4','Porcelanyanyer',110.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('BC1','Kulcstarto',1.00	);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('BX9','Szamitogephaz',2.00);
INSERT INTO TERMEK (kod,nev,ar) VALUES ('NN1','Processzorhuto',3.00	);

INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Aa-1111','AA2',2,'2028-05-10',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Aa-1111','AA6',3,'2018-5-09',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Aa-1111','BC1',2,'2018-5-14',TRUE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Aa-1111','BX9',5,'2018-5-10',TRUE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Ab-1234','BX9',1,'2018-2-21',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cd-0114','AA1',10,'2018-9-21',TRUE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cd-0114','AA6',4,'2018-9-04',TRUE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1111','AA2',3,'2016-11-10',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1111','BC1',2,'2017-9-15',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1111','BX9',1,'2016-11-14',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1234','AA6',20,'2018-2-10',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1234','BB2',1,'2018-2-10',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Cx-1235','BC1',2,'2017-2-01',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Xx-1234','BC1',1,'2018-9-30',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Xx-1234','BX9',1,'2018-9-20',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Xy-1234','AA6',2,'2017-11-10',FALSE);
INSERT INTO RENDELES (rend_szam,kod,darab,datum,kesz) VALUES ('Xy-1234','BB3',1,'2017-11-10',FALSE);

INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (111,'Vas','kg',1.20	,120.00	);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (112,'Acel','m',1.11	,300.00	);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (113,'Rez','kg',1.00	,0.00	);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (114,'Titan','kg',15.00	,4.25	);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (211,'Muanyag','cm',20.00	,0.00);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (310,'Uranium','',5.00,0		);
INSERT INTO ANYAG (azonosito,neve,mert_egys,egys_ar,keszlet) VALUES (320,'Freon','m',10.00	,130.00	);

INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA1',113,0.10	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA1',114,4.25	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA2',113,1.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA2',114,5.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA3',112,3.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA3',113,1.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA3',114,1.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('AA6',111,5.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BB2',112,5.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BB2',211,5.54	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BB3',211,11.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BB4',112,1.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BC1',111,3.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('BX9',111,4.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('NN1',310,3.00	);
INSERT INTO SZERKEZET (kod,azonosito,mennyiseg) VALUES ('NN1',320,4.00	);

INSERT INTO PARTNER (partner_kod) Values 113;
INSERT INTO PARTNER (partner_kod) Values 117;
INSERT INTO PARTNER (partner_kod) Values 120;

INSERT INTO minosit (szoveg,also) VALUES ('olcso' , 0);
INSERT INTO minosit (szoveg,also) VALUES ('kozepes' , 100);
INSERT INTO minosit (szoveg,also) VALUES ('draga' , 1000);

INSERT INTO KEDVEZMENY (also,felso,szazalek) VALUES (0 , 99 , 0);
INSERT INTO KEDVEZMENY (also,felso,szazalek) VALUES (100, 199 , 0.1);
INSERT INTO KEDVEZMENY (also,felso,szazalek) VALUES (200 , 1000000 ,  0.2);

INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('AA6',1);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('BB3',1);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('BB4',1);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('BC1',1);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('BX9',1);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('AA1',2);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('AA2',2);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('BB2',2);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('NN1',2);
INSERT INTO TERMEK_B (kod,bonyolultsag) VALUES ('AA3',3);



