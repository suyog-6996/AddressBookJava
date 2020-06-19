import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;

public class AddressBook{

        private ArrayList<Person> personArray;
        public Scanner sc = new Scanner(System.in);

        public AddressBook(){
                personArray = new ArrayList<Person>();
        }

        public void readData()throws Exception{
                try{
                        FileInputStream fileinputstream = new FileInputStream("AddressBOOK.txt");
                        DataInputStream in = new DataInputStream(fileinputstream);
                        BufferedReader bufferreader = new BufferedReader(new InputStreamReader(in));
                        String data;
                        while ((data = bufferreader.readLine()) != null)   {
                        	 String[] s = data.split("\t");
                             Person person = new Person( s[0], s[1], s[2], s[3], Long.parseLong(s[4]), Long.parseLong(s[5]));
                             personArray.add(person);
                        personArray.add(person);
                    }
                }catch (Exception ex){
                }
        }

        public Person takeUserInput()
        {
                System.out.print("\n Enter Person First Name: ");
                String firstName = sc.next();
                System.out.print("Enter Person Last Name: ");
                String lastName = sc.next();
                System.out.print("Enter Address: ");
                String address = sc.next();
                System.out.print("Enter State: ");
                String state = sc.next();
                System.out.print("Enter the Zip Code: ");
                long zipCode = sc.nextLong();
                System.out.print("Enter the Phone Number: ");
                long phoneNumber = sc.nextLong();
                Person person = new Person( firstName, lastName, address, state, zipCode, phoneNumber);
                return person;
        }

        public void addPerson(){
                Person person = takeUserInput();
                personArray.add(person);
        }

        public int getPersonIndex(String name){
                int count = 0;
                while(count < personArray.size()){
                        if((personArray.get(count).firstName).equals(name)){
                                return count;
                        }
                        count++;
                }
                return count;
        }

        public void editPerson(){
                System.out.println("\n Enter name of person you want to Edit: ");
                String name = sc.next();
                int count = 0;
                count = getPersonIndex(name);
                if (count < personArray.size()){
                        personArray.get(count).readEntry();
                        Person person = takeUserInput();
                        personArray.set(count, person);
                        personArray.get(count).readEntry();
                        return;
                }
                System.out.println("Required Contact Missing");

        }

        public void displayData(){
                for (int i=0; i<personArray.size(); i++){
                        System.out.println();
                        personArray.get(i).readEntry();
                }
        }

        public void deletePerson(){
                System.out.println("\n Enter the name of person you want to Delete: ");
                String name = sc.next();
                int count = 0;
                count = getPersonIndex(name);
                if (count < personArray.size()){
                        personArray.remove(count);
                        return;
                }
                System.out.println("Required Contact Missing");
        }

        public void sort(int n){
                for (int i = 0; i<personArray.size(); i++)
                {
                for (int j = 0; j<personArray.size(); j++)
                {
                switch(n)
                {
                case 1:
                if (personArray.get(i).firstName.compareToIgnoreCase(personArray.get(j).firstName)<0)
            {
                Person temp = personArray.get(i);
        personArray.set(i, personArray.get(j));
        personArray.set(j, temp);
        }
                                                break;
                case 2:
                    if ( personArray.get(i).zipCode < personArray.get(j).zipCode)
                {
                Person temp = personArray.get(i);
        personArray.set(i, personArray.get(j));
        personArray.set(j, temp);
                }
                                                break;
                }
                }
                }
            }

        public void sortAddressBook()
        {
                System.out.println("Enter your sorting Preference:");
                int Preference = 0;
                System.out.println("1) Sort by Name \n2) Sort by ZipCode");
                Preference = sc.nextInt();
                sort(Preference);
        }

        public void save()throws IOException
        {
                FileWriter writer = new FileWriter("output.txt");
                for(int i=0; i<personArray.size(); i++)
                {
                        writer.write(personArray.get(i).writePerson()+System.lineSeparator());
                }
                writer.close();
        }

			public void searchPerson() throws IOException 
	        {
	            String name;
	            Scanner sc = new Scanner(System.in);
	            try{
	                System.out.println("Enter person name you want to search : ");
	                name = sc.nextLine();
	                int count = 0;
	                count = getPersonIndex(name);
	                for (int i=0; i<personArray.size(); i++)
	                {
	                    if (count < personArray.size())
	                    {
	                        System.out.println();
	                        personArray.get(count).readEntry();
	                        break;
	                    }
	                    System.out.println("Required Contact Missing");
	                }
	            }

	            catch (Exception e) {
	                System.out.println("Contact Missing");
	            }
	            }
	        }
