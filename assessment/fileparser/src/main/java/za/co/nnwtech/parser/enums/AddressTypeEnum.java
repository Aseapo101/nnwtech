package za.co.nnwtech.parser.enums;

public enum AddressTypeEnum 
{
	BUSSINESS_ADDRESS(5),
	POSTAL_ADDRESS(2),
	PHYSICAL_ADDRESS(1);
	
	
	private int code;
	
	private AddressTypeEnum(int code) 
	{
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
