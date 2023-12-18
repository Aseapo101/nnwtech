package za.co.nnwtech.highestcommonfactor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.highestcommonfactor.exception.InvalidArrayInputException;
import za.co.nnwtech.highestcommonfactor.exception.NoCommonFactorException;

@Slf4j
public class HighestCommonFactor {

	static Integer [] inputArray = {2,4,6,7};
	
	public static void main(String[] args) 
	{
		try
		{
			if(validate(inputArray))
			{
				log.info("Highest Common Factor is : {} for the input array {}",findHighestCommonFactor(inputArray), Arrays.toString(inputArray));
			}
		}
		catch(InvalidArrayInputException | NoCommonFactorException ex )
		{
			log.error(ex.getMessage());
		}
		catch(Exception ex )
		{
			log.error(ex.getMessage());
		}
		
	}
	
	private static Integer findHighestCommonFactor(Integer [] inputArrayparam) throws NoCommonFactorException
	{
		Stream<Integer> arrayStream = Arrays.stream(inputArrayparam);
		int minElement = arrayStream.min(Integer::compare).get();
		List<Integer> results = Arrays.stream(inputArrayparam).filter(element -> element % minElement != 0).collect(Collectors.toList());
		
		if(Optional.ofNullable(results).isPresent() &&  Integer.compare(results.size(),0) > 0) 
		{
			log.error("Array elements not divisable by the potential HCF : "+ results);
			throw new NoCommonFactorException("Array elements have different multiples, Highest Common Factor cannot be determined !!!");
		}
		return minElement;
	}
	
	private static boolean validate(Integer [] inputArrayparam) throws InvalidArrayInputException
	{
		Optional.ofNullable(inputArrayparam).orElseThrow( () -> new InvalidArrayInputException(" Input Array is NULL."));
		if (Optional.ofNullable(inputArrayparam).isEmpty())
		{
			throw new InvalidArrayInputException("Input Array has no elements.");
		}
		return true;
	}
}
