package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Exercise1 {

	public void Example1() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arjun");
		names.add("Prasad");
		names.add("Usha");
		names.add("Arun");
		names.add("Ajay");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				count++;
			}
		}
		System.out.println("Count is :" + count);
	}

	@Test
	public void StreamExample1() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arjun");
		names.add("prasad");
		names.add("usha");
		names.add("Arun");
		names.add("Ajay");

		// stream(),Intermediate operations(map,filter,sorted), Terminal
		// operations(collect,foreach,reduce)

		// Print names whose names starts with A
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Count is :" + c);

		// Print the names which are greater than 4
		names.stream().filter(s -> s.length() > 4)
				.forEach(s -> System.out.println("Names length greater than 4 are :" + s));
		// Print the 1st name whose name is greater than 4
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

		// Print names in sorted manner
		List<String> name = names.stream().sorted().collect(Collectors.toList());
		System.out.println("Names sorted are :" + name);

		// Print names with have last letter as "n" with uppercase
		names.stream().filter(s -> s.endsWith("n")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println("Names in uppercase are :" + s));

		// print all the names in uppercase
		names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println("Characters in uppecase are :" + s));

		// print names which have first letter as "A" with uppercase and sorted
		// to convert array to arraylist we use Arrays.aslist
		List<String> namesare = Arrays.asList("Arjun", "prasad", "usha", "Arun", "Ajay");
		namesare.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println("s :" + s));

		/*
		 * // merge two arraylist List<String> name1 = Arrays.asList("Arjun", "prasad",
		 * "usha", "Arun", "Ajay"); List<String> name2 = Arrays.asList("sai", "pinki",
		 * "chinnu"); Stream<String> newstream = Stream.concat(name1.stream(),
		 * name2.stream()); newstream.sorted().forEach(s -> System.out.println(s));
		 * boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("usha"));
		 * Assert.assertTrue(flag);
		 */

		List<Integer> numbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		// print the unique number
		numbers.stream().distinct().forEach(s -> System.out.println("Unique numbers are :" + s));
		// sort the array
		List<Integer> num = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(num);

	}

}
