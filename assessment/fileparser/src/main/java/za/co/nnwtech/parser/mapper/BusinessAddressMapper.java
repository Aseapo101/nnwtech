package za.co.nnwtech.parser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.dto.BusinessAddressDto;

@Mapper(componentModel = "default")
public interface BusinessAddressMapper 
{

	public static BusinessAddressMapper MAPPER = Mappers.getMapper(BusinessAddressMapper.class);
	
	@Mapping(target = "country", source = "country.name")
	@Mapping(target = "name", source = "type.name")
	@Mapping(target = "postalCode", source = "postalCode")
	@Mapping(target = "province", source = "provinceOrState.name")
	@Mapping(target = "city", source = "cityOrTown")
	@Mapping(target = "addressLineOne", source = "addressLineDetail.line1")
	@Mapping(target = "suburb", source = "suburbOrDistrict")
	public BusinessAddressDto mapBusinessAddressDto(AddressAdapter addressAdapter);
}
