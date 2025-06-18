--<ADDITIONAL SELECT> 이인혜

--1. 핵생이름과 주소지를 표시하시오, 단, 출력헤더는 학생이름, 주소지로 하고, 정렬은 
--   오름차순 표시하도록 한다.
SELECT STUDENT_NAME AS "학생 이름", STUDENT_ADDRESS AS "주소지"
FROM tb_student
ORDER BY STUDENT_NAME ASC;


--2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오
SELECT STUDENT_NAME, STUDENT_SSN
FROM tb_student
WHERE ABSENCE_YN ='Y'
ORDER BY 1900+SUBSTR(STUDENT_SSN,1,2) DESC ;


--3. 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 이름과 학번, 주소를
--   이름의 오름차순으로 화면에 출력하시오, 단, 출력헤더에는 학생이름, 학번,거주지 주소가 출력되도록 한다.
SELECT STUDENT_NAME AS 학생이름 , STUDENT_NO AS 학번 , STUDENT_ADDRESS AS "거주지 주소"
FROM tb_student
WHERE SUBSTR(STUDENT_NO,1,2) ='99'
AND STUDENT_ADDRESS LIKE '강원도%'
OR STUDENT_ADDRESS LIKE '경기도%' 
ORDER BY STUDENT_NAME;


--4. 현재 법학과 교수 증 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL문장을
--   작성하시오(법학과느이 학과코드는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아내도록 하자)
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM tb_professor
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME ='법학과'
ORDER BY 1900+SUBSTR(PROFESSOR_SSN,1,2);



--5.2004년 2학기에 C3118100 과목을 수강한 학샏르으이 학점을 조회하려고 한다. 학점이 
--  높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해보시오.
SELECT STUDENT_NO, POINT
FROM tb_student
JOIN tb_grade USING(STUDENT_NO)
WHERE TERM_NO = '200402'
AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC, STUDENT_NO ASC;

--6. 학생번호, 학생읾, 학과이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL문을 작성하시오.
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM tb_student
JOIN tb_department USING(DEPARTMENT_NO)
ORDER BY STUDENT_NAME ASC;

--7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL문장을 작성하시오.
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN tb_department USING(DEPARTMENT_NO);

--8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하느 SQL문을 작성하시오
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS_PROFESSOR
JOIN tb_professor USING(PROFESSOR_NO)
JOIN tb_class USING(CLASS_NO);


