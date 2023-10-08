package org.peaksoft.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.util.List;

// TODO: 07.10.2023 в классе Course должен быть поля(Long id, String courseName,
//  String durationMonth, LocalDate createDate)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String courseName;
    String durationMonth;
    LocalDate createDate;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_instuctor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    List<Instructor> instructors;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;

    public Course(String courseName, String durationMonth, LocalDate createDate) {
        this.courseName = courseName;
        this.durationMonth = durationMonth;
        this.createDate = createDate;
    }
}
