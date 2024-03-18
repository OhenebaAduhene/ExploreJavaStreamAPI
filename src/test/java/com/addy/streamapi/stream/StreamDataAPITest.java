package com.addy.streamapi.stream;

import com.addy.streamapi.model.Car;
import com.addy.streamapi.model.Person;
import com.addy.streamapi.model.PersonDTO;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamDataAPITest {

    private StreamDataAPI streamDataAPI;
    @BeforeEach
    void setUp() throws IOException {
        streamDataAPI = new StreamDataAPI();
    }

    @Test
    void getPeopleWithAgeLessThan18() throws IOException {
        List<Person> peopleWithAgeLessThan18 = streamDataAPI.getPeopleWithAgeLessThan18();

        // assert that the list is not null
        assertNotNull(peopleWithAgeLessThan18);

        // assert that the list is not empty
        assertFalse(peopleWithAgeLessThan18.isEmpty());

        // assert that the list contains only people with age less than 18
        assertTrue(peopleWithAgeLessThan18.stream().allMatch(person -> person.getAge() <= 18));

        // assert that the list contains only people with age less than 18
        assertTrue(peopleWithAgeLessThan18.stream().noneMatch(person -> person.getAge() > 18));
    }

    @Test
    void getFirst10People(){
        List<Person> first10People = streamDataAPI.getFirst10People();

        //assert the list is not null
        assertNotNull(first10People);

        //assert the size is 10
        assertEquals(10, first10People.size());

        //assert first element id is 1
        assertEquals(1, first10People.get(0).getId());

        //assert last element id is 10
        assertEquals(10, first10People.get(9).getId());
    }

    @Test
    void getEvenNumbers(){
        int[] first20EvenNumbers = streamDataAPI.returnEvenNumbers();

       //assert not null
        assertNotNull(first20EvenNumbers);

        //assert number is a even
        Arrays.stream(first20EvenNumbers).forEach(n -> assertEquals(0, n % 2));
    }

    @Test
    void minValue(){
        final List<Integer> numbers = ImmutableList.of(20, 10, 74, 6, 80, 9, 2);
        int min = streamDataAPI.minValue(numbers);

        //assert not null
        assertEquals(2, min);

        assertNotEquals(10, min);
    }

    @Test
    void getDistinctNumbers(){
        final List<Integer> numbers = ImmutableList.of(20, 20, 2, 74, 1, 1, 80, 5, 9, 10, 74, 6, 80, 9, 2);

        List<Integer> distinctNumbers = streamDataAPI.getDistinctNumbers(numbers);

        assertNotNull(distinctNumbers);

        assertEquals(9, distinctNumbers.size());
    }

    @Test
    void getAllPeople(){
        List<PersonDTO> allPeople = streamDataAPI.getAllPeople();

        assertNotNull(allPeople);
        assertEquals(100, allPeople.size());

        allPeople.forEach(person -> assertTrue(person instanceof PersonDTO));
    }

    @Test
    void getAveragePriceForAllCars(){
        double averageCarPrice = streamDataAPI.averageCarPrice();
        System.out.println(averageCarPrice);
        assertNotEquals(0, averageCarPrice);
        assertEquals(118800.35, averageCarPrice);
    }

    @Test
    void testSampleGrouping(){
        Map<String, List<Car>> stringListMap = streamDataAPI.sampleGrouping();

        stringListMap.forEach((make, cars) -> {
//            System.out.println(make);
            assertNotNull(make);
//            cars.forEach(System.out::println);
            assertNotEquals(0, cars.size());
            cars.forEach(Assertions::assertNotNull);
            cars.forEach(car -> assertNotEquals(0, car.getPrice()));
//            System.out.println();
        });

    }

    @Test
    void testGroupingAndCount(){
        Map<String, Long> stringLongMap = streamDataAPI.groupingAndCount();

        assertNotEquals(0, stringLongMap.size());
        assertNotNull(stringLongMap);

        stringLongMap.forEach((make, count) -> {
            System.out.println(make + " -> " + count);
        });
    }

    @Test
    void testJoiningString(){

        List<String> str = ImmutableList.of("java", "stream", "api");
        String joinStr = streamDataAPI.joinStrings(str);

        assertNotNull(joinStr);
        assertEquals("JAVA|STREAM|API", joinStr );
    }

    @AfterEach
    void tearDown() {
        streamDataAPI = null;
    }

}