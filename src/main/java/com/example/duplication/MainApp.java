package com.example.duplication;

import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Starting Java Duplication and Maintainability Demo...");

        OrderProcessor orderProcessor = new OrderProcessor();
        InvoiceProcessor invoiceProcessor = new InvoiceProcessor();
        CustomerReportService reportService = new CustomerReportService();

        List<String> items = Arrays.asList("Laptop", "Mouse", "Keyboard");

        double orderTotal = orderProcessor.processOrder(1200.00, "VIP", items);
        double priorityTotal = orderProcessor.processPriorityOrder(1200.00, "VIP", items);
        double invoiceTotal = invoiceProcessor.generateInvoice(1200.00, "VIP", items);

        reportService.generateReport(null, 50, true, true, true);

        System.out.println("Execution completed.");
        System.out.println("Order total: " + orderTotal);
        System.out.println("Priority total: " + priorityTotal);
        System.out.println("Invoice total: " + invoiceTotal);
    }
}
