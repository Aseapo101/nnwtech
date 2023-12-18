package za.co.nnwtech.parser;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.dto.BusinessAddressDto;
import za.co.nnwtech.parser.dto.PhysicalAddressDto;
import za.co.nnwtech.parser.dto.PostalAddressDto;
import za.co.nnwtech.parser.mapper.AddressTypeMapper;

public class MapperImpl implements AddressTypeMapper{

	public MapperImpl()
	{
		super();
	}
	
	@Override
	public PostalAddressDto mapPostalAddressDto(AddressAdapter addressAdapter) {
		
		PostalAddressDto dto = null;
		try
		{
			System.out.println("sdasd ");
			System.out.println("sdasd ");
			System.out.println("sdasd ");
			System.out.println("sdasd ");
			System.out.println("sdasd ");
		dto = this.mapPostalAddressDto(addressAdapter);
		
		System.out.println("sdasd ");
		return dto;
		}
		catch(Exception e)
		{
			System.out.println("sdasd "+e.getMessage());
		}
		return null;
	}

	@Override
	public PhysicalAddressDto mapPhysicalAddressDto(AddressAdapter addressAdapter) {
		return this.mapPhysicalAddressDto(addressAdapter);
	}

	@Override
	public BusinessAddressDto mapBusinessAddressDto(AddressAdapter addressAdapter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
