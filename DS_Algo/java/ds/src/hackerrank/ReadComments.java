package hackerrank;

import java.util.Scanner;

public class ReadComments {
	
	public static void main(String[] args) {
		boolean continuePrint = false;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			if(line.contains("//")) {
				System.out.println("//"+line.substring(line.indexOf("//")+2));
				continue;
			}
			if(line.contains("/*") && line.contains("*/")) {
				System.out.println(line);
			}
			if(line.contains("/*") && !line.contains("*/")) {
				continuePrint = true;
				System.out.println(line);
				continue;
			}
			if(continuePrint) {
				System.out.println(line);
				
			}
			if(line.contains("*/")) {
				continuePrint = false;
			}
		}
		
		scanner.close();
	}

}
