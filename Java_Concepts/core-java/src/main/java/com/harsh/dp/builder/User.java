package com.harsh.dp.builder;

/**
 * Builder is a creational pattern.
 * used to create complex objects or objects with large number of attributes,
 * 
 * this pattern removes unnecessary complexity that stems from multiple constructors, 
 * multiple optional parameters and overuse of setters.
 * 
 * 
 *
 */
public class User {

	private String firstName; 	// required
	private String lastName; 	// required
	private int age; 			// optional
	private String phone; 		// optional
	private String address; 	// optional
	
	//parent class will have a private constructor, that will accept a builder parameter
	//and will initialize all it's attributes from builder attributes.
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	//create a static nested class and copy all the arguments from the outer class to the Builder class.
	public static class UserBuilder {
		
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		//Builder class should have a public constructor with all the required attributes as parameters.
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		/*Builder class should have methods to set the optional parameters and it should 
		 * return the same Builder object after setting the optional attribute.
		 */
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		//The final step is to provide a build() method in the builder class that will return 
		//the Object needed by client program.
		
		public User build() {
			return new User(this);
		}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
