//Create Patient Class to accept user info from patientdriverapp
  public class Procedure
    {
        //Private fields for userName
	 	private String name;
    	private String date;
    	private String practitioner;
    	private double charge;
        
        //constructors are below:
        
        //No arg constructor returns blank 
        public Procedure()
        {
            name = "";
           
            date = "";
          
            practitioner = "";
        
            charge = 0;
        }
        
        //Constructor with parametrized values for names
        public Procedure(String name,  String date)
        {
        	this.name = name;
    		this.date = date;
            
        }
        
        //Constructor setting all attributes for the patient
        public Procedure(String name, String date,  String practitioner, double charge)
        {
        	this.name = name;
    		this.date = date;
    		this.practitioner = practitioner;
    		this.charge = charge;
            
        }
        
   
       	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name = name;
    	}
    	public String getDate() {
    		return date;
    	}
    	public void setDate(String date) {
    		this.date = date;
    	}
    	public String getPractitioner() {
    		return practitioner;
    	}
    	public void setPractitioner(String practitioner) {
    		this.practitioner = practitioner;
    	}
    	public double getCharge() {
    		return charge;
    	}
    	public void setCharge(double charge) {
    		this.charge = charge;
    	}
    	
    	public double getCharges() {
    		return charge;
    	}
    	@Override
    	public String toString() {
    		return "\tProcedure: " + this.name + "\n \tProcedure date: " + this.date + "\n \tPractitioner: " + this.practitioner + "\n \tCharge: " + this.charge
    				;
    	}
        
   
    }


