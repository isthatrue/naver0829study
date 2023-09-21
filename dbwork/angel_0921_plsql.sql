-- PL-SQL이란?
-- SQL 언어에 절차적 언어요소를 추가해서 프로그래밍한것을 PL-SQL 이라고 한다.
-- 예제1
DECLARE
    -- 변수 선언하는 영역
    v_no number(4,1);   -- 4자리에 소숫점이하 1자리 값을 넣는 변수 선언
BEGIN
    -- sql 구문이나 PL-SQL 문으로 코딩하는 영역 (:=: 대입, =; 비교,동등)
    v_no:=12.7;
   DBMS_Output.put_line(v_no);  -- 출력 
END;
/

DECLARE
    VNAME VARCHAR(200);
    VBAN VARCHAR(200);
    
    
BEGIN
    SELECT
        NAME, VBAN
        INTO VNAME, VBAN
        FROM STUDENT WHERE NUM=6;
    DBMS_OUTPUT.PUT_LINE(VNAME||'님은'||VBAN||'입니다');
END;
/

-- PERSON과 FOOD 테이블을 조인하여 PERSON_NUM이 9인 사람의 이름, 주문한 메뉴, 가격을 출력하시오.
DECLARE
    VNAME VARCHAR2(20);
    VFOOD VARCHAR2(20);
    VPRICE NUMBER(7);
    
BEGIN
    SELECT PERSON_NAME, FNAME, FPRICE
    INTO VNAME, VFOOD, VPRICE
    FROM FOOD F, PERSON P
    WHERE F.FOOD_NUM=P.FOOD_NUM AND PERSON_NUM=1;
    
    DBMS_OUTPUT.PUT_LINE('주문자:'||VNAME);
    DBMS_OUTPUT.PUT_LINE('메뉴명:'||VFOOD);
    DBMS_OUTPUT.PUT_LINE('가 격 : '||VPRICE||'원');
END;
/

-- 예제 4
-- 상품명을 변수에 지정한 후 해당 상품명의 가격과 색상을 출력
DECLARE
    VSANGPUM VARCHAR2(20) := '체크자켓';
    VCOLOR VARCHAR2(20);
    VPRICE NUMBER(7);
    VPRICE2 VARCHAR2(20);
BEGIN
    SELECT SANG_PRICE, SANG_COLOR, LTRIM(TO_CHAR(SANG_PRICE, 'L999,999'))
    INTO VPRICE, VCOLOR, VPRICE2
    FROM SHOP WHERE SANG_NAME=VSANGPUM;
    
    DBMS_OUTPUT.PUT_LINE('상품명:'||VSANGPUM);
    DBMS_OUTPUT.PUT_LINE('색 상:'||VCOLOR);
    DBMS_OUTPUT.PUT_LINE('단 가:'||VPRICE);
    DBMS_OUTPUT.PUT_LINE('단 가:'||VPRICE2);
END;
/

/*
if 조건식 then
    문장1;
else
    문장2;
end if;

다중 if 문
if 조건식1 then
    문장1;
elsif 조건2 then
   ` 문장2;
    ...
end if;
*/

-- 예제5
-- 연도에 맞는 띠 구하기

-- 키보드로 연도를 입력받고자 할 경우
ACCEPT YEAR PROMPT '태어난 연도를 입력하세요';
DECLARE
    -- V_YEAR NUMBER(4) := 1989;
    V_YEAR NUMBER(4) := '&YEAR';    -- 입력한 값을 대입
    V_MOD NUMBER(2) := MOD(V_YEAR, 12);   -- 연도를 12로 나눈 나머지를 구한다.
    V_DDI VARCHAR2(10);     -- 띠 저장할 변수
BEGIN
    IF V_MOD=0 THEN V_DDI := '원숭이';
    ELSIF V_MOD=1 THEN V_DDI := '닭';
    ELSIF V_MOD=2 THEN V_DDI := '개';
    ELSIF V_MOD=3 THEN V_DDI := '돼지';
    ELSIF V_MOD=4 THEN V_DDI := '쥐';
    ELSIF V_MOD=5 THEN V_DDI := '소';
    ELSIF V_MOD=6 THEN V_DDI := '호랑이';
    ELSIF V_MOD=7 THEN V_DDI := '토끼';
    ELSIF V_MOD=8 THEN V_DDI := '용';
    ELSIF V_MOD=9 THEN V_DDI := '뱀';
    ELSIF V_MOD=10 THEN V_DDI := '말';
    ELSIF V_MOD=11 THEN V_DDI := '양';
    END IF;
    DBMS_OUTPUT.PUT_LINE(V_YEAR||'년생은 '||V_DDI||'띠입니다.');
END;
/

