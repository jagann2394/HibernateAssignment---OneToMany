package com.onetomanyexp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity class Student.
 * @author jn.chakravarthy
 * @param studentId - auto generated
 * @param studentName - Student name
 * @param course - course student has enrolled in
 * @param department - many to one mapping with department.  One student can have only one department
 *
 */
@Entity
public class Student {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int studentId;
	private String studentName;
	private String course; 

	@ManyToOne
	Department department;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
