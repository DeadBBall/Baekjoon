import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Map<String, Directory> directories;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        diskTree();
        System.out.print(ansMaker);
    }


    static void input() {
        directories = new HashMap<>();
        n = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void diskTree() {
        while(n-- > 0) {
            String[] path = sc.next().split("\\\\");

            if(!directories.containsKey(path[0])) {
                directories.put(path[0], new Directory(path[0], new HashMap<>()));
            }

            Directory nowDirectory = directories.get(path[0]);

            for(int idx = 1; idx < path.length; idx++) {
                if(!nowDirectory.subDirectories.containsKey(path[idx])) {
                    nowDirectory.subDirectories.put(path[idx], new Directory(path[idx], new HashMap<>()));
                }

                nowDirectory = nowDirectory.subDirectories.get(path[idx]);
            }
        }

        directories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> printDirectories(entry.getValue(), 0));
    }

    static void printDirectories(Directory nowDirectory, int depth) {
        for(int idx = 0; idx < depth; idx++) {
            ansMaker.append(" ");
        }

        ansMaker.append(nowDirectory.name);

        ansMaker.append("\n");

        nowDirectory.subDirectories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> printDirectories(entry.getValue(), depth + 1));
    }
}

class Directory {
    String name;
    Map<String, Directory> subDirectories;

    public Directory(String name, Map<String, Directory> subDirectories) {
        this.name = name;
        this.subDirectories = subDirectories;
    }
}