package org.peaksoft.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.peaksoft.model.enums.Gender;
import org.peaksoft.model.enums.StudyFormat;

import java.time.LocalDate;
import java.util.List;

// TODO: 07.10.2023 в классе Student должен быть поля (Long id, String name, int age,
//  StudyFormat studyFormat(enum),Gender gender, LocalDate createDate)
//  Relationships:
//  1. Student and StudentIdCard. У каждого Студента должна быть только одна машина
//  2. Student and Course. Студент может обучаться на нескольких курсах, и на одном курсе может быть несколько студентов
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    StudyFormat studyFormat;
    Gender gender;
    LocalDate createDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "students")
    StudentIdCard IdCard;

    public Student(String name, int age, StudyFormat studyFormat, Gender gender) {
        this.name = name;
        this.age = age;
        this.studyFormat = studyFormat;
        this.gender = gender;
    }
}
