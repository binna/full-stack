package 연잔자.자가진단03;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();

		System.out.println(input++);
		System.out.println(++input);
	}

}