--9.8번의 결과 중 인문사회 계열에 속한 과목의 교수 이름을 찾으려고 한다. 이에 해당하는
--  과목 이름과 교수 이름을 출력하는 SQL문을 작성하시오
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS_PROFESSOR
JOIN tb_professor USING(PROFESSOR_NO)
JOIN tb_class USING(CLASS_NO)
JOIN tb_department ON(TB_PROFESSOR.DEPARTMENT_NO = TB_CLASS.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회';


--10. 음악학과 학생들의 평점을 구하려고 한다. 음악학과 음악학과 학생들의 학번 학생이름, 전체평점을 
-- 출력하는 SQL문장을 작성하이소 (단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)
SELECT student_no, student_name, round(AVG(POINT),1) AS 평균
FROM tb_student
JOIN tb_department USING (DEPARTMENT_NO)
join TB_GRADE USING(student_no)
WHERE DEPARTMENT_NAME ='음악학과'
group by student_no, student_name;


--11.학번이 A313047인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기 위한
--   학과이름. 학생이름과  지도 교수 이름이 필요하다. 이때 사용할 SQL문을 작성하시오
--   단 출력헤더는 학과이름, 학생이름, 지도교수이름으로 출력되도록 한다.
SELECT DEPARTMENT_NAME, STUDENT_NAME, PROFESSOR_NAME
FROM tb_student
JOIN tb_department USING (DEPARTMENT_NO)
JOIN tb_professor ON(COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO ='A313047';


--12. 2007년도에 인간관계론 과목을 수강한 학생을 찾아 학생이름과 수강학기를 표시하는
--    SQL 문장을 작성하시오
SELECT STUDENT_NAME, TERM_NO
FROM TB_CLASS
JOIN TB_GRADE USING(CLASS_NO)
JOIN tb_student USING (STUDENT_NO)
WHERE SUBSTR(TERM_NO,1,4)='2007'
AND CLASS_NAME ='인간관계론';


--13.예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아 그 과목이름과 학과
--   이름을 출력하는 SQL 문장을 작성하시오

SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C, tb_class_professor CF, tb_department D
WHERE C.CLASS_NO = CF.CLASS_NO(+)
AND C.department_NO = D.department_NO
AND CF.CLASS_NO IS NULL;


--14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 학생이름과
--    지도교수 이름을 찾고 만일 지도 교수가 없는 학생일 경우 지도교수 미지정으로 표시하도록 하는
--    SQL 문을 작성하시오 단, ㄷ출력헤더는 학생이름 지도교수로 표시하며 고학번 학생이 먼저 표시되로록 한다.
SELECT STUDENT_NAME, NVL2(professor_NO, professor_NAME, '지도교수미지정')
FROM tb_student 
JOIN tb_department ON (tb_student.DEPARTMENT_NO = tb_department.DEPARTMENT_NO)
LEFT JOIN TB_professor ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE DEPARTMENT_NAME ='서반아어학과';

--15.휴학생이 아닌 학생 중 평점이 4.0이상인 학생을 찾아 그 학생의 학번, 이름, 학과이름, 평점을 출력하는 SQL문을 작성하시오
SELECT student_no, student_name, DEPARTMENT_NAME, round(AVG(POINT),2) AS 평균
FROM tb_student S
JOIN tb_department D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
join TB_GRADE USING(student_no)
WHERE ABSENCE_YN ='N'
group by student_no, student_NAME, DEPARTMENT_NAME
HAVING AVG(POINT)>= 4.0
ORDER BY student_no;

--16. 환경조경학과 전공과목들의 과목별 평점을 파악할 수 있는 SQL문을 작성하시오
SELECT CLASS_NO, CLASS_NAME, avg(point)
from (SELECT *
FROM tb_CLASS
JOIN tb_department USING (department_NO)
WHERE department_NAME = '환경조경학과')
join TB_GRADE USING(CLASS_NO)
GROUP BY CLASS_NO, CLASS_NAME;



-- 17.춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생드르이 이름과 주소를 출력하는 SQL문을 작성하시오
SELECT STUDENT_NAME, STUDENT_ADDRESS
FROM tb_student
WHERE DEPARTMENT_NO =(SELECT DEPARTMENT_NO
FROM tb_department
JOIN tb_student USING(DEPARTMENT_NO)
WHERE STUDENT_NAME ='최경희');


--18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL문을 작성하시오
SELECT STUDENT_NO, STUDENT_NAME, 평점
FROM (SELECT STUDENT_NO, STUDENT_NAME, AVG(POINT) AS 평점
FROM tb_student
JOIN tb_grade USING(STUDENT_NO)
JOIN tb_department USING(department_NO)
WHERE department_NAME = '국어국문학과'
GROUP BY STUDENT_NO, STUDENT_NAME
ORDER BY 평점 DESC)
WHERE ROWNUM <=1;

--19. 춘 기술대학교의 환경조경학가 속한 같은 계열 학과들의 학과별 전공과목 평점을 파악하기 위한
--    적절한 SQL문을 찾아내시오. 단 출력헤더는 계열학과명 전공평점으로 표시되도록 하고, 평점은
--    소수점 한 자리까지만 반올ㄹ림하여 표시되도록한다.
SELECT department_NAME AS 계열학과명, ROUND(avg(point),1) AS 전공평점
from tb_department D, tb_GRADE G, TB_CLASS C
WHERE C.department_NO = D.department_NO 
AND C.CLASS_NO = G.CLASS_NO
AND CATEGORY = (SELECT CATEGORY
FROM tb_department 
WHERE department_NAME = '환경조경학과')
GROUP BY department_NAME;
