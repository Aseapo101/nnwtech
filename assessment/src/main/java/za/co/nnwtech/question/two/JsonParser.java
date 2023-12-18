package za.co.nnwtech.question.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ServiceLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import za.co.nnwtech.question.two.jsonparser.adapters.AddressAdapter;
import za.co.nnwtech.question.two.jsonparser.dto.PostalAddressDto;
import za.co.nnwtech.question.two.jsonparser.mapper.AddressTypeMapper;

public class JsonParser 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try(FileWriter fw = new FileWriter("C:\\Users\\T420\\local-git-repositories\\nnwtech\\assessment\\src\\main\\resource\\answers\\pretty-print.json"))
		{
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		
		AddressAdapter [] j =  g.fromJson(new FileReader("C:\\Users\\T420\\local-git-repositories\\nnwtech\\assessment\\src\\main\\resource\\input.json"), AddressAdapter [].class);
		
		//ServiceLoader<AddressTypeMapper> adms = ServiceLoader.load(AddressTypeMapper.class);
		
		MapperImpl mapper = new MapperImpl();
		PostalAddressDto pad = mapper.mapPostalAddressDto(j[1]);
		
		
		System.out.println(" Done "+pad.getCountry());
		}
		catch(Exception e)
		{
			System.out.println("sdfdsafsadfdsaf :" +e.getMessage());
		}
	}
	
	private void mapObject()
	{
		
	}
}
