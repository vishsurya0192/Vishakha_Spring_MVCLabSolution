package com.greatLearning.studentManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	
	//create session
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {session = sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student>findAll(){
		Transaction tx = session.beginTransaction();
		
		//find all records from table student
		
		List<Student> students = session.createQuery("from Student").list();
		
		tx.commit();
		return students;
	}
	
	@Transactional
	public void save(Student theStudent) {
		Transaction tx = session.beginTransaction();
		
		//save transaction
		session.saveOrUpdate(theStudent);
		tx.commit();
	}
	
	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		
		//get transaction
		Student student = session.get(Student.class, id);
		
		//delete record
		session.delete(student);
		
		tx.commit();
	}
	
	@Transactional
	public Student findById(int id) {
		Student student = new Student();
		
		Transaction tx = session.beginTransaction();
		
		//find record with id from table
		student = session.get(Student.class, id);
		tx.commit();
		return student;
	}
	
	

}
