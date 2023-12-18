package za.co.nnwtech.parser;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.constants.Constants;
import za.co.nnwtech.parser.dto.PostalAddressDto;
import za.co.nnwtech.parser.mapper.AddressTypeMapper;

@Slf4j
public class JsonParser 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try(FileWriter fw = new FileWriter(Constants.JSON_PRETTY_PRINT_OUTPUT))
		{
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		
		AddressAdapter [] j =  g.fromJson(new FileReader(Constants.JSON_INPUT_FILE_DIRECTORY), AddressAdapter [].class);
		
		
		PostalAddressDto pad = AddressTypeMapper.MAPPER.mapPostalAddressDto(j[1]);
		
		
		log.info(" Done "+pad.getCountry());
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	private void mapObject()
	{
		
	}
}
