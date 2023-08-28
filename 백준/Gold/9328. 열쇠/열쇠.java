import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final char DOCS = '$';
    static final char WALL = '*';
    static final char SPACE = '.';
    static final int Y = 0;
    static final int X = 1;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static int ySize;
    static int xSize;
    static char[][] board;
    static Set<Character> keys;
    static List<int[]> starts;
    static boolean[][] visit;
    static int documents;
    static int repetitionCount;
    static boolean flag;

    public static void main(String[] args) {
        int t = sc.nextInt();
        
        for (int testIdx = 0; testIdx < t; testIdx++) {
            input();
            stealDocs();
            System.out.println(documents);
        }
    }

    static void input() {
        ySize = sc.nextInt();
        xSize = sc.nextInt();
        board = new char[ySize][xSize];
        visit = new boolean[ySize][xSize];
        starts = new ArrayList<>();
        documents = 0;
        
        for (int y = 0; y < ySize; y++) {
            String inputStr = sc.next();
            board[y] = inputStr.toCharArray();

            for (int x = 0; x < xSize; x++) {
                if (isCorner(y, x) && board[y][x] != WALL) {
                    starts.add(new int[]{y, x});
                }
            }
        }

        keys = new HashSet<>();
        String inputKey = sc.next();

        for (int keyIdx = 0; keyIdx < inputKey.length(); keyIdx++) {
            char key = inputKey.charAt(keyIdx);
            if (isKey(key)) keys.add((char) (key - 'a' + 'A'));
        }

    }

    static boolean isCorner(int y, int x) {
       return y == 0 || y == ySize - 1 || x == 0 || x == xSize - 1;
    }

    static boolean isKey(char key) {
        return key >= 'a' && key <= 'z';
    }

    static void stealDocs() {
        repetitionCount = 1;

        List<int[]> exceptions = new ArrayList<>();

        for (int i = 0; i < repetitionCount; i++) {
            exceptions.clear();

            for (int startIdx = 0; startIdx < starts.size(); startIdx++) {
                flag = false;
                int[] nowStart = starts.get(startIdx);
                clearVisit();
                checkStart(nowStart[Y], nowStart[X]);
                
                if (!isDoor(nowStart[Y], nowStart[X])) moveInBoard(nowStart[Y], nowStart[X]);
                else flag = true;
                
                if (!flag) exceptions.add(new int[]{nowStart[Y], nowStart[X]});
            }
            
            excludeStart(exceptions);

        }
        
//        for(int y = 0; y < ySize; y++) {
//        	for(int x = 0; x < xSize; x++) {
//        		System.out.print(board[y][x]);
//        	}
//        	System.out.println();
//        }

    }

    static void excludeStart(List<int[]> exceptions) {
        for (int idx = 0; idx < exceptions.size(); idx++) {
            for (int startIdx = 0; startIdx < starts.size(); startIdx++) {
                int[] now = starts.get(startIdx);
                if (now[0] == exceptions.get(idx)[0] && now[1] == exceptions.get(idx)[1]) {
                    starts.remove(startIdx);
                    break;
                }
            }
        }
    }

    static void checkStart(int y, int x) {
        if (isKey(board[y][x])) {
        	keys.add((char)(board[y][x] - 'a' + 'A'));
            repetitionCount++;
            board[y][x] = SPACE;
        } else if (isDocs(y, x)) {
            board[y][x] = SPACE;
            documents++;
        } else if (isDoor(y, x) && hasKey(y, x)) {
            board[y][x] = SPACE;
        }
        visit[y][x] = true;
    }

    static void moveInBoard(int y, int x) {
        Queue<int[]> posQueue = new LinkedList<>();
        posQueue.add(new int[]{y, x});

        while (!posQueue.isEmpty()) {
            int[] now = posQueue.remove();

            for (int drct = 0; drct < 4; drct++) {
                int ny = now[Y] + dy[drct];
                int nx = now[X] + dx[drct];

                if (!canMove(ny, nx)) continue;

                if (isKey(board[ny][nx])) {
                    keys.add((char) (board[ny][nx] - 'a' + 'A'));
                    board[ny][nx] = SPACE;
                    repetitionCount++;
                }

                if (isDoor(ny, nx)) {
                    if (hasKey(ny, nx)) board[ny][nx] = SPACE;
                    else {
                        flag = true;
                        continue;
                    }
                }

                if (isDocs(ny, nx)) {
                    documents++;
                    board[ny][nx] = SPACE;
                }

                visit[ny][nx] = true;

                posQueue.add(new int[]{ny, nx});
            }
        }
    }

    static void clearVisit() {
        for (int y = 0; y < ySize; y++) {
            Arrays.fill(visit[y], false);
        }
    }

    static boolean canMove(int y, int x) {
        if (y < 0 || x < 0 || y >= ySize || x >= xSize) return false;
        else if (board[y][x] == WALL) return false;
        else if (visit[y][x]) return false;
        return true;
    }

    static boolean isDocs(int y, int x) {
        return board[y][x] == DOCS;
    }

    static boolean isDoor(int y, int x) {
        return board[y][x] >= 'A' && board[y][x] <= 'Z';
    }

    static boolean hasKey(int y, int x) {
        return keys.contains(board[y][x]);
    }

}