import java.util.ArrayList;
import java.util.Scanner;

public class TwoDSearch {
    public static void main(String[] args) {

        ArrayList<Person> personArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner, personArrayList);

    }

    public static void mainMenu(Scanner scanner, ArrayList<Person> personArrayList){

        int choice;
        do {
            System.out.println("1.Add Person");
            System.out.println("2.View Persons");
            System.out.println("3.update Person");
            System.out.println("4.Delete Person");
            System.out.println("5.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPerson(scanner, personArrayList);
                    break;
                case 2:
                    showPerson(personArrayList);
                    break;
                case 3:
                    updatePerson(scanner,personArrayList);
                    break;
                case 4:
                    deletePerson(scanner, personArrayList);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("!!!Invalid Input!!!");
            }
        }while (choice !=5);



    }


    public static void addPerson(Scanner scanner, ArrayList<Person> personArrayList){
        System.out.print("Enter First Name: ");
        String fName = scanner.next();
        System.out.print("Enter Last Name: ");
        String lName = scanner.next();
        System.out.print("Enter Phone Number: ");
        String Phone = scanner.next();
        personArrayList.add(new Person(fName,lName,Phone));
        System.out.println("Person added successfully.\n");
    }

    public static void showPerson(ArrayList<Person> personArrayList){
        if(!personArrayList.isEmpty()) {
            int i = 0;
            for (Person person: personArrayList){
            System.out.println( ++i +": "+person.getfName() +" | "+ person.getlName() +" | "+ person.getPhone());
            }
        }else{
            System.out.println("No Person available!");
        }
    }
    public static void updatePerson(Scanner scanner, ArrayList<Person> personArrayList){
        int choice;
        do{
            System.out.println("1. Update First Name.");
            System.out.println("2. Update Last Name.");
            System.out.println("3. Update Phone No.");
            System.out.println("4. exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    updateSpecific(scanner,"fName", personArrayList);
                    break;
                case 2:
                    updateSpecific(scanner,"lName", personArrayList);
                    break;
                case 3:
                    updateSpecific(scanner,"phone", personArrayList);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("invalid input!!!");
            }
        }while(choice != 4);

    }
    public static void updateSpecific(Scanner scanner, String spec, ArrayList<Person> personArrayList) {
        if (spec.equals("fName")) {
            System.out.print("Enter previous first Name: ");
            String updatedFName = scanner.next();
            for (Person person : personArrayList) {
                if (updatedFName.equals(person.getfName())){
                    System.out.print("Enter name to update: ");
                    person.setfName(scanner.next());
                    System.out.println("Updated successfully.");
                }else {
                    System.out.println("Person not found!!!");
                }
                return;

            }
        }else if (spec.equals("lName")){
            System.out.print("Enter previous Last Name: ");
            String updatedLName = scanner.next();
            for (Person person : personArrayList) {
                if (updatedLName.equals(person.getlName())){
                    System.out.print("Enter last name to update: ");
                    person.setlName(scanner.next());
                    System.out.println("Updated successfully.");
                }else {
                    System.out.println("Person not found!!!");
                }
                return;

            }
        }else if (spec.equals("phone")){
            System.out.print("Enter previous phone number: ");
            String phone = scanner.next();
            for (Person person : personArrayList) {
                if (phone.equals(person.getPhone())){
                    System.out.print("Enter phone to update: ");
                    person.setPhone(scanner.next());
                    System.out.println("Updated successfully.");
                }else {
                    System.out.println("Person not found!!!");
                }
                return;

            }
        }
    }


    public static void deletePerson(Scanner scanner, ArrayList<Person> personArrayList){
        System.out.print("Enter First name: ");
        String fName = scanner.next();
        System.out.print("Enter last name: ");
        String lName = scanner.next();

        for (Person person : personArrayList) {
            if (fName.equals(person.getfName()) && lName.equals(person.getlName())){
                personArrayList.remove(person);
                System.out.println("Person deleted successfully.");
            }else {
                System.out.println("Person not found!!!");
            }
            return;

        }
    }
}

























