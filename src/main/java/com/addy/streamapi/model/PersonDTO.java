package com.addy.streamapi.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PersonDTO {
    private int id;
    private String name;
    private String gender;

    public static PersonDTO map(Person person){
        String name = person.getFirstName() + " " + person.getLastName();
        return new PersonDTO(person.getId(), name, person.getGender());
    }
}
