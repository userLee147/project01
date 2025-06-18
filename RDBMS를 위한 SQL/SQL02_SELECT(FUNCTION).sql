--ADDITIONAL SELECT 함수 이인혜

--1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학년도를 입학년도가 빠른 순으로
--   표시하는 SQL문을 작성하시오(단, 헤더는 학번,이름,입학년도가 표시되도록한다.
SELECT STUDENT_NO AS "학번", STUDENT_NAME AS "이름", TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') AS "입학년도"
FROM TB_STUDENT
JOIN tb_department USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME ='영어영문학과';


--2. 춘 기술대학교의 교수 중 이름이 세글자가 아닌 교수가 한 명 있다고 한다. 그 교수의 이름과
-- 주민번호를 화면에 출력하는 SQL문장을 작성해 보자(*이때 올바르게 작성한 SQL 문장의 결과 값이
-- 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM tb_professor
WHERE LENGTH(PROFESSOR_NAME) !=3;


--3.춘 기술대학교의 남자교수들의 이름과 나이를 출력하는 SQL문장을 작성하시오, 단
--  이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되로록 만드시오,(단 교수 중 2000년 이후
--  출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 '만'으로 계산하낟
SELECT PROFESSOR_NAME AS 교수이름, ROUND((SYSDATE - TO_DATE(19||SUBSTR(PROFESSOR_SSN,1,6),'YYYY-MM-DD'))/365) AS "나이" 
FROM tb_professor
WHERE SUBSTR(PROFESSOR_SSN,8,1) IN '1';

--4.교수들의 이름 중 성을 제외한 이름람 출력하는 SQL문을 작성하시오. 출력헤더는 이름이 찍히도록
--  한다. (성이 2자인 경우는 교수는 없다고 가정하시오)
SELECT SUBSTR(PROFESSOR_NAME,2,LENGTH(PROFESSOR_NAME)-1) AS 이름
FROM tb_professor;

--5.춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가? 이때,
--  19살에 입학하면 재수를 하지 않은 것으로 간주한다.
SELECT STUDENT_NO,STUDENT_NAME
FROM tb_student
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - (1900+ SUBSTR(STUDENT_SSN,1,2)) >19;



--6. 2020년 크리마스는 무슨 요일일까
--- 검증
--SELECT NEXT_DAY('2020-12-24',2),NEXT_DAY('2020-12-24',2)- TO_DATE('2020-12-24','YYYY-MM-DD') AS 날짜차이
--FROM DUAL;

SELECT DECODE(NEXT_DAY('2020-12-24',2)- TO_DATE('2020-12-24','YYYY-MM-DD'),0,'월',1,'일',2,'토',3,'금',4,'목',5,'수',6,'화',7,'일') AS 요일
FROM DUAL;


--7.TO_DATE('90/10/11','YY/MM/DD'), TO_DATE("49,10,11','YY/MM/DD')은 각각 몇 년 몇월 몇일을
--의미할까? 또 TO_DATE('49/10/11'.'RR/MM/DD'), TO_DATE('49/10/11','RR/MM/DD')은 각각 몇년 몇월 몇일을 의미할까?
SELECT 
ROUND(TO_DATE('90/10/11','YY/MM/DD')-SYSDATE) AS "YY(2000년대) =2090년", 
ROUND(TO_DATE('49,10,11','YY/MM/DD')-SYSDATE) AS "YY(2000년대) =2049년",
ROUND(TO_DATE('90/10/11','RR/MM/DD')-SYSDATE) AS "RR(2000년대) =1946년", 
ROUND(TO_DATE('49/10/11','RR/MM/DD')-SYSDATE) AS "RR(1900년대) =2046년" 
FROM DUAL;
-- 기준날짜 - 현재날짜 => 양수(기준날짜 > 현재날짜)
--  -> 기준날짜가 현재날짜보다 큰 경우 임으로 2000년대라는 것을 짐작할수 있음
-- 기준날짜 - 현재날짜 => 음수(기준날짜 < 현재날짜)
--  -> 기준날짜가 현재날짜보다 작은경우 1900년대라는 것을 짐작할수 있음
-- * YY은 2000년대 RR은 1900년대를 포함
-- * RR은 50년을 기준으로 50년 이상은 1900년대 50년 이하는 2000년를 나타냄



--8.춘 기술대학교의 2000년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000년도
--이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오
SELECT STUDENT_NO, STUDENT_NAME
FROM tb_student
WHERE STUDENT_NO NOT LIKE 'A%'
ORDER BY STUDENT_NAME ASC;

--9. 학번이 A517178인 한아름 학생의 학점 총 평점을 구하는 SQL문을 작성하시오 단, 
--   이때 출력화면의 헤더는 평점이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한자리까지만 표시한다.
SELECT ROUND(AVG(POINT),1) AS 평점
FROM tb_student
JOIN TB_GRADE USING (STUDENT_NO)
WHERE STUDENT_NO = 'A517178'
GROUP BY STUDENT_NO;

--10.학과별 학생수를 구하여 학과번호, 학생수(명) 의 형태로 헤더를 만들어 결과값이 출력되도록 하시오
SELECT DEPARTMENT_NO AS 학과번호 ,COUNT(student_NO) AS "학생수(명)"
FROM tb_student
JOIN tb_department USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO ASC;

---11.지도 교수를 배정받지 못한 학생의 수느느 몇 명 정도되는지 알아내는 SQL문장을 작성하시오
SELECT COUNT(*)
FROM tb_student
WHERE coach_professor_no IS NULL;

-- 12.학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL문을 작성하시오, 단, 이때
-- 출력 화면의 헤더는 년도, 년도 별 평점 이라고 직히게 하고, 점수는 반오림하여 소수점 이하 한자리까지만 표시한다. 
SELECT SUBSTR(TERM_NO,1,4), ROUND(AVG(POINT),1) AS 평점
FROM tb_student
JOIN TB_GRADE USING (STUDENT_NO)
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4);

--13.학과별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL문장을 작성하시오

--SELECT DEPARTMENT_NO, COUNT(student_NO) AS "휴학생의 수"
--FROM tb_student
--WHERE ABSENCE_YN = 'Y'
--GROUP BY DEPARTMENT_NO;
--> 이렇게 작성하면 0이 출력이 안됌

SELECT DEPARTMENT_NO, SUM(DECODE( ABSENCE_YN ,'Y',1,'N',0)) AS "휴학생의 수"
FROM tb_student
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO ASC ;





--14. 춘 대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다. 어떤 SQL문장을 사용하면 가능하는가
SELECT STUDENT_NAME AS "동일이름", COUNT(STUDENT_NAME) AS "동명이인 수"
FROM tb_student
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME) >=2;


--15. 학번이 A112113인 김고운 학생의 년도, 학기별 평점과 년도 별 누적 평점, 총평점을 구하는 SQL문을 작성하시오
--    (단, 평점은 소수점 1자리까만 반올림하여 표시한다.) 
SELECT SUBSTR(TERM_NO,1,4) AS "년도" , SUBSTR(TERM_NO,5,2) "학기" , ROUND(AVG(POINT),1) AS 평점
FROM tb_student
JOIN TB_GRADE USING (STUDENT_NO)
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2);

