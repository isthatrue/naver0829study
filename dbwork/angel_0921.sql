-- 2023-09-21 DB 정규화
-- DB 정규화(Normalization)
-- 정규화란? 한마디로 DB 서버의 메모리를 낭비하지 않기 위해서
-- 어떤 테이블을 식별자를 가지는 여러 개의 테이블로 나누는 과정을 정규화라고 한다.
-- 정규화된 데이터베이스는 중복이 최소화 되도록 설계된 데이터베이스이다.
-- 장점 : 메모리를 절약할 수 있다.
--       구조화된 시스템으로 인해서 관리가 편하다.
-- 단점 : 조회 비율이 매우 높은 시스템의 경우에는 테이블간의 JOIN 연산이 반복적으로
--        이뤄지기 때문에 질의 응답 속도가 살짝 늦어질 수 있다.

-- STUDENT 의 NUM 을 외부 키로 갖는 새로운 테이블 STUINFO 를 만들어보자.
-- 외부 키는 테이블 생성 시에 설정해도 되고 나중에 설정해도된다.


CREATE TABLE STUINFO (
    IDX NUMBER(5) CONSTRAINT STUINFO_PK_IDX PRIMARY KEY,
    NUM NUMBER(5),
    ADDR VARCHAR2(20),
    HP VARCHAR2(20));

-- STUDENT 의 NUM을 외부 키로 설정
-- PPT 29 페이지에 있음
ALTER TABLE STUINFO ADD CONSTRAINT STUINFO_FK_NUM FOREIGN KEY(NUM) REFERENCES STUDENT(NUM);

-- STUINFO 에 데이터를 추가해보자, 없는 번호인 9번으로 INSERT 시 어떤 오류가 나는지 확인 필요
-- 오류메세지 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다. - 부모키가 없습니다.
-- STUDENT 테이블이 부모테이블 : 거기에 NUM 9가 없어서 오류가 나는 것
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 9, '서울시 강남구', '010-2323-4545');
-- 만약 김말자의 정보일 경우 김말자의 NUM이 3이므로 3으로 추가해야만한다.
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 3, '서울시 강남구', '010-2323-4545'); -- 김말자
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 6, '제주도', '010-1234-1234'); -- 영숙
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 8, '부산', '010-8989-7878'); -- 향숙

-- STUINFO 만 조회
SELECT * FROM STUINFO;

-- STUDENT 만 조회
SELECT * FROM STUDENT;

-- 컬럼명 앞에 무조건 어느 테이블 소속인지 붙였는데
-- 양쪽에 같은 컬럼이 없다면 생략해도 된다.
SELECT
    STU.NUM, NAME, JAVA, SPRING, BAN, ADDR, HP
FROM STUDENT STU, STUINFO INFO
WHERE STU.NUM=INFO.NUM;


-- 개인정보가 등록된 학생에 한해서 모든 정보를 출력해보자(INNER JOIN, EQUI JOIN)
-- SUB TABLE DP (+) : 등록이 안된 컬럼은 NULL 값으로 출력
SELECT
    STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP
FROM STUDENT STU, STUINFO INFO
WHERE STU.NUM=INFO.NUM(+);

-- 위의 결과에 NULL 인 학생만 출력하고자 할 경우
SELECT
    STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP
FROM STUDENT STU, STUINFO INFO
WHERE STU.NUM=INFO.NUM(+) AND INFO.ADDR IS NULL;

-- SUB 테이블에 연결된 데이터가 있는데 부모 테이블(STUDENT)의 해당 데이터를 삭제하고자 할 경우
-- 오류발생 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다. - 자식 레코드가 발견되었습니다.
DELETE FROM STUDENT WHERE NUM=3; -- 오류
DELETE FROM STUDENT WHERE NUM=7; --지워짐, STUINFO에 데이터가 없어서

-- STUDENT 의 3번 데이터를 지워보자
-- 자식 테이블(STUINFO 의 NUM 이 3인 데이터를 먼저 삭제 후 STUDENT 삭제)
DELETE FROM STUINFO WHERE NUM=3; -- 자식 테이블 먼저 삭제
DELETE FROM STUDENT WHERE NUM=3; -- 부모 테이블 삭제

-- 부모 테이블 DROP
-- 오류 발생 : 외래키에 의해 참조되는 고유/기본 키가 테이블에 있습니다.
DROP TABLE STUDENT;

-- 자식 테이블은 삭제가 될까요? 네 됩니다.
DROP TABLE STUINFO;

----------------------------------------------------------------------------
-- 상품 정보를 담을 SHOP 테이블
-- 장바구니에 담을 CART 테이블을 만드는 데 상품 정보 저장을 위해서 SHOP의 NUM을 외부키로 설정
-- 상품을 삭제하면 장바구니의 해당 데이터가 자동으로 삭제되도록 ON DELETE CASCADE 설정해보자.
-- 시퀀스도 새로 하나 만들어보자.
CREATE SEQUENCE SEQ_SHOP START WITH 10 INCREMENT BY 10 NOCACHE;

-- SHOP TABLE 생성
CREATE TABLE SHOP (
    SANG_NO NUMBER(5) CONSTRAINT SHOP_PK_NO PRIMARY KEY,
    SANG_NAME VARCHAR2(100),
    SANG_PRICE NUMBER(7),
    SANG_COLOR VARCHAR2(20)
    );
    
