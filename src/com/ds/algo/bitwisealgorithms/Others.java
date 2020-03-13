package com.ds.algo.bitwisealgorithms;

public class Others {

	private static void oppositeSigns() {
		System.out.println((100 ^ -100) < 0);
		System.out.println((100 ^ -200) < 0);
		System.out.println((100 ^ 100) < 0);
		System.out.println((100 ^ 200) < 0);
		System.out.println((0 ^ -100) < 0);
	}

	private static void addOne() {
		System.out.println("Add One ================================");
		System.out.println(-(~13));
		System.out.println(-(~-1));
		System.out.println(-(~-3));
		System.out.println(-(~100));

		System.out.println((~13));
		System.out.println((~-1));
		System.out.println((~-3));
		System.out.println((~2147483647));
	}

	private static void positionOfRightMostSetBit() {
		System.out.println("Position Of right most set bit");
		int x = 96;
		int pos = 0;
		while ((x & 1) != 1) {
			x = x >> 1;
			pos++;
		}
		System.out.println(pos + 1);
	}

	private static void printBinNumber(int n) {
		if (n > 0) {
			printBinNumber(n / 2);
		}
		System.out.print(n % 2);
	}

	private static void reverseBits() {
		int x = 1;
		int b = 0;
		while (x != 0) {
			b <<= 1;
			b |= (x & 1);
			x >>= 1;
		}
		System.out.println(" Reverse is " + b);
	}

	private static void reverseBits2() {
		byte num = 2;
		byte rev = num;
		byte count = 7;
		num >>= 1;
		while (num != 0) {
			rev <<= 1;
			rev |= num & 1;
			num >>= 1;
			count--;
		}
		rev <<= count;
		System.out.println(" Reverse is " + rev);
	}

	private static void reverseBits3() {
		
		byte num;
		byte rev;
		byte count = 7;
		
		for (byte i = 0; i < 20; i++) {
			num= i;
			rev = 0;
			count = 7;
			while (num != 0) {
				rev |= num & 1;
				rev <<= 1;
				num >>= 1;
				count--;
			}
			rev <<= count;
			System.out.println(" Reverse is " + rev);
		}
	}
	
	private static void swapOddEvenBits() {
		int a = 23;
		
		int evenBits = a & 0xAAAAAAAA;
		int oddBits = a & 0x55555555;
		evenBits>>=1;
		oddBits<<=1;
		System.out.println(evenBits|oddBits);
	}
	
	private static void isSparse() {
		/*int a = 384;
		int log = (int) (Math.log(a)/Math.log(2));
		int val = (int) Math.pow(2, log);
		val = (val + val/2);*/
		int a = 3;
		if ((a & a >> 1) >0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	public static void main(String[] args) {
		/*oppositeSigns();
		addOne();
		positionOfRightMostSetBit();
		printBinNumber(100);
		System.out.println();
		reverseBits3();
		swapOddEvenBits();*/
		isSparse();
	}

}
