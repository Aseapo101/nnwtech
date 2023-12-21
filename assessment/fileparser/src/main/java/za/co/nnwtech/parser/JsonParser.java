package za.co.nnwtech.parser;

import java.io.FileReader;
import java.io.FileWriter;

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
		try(FileWriter fw = new FileWriter(Constants.JSON_PRETTY_PRINT_OUTPUT))//remove
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			AddressAdapter [] parsedJsonArrayElements =  gson.fromJson(new FileReader(Constants.JSON_INPUT_FILE_DIRECTORY), AddressAdapter [].class);
			
			//Call separate thread for each element parsing
			jsonParser.printAllAddressesIntheFile(parsedJsonArrayElements);
			jsonParser.validateAddress(parsedJsonArrayElements[0]);
			jsonParser.printCertainTypeAddress(parsedJsonArrayElements[0]);
			jsonParser.prettyPrintAllAddresses();
			jsonParser.validateAllAddresses(parsedJsonArrayElements);
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
}
