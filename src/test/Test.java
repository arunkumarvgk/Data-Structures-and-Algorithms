package test;

public class Test {

	public static void main(String[] args) {
		int index = 5;
		int arr[] = {1,2,3,4,5,6,7,8,9,0};
		int i = index;
		
		do {
			//System.out.println(i);
			i = (i+1)%arr.length;
		} while (index != i);
		
		i =index-1;
		while (i != index) {
			System.out.println(i);
			i = (i-1 + arr.length)%arr.length;
		}
	}

}
