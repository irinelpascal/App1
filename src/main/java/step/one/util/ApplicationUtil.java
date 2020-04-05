package step.one.util;

import java.util.List;

import static step.one.constants.ApplicationConstants.BUZZ;
import static step.one.constants.ApplicationConstants.FIZZBUZZ;
import static step.one.report.Report.*;

public class ApplicationUtil {

    private ApplicationUtil() {

    }

    public static void checkIfNumberDivisibleBy_3_Or_5_Or_15_AndPopulateList(int number, List<String> strings, String word, String integerValue) {
        if (number % 3 == 0 && number % 5 != 0) {
            strings.add(word);
        } else if (number % 5 == 0 && number % 3 != 0) {
            strings.add(BUZZ);
            buzzCounter++;
        } else if (number % 15 == 0) {
            strings.add(FIZZBUZZ);
            fizzBuzzCounter++;
        } else {
            strings.add(integerValue);
            integerCounter++;
        }
    }
}
