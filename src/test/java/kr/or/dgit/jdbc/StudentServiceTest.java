package kr.or.dgit.jdbc;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.jdbc.dao.StudentService;
import kr.or.dgit.jdbc.dto.Student;

public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = studentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testInsertStudent() {
		Student insStudent = new Student(2, "김두한", "kdh@test.co.kr", new Date());
		int res = studentService.insertStudent(insStudent);
		Assert.assertEquals(1, res);
	}

}
