package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentDao.StudentDao;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	   @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("student", "student", new Student());
	   } //Initial loading of student JSp Page
	   
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	      public String addStudent(@Valid  @ModelAttribute("student") Student student,BindingResult result,ModelMap model) {
	      model.addAttribute("studentName", student.getStudentName());
	      model.addAttribute("studentAge", student.getStudentAge());
	      model.addAttribute("studentEmail", student.getstudentEmail());
         if(result.hasErrors()){
        	 return "student";
         }
	      boolean checkInsert=studentDao.addStudent(student);
	      if(checkInsert==true){
	      model.addAttribute("sucessORfail","Sucessfully insert into database here is your result");
	      }
	      else{
	       model.addAttribute("sucessORfail","Error in inserting into database here is your result");   
	      }
	      return "result";
	   } //This is used to add the students into database
	   
	   
	   
	   @RequestMapping(value = "/getAllStudents", method = RequestMethod.POST)
	      public String getAllStudents(ModelMap model) {
		   List<Student> studentList=studentDao.listAllStudents();
		   model.addAttribute("getStudentDetails",studentList);
		   return "getStudentDetails";
	   } //This method is used to display all the students in the table
	   
	   @RequestMapping(value = "/getStudent", method = RequestMethod.POST)
	   public String getStudent(@ModelAttribute("student")Student student,HttpServletRequest req, ModelMap model) {
		  int studentId=Integer.parseInt(req.getParameter("studentId"));
		  Object[] getstudent=studentDao.getStudent(studentId);
		  model.addAttribute("studentId",getstudent[0]);
		  model.addAttribute("studentName",getstudent[1]);
		  model.addAttribute("studentAge",getstudent[2]);
		  model.addAttribute("studentEmail",getstudent[3]);
	      return "student_details";
	   } // This method is used to retrive single data in a table  
	   
	   
	   @RequestMapping(value = "/studentSingleUpdate", method = RequestMethod.POST)
	   public String studentUpdate(HttpServletRequest req,  ModelMap model) {
		   int studentId=Integer.parseInt(req.getParameter("studentId"));
		   Object[] updatestudent= studentDao.UpdateStudent(studentId);
		      model.addAttribute("studentId",updatestudent[0]);
			  model.addAttribute("studentName",updatestudent[1]);
			  model.addAttribute("studentAge",updatestudent[2]);
			  model.addAttribute("studentEmail",updatestudent[3]);
		   return "updateStudent";
	   }
	   
	   
	   @RequestMapping(value = "/studentUpdateValue", method = RequestMethod.POST)
	   public String studentUpdateValue(@ModelAttribute("student")Student student,HttpServletRequest req,  ModelMap model) {
		   int studentId=Integer.parseInt(req.getParameter("studentId"));
		   model.addAttribute("studentName", student.getStudentName());
		   model.addAttribute("studentAge", student.getStudentAge());
		   model.addAttribute("studentEmail", student.getstudentEmail());
		   boolean checkInsert= studentDao.UpdateStudentValue(student,studentId);
		   if(checkInsert==true){
			      model.addAttribute("sucessORfail","Sucessfully updated into database here is your result");
		    }
		   return "result";
	   } //Its is used to update the records in  a table
	   
	   
	   @RequestMapping(value = "/studentDelete", method = RequestMethod.POST)
	   public String studentDelete(HttpServletRequest req,  ModelMap model) {
		   int studentId=Integer.parseInt(req.getParameter("studentId"));
		  boolean deleteCheck= studentDao.deleteStudent(studentId);
		  if(deleteCheck==true){
			  model.addAttribute("deleted","Sucessfully  deleted from the database");		  
		  }
		  return "deleted";  
	   } // It is used to delete the record in a table
}
