package za.co.nnwtech.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalAddressDto implements Addressable
{
	public String addressLine_1;
	public String addressLine_2;
	public String city;
	public String province;
	public String postalCode;
	public String country;
	
}
