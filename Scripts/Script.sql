-- 학생
CREATE TABLE mybatis.student (
	stud_id INTEGER     NOT NULL, -- 학번
	name    VARCHAR(50) NOT NULL, -- 성명
	email   VARCHAR(50) NOT NULL, -- 메일
	dob     DATE        NULL      -- 입학일자
);

-- 학생
ALTER TABLE mybatis.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			stud_id -- 학번
		);

ALTER TABLE mybatis.student
	MODIFY COLUMN stud_id INTEGER NOT NULL AUTO_INCREMENT;
	

	
