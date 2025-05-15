# Car Dealership

## Description of the Project

The Car Dealership Application is a console-based dealership management application designed for use by sales personnel at a car dealership. 
It provides a simple interface for viewing, searching, adding, and removing vehicles from the dealership's inventory. 
Users can filter vehicles based on price, make/model, year, color, mileage, or type. The inventory is stored in a pipe-delimited file, ensuring that all changes (such as adding or removing vehicles) are saved persistently. This lightweight system is ideal for managing vehicle listings directly from a desktop environment.


## User Stories

- As a user,
  I want to view a list of all available vehicles in the dealership.

- As user,
  I want to find vehicles within a specific price range.

- As a user, I want to add a new vehicle to the inventory.

- As a user, I want to remove a vehicle that has been sold.

- As a user, I want to find vehicles by make and model.
## Setup

1. Clone the Repository
    1. git clone https://github.com/sharad101/CarDealership.git
    2. cd financial-ledger-tracker
   

2. Open/Launch in IntelliJ IDEA
   Launch IntelliJ IDEA
    1. Click File > Open
   2. Select the project folder you just cloned


3. Configure Project
   1. Go to File > Project Structure


4. Build and Run the Project
   1. Open the main class file (Program.java)
   2. Right-click on it and select Run 'Program.main()'


### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.

## Technologies Used

- Java 17

## Demo

![car.gif](car.gif)

## Interesting Code

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

This method demonstrates how to cleanly and effectively display a formatted table of data in a console application, mimicking a UI-like experience within plain text. 
Using System.out.printf() with formatted width fields creates clear, aligned columns, which is uncommon in beginner-level console apps but makes a huge difference in usability and readabilty.
## Resources

List resources such as tutorials, articles, or documentation that helped you during the project.

- Raymond's Notes
- Potato Sensei


## Thanks

Express gratitude towards those who provided help, guidance, or resources:

- Thank you to Raymond for continuous support and guidance.

 