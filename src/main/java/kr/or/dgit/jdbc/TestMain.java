package kr.or.dgit.jdbc;

import java.sql.Connection;
import java.util.Date;

import kr.or.dgit.jdbc.dao.StudentService;
import kr.or.dgit.jdbc.dto.Student;
import kr.or.dgit.jdbc.util.ConnectionFactory;

public class TestMain {

	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println(connection);
		
		StudentService service = StudentService.getInstance();
		Student student = new Student(1, "가가가", "naver.com", new Date());
		service.insertStudent(student);
	}

}
