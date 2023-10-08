package org.peaksoft.model.entities;

// TODO: 07.10.2023 в классе StudentIdCard должен быть поля(Long id, String identityNumber,
//  LocalDate createDate)

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_id_cards")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String identityNumber;
    LocalDate createDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    Student student;

    public StudentIdCard(String identityNumber, LocalDate createDate) {
        this.identityNumber = identityNumber;
        this.createDate = createDate;
    }
}
