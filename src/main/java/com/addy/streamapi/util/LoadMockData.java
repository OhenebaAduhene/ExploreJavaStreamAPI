package com.addy.streamapi.util;

import com.addy.streamapi.model.Car;
import com.addy.streamapi.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoadMockData {

    // load mock data from a file and return it as a list of Person objects
    public static ImmutableList<Person> getPeople() throws IOException {
        InputStream in = Resources.getResource("people.json").openStream();
        return ImmutableList.copyOf(new ObjectMapper().readValue(in, Person[].class));
    }

    // load mock data from a file and return it as a list of Car objects
    public static ImmutableList<Car> getCars() throws IOException {
        InputStream in = Resources.getResource("cars.json").openStream();
        return ImmutableList.copyOf(new ObjectMapper().readValue(in, Car[].class));
    }

}
