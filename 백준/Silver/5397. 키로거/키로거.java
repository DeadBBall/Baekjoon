import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static String inputStr;

	static void input() {
		inputStr = sc.next();
	}
	
	static void hack() {
		LinkedList list = new LinkedList();
		for(int i = 0; i < inputStr.length(); i++) {
			char now = inputStr.charAt(i);
			if(now == '<' || now == '>') {
				list.move(now);
			}
			else if(now == '-') {
				list.remove();
			}
			else {
				list.add(now);
			}
//			System.out.println(list.now.data);
		}
		list.print();
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			input();
			hack();
			ansMaker.append("\n");
		}
		System.out.println(ansMaker);
	}

	static class LinkedList {
		Node head;
		Node now;
		Node tail;

		public LinkedList() {
			this.head = new Node(null);
			this.tail = new Node(null);
			now = tail;
			head.next = tail;
			tail.prev = head;
		}

		void add(char c) {
			Node node = new Node(c);
			Node prev = now.prev;
			node.prev = prev;
			node.next = now;
			now.prev = node;
			prev.next = node;
		}

		void move(char dir) {
			if (dir == '<' && now.prev.data != null) {
				now = now.prev;
			} else if (dir == '>' && now.data != null) {
				now = now.next;
			}
		}

		void remove() {
			if (now.prev.data != null) {
				Node prev = now.prev;
				Node prev2 = prev.prev;
				prev2.next = now;
				now.prev = prev2;
			}
		}
		
		void print() {
			Node cur = head.next;
			while(cur.data != null) {
				ansMaker.append(cur.data);
				cur = cur.next;
			}
		}
	}

	static class Node {
		Node next;
		Node prev;
		Character data;

		public Node(Character data) {
			this.data = data;
			next = null;
			prev = null;
		}

	}
}