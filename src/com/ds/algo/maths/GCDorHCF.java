package com.ds.algo.maths;

public class GCDorHCF {

	/*private static int gcd(int num1, int num2) {
		int remainder = -1;
		int a;
		int b;
		if (num1 > num2) {
			a = num1;
			b = num2;
		} else {
			a = num2;
			b = num1;
		}

		while (remainder != 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}*/
	
	static int gcd(int a, int b) { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 

	public static void main(String[] args) {
		System.out.println(gcd(24, 60));
		System.out.println(gcd(64, 40));
		System.out.println(gcd(98, 56));
		System.out.println(gcd(56, 98));
	}
}
