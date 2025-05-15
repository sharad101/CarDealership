package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class DealershipFileManager {
        public Dealership getDealership() {
            try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {
                // Read dealership info from first line
                String dealershipLine = br.readLine();
                String[] dealershipInfo = dealershipLine.split("\\|");
                String name = dealershipInfo[0];
                String address = dealershipInfo[1];
                String phone = dealershipInfo[2];

                // Create dealership
                Dealership dealership = new Dealership(name, address, phone);

                // Read vehicle info
                String vehicleLine;
                while ((vehicleLine = br.readLine()) != null) {
                    String[] vehicleInfo = vehicleLine.split("\\|");
                    int vin = Integer.parseInt(vehicleInfo[0]);
                    int year = Integer.parseInt(vehicleInfo[1]);
                    String make = vehicleInfo[2];
                    String model = vehicleInfo[3];
                    String vehicleType = vehicleInfo[4];
                    String color = vehicleInfo[5];
                    int odometer = Integer.parseInt(vehicleInfo[6]);
                    double price = Double.parseDouble(vehicleInfo[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }

                return dealership;
            } catch (Exception e) {
                System.out.println("Error reading file");
                return null;
            }
        }

        public void saveDealership(Dealership dealership) {
            try (FileWriter writer = new FileWriter("inventory.csv")) {
                // Write dealership information as the first line
                writer.write(dealership.toString() + "\n");

                // Write each vehicle on a separate line
                List<Vehicle> vehicles = dealership.getAllVehicles();
                for (Vehicle vehicle : vehicles) {
                    writer.write(vehicle.toString() + "\n");
                }

                System.out.println("Dealership data saved successfully!");
            } catch (Exception e) {
                System.out.println("Error saving dealership data");
            }
        }
    }

