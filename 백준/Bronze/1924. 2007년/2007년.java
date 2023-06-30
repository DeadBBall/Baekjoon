import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int year = 2007;
	static int month;
	static int day;
	
	static void input() {
		month = sc.nextInt();
		day = sc.nextInt();
	}

	static void checkDay() {
		LocalDate date = LocalDate.of(year, month, day);
		int num = date.getDayOfWeek().getValue();
		String dayOfTheWeek = "";
		switch (num) {
		case 1:
			dayOfTheWeek = "MON";
			break;
		case 2:
			dayOfTheWeek = "TUE";
			break;
		case 3:
			dayOfTheWeek = "WED";
			break;
		case 4:
			dayOfTheWeek = "THU";
			break;
		case 5:
			dayOfTheWeek = "FRI";
			break;
		case 6:
			dayOfTheWeek = "SAT";
			break;
		default:
			dayOfTheWeek = "SUN";
			break;
		}
		System.out.println(dayOfTheWeek);
	}
	
	public static void main(String[] args) {
		input();
		checkDay();
	}
	
}