-- 외부 키로 연결된 CART 테이블을 생성 - SHOP의 상품을 지우면 장바구니 목록은 자동으로 지워지도록
-- CASCADE 를 설정해서 생성해보자
CREATE TABLE CART (
    CART_NO NUMBER(5) CONSTRAINT CART_PK_NO PRIMARY KEY,
    SANG_NO NUMBER(5),
    CNT NUMBER(5),
    CARTDAY DATE
    );
    
ALTER TABLE CART ADD CONSTRAINT CART_FK__SHOPNO FOREIGN KEY(SANG_NO) REFERENCES SHOP(SANG_NO) ON DELETE CASCADE;

-- MODEL(ERD) 확인해보세요.

-- 5개의 상품을 등록해보자.
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '블라우스', 23000, 'Yellow');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '청바지', 45000, 'Black');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '브이넥티', 11000, 'White');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '브이넥티', 23000, 'RED');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '체크자켓', 130000, 'Gray');
commit;

SELECT * FROM SHOP;

-- CART에 블라우스, 브이넥티(WHITE), 체크자켓3개에 대해서 추가-날짜 현재 날짜로(sysdate)
INSERT INTO CART VALUES (SEQ_SHOP.NEXTVAL, 10, 2, sysdate);
INSERT INTO CART VALUES (SEQ_SHOP.NEXTVAL, 50, 3, '2023-09-20');
INSERT INTO CART VALUES (SEQ_SHOP.NEXTVAL, 70, 1, sysdate);
commit;

SELECT * FROM CART;

-- 조회(INNER JOB)
--  상품명, 가격, 색상, 개수, 구입일(yyyy-mm-dd hh24:mi)
SELECT SANG_NAME, SANG_PRICE, SANG_COLOR, CNT, TO_CHAR(CARTDAY, 'yyyy-mm-dd hh24:mi') CARTDAY
FROM SHOP S, CART C
WHERE S.SANG_NO=C.SANG_NO;

-- 아무도 CART에 담지 않은 상품명 조회
--  상품명, 가격, 색상을 출력
SELECT SANG_NAME, SANG_PRICE, SANG_COLOR
FROM SHOP S, CART C
WHERE S.SANG_NO=C.SANG_NO(+) AND C.CNT IS NULL;

-- CASCADE 를 지정했으므로 CART에 담긴 상품도 삭제가 된다. (이떄 CART 도 자동으로 지워짐)
DELETE FROM SHOP WHERE SANG_NO=10;

-- 부모 테이블 DROP 시켜보자
DROP TABLE SHOP;    -- 에러

-- 테이블 삭제 시 SUB 테이블 먼저 제거 후 부모 테이블 제거
DROP TABLE CART;
DROP TABLE SHOP;

-- 시퀀스도 지워보자
DROP SEQUENCE SEQ_SHOP;

-------------------------------------------------------------------------------
-- 문제
-- 시퀀스 : SEQ_FOOD 생성
CREATE SEQUENCE SEQ_FOOD NOCACHE;

-- 레스토랑의 메뉴 테이블 (테이블명 : FOOD)
-- FOOD_NUM 숫자(5) 기본 키, FNAME 문자열(20) : 메뉴명, FPRICE 숫자(7) : 가격
CREATE TABLE FOOD (
    FOOD_NUM NUMBER(5) CONSTRAINT FOOD_PK_FOODNUM PRIMARY KEY,
    FNAME VARCHAR2(20),
    FPRICE NUMBER(7)
);

-- SUB 테이블 : 고객 테이블 (PERSON)
-- PERSON_NUM 숫자(5) 기본 키, FOOD_NUM 외부 키 설정(CASCADE 설정)
-- PERSON_NAME 문자열(10) : 고객명
-- 예약일 : BOOKINGDAY : DATE 타입
CREATE TABLE PERSON (
    PERSON_NUM NUMBER(5) CONSTRAINT PERSON_PK_PERSONNUM PRIMARY KEY,
    PERSON_NAME VARCHAR2(20),
    BOOKINGDAY DATE
);
ALTER TABLE PERSON ADD FOOD_NUM NUMBER(5);
ALTER TABLE PERSON ADD CONSTRAINT PERSON_FK_FOODNUM FOREIGN KEY(FOOD_NUM) REFERENCES FOOD(FOOD_NUM) ON DELETE CASCADE;

-- FOOD 에 5개의 메뉴를 등록하자(스파게티, 떡볶이 등등등...)
INSERT INTO FOOD VALUES (SEQ_FOOD.NEXTVAL, '스파게티', 10000);
INSERT INTO FOOD VALUES (SEQ_FOOD.NEXTVAL, '떡볶이', 8000);
INSERT INTO FOOD VALUES (SEQ_FOOD.NEXTVAL, '맥앤치즈', 9000);
INSERT INTO FOOD VALUES (SEQ_FOOD.NEXTVAL, '돈까스', 10000);
INSERT INTO FOOD VALUES (SEQ_FOOD.NEXTVAL, '오코노미야끼', 15000);

-- 주문한 고객정보를 추가해보자(같은 메뉴를 여러명 주문하기도 함..)
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL, 1, '유재석', sysdate);

-- 메뉴 중 스파게티를 삭제 시 주문한 테이블에서도 지워지는지 확인
DELETE FROM FOOD WHERE FOOD_NUM=1;


-- 조회 : 시퀀스, 주문자명, 음식명, 가격, 예약일 (제목도 한글로 주기) 
SELECT
    F.FOOD_NUM 메뉴번호, PERSON_NAME 주문자명, FNAME 메뉴명, FPRICE 가격,
    TO_CHAR(BOOKINGDAY, 'yyyy-mm-dd') 예약일
FROM FOOD F, PERSON P
WHERE F.FOOD_NUM=P.FOOD_NUM;
