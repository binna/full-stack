package com.lec.java.wrapper01;
/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * 
 *  Wrapper 클래스는 immutable 하다!
 *  
 */
// 자바 세상에서는...!! final 대문자, static 기울림, 파란색은 멤버 변수
public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();
		
		Integer i1 = 100;	// reference <= primitive ?!?!?  
							// 호에에에!??!? 둘이 타입이 다른데 어캐 대입된거지??
		
		i1 = i1 + 200;		// 호에에에..!!! reference 가 산술연산을!?!?!?!?
		System.out.println("i1 = " + i1);	// 300
		// Wrapper 클래스는 마치 primitive 타입처럼 동작한다!
		

		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("num1 = " + num1);
		
		
		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);
		
		// == 로 비교해보면 다르다고 나옴
		if(num1 == num2) {
			System.out.println("== 같다");
		} else {
			System.out.println("== 다르다!");
		}
		
		// equals()로 비교해보면 같다고 나옴
		if(num1.equals(num2)) {
			System.out.println("== 같다");
		} else {
			System.out.println("== 다르다");
		}
		
		
		// 3. new Integer() VS Integer.valueOf()
		Integer num3 = new Integer(123);	// new 는 새로운 instance 생성
		Integer num4 = Integer.valueOf(123);
		
		// valueOf()는 생성한 Object 를 cache(캐시) 해둔다.
		// 동일 literal 로 valueOf() 생성하면, 기존의 생성된 Object 리턴
		// 왜..?? 메모리 절약을 위해...!!!
		
		// new 로 생성한 것들끼리 비교
		if(num1 == num3) {
			System.out.println("생성자: 같은 참조");
		} else {
			System.out.println("생성자: 다른 참조");
		}
		
		// valueOf() 로 생성한 것들끼리 비교
		if(num2 == num4) {
			System.out.println("valueOf(): 같은 참조");
		} else {
			System.out.println("valueof(): 다른 참조");
		}
		
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;
		// Integer.valueOf(123) 과 동일한 코드가 동작됨! (Auto-Boxing)
		if(num4 == num5) {
			System.out.println("literal 같은 참조");
		} else {
			System.out.println("literal 다른 참조");
		}
		
		
		// 5. valueOf(문자열) 가능!
		Integer num6 = Integer.valueOf("123");
		System.out.println(num6);
		
		if(num6 == num5) {
			System.out.println("같은 참조");
		} else {
			System.out.println("다른 참조");
		}
		
		
		// 6. 산술 연산 가능
		num6 *= 2;	// Wrapper 의 연산 결과는 새로운 Wrapper 생성(immutable!)
		System.out.println(num6);
		
		if(num6 == num5) {
			System.out.println("같은 참조");
		} else {
			System.out.println("다른 참조");	// 다르다! Wrapper 는 immutable 하다!
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class