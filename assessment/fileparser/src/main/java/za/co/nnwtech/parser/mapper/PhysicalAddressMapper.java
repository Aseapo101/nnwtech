package za.co.nnwtech.parser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.dto.PhysicalAddressDto;

@Mapper(componentModel = "default")
public interface PhysicalAddressMapper
{

	public static PhysicalAddressMapper MAPPER = Mappers.getMapper(PhysicalAddressMapper.class);
	
	@Mapping(target = "country", source = "country.name")
	@Mapping(target = "postalCode", source = "postalCode")
	@Mapping(target = "province", source = "provinceOrState.name")
	@Mapping(target = "name", source = "type.name")
	@Mapping(target = "city", source = "cityOrTown")
	@Mapping(target = "addressLine_1", source = "addressLineDetail.line1")
	@Mapping(target = "addressLine_2", source = "addressLineDetail.line2")
	public PhysicalAddressDto mapPhysicalAddressDto(AddressAdapter addressAdapter);
	
	
}
