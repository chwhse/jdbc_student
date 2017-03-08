package kr.or.dgit.jdbc.dao;

import java.util.List;

import kr.or.dgit.jdbc.dto.Student;

public interface StudentDao {
	Student findStudentById(int studId);
	void insertStudent(Student student);
	void deleteStudent(int studId);
	List<Student> findAllStudents();
}
