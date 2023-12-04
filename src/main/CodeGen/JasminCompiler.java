import java.io.*;

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

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "src/JasminFiles/JavaClasses", "MainClass");
        processBuilder.redirectErrorStream(true); // объединение stdout и stderr

        Process javaProcess = processBuilder.start();

        // Создаем отдельный поток для чтения ввода пользователя и записи в стандартный ввод процесса


        Thread inputThread = new Thread(() -> {
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(javaProcess.getOutputStream()));
                BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
                String userInput;
                while ((userInput = userInputReader.readLine()) != null) {
                    writer.write(userInput);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        inputThread.start();


        // Read the output from the java process
        BufferedReader reader = new BufferedReader(new InputStreamReader(javaProcess.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(javaProcess.getErrorStream()));
        while ((line = errorReader.readLine()) != null) {
            System.err.println(line);
        }


        inputThread.interrupt();
        int exitCode = javaProcess.waitFor();

        System.out.println("\nExit Code: " + exitCode);
        System.exit(exitCode);

    }
}