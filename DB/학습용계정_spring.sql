CREATE TABLE PhotoBOARD(
    photo_NO NUMBER PRIMARY KEY,
    photo_TITLE VARCHAR2(100) NOT NULL,
    photo_WRITER VARCHAR2(15) NOT NULL,
    photo_CONTENT VARCHAR2(4000) NOT NULL,
    ORIGIN_NAME VARCHAR2(100),
    CHANGE_NAME VARCHAR2(100),
    COUNT NUMBER DEFAULT 0,
    CREATE_DATE DATE DEFAULT SYSDATE,
    STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
    FOREIGN KEY (photo_WRITER) REFERENCES MEMBER ON DELETE CASCADE
);

COMMENT ON COLUMN PhotoBOARD.photo_NO IS '게시글번호';
COMMENT ON COLUMN PhotoBOARD.photo_TITLE IS '게시글제목';
COMMENT ON COLUMN PhotoBOARD.photo_WRITER IS '작성자아이디';
COMMENT ON COLUMN PhotoBOARD.photo_CONTENT IS '게시글내용';
COMMENT ON COLUMN PhotoBOARD.ORIGIN_NAME IS '첨부파일원래이름';
COMMENT ON COLUMN PhotoBOARD.CHANGE_NAME IS '첨부파일변경이름';
COMMENT ON COLUMN PhotoBOARD.COUNT IS '게시글조회수';
COMMENT ON COLUMN PhotoBOARD.CREATE_DATE IS '게시글작성일';
COMMENT ON COLUMN PhotoBOARD.STATUS IS '게시글상태값(Y/N)';

CREATE SEQUENCE SEQ_PBNO
NOCACHE;

INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, '관리자 게시글', 'admin',
        '저희 사이트를 이용해 주셔서 감사합니다.', NULL, NULL,
        DEFAULT, '20220210', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'MVC Model2 패턴이란', 'user01',
        '웹 애플리케이션 설계 방식 중 하나입니다.', NULL, NULL,
        DEFAULT, '20220211', DEFAULT);  
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, '설계방식 2', 'user02',
        '웹 애플리케이션 설계 방식 중 두번째 방식은 각 서블릿 구동 앞에 First Controller를 두는 것입니다.', 
        NULL, NULL, DEFAULT, '20220212', DEFAULT);

INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, '설계방식 3', 'user02',
        '웹 애플리케이션 설계 방식 중 세번째 방식은 Front Controller 다음에 연결되는 컨트롤러들을 서블릿이 아닌 자바 클래스로 작성해서 연결하는 방식입니다.', 
        NULL, NULL, DEFAULT, '20220220', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'MVC Modell 패턴', 'user01',
        '웹 애플리케이션 설계 방식 중 JSP 파일이 뷰와 컨트롤러 두가지 다를 처리하는 방식입니다.', 
        NULL, NULL, DEFAULT, '20220220', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'JSP란', 'user02',
        'Java Server Page를 말함', 
        NULL, NULL, DEFAULT, '20220221', DEFAULT);

INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'Servlet이란', 'admin',
        '서버에서 구동되는 웹 규약이 적용된 Java EE모듈이 제공하는 서비스 처리용 클래스임.', 
        NULL, NULL, DEFAULT, '20220221', DEFAULT);

INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'HTML5', 'user02',
        '새로운 웹 표준기술로 모든 디바이스 장치와 브라우저에서 동일하게 작동되는 웹페이지를 만들기 위한 기술을 제공한다.', 
        NULL, NULL, DEFAULT, '20220301', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'CSS3', 'user02',
        '웹 페이지를 꾸미기 위한 스타일시트로 HTML5 버전에 맞추어 속성들이 업그레이드 되었다.', 
        NULL, NULL, DEFAULT, '20220301', DEFAULT);

INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'jQuery 란', 'admin',
        '자바스크립트 오픈 소스 라이브러리의 하나로 html 요소들을 css 선택자를 이용해서 쉽게 선택할 수 있는 기능들을 제공한다.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, 'ajax 란', 'admin',
        'asynchronos javascript and xml의 줄임말로 서버의 서블릿과 직접 통신하는 자바스크립트 기술이다.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, '필터(Filter) 란', 'user02',
        '클라이언트 요청한 서비스가 서블릿으로 전달되기 전에 먼저 구동되는 클래스이다.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
        
INSERT INTO PhotoBOARD
VALUES(SEQ_BNO.NEXTVAL, '래퍼(Wrapper) 란', 'user01',
        '필터가 낚아챈 요청에 대한 데이터 처리를 담당하는 클래스이다.', 
        NULL, NULL, DEFAULT, '20221021', DEFAULT);
 
commit;
     