import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class IOTesting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("text.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("text.txt"),true));
        writeToFile(bufferedWriter);
        readFromFile(new File("text.txt"));



    }
    // write data to the file
    public static void writeToFile(BufferedWriter bufferedWriter) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        String fullName = ((firstName.trim()).replaceAll("\\s+", "") + " " + (lastName.trim()).replaceAll("\\s+", "")).toLowerCase();
        int latestId = getIdFromFile(new File("text.txt"));
        bufferedWriter.write(++latestId + " " + fullName + "\n" );
        bufferedWriter.close();
    }


    //read all data from file
    public static void readFromFile(File file) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(" ");
            System.out.println(Arrays.toString(arr));
        }
        bufferedReader.close();
    }

    //get latest id from file
    public static int getIdFromFile(File file) throws IOException {
        int utilId = 0;
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(" ");
            utilId = Integer.parseInt(arr[0]);
        }
        bufferedReader.close();
        return utilId;

    }
}
