package za.co.nnwtech.parser.dto;

import java.util.Arrays;
import java.util.StringJoiner;

public interface Addressable 
{

	//Type: Line details - city - province/state - postal code – country
	default String print(String...strings)
	{
		StringJoiner stringJoiner = new StringJoiner("-","[" , "]");
		
		Arrays.stream(strings).forEach(element -> stringJoiner.add(element));
		return stringJoiner.toString();
	}
}
