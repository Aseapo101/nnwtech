package za.co.nnwtech.question.two.jsonparser.dto;

public class PostalAddressDto implements Addressable{

	String city;
	String postalCode;
	String country;
	
	public PostalAddressDto() {}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
