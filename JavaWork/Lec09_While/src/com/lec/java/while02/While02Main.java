package com.lec.java.while02;

public class While02Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// 구구단 2단
		// while문 사용
		
		int n = 1;	// 초기식
		while(n <= 9) {	// 조건식
			System.out.println("2 x " + n + " = " + (2 * n));
			n++;	// 증감식
		} // end while

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class While02Main