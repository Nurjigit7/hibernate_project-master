package org.peaksoft.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.peaksoft.model.entities.Student;
import org.peaksoft.service.Service;
import org.peaksoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements Service<Student> {
    @Override
    public void create(Student student) {
        if (student==null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Student student) {
        if (student==null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            studentList = session.createQuery("FROM Student", Student.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public Student getById(Long id) {
        Student student = new Student();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.get(Student.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public String deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student!=null) {
                session.delete(student);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return "Student with Id" + id + "has been deleted";
    }
}
