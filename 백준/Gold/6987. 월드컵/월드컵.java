import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static Country[] countries;
    static boolean isPossible;

    public static void main(String[] args) {
        for(int tc = 0; tc < 4; tc++) {
            input();

            if(isPossible) {
                isPossible = false;
                playWorldCup(0, 1);
            }

            ansMaker.append(isPossible ? 1 : 0).append("\n");
        }
        System.out.print(ansMaker);
    }

    static void input() {
        countries = new Country[6];
        isPossible = true;

        for(int countryIdx = 0; countryIdx < 6; countryIdx++) {
            int win = sc.nextInt();
            int draw = sc.nextInt();
            int lose = sc.nextInt();

            countries[countryIdx] = new Country(win, draw, lose);

            if(win + draw + lose != 5) {
                isPossible = false;
            }
        }
    }

    static void playWorldCup(int countryIdx, int opponentIdx) {
        if(countryIdx == 5) {
            isPossible = true;
            return;
        }

        Country country = countries[countryIdx];
        Country opponent = countries[opponentIdx];

//        System.out.println(country + " " + opponent);

        int nextCountryIdx = opponentIdx + 1 == 6 ? countryIdx + 1 : countryIdx;
        int nextOpponentIdx = opponentIdx + 1 == 6 ? countryIdx + 2 : (opponentIdx + 1) % 6;

        if(country.win >= 1 && opponent.lose >= 1) {
            country.win--;
            opponent.lose--;

            playWorldCup(nextCountryIdx, nextOpponentIdx);

            country.win++;
            opponent.lose++;
        }

        if(country.draw >= 1 && opponent.draw >= 1) {
            country.draw--;
            opponent.draw--;

            playWorldCup(nextCountryIdx, nextOpponentIdx);

            country.draw++;
            opponent.draw++;
        }

        if(country.lose >= 1 && opponent.win >= 1) {
            country.lose--;
            opponent.win--;

            playWorldCup(nextCountryIdx, nextOpponentIdx);

            country.lose++;
            opponent.win++;
        }

    }

}

class Country {
    int win;
    int draw;
    int lose;

    public Country(int win, int draw, int lose) {
        this.win = win;
        this.draw = draw;
        this.lose = lose;
    }

    @Override
    public String toString() {
        return "Country{" +
                "win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                '}';
    }
}