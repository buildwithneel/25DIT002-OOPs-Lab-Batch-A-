import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("logs");
        Files.createDirectories(dir);

        Files.write(dir.resolve("log1.txt"), Arrays.asList(
            "INFO: Started",
            "ERROR: File missing",
            "INFO: Completed"
        ));

        Files.write(dir.resolve("log2.txt"), Arrays.asList(
            "ERROR: Invalid input",
            "INFO: Running"
        ));

        Files.write(dir.resolve("log3.txt"), Arrays.asList(
            "INFO: Connected",
            "ERROR: Connection failed"
        ));

        int total = 0;
        int count = 0;

        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path p : files) {
                int lines = 0;

                try (BufferedReader br = Files.newBufferedReader(p)) {
                    String s;

                    while ((s = br.readLine()) != null) {
                        total++;
                        lines++;

                        if (s.contains("ERROR")) {
                            count++;
                        }
                    }
                }

                System.out.println(p.getFileName() + " Size: " + Files.size(p) + " bytes");
            }
        }

        System.out.println("Total lines: " + total);
        System.out.println("Lines containing ERROR: " + count);
    }
}