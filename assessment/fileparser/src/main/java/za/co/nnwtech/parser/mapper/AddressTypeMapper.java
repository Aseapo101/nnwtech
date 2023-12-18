package za.co.nnwtech.parser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.adapters.AddressLineAdapter;
import za.co.nnwtech.parser.adapters.CountryAdapter;
import za.co.nnwtech.parser.adapters.ProvinceOrStateAdapter;
import za.co.nnwtech.parser.adapters.TypeAdapter;
import za.co.nnwtech.parser.dto.BusinessAddressDto;
import za.co.nnwtech.parser.dto.PhysicalAddressDto;
import za.co.nnwtech.parser.dto.PostalAddressDto;

@Mapper(componentModel = "default")
public interface AddressTypeMapper 
{
	
	public static AddressTypeMapper MAPPER = Mappers.getMapper(AddressTypeMapper.class);
	
	@Mapping(target = "country", source = "country.name")
	@Mapping(target = "postalCode", constant = "postalCode")
	@Mapping(target = "city", constant = "cityOrTown")
	public PostalAddressDto mapPostalAddressDto(AddressAdapter addressAdapter);
	
	@Mapping(target = "country", constant = "country.name")
	@Mapping(target = "postalCode", constant = "postalCode")
	@Mapping(target = "province", constant = "province.name")
	@Mapping(target = "city", constant = "cityOrTown")
	@Mapping(target = "addressLine_1", constant = "LineOne")
	@Mapping(target = "addressLine_2", constant = "LineTwo")
	public PhysicalAddressDto mapPhysicalAddressDto(AddressAdapter addressAdapter);
	
	@Mapping(target = "country", constant = "country.name")
	@Mapping(target = "postalCode", constant = "postalCode")
	@Mapping(target = "province", constant = "province.name")
	@Mapping(target = "city", constant = "cityOrTown")
	@Mapping(target = "addressLine", constant = "addressLine")
	public BusinessAddressDto mapBusinessAddressDto(AddressAdapter addressAdapter);
}
