package excercise;

public class ExcerciceOnStringTest {
	static StringBuffer sb;

	public static void main(String[] args) {

		// Append
		sb = new StringBuffer("ushakiran");
		System.out.println(sb.append(" battini"));

		// Reverse
		sb = new StringBuffer("durga");
		System.out.println(sb.reverse());

		// Related to String
		String s = "durgaprasad";
		sb = new StringBuffer(s);
		String str = sb.toString();
		System.out.println(str);

	}

}
