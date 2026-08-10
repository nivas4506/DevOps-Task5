package com.example.duplication;

import java.util.List;

public class OrderProcessor {

    public double processOrder(double amount, String customerType, List<String> items) {
        // Validation Block (Duplicated in InvoiceProcessor and processPriorityOrder)
        if (amount <= 0) {
            System.out.println("Invalid amount provided: " + amount);
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (customerType == null || customerType.trim().isEmpty()) {
            System.out.println("Invalid customer type: null or empty");
            throw new IllegalArgumentException("Customer type cannot be empty");
        }
        if (items == null || items.isEmpty()) {
            System.out.println("Item list is empty");
            throw new IllegalArgumentException("Items list cannot be empty");
        }

        // Discount & Tax Calculation Block (Duplicated in InvoiceProcessor and processPriorityOrder)
        double discount = 0.0;
        if (customerType.equalsIgnoreCase("VIP")) {
            discount = amount * 0.20;
        } else if (customerType.equalsIgnoreCase("PREMIUM")) {
            discount = amount * 0.15;
        } else if (customerType.equalsIgnoreCase("REGULAR")) {
            discount = amount * 0.05;
        } else {
            discount = 0.0;
        }

        double taxableAmount = amount - discount;
        double stateTax = taxableAmount * 0.075;
        double federalTax = taxableAmount * 0.025;
        double totalTax = stateTax + federalTax;
        double shippingFee = 15.00;
        
        if (taxableAmount > 500.0) {
            shippingFee = 0.0;
        }

        double finalTotal = taxableAmount + totalTax + shippingFee;

        // Logging & Formatting Block (Duplicated in InvoiceProcessor and processPriorityOrder)
        System.out.println("=========================================");
        System.out.println("Processing Summary for Customer: " + customerType);
        System.out.println("Base Amount: $" + String.format("%.2f", amount));
        System.out.println("Discount Applied: $" + String.format("%.2f", discount));
        System.out.println("Taxable Amount: $" + String.format("%.2f", taxableAmount));
        System.out.println("Total Tax: $" + String.format("%.2f", totalTax));
        System.out.println("Shipping Fee: $" + String.format("%.2f", shippingFee));
        System.out.println("Final Calculated Total: $" + String.format("%.2f", finalTotal));
        System.out.println("=========================================");

        return finalTotal;
    }

    public double processPriorityOrder(double amount, String customerType, List<String> items) {
        // Internal Duplication - Exact same code block inside same class
        if (amount <= 0) {
            System.out.println("Invalid amount provided: " + amount);
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (customerType == null || customerType.trim().isEmpty()) {
            System.out.println("Invalid customer type: null or empty");
            throw new IllegalArgumentException("Customer type cannot be empty");
        }
        if (items == null || items.isEmpty()) {
            System.out.println("Item list is empty");
            throw new IllegalArgumentException("Items list cannot be empty");
        }

        double discount = 0.0;
        if (customerType.equalsIgnoreCase("VIP")) {
            discount = amount * 0.20;
        } else if (customerType.equalsIgnoreCase("PREMIUM")) {
            discount = amount * 0.15;
        } else if (customerType.equalsIgnoreCase("REGULAR")) {
            discount = amount * 0.05;
        } else {
            discount = 0.0;
        }

        double taxableAmount = amount - discount;
        double stateTax = taxableAmount * 0.075;
        double federalTax = taxableAmount * 0.025;
        double totalTax = stateTax + federalTax;
        double shippingFee = 15.00;
        
        if (taxableAmount > 500.0) {
            shippingFee = 0.0;
        }

        double finalTotal = taxableAmount + totalTax + shippingFee;

        System.out.println("=========================================");
        System.out.println("Processing Summary for Customer: " + customerType);
        System.out.println("Base Amount: $" + String.format("%.2f", amount));
        System.out.println("Discount Applied: $" + String.format("%.2f", discount));
        System.out.println("Taxable Amount: $" + String.format("%.2f", taxableAmount));
        System.out.println("Total Tax: $" + String.format("%.2f", totalTax));
        System.out.println("Shipping Fee: $" + String.format("%.2f", shippingFee));
        System.out.println("Final Calculated Total: $" + String.format("%.2f", finalTotal));
        System.out.println("=========================================");

        return finalTotal;
    }
}
