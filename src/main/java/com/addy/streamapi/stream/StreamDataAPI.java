package com.addy.streamapi.stream;

import com.addy.streamapi.model.Person;
import com.addy.streamapi.util.LoadMockData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgeLessThan18 {
    public List<Person> getPeopleWithAgeLessThan18() throws IOException {
        List<Person> people = LoadMockData.getPeople();
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());
    }
}
