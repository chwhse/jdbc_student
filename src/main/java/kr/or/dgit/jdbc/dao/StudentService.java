package kr.or.dgit.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import kr.or.dgit.jdbc.dto.Student;
import kr.or.dgit.jdbc.util.ConnectionFactory;
import kr.or.dgit.jdbc.util.JdbcUtil;

public class StudentService implements StudentDao {
	
	private static final StudentService instance= new StudentService();
	
	public static StudentService getInstance(){
		return instance;
	}
	
	@Override
	public Student findStudentById(int studId) {
		Student student = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = ConnectionFactory.getConnection();
		String sql = "select * from student where stud_id=?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				student = getStudent(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return student;
	}

	private Student getStudent(ResultSet rs) {
		
		return null;
	}

	@Override
	public void insertStudent(Student student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = ConnectionFactory.getConnection();
		String sql = "insert into student values(?,?,?,?)";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getStudId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setTimestamp(4, new Timestamp(student.getDob().getTime()));
			pstmt.executeUpdate();
			System.out.println(pstmt);
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.err.printf("중복학생존재", student);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}

	@Override
	public void deleteStudent(int studId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = ConnectionFactory.getConnection();
		String sql = "delete from student where stud_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studId);
			pstmt.executeUpdate();
			System.out.println(pstmt);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}


	@Override
	public List<Student> findAllStudents() {
		List<Student> lists = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = ConnectionFactory.getConnection();
		String sql = "select * from student where stud_id=?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				student = getStudent(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return student;
	}

}
