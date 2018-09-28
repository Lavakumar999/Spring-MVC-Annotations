package com.studentDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.controller.Student;
import com.mysql.jdbc.ResultSetMetaData;
@Repository
public class StudentDaoImpl implements  StudentDao{
	DatabaseFunctionality db=new DatabaseFunctionality();

	@Override
	public boolean addStudent(Student student) {	
		 
		try{
			ResultSet rs=db.database().createStatement().executeQuery("select max(id) from student");
			int maxid=0;
	        if(rs.next()){
				maxid=rs.getInt(1);
				maxid++;
			}
	        String sql="insert into student values(?,?,?,?)";
	         java.sql.PreparedStatement pt=db.database().prepareStatement(sql);
	         pt.setInt(1, maxid);
	         pt.setString(2,student.getStudentName());
	         pt.setInt(3,student.getStudentAge());
	         pt.setString(4,student.getstudentEmail());
	         int i=pt.executeUpdate();         
	         if(i>0){
	        	 return true;
	         }
	         
		}catch(Exception e){}
		return false;
	}
	
	@Override
	public Object[] UpdateStudent(int studentId) {
		Object[] updateStudent;
		ArrayList<Student> updateList=new ArrayList<Student>();
		try{
			 String sql="select * from student where id="+studentId;
		        java.sql.PreparedStatement pt=db.database().prepareStatement(sql);
		       ResultSet resultSet=pt.executeQuery(sql);
		       ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
		 	   int columnsCount = rsmd.getColumnCount();
		       while(resultSet.next()){   	   
		    	   updateStudent=new Object[columnsCount];
		    	   updateStudent[0]=studentId;
		    	   updateStudent[1]=resultSet.getString("name");
		    	   updateStudent[2]=resultSet.getInt("age"); 	
		    	   updateStudent[3]=resultSet.getString("email");   
				return updateStudent;
		       }
		}catch(Exception e){}       
		return null;
	}
	@Override
	public Object[] getStudent(int studentId) {
		Object[] singleStudent;
	try{
		 String sql="select * from student where id="+studentId;
         java.sql.PreparedStatement pt=db.database().prepareStatement(sql);
         ResultSet resultSet=pt.executeQuery(sql);
         ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
 		 int columnsCount = rsmd.getColumnCount();
	     while(resultSet.next()){ 
	    singleStudent=new Object[columnsCount];
	    singleStudent[0]=studentId;
	    singleStudent[1]=resultSet.getString("name");
	    singleStudent[2]=resultSet.getInt("age"); 	
	    singleStudent[3]=resultSet.getString("email");

	    return singleStudent;
		  } 
	   }catch(Exception e){}
	 return null;
	}

	@Override
	public List<Student> listAllStudents() {
		ArrayList<Student> arrayList=new ArrayList<Student>();
		try{
		 Statement st=db.database().createStatement();
	     String sql="select * from student";
	     ResultSet resultSet=st.executeQuery(sql);	     
	     String studentName,studentEmail;
	     int studentAge;
	      while (resultSet.next()) {
	    	   int studentId=resultSet.getInt("id");
	    	   studentName=resultSet.getString("name");
	    	   studentAge=resultSet.getInt("age");
	    	   studentEmail=resultSet.getString("email");
	    	   
	    	   arrayList.add(new Student(studentId,studentAge,studentName,studentEmail));   
	       }         
		}catch(Exception e){} 
		return arrayList;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		try{
		String sql="delete from student where id="+studentId;
        java.sql.PreparedStatement pt=db.database().prepareStatement(sql);
        int i=pt.executeUpdate();
        if(i>0){
        	return true;
        }
		}catch(Exception e){
			
		}
		return false;
	}

	@Override
	public boolean UpdateStudentValue(Student student,int studentId) {
		 try{
		   String sql="update student set name=?,age=?,email=? where id=?";
	       java.sql.PreparedStatement pt=db.database().prepareStatement(sql);   
	       pt.setString(1,student.getStudentName());
	       pt.setInt(2, student.getStudentAge());
	       pt.setString(3, student.getstudentEmail());
	       pt.setInt(4,studentId);
	       int i=pt.executeUpdate();
	       if(i>0){
	    	   return true;
	       }
		 }catch(Exception e){}
		return false;
	}
	


}
