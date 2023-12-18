package za.co.nnwtech.question.two.jsonparser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.nnwtech.question.two.jsonparser.adapters.AddressAdapter;
import za.co.nnwtech.question.two.jsonparser.adapters.AddressLineAdapter;
import za.co.nnwtech.question.two.jsonparser.adapters.CountryAdapter;
import za.co.nnwtech.question.two.jsonparser.adapters.ProvinceOrStateAdapter;
import za.co.nnwtech.question.two.jsonparser.adapters.TypeAdapter;
import za.co.nnwtech.question.two.jsonparser.dto.BusinessAddressDto;
import za.co.nnwtech.question.two.jsonparser.dto.PhysicalAddressDto;
import za.co.nnwtech.question.two.jsonparser.dto.PostalAddressDto;

@Mapper(componentModel = "default")
public interface AddressTypeMapper 
{
	
	public AddressTypeMapper MAPPER = Mappers.getMapper(AddressTypeMapper.class);
	
	@Mapping(target = "country", constant = "country.name")
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
