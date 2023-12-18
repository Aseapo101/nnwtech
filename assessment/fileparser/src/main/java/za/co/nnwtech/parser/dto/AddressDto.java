package za.co.nnwtech.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.nnwtech.parser.enums.AddressTypeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto 
{

	public AddressTypeEnum addressType;
	public Addressable addressDetail;
}
