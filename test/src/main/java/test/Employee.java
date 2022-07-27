package test;

public class Employee {
	
	 private String ID;
	    private String name;

	 
	    public Employee(String ID, String name) {
	         this.ID = ID;
	         this.name = name;
	    }
	 
	    @Override
	    public String toString() {
	         return "<" + ID + ", " + name + ">";
	    }
	    
}
