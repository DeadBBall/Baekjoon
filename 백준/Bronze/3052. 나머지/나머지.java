import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int[] rest = new int[42];
	    int ans = 0;
	    for(int i = 0; i < 10; i++)
	    {
	        int tmp = Integer.parseInt(br.readLine());
            rest[tmp % 42]++;
	    }
	    for(int i = 0; i < 42; i++)
	        if(rest[i] > 0)
	            ans++;
	    bw.write("" + ans);
	    bw.flush();
	    bw.close();
	}
}