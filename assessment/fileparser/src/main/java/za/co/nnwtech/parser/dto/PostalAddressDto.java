package za.co.nnwtech.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalAddressDto implements Addressable{

	public String city;
	public String postalCode;
	public String country;
}
