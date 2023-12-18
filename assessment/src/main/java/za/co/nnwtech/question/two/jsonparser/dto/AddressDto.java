package za.co.nnwtech.question.two.jsonparser.dto;

import za.co.nnwtech.question.two.enums.AddressTypeEnum;

public class AddressDto 
{

	private AddressTypeEnum addressType;
	private Addressable addressDetail;
	public AddressTypeEnum getAddressType() 
	{
		return addressType;
	}
	public void setAddressType(AddressTypeEnum addressType) {
		this.addressType = addressType;
	}
	public Addressable getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(Addressable addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	
}
