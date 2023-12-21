package za.co.nnwtech.parser.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import za.co.nnwtech.parser.AnswersFile;
import za.co.nnwtech.parser.JsonParser;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.adapters.AddressLineAdapter;
import za.co.nnwtech.parser.adapters.CountryAdapter;
import za.co.nnwtech.parser.adapters.ProvinceOrStateAdapter;
import za.co.nnwtech.parser.adapters.TypeAdapter;
import za.co.nnwtech.parser.util.FileParserUtil;

class JsonParserTest {

	private static AddressAdapter addressAdapter = null;
	private static AnswersFile jsonParser = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		jsonParser = new AnswersFile();
		addressAdapter = new AddressAdapter();
		addressAdapter.setCountry(new CountryAdapter("ZA","South Africa"));
		addressAdapter.setProvinceOrState(new ProvinceOrStateAdapter("GP","Gauteng"));
		addressAdapter.setAddressLineDetail(new AddressLineAdapter("line1","line2"));
		addressAdapter.setType(new TypeAdapter("1","Physical Address"));
		addressAdapter.setCityOrTown("JHB");
		addressAdapter.setPostalCode("200");
	}

	@Test
	void printCertainTypeAddress() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	void testValidateAllAddressTypes() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	void testValidatePrettyPrint() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	void testPrintAllAddressesIntheFile() 
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
	void testValidateAddress() 
	{
	
		assertTrue(jsonParser.validateAddress(addressAdapter));
		
		addressAdapter.setPostalCode("abc");
		assertFalse(jsonParser.validateAddress(addressAdapter));
		
		addressAdapter.getProvinceOrState().setName("");
		assertFalse(jsonParser.validateAddress(addressAdapter));
		
		addressAdapter.getCountry().setName("USA");
		addressAdapter.setPostalCode("13980");
		
		assertTrue(jsonParser.validateAddress(addressAdapter));
	}
}
