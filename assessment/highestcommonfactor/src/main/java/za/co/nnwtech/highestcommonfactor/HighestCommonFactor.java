package za.co.nnwtech.highestcommonfactor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.highestcommonfactor.exception.InvalidArrayInputException;
import za.co.nnwtech.highestcommonfactor.exception.NoCommonFactorException;

@Slf4j
@NoArgsConstructor
public class HighestCommonFactor {

	
	public static void main(String[] args) 
	{
	
		Integer [] inputArray = {2,4,6,8};
		HighestCommonFactor HighestCommonFactorObjectReference = new HighestCommonFactor();
		
		try
		{
			Integer highestCommonFactorValue = HighestCommonFactorObjectReference.findHighestCommonFactor(inputArray);
			log.info("Highest Common Factor is : {} for the input array {}",highestCommonFactorValue, Arrays.toString(inputArray));
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
	
	public Integer findHighestCommonFactor(Integer [] inputArrayparam) throws NoCommonFactorException, InvalidArrayInputException
	{
		
		validate(inputArrayparam);
		Stream<Integer> arrayStream = Arrays.stream(inputArrayparam);
		int minElement = arrayStream.min(Integer::compare).get();
		List<Integer> results = Arrays.stream(inputArrayparam).filter(element -> element % minElement != 0).collect(Collectors.toList());
		
		if(Optional.ofNullable(results).isPresent() &&  Integer.compare(results.size(),0) > 0) 
		{
			log.error("Array elements not divisable by the potential HCF : {}", results);
			throw new NoCommonFactorException("Array elements have different multiples, Highest Common Factor cannot be determined !!!");
		}
		return minElement;
	}
	
	private boolean validate(Integer [] inputArrayparam) throws InvalidArrayInputException
	{
		Optional.ofNullable(inputArrayparam).orElseThrow( () -> new InvalidArrayInputException("Input Array is NULL."));
		if (Optional.ofNullable(inputArrayparam).isEmpty())
		{
			throw new InvalidArrayInputException("Input Array has no elements.");
		}
		return true;
	}
}
