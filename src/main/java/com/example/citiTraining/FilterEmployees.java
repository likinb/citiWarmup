package com.example.citiTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilterEmployees implements FilterAddress {

    @Override
    public Boolean filterCity(String city) {
        String defaultAddress ="Delhi";
        Optional<String> optAddress = Optional.ofNullable(city);
        String result = optAddress.orElse(defaultAddress);
        if(result.equalsIgnoreCase("Bangalore")) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> FilterCity(List<Employee> employeeList) {
        List<String> result = new ArrayList<>();
        employeeList.stream()
                .forEach(
                        y -> {
                            if (filterCity(y.address.city)) {
                                result.add(y.employeeName);
                            }
                        });
        return result;
    }
}
