package step.one.reader;

import java.util.Scanner;
import java.util.logging.Logger;

public class ReaderProcessor {

    private static final Logger LOG = Logger.getLogger(ReaderProcessor.class.getName());
    private static int minimumRange;
    private static int maximumRange;
    private static Scanner scanner = new Scanner(System.in);;

    public ReaderProcessor processReading() {
        setMinimumRange();
        setMaximumRange();
        return this;
    }

    private static void setMinimumRange() {
        System.out.println("Please enter the minimum range: ");
        minimumRange = scanner.nextInt();
        checkValidityOnRange(minimumRange, false);
        LOG.info("Minimum number has been set");
    }

    private static void setMaximumRange() {
        System.out.println("Please enter the maximum range: ");
        maximumRange = scanner.nextInt();
        checkValidityOnRange(maximumRange, true);
        LOG.info("Maximum number has been set");
    }

    private static void checkValidityOnRange(int number, boolean isSecondEntry) {
        if (number == 0 || number < 0) {
            throw new IllegalStateException("Please enter a number which is greater than 0");
        }
        if (isSecondEntry) {
            if (minimumRange >= number) { // number being the second range which should be greater
                throw new IllegalStateException("The 2nd range number should be greater than the first range");
            }
        }
    }

    public int getMinimumRange() {
        return minimumRange;
    }

    public int getMaximumRange() {
        return maximumRange;
    }
}
