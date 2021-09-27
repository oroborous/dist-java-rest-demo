package edu.wctc.distjavarestdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private Double gpa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="address_id")
    private Address address;

    @Column(name="date_enrolled")
    private LocalDate dateEnrolled;

    @ElementCollection
    @CollectionTable(name = "student_language", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name="language")
    private List<String> languages;
}
