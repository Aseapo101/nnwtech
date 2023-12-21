package za.co.nnwtech.parser.adapters;

import java.util.Optional;
import java.util.StringJoiner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressAdapter 
{
	public TypeAdapter type;
	public String postalCode;
	public String lastUpdate; 
	public String cityOrTown;
	public String suburbOrDistrict;
	public ProvinceOrStateAdapter provinceOrState;
	public CountryAdapter country;
	public AddressLineAdapter addressLineDetail;
	
	@Override
	public String toString()
	{
	
		StringJoiner j = new StringJoiner("|","{","}");
		if(Optional.ofNullable(type).isPresent())
		{
			j.add("typeAdapter:");
			j.add("code : "+type.getCode());
			j.add("name : "+type.getName());
		}
		if(Optional.ofNullable(provinceOrState).isPresent())
		{
			j.add("province:");
			j.add("code : "+provinceOrState.getCode());
			j.add("name : "+provinceOrState.getName());
		}
		if(Optional.ofNullable(country).isPresent())
		{
			j.add("country:");
			j.add("code : "+country.getCode());
			j.add("name : "+country.getName());
		}
		if(Optional.ofNullable(addressLineDetail).isPresent())
		{
			j.add("addressLineAdapter:");
			j.add("line 1 : "+addressLineDetail.getLine1());
			j.add("line 2 : "+addressLineDetail.getLine2());
		}
		return j.toString();
	}
	
}
