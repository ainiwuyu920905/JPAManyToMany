package junit.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.edu.beans.Student;
import cn.edu.beans.Teacher;

public class Many2ManyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistences");
		EntityManager em = emf.createEntityManager();
		Student student = new Student();
		student.setName("С��");
		Teacher teacher = new Teacher();
		teacher.setName("����ʦ");
		student.addTeacher(teacher);
		em.getTransaction().begin();
		em.persist(student);
		em.persist(teacher);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	@Test
	public void deleteTeacher(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistences");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class,2);
		student.removeTeacher(em.getReference(Teacher.class,2));
		em.remove(em.getReference(Teacher.class,2));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
