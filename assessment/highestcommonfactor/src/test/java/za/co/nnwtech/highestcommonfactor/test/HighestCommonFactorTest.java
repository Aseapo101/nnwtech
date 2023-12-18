package za.co.nnwtech.highestcommonfactor.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import za.co.nnwtech.highestcommonfactor.HighestCommonFactor;
import za.co.nnwtech.highestcommonfactor.exception.InvalidArrayInputException;
import za.co.nnwtech.highestcommonfactor.exception.NoCommonFactorException;

@Slf4j // required by Junit..
class HighestCommonFactorTest 
{

	private static List<Integer> listInput = List.of(3,6,12,15,21,30);
	private HighestCommonFactor objectRefeference = new HighestCommonFactor();

	@Test
	void test() 
	{
		
		try {
			
			assertTrue(Integer.compare(objectRefeference.findHighestCommonFactor(listInput.toArray(new Integer [listInput.size()])), 3)==0 );
			assertFalse(Integer.compare(objectRefeference.findHighestCommonFactor(listInput.toArray(new Integer [listInput.size()])), 1)==0 );
			Assertions.assertThrows(InvalidArrayInputException.class, () -> objectRefeference.findHighestCommonFactor(null));
			Assertions.assertThrows(NoCommonFactorException.class, () -> objectRefeference.findHighestCommonFactor(List.of(4,13,20).toArray(new Integer[3])));
			
		} catch (NoCommonFactorException | InvalidArrayInputException e) {
			e.printStackTrace();
		}
	}

}
