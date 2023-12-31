package za.co.nnwtech.parser;

import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.constants.Constants;

@Slf4j
public class JsonParser 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		AnswersFile jsonParser = new AnswersFile();
		try
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			AddressAdapter [] parsedJsonArrayElements =  gson.fromJson(new FileReader(Constants.JSON_INPUT_FILE_DIRECTORY), AddressAdapter [].class);
			
			jsonParser.printAllAddressesIntheFile(parsedJsonArrayElements);
			jsonParser.validateAddress(parsedJsonArrayElements[0]);
			jsonParser.printCertainTypeAddress(parsedJsonArrayElements[0]);
			jsonParser.printCertainTypeAddress(parsedJsonArrayElements[1]);
			jsonParser.printCertainTypeAddress(parsedJsonArrayElements[2]);
			jsonParser.prettyPrintAllAddresses();
			jsonParser.validateAllAddresses(parsedJsonArrayElements);
		}
		catch(Exception e)
		{
			log.error("Error during parsing the Json file {}",e.getMessage());	
		}
	}
}
