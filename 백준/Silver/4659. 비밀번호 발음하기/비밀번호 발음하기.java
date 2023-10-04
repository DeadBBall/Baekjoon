import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        while(true) {
            String password = sc.nextLine();
            if(password.equals("end")) break;
            ansMaker.append("<").append(password).append("> is ");
            if(!checkPassword(password)) {
                ansMaker.append("not ");
            }
            ansMaker.append("acceptable.\n");
        }
        System.out.print(ansMaker);
    }

    static boolean checkPassword(String password) {
            boolean hasVowel = false;
            int continuousConsonant = 0;
            int coninuousVowel = 0;
            for(int idx = 0; idx < password.length(); idx++) {
                char now = password.charAt(idx);
                if(idx >= 1 && now != 'o' && now != 'e' && now == password.charAt(idx - 1)) {
                    return false;
                }
                if(now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                    hasVowel = true;
                    coninuousVowel++;
                    continuousConsonant = 0;
                }
                else {
                    coninuousVowel = 0;
                    continuousConsonant++;
                }

                if(coninuousVowel == 3 || continuousConsonant == 3) return false;
            }
        return hasVowel;
    }
}