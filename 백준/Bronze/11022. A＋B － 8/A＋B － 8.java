import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++)
        {
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.printf("Case #%d: %d + %d = %d\n", i + 1, a, b, a + b);
        }
    }
}