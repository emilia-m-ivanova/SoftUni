package Telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        return this.numbers.stream()
                .map(e->{
                    if(!e.matches("^[0-9]+$")){
                        return "Invalid number!";
                    }
                    return "Calling... " + e;
                }).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String browse() {
        return this.urls.stream()
                .map(e->{
                    if(!e.matches("^[^0-9]+$")){
                        return "Invalid URL!";
                    }
                    return "Browsing: " + e + "!";
                }).collect(Collectors.joining(System.lineSeparator()));
    }
}
