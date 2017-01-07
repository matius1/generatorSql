
public class Address {

	private int custID;
	private String city;
	private String postcode;
	private String street;
	private String number;
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode() {
		this.postcode = generatePostCode();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Address(int custID, String city, String postcode, String street, String number) {
		this.custID = custID;
		this.city = city;
		this.postcode = postcode;
		this.street = street;
		this.number = number;
	}
	public Address() {

	}
	@Override
	public String toString() {
		return "Address [custID=" + custID + ", city=" + city + ", postcode=" + postcode + ", street=" + street
				+ ", number=" + number + "]";
	}
	
	public String sqlQeury() {
		return "\"" + custID + "\", \"" + city + "\", \"" + postcode + "\", \"" + street + "\",\"" + number + "\"";

	}
	
	
	public String generatePostCode(){
		String post = null;
		post = Integer.toString(randBetween(10, 98)) + "-";
		return post += Integer.toString(randBetween(100, 999));
	}
	
	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	
	
}
