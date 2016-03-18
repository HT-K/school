CREATE SEQUENCE seq_hak <!-- 시퀀스 생성, 시작학번을 설정해두고 증가값을 설정해두면 자동으로 된다. -->
INCREMENT BY 1
START WITH 200934001;

CREATE TABLE Grade(
     id VARCHAR2(30) UNIQUE NOT NULL,
     hak NUMBER PRIMARY KEY,
     java NUMBER,
     sql NUMBER,
     jsp NUMBER,
     spring NUMBER
);

INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('hong',seq_hak.NEXTVAL,90,90,90,90); <!-- 시퀀스명.NEXTVAL을 하면 시퀀스로 학번을 생성한다. -->
INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('kim',seq_hak.NEXTVAL,85,80,70,65);
INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('lee',seq_hak.NEXTVAL,15,25,30,45);
INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('song',seq_hak.NEXTVAL,95,100,60,50);
INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('yoon',seq_hak.NEXTVAL,70,85,90,100);
INSERT INTO Grade(id,hak,java,sql,jsp,spring)
VALUES ('kim2',seq_hak.NEXTVAL,35,25,15,65);

SELECT * FROM Grade;

DROP TABLE Grade CASCADE;

<!-- 가상 테이블인 뷰를 만들어  이름으로 검색할 수 있게 한다. -->
CREATE VIEW v_Grade_Member
AS SELECT g.id '아이디', m.name '이름', g.hak '학번'
FROM Grade g, Member m
WHERE g.id = m.id;