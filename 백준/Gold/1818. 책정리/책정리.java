import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Integer> books;

    public static void main(String[] args) {
        input();
        arrangeBooks();
        System.out.println(n - books.size());
    }

    static void input() {
        n = sc.nextInt();
        books = new ArrayList<>();

        books.add(n + 1);
    }

    static void arrangeBooks() {
        for(int idx = 0; idx < n; idx++) {
            int book = sc.nextInt();

            if(books.get(books.size() - 1) < book) {
                books.add(book);
            }else {
                int left = 0;
                int right = books.size();

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if(books.get(mid) < book) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                books.set(right, book);
            }
        }
    }

}