import java.util.Scanner;

public class Main
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);

		int[][] arr = new int[100][100];
		int[][] arr2 = new int[100][100];
		int a = in.nextInt();
		int b = in.nextInt();
		for(int i = 0; i < a; i++)
			for(int j = 0; j < b; j++)
				arr[i][j] = in.nextInt();
		for(int i = 0; i < a; i++)
			for(int j = 0; j < b; j++)
				arr2[i][j] = in.nextInt();
		in.close();
		for(int i = 0; i < a; i++)
		{
			for(int j = 0; j < b; j++)
				System.out.print(arr[i][j] + arr2[i][j] +" ");
			System.out.println();
		}
	}
}