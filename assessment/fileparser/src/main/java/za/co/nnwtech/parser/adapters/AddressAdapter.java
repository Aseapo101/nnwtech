package za.co.nnwtech.parser.adapters;

public class AddressAdapter 
{
	public TypeAdapter type;
	public String postalCode;
	public String lastUpdate; //use date type
	public String CityOrTown;
	public ProvinceOrStateAdapter province;
	public CountryAdapter country;
	public AddressLineAdapter addressLineAdapter;
	
	
	public TypeAdapter getType() {
		return type;
	}
	public void setType(TypeAdapter type) {
		this.type = type;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCityOrTown() {
		return CityOrTown;
	}
	public void setCityOrTown(String cityOrTown) {
		CityOrTown = cityOrTown;
	}
	public ProvinceOrStateAdapter getProvince() {
		return province;
	}
	public void setProvince(ProvinceOrStateAdapter province) {
		this.province = province;
	}
	public CountryAdapter getCountry() {
		return country;
	}
	public void setCountry(CountryAdapter country) {
		this.country = country;
	}
	public AddressLineAdapter getAddressLineAdapter() {
		return addressLineAdapter;
	}
	public void setAddressLineAdapter(AddressLineAdapter addressLineAdapter) {
		this.addressLineAdapter = addressLineAdapter;
	}
	
	
}
