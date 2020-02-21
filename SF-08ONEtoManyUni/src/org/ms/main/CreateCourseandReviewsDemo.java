package org.ms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.Course;
import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;
import org.ms.entities.Review;


public class CreateCourseandReviewsDemo {
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
			
			Course tempCourse = new Course ("Pacman - How to Score One Million points");
			
			tempCourse.add(new Review("Great course I loved it!"));
			tempCourse.add(new Review("cool course I loved it!"));
			tempCourse.add(new Review("what a dump course course I loved it!"));
			
			session.save(tempCourse);
			
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
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
