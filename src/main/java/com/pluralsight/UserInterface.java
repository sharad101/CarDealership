package com.pluralsight;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    private DealershipFileManager dealershipFileManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.dealershipFileManager = new DealershipFileManager();
    }

    private void init() {
        this.dealership = dealershipFileManager.getDealership();
        if (this.dealership == null) {
            System.out.println("Error: Could not load dealership data.");
            System.exit(1);
        }
    }

    public void display() {
        init();
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String command = scanner.nextLine();
            processChoice(command);
        }
    }

    private void displayMenu() {
        System.out.println("\n===== " + dealership.getName() + " =====");
        System.out.println("1. View all vehicles");
        System.out.println("2. Add a vehicle");
        System.out.println("3. Remove a vehicle");
        System.out.println("4. Find vehicles within a price range");
        System.out.println("5. Find vehicles by make/model");
        System.out.println("6. Find vehicles by year range");
        System.out.println("7. Find vehicles by color");
        System.out.println("8. Find vehicles by mileage range");
        System.out.println("9. Find vehicles by type");
        System.out.println("10. Save and exit");
        System.out.print("Enter your choice: ");
    }

    private void processChoice(String choice) {
        switch (choice) {
            case "1":
                processAllVehiclesRequest();
                break;
            case "2":
                processAddVehicleRequest();
                break;
            case "3":
                processRemoveVehicleRequest();
                break;
            case "4":
                processGetByPriceRequest();
                break;
            case "5":
                processGetByMakeModelRequest();
                break;
            case "6":
                processGetByYearRequest();
                break;
            case "7":
                processGetByColorRequest();
                break;
            case "8":
                processGetByMileageRequest();
                break;
            case "9":
                processGetByVehicleTypeRequest();
                break;
            case "10":
                processSaveAndExitRequest();
                break;
            default:
                System.out.println("Invalid command. Please try again.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-5s %-5s %-10s %-10s %-10s %-10s %-10s %s\n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("---------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-5d %-5d %-10s %-10s %-10s %-10s %-10d $%.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());
        }
        System.out.println("--------------------------------------------------");
    }

    public void processAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processAddVehicleRequest() {
        System.out.println("\nEnter vehicle details:");
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        dealershipFileManager.saveDealership(dealership); // Save changes
        System.out.println("Vehicle added successfully.");
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vinToRemove = Integer.parseInt(scanner.nextLine());
        List<Vehicle> inventory = dealership.getAllVehicles(); //get the current inventory
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinToRemove) {
                dealership.removeVehicle(vinToRemove);
                dealershipFileManager.saveDealership(dealership);  //save
                System.out.println("Vehicle removed successfully.");
                return; // exit the method after successful removal
            }
        }
        System.out.println("Vehicle with given VIN not found."); //if the vehicle is not found
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int maxYear = Integer.parseInt(scanner.nextLine());
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processSaveAndExitRequest() {
        dealershipFileManager.saveDealership(dealership);
        System.out.println("Dealership data saved. Exiting application.");
        scanner.close();
    }
}
