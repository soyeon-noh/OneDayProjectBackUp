-- 여기는 food 영역
DROP TABLE tbl_foods;
DROP TABLE tbl_company;
DROP TABLE tbl_items;

DELETE FROM tbl_company;

CREATE TABLE tbl_foods(
    fd_code	    CHAR(7)		PRIMARY KEY,
    fd_name	    nVARCHAR2(100)	NOT NULL,
    fd_year	    CHAR(4)	NOT NULL,
    fd_ccode    	CHAR(6)	NOT NULL,
    fd_icode    	CHAR(4)	NOT NULL,
    fd_container	NUMBER,
    fd_content	NUMBER	NOT NULL,
    fd_calories	NUMBER,
    fd_protein	NUMBER,
    fd_fat	    NUMBER,
    fd_carbo	NUMBER,
    fd_sugar	NUMBER
);

CREATE TABLE tbl_company(
cp_code	CHAR(6)		PRIMARY KEY,
cp_name	nVARCHAR2(100)	NOT NULL	
);

CREATE TABLE tbl_items(
it_code	CHAR(4)		PRIMARY KEY,
it_name	nVARCHAR2(50)	NOT NULL
);


ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY(fd_ccode)
REFERENCES tbl_company(cp_code);


ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY(fd_icode)
REFERENCES tbl_items(it_code);

CREATE VIEW view_식품정보 AS(
    SELECT 
        FD.fd_code AS 식품코드,
        FD.fd_name AS 식품명,
        FD.fd_year AS 출시연도,
        CP.cp_code AS 제조사코드,
        CP.cp_name AS 제조사명,
        it_code AS 분류코드,
        it_name AS 분류명,
        FD.fd_container AS "1회제공량",
        FD.fd_content AS "총내용량(g)",
        FD.fd_calories AS "에너지(kcal)",
        FD.fd_protein AS "단백질(g)",
        FD.fd_fat AS "지방(g)",
        FD.fd_carbo AS "탄수화물(g)",
        FD.fd_sugar AS "총당류(g)"
    FROM tbl_foods FD
        LEFT JOIN tbl_company CP
            ON FD.fd_ccode = CP.cp_code
        LEFT JOIN tbl_items IT
            ON FD.fd_icode = IT.it_code
);           


-------------------------------------------------

CREATE TABLE tbl_myfoods(
    my_seq NUMBER,
    my_date CHAR(10),
    my_fcode CHAR(7),
    my_intake NUMBER
);

DROP TABLE tbl_myfoods;


CREATE SEQUENCE seq_myfoods -- seq 이름
START WITH 1    -- 시작값
INCREMENT BY 1; -- 자동증가값


DROP SEQUENCE seq_myfoods;

INSERT INTO tbl_myfoods(my_seq, 
        my_date, my_fcode, my_intake)
VALUES(seq_myfoods.NEXTVAL, 
        '2021-05-09', 'PD00017', 1);
        
INSERT INTO tbl_myfoods(my_seq, 
        my_date, my_fcode, my_intake)
VALUES(seq_myfoods.NEXTVAL, 
        '2021-05-09', 'PD00102', 2);
        
INSERT INTO tbl_myfoods(my_seq, 
        my_date, my_fcode, my_intake)
VALUES(seq_myfoods.NEXTVAL, 
        '2021-05-09', 'PD00222', '1');
        
INSERT INTO tbl_myfoods(my_seq, 
        my_date, my_fcode, my_intake)
VALUES(seq_myfoods.NEXTVAL, 
        '2021-05-09', 'PD01001', 1);        

SELECT * FROM tbl_myfoods;


-------------------------------------------

CREATE VIEW view_섭취정보 AS(
    SELECT
        MY.my_date AS 날짜,
        FD.fd_name AS 식품명,
        MY.my_intake AS 섭취량,
        FD.fd_content AS "총내용량(g)",
        FD.fd_calories AS "에너지(kcal)",
        FD.fd_protein AS "단백질(g)",
        FD.fd_fat AS "지방(g)",
        FD.fd_carbo AS "탄수화물(g)",
        FD.fd_sugar AS "총당류(g)"
    FROM tbl_myfoods MY
        LEFT JOIN tbl_foods FD
            ON FD.fd_code = MY.my_fcode
);    

DROP VIEW view_섭취정보;

SELECT * FROM view_섭취정보
WHERE 날짜 = '2021-05-09';
