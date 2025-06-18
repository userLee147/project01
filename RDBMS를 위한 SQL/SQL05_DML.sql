--DDL  이인혜 

--1.과목유형 테이블(TB_CLASS_TYPE)에 아래와 같은 데이터를 입력하시오
INSERT INTO TB_CLASS_TYPE(NO, CLASS_TYPE_NAME) VALUES (10,'전공필수');
INSERT INTO TB_CLASS_TYPE(NO, CLASS_TYPE_NAME) VALUES (20,'전공선택');
INSERT INTO TB_CLASS_TYPE(NO, CLASS_TYPE_NAME) VALUES (30,'교양필수');
INSERT INTO TB_CLASS_TYPE(NO, CLASS_TYPE_NAME) VALUES (40,'교양선택');
INSERT INTO TB_CLASS_TYPE(NO, CLASS_TYPE_NAME) VALUES (50,'논문지도');


--2. 춘 기술대학교 학생들의 정보가 포하되어 있는 학생일반정보 테이블을 만들고자 한다
--   아래 내용을 참고하여 SQL 문을 작성하시오(서브쿼리를 이용하시오)
CREATE TABLE TB_학생일반정보
AS(SELECT * 
FROM VW_학생일반정보
WHERE 1<>1); 

ALTER TABLE TB_학생일반정보 RENAME COLUMN STUDENT_NO TO 학생;
ALTER TABLE TB_학생일반정보 RENAME COLUMN STUDENT_NAME TO 학생이름;
ALTER TABLE TB_학생일반정보 RENAME COLUMN STUDENT_ADDRESS TO 주소;

INSERT INTO TB_학생일반정보(학생,학생이름,주소)
(SELECT *
FROM VW_학생일반정보
WHERE 1=1);


--3. 국어구문학과 학생들의 정보만이 포함되어 있는 학과정보 테이블을 만들고자 한다.
--   아래의 내용을 참고하여 적절한 SQL문을 작성하시오
CREATE TABLE TB_국어국문학과
AS (SELECT STUDENT_NO AS 학번, STUDENT_NAME AS 학생이름, 
CASE 
    WHEN SUBSTR(STUDENT_SSN,8,1) IN ('3','4') THEN 2000+SUBSTR(STUDENT_SSN,1,2)
    ELSE 1900+SUBSTR(STUDENT_SSN,1,2)
END AS 출생년도
,PROFESSOR_NAME AS 교수이름
FROM tb_student S
JOIN tb_professor P ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
JOIN tb_department D ON(D.department_NO = S.departmenT_NO)
WHERE departmenT_NAME ='국어국문학과');

--4. 현 학과들의 정원을 10% 증가시키게 되었다. 이에 사용할 SQL 문을 작성하시오
--   (단, 반올림을 사용하여 소수점 자릿수는 생기지 않도록 한다)
UPDATE tb_department
SET CAPACITY = ROUND(CAPACITY*1.1);

--5. 학번 A413042인 박건우 학생의 주소가 서울시 종로구 숭인동 181-21 로 변경되었다고
--   한다. 주소지를 정정하기 위ㅣ해 사용할 SQL 문을 작성하시오
UPDATE tb_student
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO ='A413042';

--6. 주민등록번호 보호법에 따라 학생정보 테이블에서 주민번호 뒷자리를 저장하지 않기로
--   결정하였다. 이내뇽을 반영할 적절한 SQL 문장을 작성하시오
UPDATE tb_student
SET STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);


--7 의학 김명훈 학생은 2005년 1학기에 자신이 수장한 피부생리학 점수가 잘못되었다는
-- 것을 발견하고는 정정을 요청하였다. 담당 교수의 확인 받은 결과 해당 과목의 학점을
-- 학점 3.5로 변경키로 결정되었다. 적절한 SQL 문장을 작성하시오
UPDATE tb_grade
SET POINT = 3.5
WHERE (STUDENT_NO, CLASS_NO, TERM_NO) =
(SELECT STUDENT_NO, CLASS_NO, TERM_NO
FROM tb_grade
JOIN tb_student USING(STUDENT_NO)
JOIN tb_CLASS USING(CLASS_NO) 
WHERE STUDENT_NAME = '김명훈'
AND TERM_NO = '200501'
AND CLASS_NAME ='피부생리학');

--8 TJDWJR XPDLQMF(tb_grade)에서 휴학생들의 성적항목을 제거하시오
DELETE FROM tb_grade
WHERE STUDENT_NO IN
(SELECT STUDENT_NO 
FROM tb_grade
JOIN tb_student USING(STUDENT_NO)
WHERE ABSENCE_YN = 'Y');

COMMIT;


