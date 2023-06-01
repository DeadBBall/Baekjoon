import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int userCnt, fileCnt;
	static Map<String, List<String>> groups;
	static Map<String, Map<String, String>> files;
	static StringBuilder ansMaker = new StringBuilder();
	
	static void input() {
		userCnt = sc.nextInt();
		fileCnt = sc.nextInt();
		sc.nextLine();
		String[] inputStrs;
		groups = new HashMap<>();
		files = new HashMap<>();
		for(int i = 0; i < userCnt; i++) {
			inputStrs = sc.nextLine().split(" ");
			groups.put(inputStrs[0], new ArrayList<>());
			groups.get(inputStrs[0]).add(inputStrs[0]);
			if(inputStrs.length < 2) {
				continue;
			}
			String[] tmps = inputStrs[1].split(",");
			for(int j = 0; j < tmps.length; j++) {
				groups.get(inputStrs[0]).add(tmps[j]);
			}
		}
		for(int i = 0; i < fileCnt; i++) {
			inputStrs = sc.nextLine().split(" ");
			String fileName = inputStrs[0];
			files.put(fileName, new HashMap<>());
			Map<String, String> tmpMap = files.get(fileName);
			String auth = changeNum(inputStrs[1]);
			tmpMap.put("auth", auth);
			tmpMap.put("owner", inputStrs[2]);
			tmpMap.put("owner_group", inputStrs[3]);
		}
	}
	
	static String changeNum(String num) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num.length(); i++) {
			switch (num.charAt(i) - '0') {
			case 0:
				sb.append("0");
				break;
			case 1:
				sb.append("X");
				break;
			case 2:
				sb.append("W");
				break;
			case 3:
				sb.append("WX");
				break;
			case 4:
				sb.append("R");
				break;
			case 5:
				sb.append("RX");
				break;
			case 6:
				sb.append("RW");
				break;
			default:
				sb.append("RWX");
				break;
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
	static void checkFile() {
		int t = sc.nextInt();
		sc.nextLine();
		for(int tc = 0; tc < t; tc++) {
			String[] inputStrs = sc.nextLine().split(" ");
			Map<String, String> fileInfo = files.get(inputStrs[1]);
			String owner = fileInfo.get("owner");
			String ownerGroup = fileInfo.get("owner_group");
			if(owner.equals(inputStrs[0])) {
				String tmp = fileInfo.get("auth").split(" ")[0];
				if(tmp.contains(inputStrs[2])) {
					ansMaker.append(1).append("\n");
				}
				else {
					ansMaker.append(0).append("\n");
				}
			}
			else {
				List<String> tmpGroup = groups.get(inputStrs[0]);
				boolean flag = false;
				for(int i = 0; i < tmpGroup.size(); i++) {
					if(tmpGroup.get(i).equals(ownerGroup)) {
						flag = true;
						String tmp = fileInfo.get("auth").split(" ")[1];
						if(tmp.contains(inputStrs[2])) {
							ansMaker.append(1).append("\n");
						}
						else {
							ansMaker.append(0).append("\n");
						}
						break;
					}
				}
				if(!flag) {
					String tmp = fileInfo.get("auth").split(" ")[2];
					if(tmp.contains(inputStrs[2])) {
						ansMaker.append(1).append("\n");
					}
					else {
						ansMaker.append(0).append("\n");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		checkFile();
		System.out.println(ansMaker);
	}
}