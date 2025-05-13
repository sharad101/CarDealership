package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            // Empty for now, will implement later
        }
    }

