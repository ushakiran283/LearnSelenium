package examples;

public class Demo {

	public static void main(String[] args) throws InterruptedException {

		Browser browse = new Browser();
		browse.browser("firefox");
		// browse.testCheckbox();
		// browse.testDropdownUsingSelectClass();
		// browse.testDropdownLoopingUI();
		// browse.testDynamicDropdownUsingIndex();
		// browse.testDynamicDropdownUsingParent_Child();
		// browse.testAutoSuggestions();
		// browse.testCurrentCalender();
		browse.testRadiobutton();

	}

}
