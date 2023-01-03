package com.sasicodes.fullStack.A.Full.stack.application.with.react.student;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String email;
    private Enum gender;

}
