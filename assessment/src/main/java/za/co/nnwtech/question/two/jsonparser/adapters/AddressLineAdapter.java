package za.co.nnwtech.question.two.jsonparser.adapters;

public class AddressLineAdapter
{

	public String LineOne;
	public String LineTwo;
	
	public AddressLineAdapter (String... param) 
	{
		
	}

	public String getLineOne() {
		return LineOne;
	}

	public void setLineOne(String lineOne) {
		LineOne = lineOne;
	}

	public String getLineTwo() {
		return LineTwo;
	}

	public void setLineTwo(String lineTwo) {
		LineTwo = lineTwo;
	}
	
	
}
