package za.co.nnwtech.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.adapters.CountryAdapter;
import za.co.nnwtech.parser.constants.Constants;
import za.co.nnwtech.parser.util.FileParserUtil;
import za.co.nnwtech.parser.validators.AddressValidator;

@Data
@Slf4j
@NoArgsConstructor
public class AnswersFile 
{
	
	/**
	 * prettyPrintAllAddresses() - Method reads the input json file and convert its contents into an human readable json format.
	 * @return String - Json file pretty print representation.
	 * @throws JsonIOException - Thrown if the file cannot be read.
	 * @throws JsonSyntaxException - Thrown when the read file is found to have Json format discrepancies.
	 * @throws FileNotFoundException - Thrown when the file is cannot be located in the specified directory.
	 */
	public String prettyPrintAllAddresses() throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement unformattedJsonFile = com.google.gson.JsonParser.parseReader(new FileReader(Constants.JSON_INPUT_FILE_DIRECTORY));
		String formattedJsonFile = gson.toJson(unformattedJsonFile);
		
		log.info("Json file pretty print :=> {}",formattedJsonFile);
		
		return formattedJsonFile;
	}
	
	/**
	 * validateAllAddresses() - The method validates the json file (all addresses) contents by applying address rules. In case there is a validation failure, cause is determined.
	 * @param parsedJsonArrayElements - Adapted json file address contents converted into java objects.
	 * @return TreeMap<String,Set<String>> - Map of the reasons the address failed validation and the key being address type code.
	 */
	public TreeMap<String,Set<String>> validateAllAddresses(AddressAdapter [] parsedJsonArrayElements)
	{
		TreeMap<String,Set<String>> validationErrorsMap = new TreeMap<>();
		
		Arrays.stream(parsedJsonArrayElements).forEach( element -> {
			validationErrorsMap.put(element.type.code, AddressValidator.validateAddress(FileParserUtil.parseFileElement(element)));
		});
		
		return validationErrorsMap;
	}
	
	/**
	 * printAllAddressesIntheFile() - The method prints the address details as per the required formart, (Line details - city - province/state - postal code – country)
	 * @param parsedJsonArrayElements - Adapted json file address contents converted into a java object.
	 * @return HashSet<String> - The json file addresses to be printed after they have been parsed to Java object.
	 */
	public HashSet<String> printAllAddressesIntheFile(AddressAdapter [] parsedJsonArrayElements)
	{
		HashSet<String> addressSet = new HashSet<String>(3);//only three addresses provided.
		for(AddressAdapter element : parsedJsonArrayElements) 
		{
			var addressDto = FileParserUtil.parseFileElement(element);
			FileParserUtil.print(addressDto);
			addressSet.add(FileParserUtil.print(addressDto));
			
		}
		
		addressSet.stream().forEach(address -> log.info("Formatted address :=> {}",address));
		return addressSet;
	}
	
	/**
	 * printCertainTypeAddress() - Method determines the type of the address provided, prints it to console and determines its type.
	 * @param addressAdapter - Adapted json address into a Java object.
	 * @return String - String or sentence determining the type of address and its details.
	 */
	public String printCertainTypeAddress(AddressAdapter addressAdapter)
	{
		var addressDto = FileParserUtil.parseFileElement(addressAdapter);
		var addressString = FileParserUtil.print(addressDto);
		
		StringBuffer results = new StringBuffer("Address type : ").append(addressDto.addressTypeEnum.toString()).append(" Address details : ").append(addressString);
		log.info(results.toString());
		return results.toString();
	}
	
	/**
	 * validateAddress () - The method validates the address by applying address rules (Postal address to be only digits, if South-Africa is a country, province need to be valid, at-least one address line to be present).
	 * @param addressAdapter - Adapted json address into a Java object.
	 * @return boolean - True if validation passed, false otherwise.
	 */
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
		return (Optional.ofNullable(province).isPresent())?true:false;
	}
}
