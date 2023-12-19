package za.co.nnwtech.parser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.adapters.CountryAdapter;
import za.co.nnwtech.parser.constants.Constants;
import za.co.nnwtech.parser.dto.AddressDto;
import za.co.nnwtech.parser.dto.PostalAddressDto;
import za.co.nnwtech.parser.util.FileParserUtil;

@Slf4j
public class JsonParser 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		JsonParser jsonParser = new JsonParser();
		try(FileWriter fw = new FileWriter(Constants.JSON_PRETTY_PRINT_OUTPUT))
		{
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			
			AddressAdapter [] parsedJsonArrayElements =  g.fromJson(new FileReader(Constants.JSON_INPUT_FILE_DIRECTORY), AddressAdapter [].class);
			
			System.out.println("Results : ");
			for(AddressAdapter element : parsedJsonArrayElements) 
			{
				System.out.println("Results Value :" +element.toString());
				
			}
			//Call separate thread for each element parsing
			jsonParser.printAllAddressesIntheFile(parsedJsonArrayElements);
			jsonParser.validateAddress(parsedJsonArrayElements[0]);
			jsonParser.printCertainTypeAddress(parsedJsonArrayElements[0]);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	//Write a function to pretty print all the addresses in the attached file
	public void prettyPrintAllAddresses()
	{
		
	}
	
	//For each address in the attached file, determine if it is valid or not, and if not give an indication of what is invalid in a message format of your choice.
	public boolean validateAllAddresses()
	{
		return false;
	}
	public HashSet<String> printAllAddressesIntheFile(AddressAdapter [] parsedJsonArrayElements)
	{
		HashSet<String> addressSet = new HashSet<String>(3);
		for(AddressAdapter element : parsedJsonArrayElements) 
		{
			var addressDto = FileParserUtil.parseFileElement(element);
			FileParserUtil.print(addressDto);
			addressSet.add(FileParserUtil.print(addressDto));
			
		}
		
		addressSet.stream().forEach(address -> System.out.println(address));
		return addressSet;
	}
	
	public void printCertainTypeAddress(AddressAdapter addressAdapter)
	{
		var addressDto = FileParserUtil.parseFileElement(addressAdapter);
		var addressString = FileParserUtil.print(addressDto);
		
		System.out.println("Address type : "+addressDto.addressTypeEnum.toString()+" Address details : "+addressString);
	}
	
	public boolean validateAddress(AddressAdapter addressAdapter)
	{
		Optional<String> addressLineOneOptionalValue = Optional.ofNullable(addressAdapter.addressLineDetail.getLine1());
		Optional<CountryAdapter> countryOptionalValue = Optional.ofNullable(addressAdapter.getCountry());
		boolean isDigitPostalCode = Pattern.matches("[0-9]+", addressAdapter.getPostalCode());
		if(!addressLineOneOptionalValue.isPresent() || (!(countryOptionalValue.isPresent() && Optional.ofNullable(countryOptionalValue.get().name).isPresent())) || (!isDigitPostalCode))
		{	
			return false;
		}
		
		if(addressAdapter.getCountry().code.equalsIgnoreCase("ZA"))
		{
			return validateSouthAfricaAddress(addressAdapter.getProvinceOrState().getName());
		}
		return true;
	}
	
	private boolean validateSouthAfricaAddress(String province)
	{
		//TODO:Check valid province values..
		return (Optional.ofNullable(province).isPresent())?true:false;
	}
}
