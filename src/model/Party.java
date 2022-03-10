package model;

public class Party {
	private int partyId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String country;
	private String email;
	private String password;
	private String phone;

	public Party() {
	}

	@Override
	public String toString() {
		return "Party{" + "partyId='" + partyId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", address='" + address + '\'' + ", city='" + city + '\'' + ", zip='" + zip + '\''
				+ ", state='" + state + '\'' + ", country='" + country + '\'' + ", email='" + email + '\''
				+ ", password='\" + password + '\\'' + \", phone='" + phone + '\'' + '}';
	}

	public Party(int partyId, String firstName, String lastName, String address, String city, String zip, String state,
			String country, String email, String password, String phone) {
		this.partyId = partyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return getEmail();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.phone = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
