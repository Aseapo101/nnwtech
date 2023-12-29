package za.co.nnwtech.parser.constants;

import java.util.regex.Pattern;

public interface Constants
{

	
	public final static String JSON_PRETTY_PRINT_OUTPUT = "../fileparser/src/main/resources/answers/pretty-print.json";
	public static final String JSON_INPUT_FILE_DIRECTORY = "../fileparser/src/main/resources/input.json";
	
	public static final Pattern DIGIT_REGEX = Pattern.compile("[0-9]");
	public static final String ADDRESS_LINE_ONE_VALIDATION_MESSAGE = "No address line in the address";
	public static final String SOUTH_AFRICA_COUNTRY_CODE = "ZA";
	public static final String ADDRESS_LINE_TWO_VALIDATION_MESSAGE = "";
	public static final String SUBURB_VALIDATION_MESSAGE = "";
	public static final String CITY_VALIDATION_MESSAGE = "A valid address cannot have empty City or Town.";
	public static final String POSTAL_CODE_VALIDATION_MESSAGE = "Postal code should be made up on only digit characters.";
	public static final String COUNTRY_VALIDATION_MESSAGE = "Address cannot have an empty or invalid country name.";
	public static final String PROVINCE_VALIDATION_MESSAGE = "Province need to be valid when the country is South Africa";
}
