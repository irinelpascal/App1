package step.one.report;

public class Report {

    public static int fizzCounter;
    public static int buzzCounter;
    public static int fizzBuzzCounter;
    public static int alfrescoCounter;
    public static int integerCounter;

    public static void displayReport() {
        System.out.println();
        System.out.println("FIZZ counter has been displayed " + fizzCounter + (fizzCounter > 1 ? " times" : " time"));
        System.out.println("BUZZ counter has been displayed " + buzzCounter + (buzzCounter > 1 ? " times" : " time"));
        System.out.println("FIZZBUZZ counter has been displayed " + fizzBuzzCounter + (fizzBuzzCounter > 1 ? " times" : " time"));
        System.out.println("ALFRESCO counter has been displayed " + alfrescoCounter + (alfrescoCounter > 1 ? " times" : " time"));
        System.out.println("Integer counter has been displayed " + integerCounter + (integerCounter > 1 ? " times" : " time"));
    }
}
