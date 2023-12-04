import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class JasminCompiler {
    public static void main(String[] args) throws Exception {
        File directory = new File("src/JasminFiles"); // replace with your directory path

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(); // List all files in the directory

            if (files != null) { // Make sure the list is not null
                for (File file : files) {
                    boolean deleted = file.delete(); // Delete each file
                }
            }
        }
        directory = new File("src/JasminFiles/JavaClasses"); // replace with your directory path

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(); // List all files in the directory

            if (files != null) { // Make sure the list is not null
                for (File file : files) {
                    boolean deleted = file.delete(); // Delete each file
                }
            }
        }

        CodeGenTest.main(args);

        File jasminDir = new File("src/JasminFiles");
        File[] files = jasminDir.listFiles((dir, name) -> name.endsWith(".j")); // Assuming .j is the extension

        for (File file : files) {
            try {
                // Construct the jasmin command
                String command = "jasmin " + "src/JasminFiles/" + file.getName() + " -d src/JasminFiles/JavaClasses";

                // Execute the jasmin command
                Process jasminProcess = Runtime.getRuntime().exec(command);

                // Wait for the jasmin process to complete
                jasminProcess.waitFor();

                // Construct the java command


            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        Process javaProcess = Runtime.getRuntime().exec("java -cp src/JasminFiles/JavaClasses MainClass");

        // Read the output from the java process
        BufferedReader reader = new BufferedReader(new InputStreamReader(javaProcess.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}