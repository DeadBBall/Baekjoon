import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int ans = 0;
        int m = n;
        int tmp;
        do
        {
            if (m < 10)
                m *= 11;
            else
            {
                tmp = m % 10 + m / 10;
                m = m % 10 * 10 + tmp % 10;
            }   
            ans++;
        }
        while (n != m);
        System.out.print(ans);
    }
}