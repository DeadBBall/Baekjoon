import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static Queue<Integer> buffer;
	static int n;
	
	public static void main(String[] args) {
		input();
		useRouter();
	}

	static void input() {
		n = SC.nextInt();
		buffer = new LinkedList<>();
	}
	
	static void useRouter() {		
		while(true) {
			int packet = SC.nextInt();
			
			if(packet == -1) break;
			
			else if(packet == 0)
				buffer.remove();
			
			else {
				if(buffer.size() < n)
					buffer.add(packet);
			}
			
		}
		
		StringBuilder ansMaker = new StringBuilder();
		
		for(Integer reaminingPacket : buffer) {
			ansMaker.append(reaminingPacket + " ");
		}
		
		System.out.print(ansMaker.length() == 0 ? "empty" : ansMaker);
	}

}