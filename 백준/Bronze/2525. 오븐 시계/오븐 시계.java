import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int m = scan.nextInt();
        int q = scan.nextInt();
        m += q;
        while (m >= 60)
        {
            h += 1;
            m -= 60;
            if (h > 23)
                h = 0;
        }
        System.out.printf("%d %d", h, m);
    }
}