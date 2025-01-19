import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneId.of("UTC"));

        System.out.println(utcNow.getYear());
        System.out.println(utcNow.getMonthValue());
        System.out.println(utcNow.getDayOfMonth());
    }
}