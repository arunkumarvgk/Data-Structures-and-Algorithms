package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(1);
		l.add(1);
		int a[] = {1,2,3,1,1};
		System.out.println(Collections.frequency(Arrays.asList(a), 1));
	}

}
