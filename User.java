package coursework;


public class User {
//private fields to hide it from other classes 
	private int userId;
	private String username;
	private String surname;
	private int houseNumber;
	private String postcode;
	private String city;
	private String userType;
	
	//initialises with the constructor 

	public User(int userId,String username,String surname,int houseNumber,String postcode,String city,String userType) {
		this.userId = userId;
		this.username = username;
		this.surname = surname;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.city = city;
		this.userType = userType;
	}

	//getters and setters for encapsulation to control access and modification

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public int getHouseNumber() {
			return houseNumber;
		}

		public void setHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
		}

		public String getPostcode() {
			return postcode;
		}

		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}


		public String getUserType() {
			return userType;
		}


		public void setUserType(String userType) {
			this.userType = userType;
		}

		//polymorphism to override built in toString for object
		@Override
		public String toString() {
		    return getUserId() + ", " + getUsername() + ", " + getSurname() + ", " + getHouseNumber() + ", " + getPostcode() + ", " + getCity() + ", " + getUserType();
		}


}

 		


