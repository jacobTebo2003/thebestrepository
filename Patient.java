
//Create Patient Class to accept user info from patientdriverapp
  public class Patient
    {

		private String firstName;
		private String middleName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String zipcode;
		private String phoneNumber;
		private String emergencyContactName;
		private String emergencyContactPhone;
		private String fullName;
		private String fullAddress;
		private String emergContact;
	
		       //No arg constructor returns blank
		       public Patient()
		       {
		           firstName = "";
		           middleName = "";
		           lastName = "";
		           address = "";
		           city = "";
		           state = "";
		           zipcode = "";
		           emergencyContactName = "";
		           emergencyContactPhone = "";
		          
		       }
		      
		       //Constructor with parametrized values for names
		       public Patient(String firstName, String middleName, String lastName)
		       {
		    		this.firstName = firstName;
					this.middleName = middleName;
					this.lastName = lastName;
		       }
		      
		       //Constructor setting all attributes for the patient
		       public Patient(String firstName, String middleName, String lastName, String address, String city, String state,
						String zipcode,  String emergencyContactName, String emergencyContactPhone)
		       {
		    		this.firstName = firstName;
					this.middleName = middleName;
					this.lastName = lastName;
					this.address = address;
					this.city = city;
					this.state = state;
					this.zipcode = zipcode;
					this.emergencyContactName = emergencyContactName;
					this.emergencyContactPhone = emergencyContactPhone;
		       }
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirst(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddle(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLast(String lastName) {
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
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZip(String zipcode) {
			this.zipcode = zipcode;
		}
		public String getEmerName() {
			return emergencyContactName;
		}
		public void setEmerName(String emergencyContactName) {
			this.emergencyContactName = emergencyContactName;
		}
		public String getEmergencyContactPhone() {
			return emergencyContactPhone;
		}
		public void setEmerPhone(String emergencyContactPhone) {
			this.emergencyContactPhone = emergencyContactPhone;
		}
	 
		
      	
      	//public static String buildFullName(String userFirstName, String userMiddlename,String userLastname) {
		public void buildFullName() 
		{
			fullName = this.firstName + " " + this.middleName + " " + this.lastName;
 
		}
	       	       
	    //Send the address variables to build address       
        public void buildAddress()
        {
        	fullAddress = this.address + " " + this.city + " " + this.state + " " +
        	zipcode;
        
       
        }
	           
	       
	    //Send the emergency contact variables to build emer contact
	    public void buildEmergencyContact()
	    {
	    	emergContact = ( emergencyContactName + " " + emergencyContactPhone);
	   
	    }
	         
	    //String fullAddress = buildAddress(address,city,state,zipcode);
	    //String emergContact = buildEmergencyContact(emergencyContactName,emergencyContactPhone);
	          	
	          	
		@Override
		public String toString() {
			buildFullName();
			buildAddress();
			buildEmergencyContact();
			return "Patient info: \n" + "  Name: " + this.fullName + "\n " + " Address: " + this.fullAddress + "\n" +
					"  Emergency Contact: " + this.emergContact;
		}
		
		
	}

