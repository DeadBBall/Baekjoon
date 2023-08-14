import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
	    String ans = "";
		int month = sc.nextInt();
		int day = sc.nextInt();
		if(month >= 3) ans = "After";
		else if(month == 1) ans = "Before";
		else {
		    if(day <= 17) ans = "Before";
		    else if(day >= 19) ans = "After";
		    else ans ="Special";
		}
		System.out.print(ans);
	}
}