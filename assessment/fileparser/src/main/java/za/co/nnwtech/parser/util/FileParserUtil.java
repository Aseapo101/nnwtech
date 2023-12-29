package za.co.nnwtech.parser.util;

import java.util.TreeMap;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.dto.AddressDto;
import za.co.nnwtech.parser.dto.Addressable;
import za.co.nnwtech.parser.dto.BusinessAddressDto;
import za.co.nnwtech.parser.dto.PhysicalAddressDto;
import za.co.nnwtech.parser.dto.PostalAddressDto;
import za.co.nnwtech.parser.enums.AddressTypeEnum;
import za.co.nnwtech.parser.mapper.BusinessAddressMapper;
import za.co.nnwtech.parser.mapper.PhysicalAddressMapper;
import za.co.nnwtech.parser.mapper.PostalAddressMapper;

public class FileParserUtil 
{

	private static TreeMap<String,AddressTypeEnum> treeMap = new TreeMap<>();
	
	static
	{
		treeMap.put("1", AddressTypeEnum.PHYSICAL_ADDRESS);
		treeMap.put("2", AddressTypeEnum.POSTAL_ADDRESS);
		treeMap.put("5", AddressTypeEnum. BUSINESS_ADDRESS);
	}
	
	public static AddressDto parseFileElement(AddressAdapter addressAdapter)
	{
		AddressTypeEnum addressEnum = treeMap.get(addressAdapter.getType().getCode());
		
		if(addressEnum.toString().equalsIgnoreCase(AddressTypeEnum.POSTAL_ADDRESS.toString()))
		{
			var postalAddress = PostalAddressMapper.MAPPER.mapPostalAddressDto(addressAdapter);
			return new AddressDto (AddressTypeEnum.POSTAL_ADDRESS,postalAddress);
			
		}
		if(addressEnum.toString().equalsIgnoreCase(AddressTypeEnum.PHYSICAL_ADDRESS.toString()))
		{
			var physicalAddress = PhysicalAddressMapper.MAPPER.mapPhysicalAddressDto(addressAdapter);
			return new AddressDto (AddressTypeEnum.PHYSICAL_ADDRESS,physicalAddress);
		}
		if(addressEnum.toString().equalsIgnoreCase(AddressTypeEnum.BUSINESS_ADDRESS.toString()))
		{
			var businessAddress = BusinessAddressMapper.MAPPER.mapBusinessAddressDto(addressAdapter);
			return new AddressDto (AddressTypeEnum.BUSINESS_ADDRESS,businessAddress);
		}
		return null;
	}
	
	
	public static String print(AddressDto addressDto)
	{
		var addressable = addressDto.getAddressDetail();
		
		if(addressable instanceof PostalAddressDto)
		{
			var postalAddress = ((PostalAddressDto) addressable);
			
			return addressable.print(postalAddress.getCity(),postalAddress.getCountry(),postalAddress.getPostalCode());
			
		}
		if(addressable instanceof PhysicalAddressDto)
		{
			var physicalAddressDto = ((PhysicalAddressDto) addressable);
			return addressable.print(physicalAddressDto.getAddressLineOne(),
					physicalAddressDto.getAddressLineTwo(),physicalAddressDto.getCity(),
					physicalAddressDto.getProvince(),physicalAddressDto.getCountry(),physicalAddressDto.getPostalCode());
		}
		if(addressable instanceof BusinessAddressDto)
		{
			var businessAddressDto = ((BusinessAddressDto) addressable);
			return addressable.print(businessAddressDto.getAddressLineOne(),businessAddressDto.getCity(),
					businessAddressDto.getProvince(),businessAddressDto.getCountry(),
					businessAddressDto.getPostalCode());
		}
		return null;
	}
	
	public boolean validatePhysicalAdress(AddressDto addressDto) 
	{
		
		return false;
	}
	public static boolean validatePostalAdress(AddressDto addressDto) 
	{
		
		return false;
	}
	public static boolean validateBusinessAdress(AddressDto addressDto) 
	{
	
	return false;
}
}
