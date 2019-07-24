package emailApp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private String email;
	private String companySuffix = "company.com";
	private String alternateEmail;
	
	private int mailboxCapacity = 500;
	private int defaultPasswordLenth = 10;
	//constructor
	public Email( String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created! "+firstName+" "+lastName);
		
		//call a method asking for department
		this.department = setDepartment();
		//System.out.println("Department: "+ department);
		
		//call method that returns random password
		this.password = randomPassword(defaultPasswordLenth);
		System.out.println("\nYour password is: "+ password);
		
		//combine elements to create email
		
		email = firstName.toLowerCase() +"."+ lastName.toLowerCase() +"@" + department +"."+ companySuffix;
		//System.out.println("Your email is: " +email);
	}
	
	//ask for department
	private String setDepartment() {
		System.out.print("Chose Department:\n1) Sales\n2) Development\n3) Accounting\n0) For none ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		
		if(depChoice  == 1) { return "sales";}
		else if(depChoice  == 2) { return "sales";}
		else if(depChoice  == 3) { return "development";}
		else { return "";}	
	}
	
	//generate password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUV1234567890!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
	
	//show the mailbox capacity
	public void setMailboxCapasity(int cap) {
		this.mailboxCapacity = cap;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//get mailbox capacity
	public int getMailboxCapacity() { return mailboxCapacity; }
	//get mailbox alternate email
	public String getAlternateEMail() { return alternateEmail; }
	//get password
	public String getPassword() { return password; }
	
	public String showInfo() {
		return ("\n"+
				"Display Name: "+ firstName+" "+lastName+"\n"+
				"Company Email: "+email+"\n"+
				"Mailbox Capacity: "+mailboxCapacity+"mb");
		
	}
}
