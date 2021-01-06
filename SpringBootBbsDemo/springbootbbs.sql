CREATE TABLE Board
(
    idx              NUMBER(4),
    name          VARCHAR2(20)  NOT NULL,
    email           VARCHAR2(100),
    title             VARCHAR2(200) NOT NULL,
    contents      VARCHAR2(2000) NOT NULL,
    writedate      DATE    DEFAULT SYSDATE   NOT NULL,
    readcount     NUMBER(4)   DEFAULT 0   NOT NULL,
    filename       VARCHAR2(200),
    CONSTRAINT board_idx_pk  PRIMARY KEY(idx)
);

CREATE  SEQUENCE board_idx_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE    9999
    NOCACHE
    NOCYCLE;

--게시판 목록 가져오기
CREATE OR REPLACE PROCEDURE sp_board_select_all
(
    board_record    OUT   SYS_REFCURSOR
)
AS
BEGIN
    OPEN board_record FOR
    SELECT idx, name, email, title, writedate, readcount, filename
    FROM Board  
    ORDER BY idx DESC;
END;