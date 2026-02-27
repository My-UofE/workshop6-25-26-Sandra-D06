import java.io.*;

public class Checked1App{
    public static void main(String[] args) throws IOException {
        System.out.println("### Enter main() ...");

        String fileName = args[0];

        readTxtFile(fileName);
        
        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName) throws IOException {
        System.out.println("### Enter readTxtFile() ...");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;

        line = String.format("Contents of '%s'", fileName);
        while(line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        System.out.println("### Exit readTxtFile()!");
    }
}