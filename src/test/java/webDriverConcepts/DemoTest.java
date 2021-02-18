package webDriverConcepts;

public class DemoTest {

	public static void main(String[] args) throws InterruptedException {

		BrowserTest browse = new BrowserTest();
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
