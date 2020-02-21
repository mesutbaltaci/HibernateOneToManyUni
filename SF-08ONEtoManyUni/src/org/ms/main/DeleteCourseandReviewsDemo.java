package org.ms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.Course;
import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;
import org.ms.entities.Review;


public class DeleteCourseandReviewsDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			int theId=10;
			Course tempCourse = session.get(Course.class, theId);
			
			session.delete(tempCourse);
			session.getTransaction().commit();
			System.out.println("Done");
			
						
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