-- 예제 6
-- DB 컬럼의 타입을 가져오는 방법 TYPE
ACCEPT INAME PROMPT 'SANGPUM?';
DECLARE
    V_NAME STUDENT.NAME%TYPE := '&INAME';
    V_HEIGHT STUDENT.HEIGHT%TYPE;
    V_JAVA STUDENT.JAVA%TYPE;
    V_SPRING STUDENT.SPRING%TYPE;
BEGIN
    SELECT HEIGHT, JAVA, SPRING
    INTO V_HEIGHT, V_JAVA, V_SPRING
    FROM STUDENT WHERE NAME=V_NAME;
    
    DBMS_OUTPUT.PUT_LINE('학생명:'||V_NAME);
    DBMS_OUTPUT.PUT_LINE('키:'||V_HEIGHT);
    DBMS_OUTPUT.PUT_LINE('자바점수:'||V_JAVA);
    DBMS_OUTPUT.PUT_LINE('스프링점수:'||V_SPRING);
    DBMS_OUTPUT.PUT_LINE('총점:'||(V_JAVA+V_SPRING));
END;
/

/*
    반복문 : LOOP
    LOOP
        문장들;
        EXIT WHEN 조건;
    END LOOP;
*/

-- 예제 7
-- 1부터 10까지 반복해서 출력
DECLARE
    V_NO NUMBER(2) := 0;
BEGIN
    LOOP
        V_NO := V_NO+1;
        DBMS_OUTPUT.PUT_LINE('no='||v_no);
        EXIT WHEN V_NO=10;  -- 10일 경우 반복문을 빠져나간다.
    END LOOP;
END;
/

-- 예제 8
-- 문제 : 단을 입력하면 해당단을 출력하시오
ACCEPT DAN PROMPT 'DAN?';
DECLARE
    V_DAN NUMBER(4) := '&DAN';
    V_NO NUMBER(2) := 0;
BEGIN
    LOOP
        V_NO := V_NO+1;
        DBMS_OUTPUT.PUT_LINE(V_DAN||' X '||V_NO||' = '||(V_DAN*V_NO));
        EXIT WHEN V_NO=9;
    END LOOP;
END;
/

-- 예제 9 - Exception 처리(예제 4 복사)
-- 상품명을 변수에 지정한 후 해당 상품명의 가격과 색상을 출력
ACCEPT SANGPUM PROMPT 'SANGPUM?';
DECLARE
    VSANGPUM VARCHAR2(20) := '&SANGPUM';
    VCOLOR VARCHAR2(20);
    VPRICE NUMBER(7);
    VPRICE2 VARCHAR2(20);
BEGIN
    SELECT SANG_PRICE, SANG_COLOR, LTRIM(TO_CHAR(SANG_PRICE, 'L999,999'))
    INTO VPRICE, VCOLOR, VPRICE2
    FROM SHOP WHERE SANG_NAME=VSANGPUM;
    
    DBMS_OUTPUT.PUT_LINE('상품명:'||VSANGPUM);
    DBMS_OUTPUT.PUT_LINE('색 상:'||VCOLOR);
    DBMS_OUTPUT.PUT_LINE('단 가:'||VPRICE);
    DBMS_OUTPUT.PUT_LINE('단 가:'||VPRICE2);
    
    -- 결과가 2개 이상이거나 없으면 오류 발생
    -- 오라클에서 예외처리 하는 방법
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUTlPUT_LINE(VSANGPUM||' 상품은 DB에 없습니다.');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUTlPUT_LINE(VSANGPUM||' 상품이 DB에 두 개이상 존재합니다.');
        WHEN OTHERS THEN
           DBMS_OUTPUTlPUT_LINE(VSANGPUM||' 상품에 대한 오류 발생 - 뭔지 모름');
END;
/

/*
    반복문
    for 변수 in [reverse] 시작값... 최종값 LOOP
*/

-- 예제 10, 예제8 구구단 복사 후 for문으로 변경하기
ACCEPT DAN PROMPT 'DAN?';
DECLARE
    V_DAN NUMBER(4) := '&DAN';
    V_NO NUMBER(2);
BEGIN
    DBMS_OUTPUT.PUT_LINE('** '||V_DAN||' 단 **');
     for V_NO IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(V_DAN||' X '||V_NO||' = '||(V_DAN*V_NO));
    END LOOP;
END;
/

-- 레코드 단위로 데이터 가져오기
DECLARE
    V_NUM STUDENT.NUM%TYPE := 6;
    V_STU ANGEL.STUDENT%ROWTYPE;   -- 레코드 단위로 읽어올 경우
