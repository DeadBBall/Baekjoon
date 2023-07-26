import java.math.BigInteger;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static void inputAndPrint() {
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        System.out.println(a.add(b));
    }

    public static void main(String[] args) {
        inputAndPrint();
    }
}