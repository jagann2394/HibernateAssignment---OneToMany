package com.onetomanyexp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {

	static void createStudent() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("departmentLedger");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			Department department = entityManager.getReference(Department.class, 1);

			Student student = new Student();
			student.setStudentName("Ramya");
			student.setCourse("Data Structures and Algorithm");
			student.setDepartment(department);

			entityManager.persist(student);
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
	static void getStudent() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("departmentLedger");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			Student student = entityManager.find(Student.class, 1);
			System.out.println("Student ID: " + student.getStudentId());
			System.out.println("Student Name: " + student.getStudentName());
			System.out.println("Student Course: " + student.getCourse());
			System.out.println("Student Department: " + student.getDepartment().getDepartmentName());

			entityManager.persist(student);
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
