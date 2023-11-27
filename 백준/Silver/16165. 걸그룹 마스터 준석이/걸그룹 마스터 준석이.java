import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static Map<String, String> memberMap;
    static Map<String, Set<String>> teamMap;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        input();
        playQuiz();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        memberMap = new HashMap<>();
        teamMap = new HashMap<>();

        for(int idx = 0; idx < n; idx++) {
            String team = sc.next();
            int memberCount = sc.nextInt();
            teamMap.put(team, new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            }));
            Set<String> memberSet = teamMap.get(team);

            for(int memberIdx = 0; memberIdx < memberCount; memberIdx++) {
                String member = sc.next();
                memberMap.put(member, team);
                memberSet.add(member);
            }

        }
    }

    static void playQuiz() {
        for(int quizIdx = 0; quizIdx < m; quizIdx++) {
            String memberOrTeam = sc.next();
            int type = sc.nextInt();
            String team = memberMap.get(memberOrTeam);

            if(team == null) {
                if(type == 0) {
                    Set<String> memberSet = teamMap.get(memberOrTeam);
                    Iterator<String> memberIt = memberSet.iterator();

                    while(memberIt.hasNext()) {
                        ansMaker.append(memberIt.next()).append("\n");
                    }
                }
                else
                    ansMaker.append(memberOrTeam).append("\n");
            }
            else {
                if (type == 0) {
                    Set<String> memberSet = teamMap.get(team);
                    Iterator<String> memberIt = memberSet.iterator();

                    while (memberIt.hasNext()) {
                        ansMaker.append(memberIt.next()).append("\n");
                    }
                } else
                    ansMaker.append(team).append("\n");
            }
        }
    }

}