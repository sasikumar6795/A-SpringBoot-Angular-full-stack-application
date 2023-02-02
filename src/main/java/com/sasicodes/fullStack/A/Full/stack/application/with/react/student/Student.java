package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1)
    @GeneratedValue(generator = "student_sequence",
                    strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
