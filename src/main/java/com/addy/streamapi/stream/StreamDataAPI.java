package com.addy.streamapi.stream;

import com.addy.streamapi.model.Car;
import com.addy.streamapi.model.Person;
import com.addy.streamapi.model.PersonDTO;
import com.addy.streamapi.util.LoadMockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@Service
public class StreamDataAPI {
    private List<Person> people;
    private List<Car> cars;

    public StreamDataAPI() throws IOException {
        people = LoadMockData.getPeople();
        cars = LoadMockData.getCars();
    }
    public List<Person> getPeopleWithAgeLessThan18()  {

        return people.stream()
                .filter(person -> person.getAge() <= 18)
                .collect(Collectors.toList());
    }

    public List<Person> getFirst10People() {
        return people.stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    public int[] returnEvenNumbers(){
        return IntStream.iterate(0, operand -> operand+1)
                .filter(n -> n % 2 == 0)
                .limit(20)
                .toArray();
    }

    public int minValue(List<Integer> list){

        return list.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public List<Integer> getDistinctNumbers(List<Integer> list){
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<PersonDTO> getAllPeople(){
       return people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList());
    }

    public double averageCarPrice(){
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public DoubleSummaryStatistics summaryStatistics(){
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
    }

    public Map<String, List<Car>> sampleGrouping(){
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getMake));
    }

    public Map<String, Long> groupingAndCount(){
        return cars.stream()
                .collect(
                        Collectors.groupingBy(Car::getMake, Collectors.counting())
                );
    }

    public String joinStrings(List<String> string){
        return string.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("|"));
    }


}
