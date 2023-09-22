-- 2023-09-22 프로시져
/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다

형식
 
create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
            	exec 프로시져명(값..)

*/
-- 예제 1
-- 초 간단 프로시저 생성해보기
CREATE OR REPLACE PROCEDURE MYTEST
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('첫 프로시저를 만들었어요!');
END;
/

-- MYTEST 프로시저 호출
EXEC MYTEST;

-- 예제 2 : 숫자를 인자로 보내면 구구단 출력
CREATE OR REPLACE PROCEDURE GUGU(DAN NUMBER)
IS
BEGIN
    IF DAN<2 or DAN>9 THEN
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자입니다. 2-9 사이 값 요구!');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' **'||DAN||'단 **');
        FOR A IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(DAN||'X'||A||'='||DAN*A);
        END LOOP;
    END IF;
END;
/
-- 실행
EXEC GUGU(11);
EXEC GUGU(9);

-- SHOP에 데이터 추가하기 - 연습용
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '레이스블라우스', 23000, 'WHITE');

-- SHOP의 SANG_COLOR 의 타입 길이 변경
ALTER TABLE SHOP MODIFY SANG_COLOR VARCHAR2(30);
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '레이스조끼', 19000, 'RED');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '체크조끼', 39000, 'RAINBOW');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '칠부청바지', 56000, 'BLUE');
COMMIT;

-- 예제3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기
CREATE OR REPLACE PROCEDURE SANGPUM(SANG VARCHAR2)
IS
    CURSOR S1
    IS
    SELECT * FROM SHOP WHERE SANG_NAME LIKE '%'||SANG||'%';
    
    -- 검색된 상품 개수를 구할 변수
    V_CNT NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO V_CNT FROM SHOP WHERE SANG_NAME LIKE '%'||SANG||'%';
    IF V_CNT=0 THEN
        DBMS_OUTPUT.PUT_LINE(SANG||' 상품은 목록에 없습니다');
    ELSE
        DBMS_OUTPUT.PUT_LINE(SANG||'상품 조회하기');
        DBMS_OUTPUT.PUT_LINE(' ');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명  가격  색상');
        DBMS_OUTPUT.PUT_LINE('-------------------------------');
        FOR S IN S1 LOOP
            DBMS_OUTPUT.PUT_LINE(S.SANG_NO||'  '||S.SANG_NAME||'  '||
                S.SANG_PRICE||'  '||S.SANG_COLOR);
            EXIT WHEN S1%NOTFOUND;
        END LOOP;
    END IF;
END;
/

-- 실행
EXEC SANGPUM('조끼');
EXEC SANGPUM('청바지');
EXEC SANGPUM('한복');

-- 예제 4
/*
    EXEC ADDUPDATE('레이스조끼', 45000, 'BLACK'); : '레이스조끼' 상품이 없으면 추가
                                          : '레이스조끼' 상품이 있으면 가격, 색상 수정
*/
CREATE OR REPLACE PROCEDURE ADDUPDATE(SANG VARCHAR2, PRICE NUMBER, COLOR VARCHAR2)
IS  
    -- 검색된 상품 개수를 구할 변수
    V_CNT NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO V_CNT FROM SHOP WHERE SANG_NAME=SANG;
    IF V_CNT=0 THEN
        INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, SANG, PRICE, COLOR);
        DBMS_OUTPUT.PUT_LINE(SANG||' 상품이 추가되었습니다');
    ELSE
        UPDATE SHOP SET SANG_PRICE=PRICE, SANG_COLOR=COLOR WHERE SANG_NAME=SANG;
        DBMS_OUTPUT.PUT_LINE(SANG||' 상품을 수정했습니다');
    END IF;
END;
/
-- 실행
EXEC ADDUPDATE('조끼', 34000, 'PURPLE');
EXEC ADDUPDATE('양복정장', 150000, 'BLUE');
