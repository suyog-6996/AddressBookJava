import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;

public class AddressManager{
        public static void main(String[] ars)throws Exception{
                int Preference = 1;
                Scanner sc = new Scanner(System.in);
                AddressBook addressBook = new AddressBook();
                addressBook.readData();
                while(Preference != 0){
                        System.out.println("\n Select your Preference:");
                        System.out.println("1) Add Person Name \n2) Search Person Name \n3) Delete Person Name \n4) Edit Person Name \n5) Show Complete Address Book  \n6) Sort Address Book \n7) Save Address Book \n0) Exit the program");
                        Preference = sc.nextInt();
                        switch(Preference) {
                        case 1:
                              addressBook.addPerson();
                              break;
                        case 2:
                            addressBook.searchPerson();
                            break;
                        case 3:
                                addressBook.deletePerson();
                                break;
                        case 4:
                                addressBook.editPerson();
                                break;
                        case 5:
                                addressBook.displayData();
                                break;
                        case 6:
                                addressBook.sortAddressBook();
                                break;
                        case 7:
                                addressBook.save();
                                break;
                        default:System.out.println("exit...");
                                System.exit(0);
                }

        }
        }
}
