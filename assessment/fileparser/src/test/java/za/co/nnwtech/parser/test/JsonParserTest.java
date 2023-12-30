package za.co.nnwtech.parser.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import za.co.nnwtech.parser.AnswersFile;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.adapters.AddressLineAdapter;
import za.co.nnwtech.parser.adapters.CountryAdapter;
import za.co.nnwtech.parser.adapters.ProvinceOrStateAdapter;
import za.co.nnwtech.parser.adapters.TypeAdapter;
import za.co.nnwtech.parser.constants.Constants;
import za.co.nnwtech.parser.util.FileParserUtil;

class JsonParserTest {

	private static AddressAdapter addressAdapterPhysicalAddress = null;
	private static AddressAdapter addressAdapterPostalAddress = null;
	private static AddressAdapter addressAdapterBusinessAddress = null;
	private static AddressAdapter addressAdapterBusinessAddressTwo = null;
	private static AnswersFile jsonParser = null;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception 
	{
		jsonParser = new AnswersFile();
		addressAdapterPhysicalAddress = new AddressAdapter();
		addressAdapterPhysicalAddress.setCountry(new CountryAdapter("ZA","South Africa"));
		addressAdapterPhysicalAddress.setProvinceOrState(new ProvinceOrStateAdapter("GP","Gauteng"));
		addressAdapterPhysicalAddress.setAddressLineDetail(new AddressLineAdapter("line1","line2"));
		addressAdapterPhysicalAddress.setType(new TypeAdapter("1","Physical Address"));
		addressAdapterPhysicalAddress.setCityOrTown("JHB");
		addressAdapterPhysicalAddress.setPostalCode("2000");
		
		addressAdapterPostalAddress = new AddressAdapter();
		addressAdapterPostalAddress.setCountry(new CountryAdapter("GR","Greece"));
		addressAdapterPostalAddress.setType(new TypeAdapter("2","Postal Address"));
		addressAdapterPostalAddress.setCityOrTown("Athens");
		addressAdapterPostalAddress.setPostalCode("2000");
		
		addressAdapterBusinessAddress = new AddressAdapter();
		addressAdapterBusinessAddress.setCountry(new CountryAdapter("ZA","South Africa"));
		addressAdapterBusinessAddress.setProvinceOrState(new ProvinceOrStateAdapter("GP","Gauteng"));
		addressAdapterBusinessAddress.setAddressLineDetail(new AddressLineAdapter("line1"));
		addressAdapterBusinessAddress.setType(new TypeAdapter("5","Business Address"));
		addressAdapterBusinessAddress.setCityOrTown("JHB");
		addressAdapterBusinessAddress.setPostalCode("2000");
		
		//No province and Business address is of a South Africa
		addressAdapterBusinessAddressTwo = new AddressAdapter();
		addressAdapterBusinessAddressTwo.setCountry(new CountryAdapter("ZA","South Africa"));
		addressAdapterBusinessAddressTwo.setType(new TypeAdapter("5","Business Address"));
		addressAdapterBusinessAddressTwo.setCityOrTown("JHB");
		addressAdapterBusinessAddressTwo.setPostalCode("2000");
	}

	@Test
	void printCertainTypeAddress() 
	{
		String addressIdetifierString = jsonParser.printCertainTypeAddress(addressAdapterPhysicalAddress);
		
		assertTrue(addressIdetifierString.contains("PHYSICAL_ADDRESS"));
		assertTrue(addressIdetifierString.contains("2000"));
		assertTrue(addressIdetifierString.contains("JHB"));
		assertTrue(addressIdetifierString.contains("Gauteng"));
		assertTrue(addressIdetifierString.contains("South Africa"));
		
	}
	
	@Test
	void testValidateAllAddressTypes() 
	{
		
		
		var addressTypesErrorMap = jsonParser.validateAllAddresses(List.of(addressAdapterBusinessAddressTwo,addressAdapterPostalAddress,addressAdapterPhysicalAddress).toArray(new AddressAdapter [3]));
		
		Set<String> businessAddressErrorMessagesSet = addressTypesErrorMap.get("5");
		Set<String> physicalAddressErrorMessagesSet = addressTypesErrorMap.get("1");
		Set<String> PostalAddressErrorMessagesSet = addressTypesErrorMap.get("2");
		
		assertTrue((businessAddressErrorMessagesSet.size() == 2));// validation error message based on the province being null.
		assertTrue((businessAddressErrorMessagesSet.contains(Constants.PROVINCE_VALIDATION_MESSAGE)));// validation error message based on the province being null.
		assertTrue((businessAddressErrorMessagesSet.contains(Constants.ADDRESS_LINE_ONE_VALIDATION_MESSAGE)));// validation error message based on address line one.
		assertTrue((physicalAddressErrorMessagesSet.size() == 0)); //no error message returned
		assertTrue((PostalAddressErrorMessagesSet.size() == 0));//no error message returned
		
		
	}
	
