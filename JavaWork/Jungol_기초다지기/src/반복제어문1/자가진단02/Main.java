package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
	
		int i = 1;
		int sum = 0;
		
		while(i <= input) {
			sum += i;
			
			i++;
		}
		
		System.out.print(sum);
		
	}
}