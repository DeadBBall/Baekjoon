import java.util.Scanner;

public class Main
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        System.out.printf("%.10f", a/b);
        scan.close();
    }
}