	@Test
	void testValidatePrettyPrint() 
	{
		String JsonActual = "[\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"1\",\r\n"
				+ "        \"type\": {\r\n"
				+ "            \"code\": \"1\",\r\n"
				+ "            \"name\": \"Physical Address\"\r\n"
				+ "        },\r\n"
				+ "        \"addressLineDetail\": {\r\n"
				+ "            \"line1\": \"Address 1\",\r\n"
				+ "            \"line2\": \"Line 2\"\r\n"
				+ "        },\r\n"
				+ "        \"provinceOrState\": {\r\n"
				+ "            \"code\": \"5\",\r\n"
				+ "            \"name\": \"Eastern Cape\"\r\n"
				+ "        },\r\n"
				+ "        \"cityOrTown\": \"City 1\",\r\n"
				+ "        \"country\": {\r\n"
				+ "            \"code\": \"ZA\",\r\n"
				+ "            \"name\": \"South Africa\"\r\n"
				+ "        },\r\n"
				+ "        \"postalCode\": \"1234\",\r\n"
				+ "        \"lastUpdated\": \"2015-06-21T00:00:00.000Z\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"2\",\r\n"
				+ "        \"type\": {\r\n"
				+ "            \"code\": \"2\",\r\n"
				+ "            \"name\": \"Postal Address\"\r\n"
				+ "        },\r\n"
				+ "        \"cityOrTown\": \"City 2\",\r\n"
				+ "        \"country\": {\r\n"
				+ "            \"code\": \"LB\",\r\n"
				+ "            \"name\": \"Lebanon\"\r\n"
				+ "        },\r\n"
				+ "        \"postalCode\": \"2345\",\r\n"
				+ "        \"lastUpdated\": \"2017-06-21T00:00:00.000Z\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"3\",\r\n"
				+ "        \"type\": {\r\n"
				+ "            \"code\": \"5\",\r\n"
				+ "            \"name\": \"Business Address\"\r\n"
				+ "        },\r\n"
				+ "        \"addressLineDetail\": {\r\n"
				+ "            \"line1\": \"Address 3\",\r\n"
				+ "            \"line2\": \"\"\r\n"
				+ "        },\r\n"
				+ "        \"cityOrTown\": \"City 3\",\r\n"
				+ "        \"country\": {\r\n"
				+ "            \"code\": \"ZA\",\r\n"
				+ "            \"name\": \"South Africa\"\r\n"
				+ "        },\r\n"
				+ "        \"postalCode\": \"3456\",\r\n"
				+ "        \"suburbOrDistrict\": \"Suburb 3\",\r\n"
				+ "        \"lastUpdated\": \"2018-06-13T00:00:00.000Z\"\r\n"
				+ "    }\r\n"
				+ "]";
		try
		{
			String prettyJsonString = jsonParser.prettyPrintAllAddresses();
			
			JSONAssert.assertEquals(prettyJsonString, JsonActual, false);
		} 
		catch (JsonIOException | JsonSyntaxException | FileNotFoundException | JSONException e)
		{
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testPrintAllAddressesIntheFile() 
	{
		try
		{
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			
			AddressAdapter [] parsedJsonArrayElements =  g.fromJson(new FileReader("../fileparser/src/test/resources/input.json"), AddressAdapter [].class);
			HashSet<String> printedAddresses = jsonParser.printAllAddressesIntheFile(parsedJsonArrayElements);
			
			HashSet<String> fileAddresseses = new HashSet<String>(3);
			for(AddressAdapter item: parsedJsonArrayElements)
			{
				FileParserUtil.parseFileElement(item);
				fileAddresseses.add( FileParserUtil.print(FileParserUtil.parseFileElement(item)));
			}
			assertLinesMatch(fileAddresseses.stream(), printedAddresses.stream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test
	public void testValidateAddress() 
	{
	
		assertTrue(jsonParser.validateAddress(addressAdapterPhysicalAddress));
		
		addressAdapterPhysicalAddress.setPostalCode("abc");
		assertFalse(jsonParser.validateAddress(addressAdapterPhysicalAddress));
		
		addressAdapterPhysicalAddress.getProvinceOrState().setName("");
		assertFalse(jsonParser.validateAddress(addressAdapterPhysicalAddress));
		
		addressAdapterPhysicalAddress.getCountry().setName("USA");
		addressAdapterPhysicalAddress.setPostalCode("13980");
		
		assertTrue(jsonParser.validateAddress(addressAdapterPhysicalAddress));
	}
}
