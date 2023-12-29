package za.co.nnwtech.parser.validators;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.parser.constants.Constants;
import za.co.nnwtech.parser.dto.AddressDto;
import za.co.nnwtech.parser.dto.Addressable;
import za.co.nnwtech.parser.dto.BusinessAddressDto;
import za.co.nnwtech.parser.dto.PhysicalAddressDto;
import za.co.nnwtech.parser.dto.PostalAddressDto;
import za.co.nnwtech.parser.enums.AddressTypeEnum;

@Slf4j
public class AddressValidator 
{

	public static void validateAddress(AddressDto addressDto)
	{
		int addressTypeCode = addressDto.getAddressTypeEnum().getCode();
		
		switch(addressTypeCode) 
		{
			case 5 : 
				
				BusinessAddressDto businessAddress = ((BusinessAddressDto)addressDto.getAddressDetail());
				isValidBusinessAddress(businessAddress);
				break;
			case 1 :
				
				PhysicalAddressDto address = ((PhysicalAddressDto)addressDto.getAddressDetail());
				isValidPhysicalAddress(address);
				break;
			case 2 : 

				PostalAddressDto postalAddress = ((PostalAddressDto)addressDto.getAddressDetail());
				isValidPostalAddress(postalAddress);
				break;
			default:
		}
	}
	private static void isValidPostalAddress(PostalAddressDto postalAddressDto) 
	{
		var validateMessages = validateAddress(postalAddressDto);
		validateCity(postalAddressDto.getCity(),validateMessages);
		printErrorMessagesToConsole(validateMessages,AddressTypeEnum.POSTAL_ADDRESS);
	}
	
	private static void validateCity(String city,Set<String> validateMessages)
	{
		if(Optional.ofNullable(city).isEmpty())
			validateMessages.add(za.co.nnwtech.parser.constants.Constants.CITY_VALIDATION_MESSAGE);
	}
	
	private static void isValidBusinessAddress(BusinessAddressDto businessAddressDto) 
	{
		var validateMessages = validateAddress(businessAddressDto);
		printErrorMessagesToConsole(validateMessages,AddressTypeEnum.BUSINESS_ADDRESS);
	}
	
	private static void isValidPhysicalAddress(PhysicalAddressDto physicalAddressDto) 
	{
		var validateMessages = validateAddress(physicalAddressDto);
		validateCity(physicalAddressDto.getCity(),validateMessages);
		printErrorMessagesToConsole(validateMessages,AddressTypeEnum.PHYSICAL_ADDRESS);
	}
	
	private static void printErrorMessagesToConsole(Set<String> errorMessages,AddressTypeEnum addressType)
	{
		if(!errorMessages.isEmpty()) {
			errorMessages.stream().forEach(message -> log.info("Validation failure message : =>  {}",message+" , failed address type, "+addressType.toString()));
		}
	}
	
	private static HashSet<String> validateAddress(Addressable addressable)
	{
		
		HashSet<String> validationErrorMessages = new HashSet<>(5);
		
		if(!(addressable instanceof PostalAddressDto))
		{
			Optional<String> addressLineOneOptionalValue = Optional.ofNullable(addressable.getAddressLineOne());
			
			if(!addressLineOneOptionalValue.isPresent())
			validationErrorMessages.add(za.co.nnwtech.parser.constants.Constants.ADDRESS_LINE_ONE_VALIDATION_MESSAGE);
			
		}
		
		
		if(!(Constants.DIGIT_REGEX.matcher(addressable.getPostalCode()).find())) 
		{
			validationErrorMessages.add(za.co.nnwtech.parser.constants.Constants.POSTAL_CODE_VALIDATION_MESSAGE);
		}
		
		Optional<String> countryOptionalValue = Optional.ofNullable(addressable.getCountry());
		if(!(countryOptionalValue.isPresent()))
		{	
			validationErrorMessages.add(za.co.nnwtech.parser.constants.Constants.COUNTRY_VALIDATION_MESSAGE);
		}
		
		if(countryOptionalValue.isPresent() && za.co.nnwtech.parser.constants.Constants.SOUTH_AFRICA_COUNTRY_CODE.equalsIgnoreCase(addressable.getCountryCode()))
		{	
			
			if(!Optional.ofNullable(addressable.getProvince()).isPresent())
				validationErrorMessages.add(za.co.nnwtech.parser.constants.Constants.PROVINCE_VALIDATION_MESSAGE);
		}
		
		return validationErrorMessages;
	}
}
