package org.peaksoft.util;


import org.hibernate.HibernateError;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.peaksoft.model.entities.Course;
import org.peaksoft.model.entities.Instructor;
import org.peaksoft.model.entities.Student;
import org.peaksoft.model.entities.StudentIdCard;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {

            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml").
                    addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(StudentIdCard.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }

}
