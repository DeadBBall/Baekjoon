import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String num, num2;

    public static void main(String[] args) {
        input();
        calculate();
    }

    static void input() {
        num = sc.next();
        num2 = sc.next();
    }

    static void calculate() {
        int number = convertToNumber(num);
        int number2 = convertToNumber(num2);

        int sum = number + number2;

        System.out.println(sum);
        System.out.println(convertToSign(sum));
    }

    static int convertToNumber(String num) {
        int result = 0;

        for(int idx = 0; idx < num.length(); idx++) {
            char now = num.charAt(idx);

            switch (now) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    result += 100;

                    if(idx + 1 < num.length()) {
                        char next = num.charAt(idx + 1);

                        idx++;

                        if(next == 'D') result += 300;
                        else if(next == 'M')result += 800;
                        else idx--;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    result += 10;

                    if(idx + 1 < num.length()) {
                        char next = num.charAt(idx + 1);

                        idx++;

                        if(next == 'L') result += 30;
                        else if(next == 'C') result += 80;
                        else idx--;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                default:
                    result += 1;

                    if(idx + 1 < num.length()) {
                        char next = num.charAt(idx + 1);

                        idx++;

                        if(next == 'V') result += 3;
                        else if(next == 'X')result += 8;
                        else idx--;
                    }
            }
        }

        return result;
    }

    static String convertToSign(int num) {
        StringBuilder result = new StringBuilder();

        while(num > 0) {
            if(num >= 1000) {
                num -= 1000;
                result.append('M');
            } else if(num >= 900) {
                num -= 900;
                result.append("CM");
            } else if(num >= 500) {
                num -= 500;
                result.append("D");
            } else if(num >= 400) {
                num -= 400;
                result.append("CD");
            } else if(num >= 100) {
                num -= 100;
                result.append('C');
            } else if(num >= 90) {
                num -= 90;
                result.append("XC");
            } else if(num >= 50) {
                num -= 50;
                result.append("L");
            } else if(num >= 40) {
                num -= 40;
                result.append("XL");
            } else if(num >= 10) {
                num -= 10;
                result.append("X");
            } else if(num >= 9) {
                num -= 9;
                result.append("IX");
            } else if(num >= 5) {
                num -= 5;
                result.append('V');
            } else if(num >= 4) {
                num -= 4;
                result.append("IV");
            } else {
                num -= 1;
                result.append('I');
            }
        }
        return result.toString();
    }
}