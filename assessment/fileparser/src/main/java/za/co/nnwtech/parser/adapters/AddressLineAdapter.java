package za.co.nnwtech.parser.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressLineAdapter
{

	public String line1;
	public String line2;
	
	public AddressLineAdapter (String... param) 
	{
		
	}
}
