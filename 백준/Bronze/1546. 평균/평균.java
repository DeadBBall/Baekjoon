import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int max = 0;
        double ans = 0;
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
        {
            score[i] = Integer.parseInt(tmp[i]);
            if (max < score[i])
                max = score[i];
        }
        for(int i = 0; i < n; i++)
            ans = ans + (double)score[i] * 100 / max;
        System.out.printf("%f", ans / n);
	}
}