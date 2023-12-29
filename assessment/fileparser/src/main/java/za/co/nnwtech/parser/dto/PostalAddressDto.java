package za.co.nnwtech.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalAddressDto implements Addressable
{
	public String city;
	public String postalCode;
	public String country;
	public String name;
	public String countryCode;
	public String province;
	
	@Override
	public String getAddressLineOne() {
		throw new UnsupportedOperationException("no address line in the postal address type");
		
	}
}
