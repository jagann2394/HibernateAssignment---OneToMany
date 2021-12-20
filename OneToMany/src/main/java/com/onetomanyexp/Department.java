package com.onetomanyexp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity class Department.
 * @author jn.chakravarthy
 * @param departmentId - auto generated
 * @param departmentName - department name
 * @param headOfDepartment - name of the head of department
 * @param students - one to many mapping with students. A department can have multiple students
 *
 */
@Entity
public class Department {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int departmentId;

	private String departmentName;
	
	private String headOfDepartment;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	List<Student> students;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
