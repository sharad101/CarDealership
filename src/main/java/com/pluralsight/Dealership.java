package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    // Constructor for Dealership class
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Initialize empty inventory
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    // Add a vehicle to the dealership's inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }


    // Get all vehicles in the inventory
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    //Find vehicles within a specific price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Find vehicles by make and model

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Find vehicles within a year range
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Find vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }


    // Find vehicles within a mileage range
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }


    // Find vehicles by vehicle type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Remove a vehicle from inventory
    public void removeVehicle(int vin) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getVin() == vin) {
                inventory.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s", name, address, phone);
    }
}
