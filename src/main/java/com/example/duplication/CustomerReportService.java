package com.example.duplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerReportService {

    // Maintainability Code Smell: Public field instead of private with getter
    public String serviceName = "ReportService";


    public void generateReport(String filePath, int reportType, boolean flag1, boolean flag2, boolean flag3) {
        // Code Smell: High Cognitive Complexity & Nested If Statements
        if (filePath != null) {
            if (!filePath.isEmpty()) {
                if (reportType > 0) {
                    if (reportType < 100) {
                        if (flag1) {
                            if (flag2) {
                                if (flag3) {
                                    System.out.println("Processing report for flags 1, 2, 3");
                                } else {
                                    System.out.println("Flag 3 is false");
                                }
                            } else {
                                System.out.println("Flag 2 is false");
                            }
                        } else {
                            System.out.println("Flag 1 is false");
                        }
                    }
                }
            }
        }

        // Maintainability Issue: Swallowing exception with empty catch block
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath != null ? filePath : "dummy.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Code Smell: String concatenation in loop instead of StringBuilder
                String processedLine = line + " - PROCESSED";
                System.out.println(processedLine);
            }
            reader.close();
        } catch (IOException e) {
            // Empty catch block - severe maintainability code smell
        } catch (NullPointerException e) {
            // Empty catch block - severe maintainability code smell
        }


        // Magic numbers & poor naming
        int x = 86400; // Magic number for seconds in a day
        int y = 3600; // Magic number for seconds in an hour
        int z = x + y * 24;
        System.out.println("Calculated time value: " + z);
    }
}
