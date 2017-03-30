package com.accenture.dab.EmpDAB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.BaseDAB;


public class EmpDAB extends BaseDAB /*implements IEmpDAB*/ {
	
	
	private static EmpDAB instance =null;
	 
	private EmpDAB() {
	      // Exists only to defeat instantiation.
	   }

	static EmpDAB getInstance() {
	      if(instance == null) {
	    	  synchronized(instance) Change from GitHub
	    	  {
	    		  if(instance==null)
	    		  instance = new EmpDAB();
	    		  }
	      }  
	      return instance;
	   }
	
	public static int insertIntoEmployee(EmployeeBean emp) /*throws SQLException, ParseException*/ {

		Date date= new Date(0);
		

		// use ORM
		String query = "INSERT INTO employee (project,resourceName,gcp,personnelNo,level,resourceType,currentLocation,lockStartDate,billableDate,rollOffDate,joinDate,team,gender,supervisor,visaType,rateType,enterpriseId,contactDetails,DOB,Hometown) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int successPara=0;
		
		Connection connection = getConnection();
		PreparedStatement prepstmt = null;
		try {
			prepstmt = connection.prepareStatement(query);
			
			
			prepstmt.setInt(1, emp.getProject());
			prepstmt.setString(2, emp.getName());
			prepstmt.setBoolean(3, emp.isGcp() );
			prepstmt.setString(4, emp.getPersonnalNo());
			prepstmt.setInt(5,emp.getLevel());
			prepstmt.setInt(6, emp.getResourceType());
			prepstmt.setInt(7,  emp.getCurrentLocation());
			prepstmt.setDate(8,date);
			prepstmt.setDate(9, date);
			prepstmt.setDate(10, date);
			prepstmt.setDate(11, date);
			prepstmt.setInt(12, emp.getTeam());
			prepstmt.setInt(13, emp.getGender());
			prepstmt.setString(14, emp.getSupervisor());
			prepstmt.setInt(15, emp.getVisaType());
			prepstmt.setInt(16, emp.getRateType());
			prepstmt.setString(17, emp.getEnterpriseId());
			prepstmt.setString(18, emp.getContactDetails());
			prepstmt.setDate(19,date);
			prepstmt.setInt(20, emp.getHomeTown());
			
			successPara = prepstmt.executeUpdate();
			
			System.out.println(successPara);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 closeResources(prepstmt, connection);
		}
		

		
		return successPara;
	}

	public List<EmployeeBean> getEmployeeBeanList() {
		List<EmployeeBean> list_emp = new ArrayList<EmployeeBean>();
		
		String query = "select * from employee ";
		// String query ="SHOW COLUMNS FROM "+tableName;
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement prepstmt=null;
		try {
			prepstmt = connection.prepareStatement(query);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				// do somthing
				EmployeeBean emp_bean = new EmployeeBean();
				
				emp_bean.setProject(rs.getInt(1));  //TODO use column name 
				emp_bean.setName(rs.getString(2));

				System.out.println((rs.getInt(1)));
				list_emp.add(emp_bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {

			closeResources(rs, prepstmt, connection);

		}
		

		
		return list_emp;
	}

	public EmployeeBean getEmpBean(String empId)
	{
		EmployeeBean employeeBean = new EmployeeBean();
		
		// logic part
		
		System.out.println("Dao class");
		
		return employeeBean;
	}

	public int deleteEmployeeBean()
	{
		String query = "DELETE FROM employee WHERE personnelNo=?;";
		Connection con = getConnection();
		int successPara=0;
		
		PreparedStatement prepstmt=null;
		try {
			prepstmt = con.prepareStatement(query);
			
			prepstmt.setString(1,"11190180");
			
			int result = prepstmt.executeUpdate();
		
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeResources(prepstmt, con);
		}
		
		return successPara;
	}
	
	

	public int updateEmployeeBean() //TODO employeeBean parameter will come and all bean will set
	{
		String query = "update employee set resourceName=? WHERE personnelNo=?;";
		Connection con = getConnection();
		int successPara=0;
		
		PreparedStatement prepstmt=null;
		try {
			prepstmt = con.prepareStatement(query);
			
			prepstmt.setString(1,"Shubham");
			prepstmt.setString(2,"11190182");
			
			successPara = prepstmt.executeUpdate();
		
			System.out.println(successPara);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeResources(prepstmt, con);
		}
		
		return successPara;
	}
	


	

	
	
}
