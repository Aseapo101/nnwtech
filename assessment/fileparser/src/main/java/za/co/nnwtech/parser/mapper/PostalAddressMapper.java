package za.co.nnwtech.parser.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import za.co.nnwtech.parser.adapters.AddressAdapter;
import za.co.nnwtech.parser.dto.PostalAddressDto;

@Mapper(componentModel = "default")
public interface PostalAddressMapper
{

	public static PostalAddressMapper MAPPER = Mappers.getMapper(PostalAddressMapper.class);
	
	@Mapping(target = "country", source = "country.name")
	@Mapping(target = "name", source = "type.name")
	@Mapping(target = "postalCode", source = "postalCode")
	@Mapping(target = "city", source = "cityOrTown")
	public PostalAddressDto mapPostalAddressDto(AddressAdapter addressAdapter);
}
