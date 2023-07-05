package com.nadee.lil.quarkus.util;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class FizzBuzzExecutor {

    @ConfigProperty(name="fb.three", defaultValue = "Fizz")
    String threeMultipleText;

    @ConfigProperty(name = "fb.five", defaultValue = "Buzz")
    String fiveMultipleText;

    @ConfigProperty(name = "fb.both", defaultValue = "FizzBuzz")
    String bothMultipleText;

    @ConfigProperty(name = "fb.max", defaultValue = "100")
    int maxNumber;

    public void execute() {
        for (int i = 1; i <= maxNumber; i++) {
            String result = String.valueOf(i);

            if (i % 3 == 0 && i % 5 == 0) {
                result = bothMultipleText;
            } else if (i % 3 == 0) {
                result = threeMultipleText;
            } else if (i % 5 == 0) {
                result = fiveMultipleText;
            }

            System.out.println(result);
        }
    }
}
