package za.co.nnwtech.parser.constants;

public interface Constants
{

	//public static final String JSON_INPUT_FILE_DIRECTORY = "../fileparser/src/main/resources/input.json";
	//public final static String JSON_PRETTY_PRINT_OUTPUT = "../fileparser/src/main/resources/answers/pretty-print.json";
	public final static String JSON_PRETTY_PRINT_OUTPUT = "C:\\Users\\T420\\local-git-repositories\\nnwtech\\assessment\\fileparser\\src\\main\\resources\\answers\\pretty-print.json";
	public static final String JSON_INPUT_FILE_DIRECTORY = "C:\\Users\\T420\\local-git-repositories\\nnwtech\\assessment\\fileparser\\src\\main\\resources\\input.json";
	
	
	public static final String ADDRESS_LINE_ONE_VALIDATION_MESSAGE = "No address line in the address";
	public static final String ADDRESS_LINE_TWO_VALIDATION_MESSAGE = "";
	public static final String SUBURB_VALIDATION_MESSAGE = "";
	public static final String CITY_VALIDATION_MESSAGE = "A valid address cannot have empty City or Town.";
	public static final String POSTAL_CODE_VALIDATION_MESSAGE = "Postal code should be made up on only digit characters.";
	public static final String COUNTRY_VALIDATION_MESSAGE = "Address cannot have an empty or invalid country name.";
}
