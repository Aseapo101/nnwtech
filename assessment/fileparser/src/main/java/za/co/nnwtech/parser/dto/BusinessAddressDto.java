package za.co.nnwtech.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAddressDto implements Addressable
{
	public String name;
	public String addressLine;
	public String city;
	public String province;
	public String postalCode;
	public String country;
}
