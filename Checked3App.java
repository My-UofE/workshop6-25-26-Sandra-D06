import java.io.*;

public class Checked3App{
    public static void main(String[] args) {
        System.out.println("### Enter main() ...");

        String fileName = args[0];

        readTxtFile(fileName);
        
        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName) {
        System.out.println("### Enter readTxtFile() ...");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = String.format("Contents of '%s'", fileName);
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("### FileNotFoundException caught");
            System.out.println("### message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("### IOException caught");
            System.out.println("### message: " + e.getMessage());
        }

        System.out.println("### Exit readTxtFile()!");
    }
}