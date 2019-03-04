package eu.learn.editor;

import javax.swing.*;
import java.util.Random;

/**
 * @author Alexey Kaloshin
 */
public class Editor {
	private static Store trustedStoreProvidedWithExtraProperties;
	private static Store trustedStore;
	private static boolean enabled = true;

	public static void main(String... args) {
		//test string #1, name of variable
		String clientResponseValidatedByExternalRules = "...";

		//test string #2, if expression
		if (clientResponseValidatedByExternalRules != null
				&& responseIsValid(clientResponseValidatedByExternalRules))	{
			//...
		}

		//remove Checked from variable name
		String partnerCheckedCode = "123339";

		String[] testStrings = {
				//#1 name of clientResponseValidatedByExternalRules variable
				"",
				//#2 internals of if condition
				"",
				//#3 internals of method
				"",
				//#4 internals of <form> tag
				"",
				//#5 shortened variable name
				""
				};

		testEditor(testStrings);

		//WITHOUT CURSOR:
		//#1 use method getValue instead of getNextValue.
		String value = trustedStoreProvidedWithExtraProperties.getNextValue();
		//#2 use trustedStore instead of trustedStoreProvidedWithExtraProperties
		value = trustedStoreProvidedWithExtraProperties.getNextValue();
		//#3 use trustedStore.start() instead of trustedStoreProvidedWithExtraProperties
		trustedStoreProvidedWithExtraProperties.getNextValue();
		//#4 use updateStore instead and add if (enabled) before method call.
		trustedStore.createNewStore();
	}

	private static boolean responseIsValid(String clientResponseValidatedByExternalRules) {
		return true;
	}

	//test string #3, if expression
	private static int generateNextContractCode(){
		Random random = new Random();
		return random.nextInt();
	}

	private static void testEditor(String[] usedVars) {
		if (!"clientResponseValidatedByExternalRules".equals(usedVars[0])){
			throw new RuntimeException("usedVars[0] should be 'clientResponseValidatedByExternalRules'");
		}
		if (!("clientResponseValidatedByExternalRules != null\n" +
				"\t\t\t\t&& responseIsValid(clientResponseValidatedByExternalRules)").equals(usedVars[1])){
			throw new RuntimeException("usedVars[1] should be 'clientResponseValidatedByExternalRules != null\n" +
					"\t\t\t\t&& responseIsValid(clientResponseValidatedByExternalRules)'");
		}
		if (!("\t\tRandom random = new Random();\n" +
				"\t\treturn random.nextInt();\n").equals(usedVars[2])){
			throw new RuntimeException("usedVars[2] should be '\t\tRandom random = new Random();\n" +
					"\t\treturn random.nextInt();\n'");
		}
		if (!("<form name=\"main\">\n" +
				"        ...\n" +
				"    </form>").equals(usedVars[3])){
			throw new RuntimeException("usedVars[3] should be '<form name=\"main\">\n" +
					"        ...\n" +
					"    </form>'");
		}
		if (!("partnerCode").equals(usedVars[4])){
			throw new RuntimeException("usedVars[4] should be 'partnerCode'");
		}
	}

	private static class Store{

		public String getNextValue() {
			return null;
		}
		public String getValue() {
			return null;
		}

		public int start(){
			return 0;
		}

		public void updateStore(){

		}

		public void createNewStore() {

		}
	}
}
