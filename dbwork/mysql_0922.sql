# 테이블 조회
SHOW TABLES; -- 전체 테이블 조회
SELECT * FROM TEST01;	-- TEST01 조회
DESC TEST01;	-- 테이블 구조 확인

-- INSERT
INSERT INTO TEST01 (NAME, AGE) VALUES ('KIM', 40);
-- NUM에 NULL 값을 주면 NULL 이 들어가는게 아니라 AUTO 숫자가 발생된다.
INSERT INTO TEST01 VALUES (NULL, 'SON', 26, 189.9, NOW(), '2023-01-01');

-- 테이블 구조 변경(ADD, DROP, COLUMN, MODIFY, RENAME COLUMN)
ALTER TABLE TEST01 ADD HP VARCHAR(20) DEFAULT '010-111-1111';	-- 컬럼 추가
ALTER TABLE TEST01 DROP COLUMN AGE;		-- age 컬럼 제거
ALTER TABLE TEST01 RENAME COLUMN BIRTHDAY TO BIRTH;	-- 컬럼명 수정

-- 테이블명 변경이됨 TEST01을 MEMBER로 변경
ALTER TABLE TEST01 RENAME  MEMBER;

-- sawon 테이블 생성 - 제약조건들도 추가하기
create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자')));
DESC SAWON;
-- sawon 의 제약 조건들 확인하기
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE TABLE_NAME='SAWON';

-- 데이터 추가
INSERT INTO SAWON VALUES (NULL, '이하나', 89, '여자', '홍보부');
-- 제약 조건 오류 확인하기
-- Error Code : 3819. Check constraint 'ck_sawon_score' is violated.
INSERT INTO SAWON VALUES (NULL, '이두나', 120, '여자', '홍보부');
-- Error Code : 3819. Check constraint 'ck_sawon_gender' is violated.
INSERT INTO SAWON VALUES (NULL, '이두나', 120, '여', '홍보부');

-- 제대로 된 데이터 각자 7개 정도 추가
INSERT INTO SAWON VALUES (NULL, '강호동', 90, '남자', '인사부');
INSERT INTO SAWON VALUES (NULL, '한가인', 67, '여자', '교육부');
INSERT INTO SAWON VALUES (NULL, '오연수', 79, '여자', '홍보부');
INSERT INTO SAWON VALUES (NULL, '손지창', 99, '남자', '인사부');
INSERT INTO SAWON VALUES (NULL, '손호준', 100, '남자', '교육부');
INSERT INTO SAWON VALUES (NULL, '이서진', 87, '남자', '인사부');
INSERT INTO SAWON VALUES (NULL, '광수', 74, '남자', '홍보부');
INSERT INTO SAWON VALUES (NULL, '이이랑', 97, '남자', '인사부');

-- SELECT LIMIT
SELECT * FROM SAWON ORDER BY NAME;
SELECT * FROM SAWON ORDER BY NAME LIMIT 0,3;	-- 0(첫글)번부터 3개 조회
SELECT * FROM SAWON ORDER BY NAME LIMIT 3,3;	-- 3번부터 3개

-- 문자 함수들 연습
SELECT CONCAT('Hello', 'Kitty', '!!') FROM DUAL;
-- SAWON 에서 '이' 를 포함한 데이터 조회
SELECT * FROM SAWON WHERE NAME LIKE CONCAT('%','이','%');	-- '%이%' 도 가능
SELECT REPLACE('Happy Day!!', 'Happy', 'Nice') FROM DUAL;	-- Happy 를 Nice로 변경해서 출력
SELECT INSTR('Happy Day', 'Day') FROM DUAL;		-- 7 : Day의 위치 찾기
SELECT INSTR('Happy Day', 'Hello') FROM DUAL;	-- 없을 경우 0

-- 추출
SELECT LEFT('Have a Nice Day', 4) FROM DUAL;	-- 왼쪽에서 4글자 추출 : Have
SELECT RIGHT('Have a Nice Day', 8) FROM DUAL;	-- 오른쪽에서 8글자 추출 : Nice Day
SELECT MID('Have a Nice Day', 6, 6) FROM DUAL;	-- 왼쪽에서 4글자 추출 : 6번부터 6글자 : a Nice 
SELECT SUBSTRING('Have a Nice Day', 6, 6) FROM DUAL;	-- 왼쪽에서 4글자 추출 : 6번부터 6글자 : a Nice 

-- 공백제거
SELECT LTRIM('    Hello    ') FROM DUAL;	-- 왼쪽 공백 제거
SELECT RTRIM('    Hello    ') FROM DUAL;	-- 오른쪽 공백 제거
SELECT TRIM('    Hello    ') FROM DUAL;		-- 양쪽 공백 제거

-- 대소문자 변환
SELECT LCASE('Happy') FROM DUAL;	-- 소문자
SELECT LOWER('Happy') FROM DUAL;	-- 소문자
SELECT UCASE('Happy') FROM DUAL;	-- 대문자
SELECT UPPER('Happy') FROM DUAL;	-- 대문자

SELECT REVERSE('Happy') FROM DUAL;	-- 거꾸로

-- 조건 함수
SELECT IF(1=2, 'happy', 'nice') FROM DUAL;
SELECT NAME, SCORE, IF(SCORE>=90, '합격', '불합격') "평가" FROM SAWON;

-- 오라클의 NVL 이 MYSQL 에서는 IFNULL
SELECT NAME, HEIGHT FROM MEMBER;
SELECT NAME, IFNULL(HEIGHT, 0) FROM MEMBER;

-- 수학 함수
SELECT CEILING(5.3), CEILING(5.9) FROM DUAL;	-- 무조건 올림
SELECT FLOOR(5.3), FLOOR(5.9) FROM DUAL;	-- 무조건 내림
SELECT TRUNCATE(2.348, 2) FROM DUAL;	-- 소수점 2자리까지 출력, 무조건 내림
SELECT MOD(7,2) FROM DUAL;	-- 나머지

-- Group by
-- 부서별 인원수, 최고점수, 최저점수, 평균점수
SELECT BUSEO 부서, COUNT(*) 인원수, MAX(SCORE) 최고점수, MIN(SCORE) 최저점수,
	AVG(SCORE) 평균점수 FROM SAWON GROUP BY BUSEO;

-- JOIN 연습
create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

-- bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

-- stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

-- INNER JOIN 1
SELECT CLASS, PRICE, GIGAN, NAME, SUGANGDAY
FROM BITCLASS B, STU S
WHERE B.IDX=S.IDX;

-- INNER JOIN 2
SELECT CLASS, PRICE, GIGAN, NAME, SUGANGDAY
FROM BITCLASS B
INNER JOIN STU S ON B.IDX=S.IDX;

SELECT *
FROM BITCLASS B
INNER JOIN STU S ON B.IDX=S.IDX;

-- SUB TABLE에 데이터가 추가된 상태에서 부모테이블의 데이터를 삭제해보자
DELETE FROM BITCLASS WHERE IDX=100;		-- 오류 발생

-- SUB 테이블의 데이터를 먼저 삭제 후 부모 테이블의 데이터 삭제
DELETE FROM STU WHERE IDX=100;
DELETE FROM BITCLASS WHERE IDX=100;

-- 연습용 JOIN 테이블 모두 제거하기
DROP TABLE STU;
DROP TABLE BITCLASS;

DROP TABLE MEMBER;