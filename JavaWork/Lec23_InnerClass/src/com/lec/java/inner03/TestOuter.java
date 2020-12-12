package com.lec.java.inner03;

public class TestOuter {
	private int value;
	
	public TestOuter(int value) {
		this.value = value;	// 1. Outer value
	}
	
	public int getValue() {
		return value;
	}
	
	// 멤버 내부 클래스
	public class TestInner{
		private int value;	// 2. Inner value
		
		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue() {
			int value = 10;	// 3. 지역변수 value
			System.out.println("value = " + value);	// 3번
			System.out.println("this.value = " + this.value);	// 2번
			System.out.println("TestOuter.this.value = " + TestOuter.this.value);	// 1번
		}
	}
	

} // end class TestOuter













