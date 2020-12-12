package com.lec.java.class01;
/*
 	클래스 정의 및 사용
 	
 	우리가 만든 클래스를 사용하려면,
	그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
	
	구문
		클래스이름 변수이름 = new 생성자();
		생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
		
 	new 로 생성하는 instance 들은
 	지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
 	특별히 초기화를 할 값들이 지정되어 있지 않을 때는
 	각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
 		boolean -> false, 숫자타입(int, double, ...) -> 0
 		String, 참조 타입(클래스) -> null
 	
 	지역변수: 메소드 안에서 선언된 변수
 	지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
 */
public class Class01Main {

	public static void main(String[] args) {
		System.out.println("클래스 생성 & 사용");
		
		MyTV tv1;
		tv1 = new MyTV();	// MyTV 인스턴스 생성!
		tv1.displayStatus();
		
		// TV 켜기
		tv1.powerOnOff();
		
		// 볼륨 조정
		tv1.volumeUp();
		tv1.volumeUp();

		// 채널 조정
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		
		// 일반적으로 
		// 멤버변수는 private 으로 설정하여
		// 외부클래스에서 아래와 같이
		// 직접 사용하는 것을 금지하게 설계함.
		// 현재 isPowerOn, volume, channel 멤버 변수는
		// private로 설정되어 있어서 외부클래스에서 값을 변경하지 못함.
//		tv1.isPowerOn = false;
//		tv1.volume = 32;
//		tv1.channel = 100;
		
		tv1.displayStatus();
		
		System.out.println();
		MyTV tv2 = new MyTV();	// 다른 MyTV 인스턴스
		tv2.powerOnOff();
		tv2.channelUp();
		tv2.volumeUp();
		tv2.displayStatus();
		
		System.out.println();
		System.out.println(tv1);	// 출력값: com.lec.java.class01.MyTV@15db9742
		System.out.println(tv2);	// 출력값: com.lec.java.class01.MyTV@6d06d69c
		
		System.out.println();
		tv1 = tv2;	// 어떻게 될까? 
					// 결과! tv2의 주소값이 tv1으로 복사됨(tv1과 tv2에 저장된 주소값은 동일해짐)
					// 원래 tv1 이 레퍼런싱 하던 인스턴스는 Garbage Collector 에 의해 소멸된다. (GC된다)
					// 왜? 레퍼런싱이 끝기면 Garbage Collector가 자동으로  지우기 때문에
		tv1.displayStatus();
		tv1.powerOnOff();
		tv2.displayStatus();	// tv1과 tv2는 같은 인스턴스를 레퍼런싱 하고 있다!
		
		System.out.println(tv1); // 출력값: com.lec.java.class01.MyTV@6d06d69c
		System.out.println(tv2); // 출력값: com.lec.java.class01.MyTV@6d06d69c

		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class