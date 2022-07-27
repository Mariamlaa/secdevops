package test;

public class User {
	
    private String fullname;
    private String email;
    private String password;
    private String ref;
    
	
	
	public User(String fullname, String email, String password, String ref) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.ref = ref;
	}
	
	public User() {
		
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
    
    

}
