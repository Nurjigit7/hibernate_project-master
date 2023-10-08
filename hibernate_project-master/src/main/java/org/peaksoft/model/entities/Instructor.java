package org.peaksoft.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.peaksoft.model.enums.Gender;

import java.time.LocalDate;
import java.util.List;

// TODO: 07.10.2023  в классе Instructor должен быть поля(Long id,String name, String lastName, int age,
//  Gender gender, LocalDate createDate)
//  Relationship: Instructor and Course.На одном курсе может быть несколько инструкторов,
//  но один инструктор не может работать на нескольких курсах
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "instructors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    int age;
    Gender gender;
    LocalDate createDate;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "instructors")
    List<Course>courses;

    public Instructor(String name, String lastName, int age, Gender gender, LocalDate createDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.createDate = createDate;
    }
}
