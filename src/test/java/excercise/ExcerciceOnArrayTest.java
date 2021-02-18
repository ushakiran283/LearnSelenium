package excercise;

import java.util.ArrayList;
import java.util.Arrays;

public class ExcerciceOnArrayTest {

	public static void main(String[] args) {

		int[] a = { 10, 2, 34, 45 };
		System.out.println(a[2]);// based on index
		System.out.println(".............");
		System.out.println(Arrays.toString(a));
		System.out.println(".............");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		ArrayList<String> items = new ArrayList<String>();
		items.add("apple");
		items.add("mango");
		items.add("orange");
		System.out.println(items);
		System.out.println(items.size());
		items.remove(0);
		System.out.println(items);

	}

}
