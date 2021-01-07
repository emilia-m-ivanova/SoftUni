package StrategyPattern;

import java.util.Comparator;

public class CompareByAge implements Comparator<Person> {

    @Override
    public int compare (Person first, Person second){
        return first.getAge() - second.getAge();
    }

}
