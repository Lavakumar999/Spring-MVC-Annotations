package com.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Student {
	   private int studentId;
	   private int studentAge;
	   @NotEmpty(message="name should not be empty")
	   @Size(min=4,max=30,message="name should 4 to 30") @Pattern(regexp="[^0-9]*")
	   private String studentName;
	   @NotEmpty(message="email should not be empty") @Email(message="email  30")
	   private String studentEmail;
	   public Student(){}
	   public  Student(int studentId,int studentAge,String studentName,String studentEmail)
	   {
		   this.studentId=studentId;
		   this.studentAge=studentAge;
		   this.studentName=studentName;
		   this.studentEmail=studentEmail;
	   }
	  public void setStudentId(int studentId) {
		      this.studentId= studentId;
		   }
	  public int getStudentId() {
		      return studentId;
		   }
	   public void setStudentAge(int studentAge) {
	      this.studentAge = studentAge;
	   }
	   public int getStudentAge() {
	      return studentAge;
	   }
	   public void setStudentName(String studentName) {
	      this.studentName = studentName;
	   }
	   public String getStudentName() {
	      return studentName;
	   }
	   public void setstudentEmail(String studentEmail) {
	      this.studentEmail = studentEmail;
	   }
	   public String getstudentEmail() {
	      return studentEmail;
	   }
}
