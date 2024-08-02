import java.io.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {

        int Id = 0;
//        File file = new File("test.txt");
//        FileWriter fileWriter = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        // same as above
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("text.txt")));

        bufferedWriter.write(Id++ + " Mohsin bhatti\n");
        bufferedWriter.write(4 + " Umar bhatti\n");
        bufferedWriter.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("text.txt")));
        String line;
        int utilId = 0;

        while ((line = bufferedReader.readLine()) != null) {
         String[] arr = line.split(" ");
          utilId = Integer.parseInt(arr[0]);
        }
        System.out.println(utilId);
        bufferedReader.close();
    // that is now working. about 70 percent is done;
    }
}
