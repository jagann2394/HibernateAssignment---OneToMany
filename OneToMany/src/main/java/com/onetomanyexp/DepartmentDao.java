package com.onetomanyexp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DepartmentDao {

	static void createDepartment() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("departmentLedger");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			Department department = new Department();
			department.setDepartmentName("Computer Science");
			department.setHeadOfDepartment("Dr. Sudaraman Ramakrishnan");

			Student student = new Student();
			student.setStudentName("Jagannathan");
			student.setCourse("Data Structures and Algorithm");
			student.setDepartment(department);

			Student student2 = new Student();
			student2.setStudentName("Anuradha");
			student2.setCourse("Networking");
			student2.setDepartment(department);

			List<Student> students = new ArrayList<Student>();
			students.add(student);
			students.add(student2);

			department.setStudents(students);
			entityManager.persist(department);

		} catch (Exception exception) {
			entityTransaction.rollback();

		} finally {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.commit();
			}
			if (entityManager != null)
				entityManager.close();

			if (entityManagerFactory != null)
				entityManagerFactory.close();
		}
	}

	static void getDeparment() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("departmentLedger");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			Department department = entityManager.find(Department.class, 1);
			System.out.println("Department ID: " + department.getDepartmentId());
			System.out.println("Department Name: " + department.getDepartmentName());
			System.out.println("HoD: " + department.getHeadOfDepartment());
			List<Student> students = department.getStudents();

			System.out.println("Number of Students: " + students.size());
			for (Student student : students) {
				System.out.println("Student ID: " + student.getStudentId());
				System.out.println("Student Name: " + student.getStudentName());
				System.out.println("Student Course: " + student.getCourse());
				System.out.println("Student Department: " + student.getDepartment().getDepartmentName());
			}

		} catch (Exception exception) {
			entityTransaction.rollback();

		} finally {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.commit();
			}
			if (entityManager != null)
				entityManager.close();

			if (entityManagerFactory != null)
				entityManagerFactory.close();
		}
	}

}