BEGIN
    SELECT * INTO V_STU
    FROM STUDENT WHERE NUM = V_NUM;
    
    DBMS_OUTPUT.PUT_LINE('이름:'||V_STU.NAME);
    DBMS_OUTPUT.PUT_LINE('키:'||V_STU.HEIGHT);
    DBMS_OUTPUT.PUT_LINE('자바:'||V_STU.JAVA);
    DBMS_OUTPUT.PUT_LINE('스프링:'||V_STU.SPRING);
    DBMS_OUTPUT.PUT_LINE('반:'||V_STU.BAN);    
END;
/

-- DB의 여러데이터를 조회할 경우
/*
    CURSOR : SQL문을 실행할때마다 명령이 분석되고 실행되어 결과를 보관하기 위한
    특별한 메모리 영역을 사용하는데 이 영역을 참조하는 것이 커서이다.
    
    SELECT 문에서 여러 데이터 조회 시 사용하는 객체이다.
    
    커서 속성
    SQL%ROWCOUNT : 실행된 개수 반환
    SQL%FOUND : 가장 최근의 SQL문이 하나 이상의 행에 영향을 준 경우 TRUE
    SQL%NOTFOUND : 결과행이 없는 경우
    SQL%ISOPEN : 항상 FALSE (항상 CLOSE를 하기 때문에 항상 FALSE)
*/

-- 예제 12
DECLARE
    V_SNO NUMBER(3) := 20;
    V_SHOP ANGEL.SHOP%ROWTYPE;
BEGIN
    SELECT * INTO V_SHOP
    FROM SHOP WHERE SANG_NO = V_SNO;
    
    DBMS_OUTPUT.PUT_LINE('상품명:'||V_SHOP.SANG_NAME);
    DBMS_OUTPUT.PUT_LINE('조회된 실행개수:'||SQL%ROWCOUNT);    --1
    
    -- STUDENT 의 JAVA 점수 변경하기
    UPDATE STUDENT SET JAVA = 99;
    DBMS_OUTPUT.PUT_LINE('수정된 실행개수:'||SQL%ROWCOUNT);
END;
/

-- 여러 레코드 조회
-- 예제 13
DECLARE
    CURSOR s1
    IS
    SELECT * FROM SHOP;
BEGIN
    DBMS_OUTPUT.PUT_LINE('상품번호  상품명  색상  가격');
    DBMS_OUTPUT.PUT_LINE('-------------------------');
    FOR S IN S1 LOOP
        EXIT WHEN S1%NOTFOUND;  -- 더 이상 데이터가 없으면 빠져나간다.
        DBMS_OUTPUT.PUT_LINE(S.SANG_NO||'  '||S.SANG_NAME||'  '
        ||S.SANG_COLOR||'  '||S.SANG_PRICE);
    END LOOP;
END;
/
SELECT * FROM SEQ;
-- 예제 14
-- 상품명, 색상, 가격을 입력하면 SHOP DB에 추가하기
ACCEPT ISANG PROMPT 'SANGPUM?';
ACCEPT ICOLOR PROMPT 'COLOR?';
ACCEPT IPRICE PROMPT 'PRICE?';
DECLARE
    V_SANG SHOP.SANG_NAME%TYPE := '&ISANG';
    V_COLOR SHOP.SANG_COLOR%TYPE := '&ICOLOR';
    V_PRICE SHOP.SANG_PRICE%TYPE := '&IPRICE';    
BEGIN
    INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, V_SANG, V_PRICE, V_COLOR);
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('상품정보를 추가했습니다.');
END;
/

-- 문제 : FOOD 테이블
/*
    FNAME, FPRICE, NO 입력을 받아서
    NO 가 1 이면 FNAME, FPRICE로 데이터 추가를 하고
    NO 가 2면 FOOD 전체 데이터 출력
*/
ACCEPT INAME PROMPT 'FOOD NAME?';
ACCEPT IPRICE PROMPT 'PRICE?';
ACCEPT INO PROMPT 'NO?';

DECLARE
    V_NAME FOOD.FNAME%TYPE := '&INAME';
    V_PRICE FOOD.FPRICE%TYPE := '&IPRICE';
    V_NO NUMBER(2) := '&INO';
    
    CURSOR F1
    IS
    SELECT * FROM FOOD;
    
BEGIN
    IF V_NO=1 THEN 
    INSERT INTO FOOD VALUES (SEQ_SHOP.NEXTVAL, V_NAME, V_PRICE);
    COMMIT;
    
    ELSIF V_NO=2 THEN 
    FOR F IN F1 LOOP
        EXIT WHEN F1%NOTFOUND;  -- 더 이상 데이터가 없으면 빠져나간다.
        DBMS_OUTPUT.PUT_LINE(F.FNAME||'  '||F.FPRICE);
    END LOOP;
    END IF;
    
END;
/

SELECT * FROM FOOD;