package za.co.nnwtech.question.one;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import za.co.nnwtech.question.exception.InvalidArrayInputException;
import za.co.nnwtech.question.exception.NoCommonFactorException;


public class HighestCommonFactor {

	static Integer [] inputArray = {2,4,6,7};
	//private static Logger log = LoggerFactory.getLogger(HighestCommonFactor.class);
	
	public static void main(String[] args) 
	{
		try
		{
			if(validate(inputArray))
			{
				System.out.println("Highest Common Factor is : "+findHighestCommonFactor(inputArray));
				//log.info("Highest Common Factor is : {} for the input array {}",findHighestCommonFactor(inputArray), Arrays.toString(inputArray));
			}
		}
		catch(InvalidArrayInputException | NoCommonFactorException ex )
		{
			System.out.println(ex.getMessage());
			//log.error(" Exception : {}",ex );
		}
		catch(Exception ex )
		{
			System.out.println(ex.getMessage());
			//log.error(" Exception : {}",ex );
		}
		
	}
	
	private static Integer findHighestCommonFactor(Integer [] inputArrayparam) throws NoCommonFactorException
	{
		Stream<Integer> arrayStream = Arrays.stream(inputArrayparam);
		int minElement = arrayStream.min(Integer::compare).get();
		
		List<Integer> results = Arrays.stream(inputArrayparam).filter(element -> element % minElement != 0).collect(Collectors.toList());
		
		if(Optional.ofNullable(results).isPresent() &&  Integer.compare(results.size(),0) > 0) 
		{
			System.out.println("Array elements not divisable by the potential HCF : "+results);
			throw new NoCommonFactorException("Array elements have different multiples, Highest Common Factor cannot be determined");
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
