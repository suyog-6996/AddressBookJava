public class Person{
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public long zipCode;
	public long phoneNumber;

	public Person(String firstName, String lastName, String address, String state, long zipCode, long phoneNumber){
		this.firstName = firstName;
        	this.lastName = lastName;
        	this.address = address;
        	this.state = state;
        	this.zipCode = zipCode;
        	this.phoneNumber = phoneNumber;
	}

	public void readEntry(){
		System.out.print(firstName);
		System.out.print("\t\t"+lastName);
		System.out.print("\t\t"+address);
		System.out.print("\t\t"+state);
		System.out.print("\t\t"+zipCode);
		System.out.println("\t\t"+phoneNumber);
	}


	public String writePerson(){
		String str = firstName+"\t\t"+lastName+"\t\t"+address+"\t\t"+state+"\t\t"+zipCode+"\t\t"+phoneNumber;
		return str;
	}


	public static void main(String[] args){
		System.out.println("Welcome to Address Book");
		Person person = new Person("Suyog", "Gabhane", "Amravati", "MH" , 45425, 444215);
		person.readEntry();
		System.out.println(person.writePerson());
	}
}
