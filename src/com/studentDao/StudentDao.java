package com.studentDao;

import java.util.List;

import com.controller.Student;

public interface StudentDao  {
	   public boolean addStudent(Student student);
	   public  Object[] getStudent(int studentId);
	   public List<Student> listAllStudents();
	   public boolean deleteStudent(int studentId);
	   public Object[] UpdateStudent(int studentId);
	   public boolean UpdateStudentValue(Student student,int studentId);
}
