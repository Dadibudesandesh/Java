import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

class Car {

    private String carid;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carid, String brand, String model, double basePricePerDay) {
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carid;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return rentalDays * basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

class Customer {

    private String custId;
    private String name;
    private String gender;
    private long phoneNo;
    private String Address;

    public Customer(String custId, String name, String gender, long phoneNo) {
        this.custId = custId;
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.Address = Address;
    }

    public String getCustId() {
        return custId;
    }

    public String getname() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return Address;
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

}

class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);

    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not availabe for rent");
        }
    }

    public void returnCar(Car car) {
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returened successfully.");
        } else {
            System.out.println("Car was not rented.");
        }
        car.returnCar();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------- Car Rental System ---------------------");
            System.out.println("1] Rent a Car");
            System.out.println("2] Return a Car");
            System.out.println("3] Exit");
            System.out.print("\n\nEnter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n\n-------- Rent a Car ---------\n");
                    System.out.print("Enter your name : ");
                    String custName = sc.nextLine();
                    System.out.print("Enter your gender : ");
                    String gender = sc.nextLine();
                    System.out.print("Enter your Mobile number : ");
                    long phoneNo = sc.nextLong();
                    // System.out.print("Enter your address : ");
                    // String Address = sc.nextLine();

                    System.out.println("\n\nAvailable Cars =>> \n");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCarId() + "  " + car.getBrand() + "  " + car.getModel());
                        }
                    }

                    System.out.print("\nEnter the car ID you want to rent : ");
                    String carId = sc.nextLine();

                    System.out.print("\nEnter the number of days for rental : ");
                    int days = sc.nextInt();
                    sc.nextLine();

                    // Customer newCustomer=new Customer(custId,name,gender,phoneNo, Address);
                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), custName, gender, phoneNo);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && car.isAvailable()) {

                            selectedCar = car;
                            break;

                        }
                    }

                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(days);
                        System.out.println("\n ---- Rental Information ----\n");
                        System.out.print("Customer ID : " + newCustomer.getCustId());
                        System.out.print("Customer Name : " + newCustomer.getname());
                        System.out.print("Car : " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.print("Rental Days : " + days);
                        System.out.print("Total Rent : " + totalPrice + " Rs");
                        System.out.print("Confirm rental (Y/N) : ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, days);
                            System.out.println("\n Car rented successfully.");
                        } else {
                            System.out.println("\n Invalid car selection or car not available for rent.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n\n ----- Return a Car -----\n");
                    System.out.println("Enter the car ID you want to return : ");
                    String verifyCarId = sc.nextLine();

                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(verifyCarId) && !car.isAvailable()) {
                            carToReturn = car;
                            break;
                        }
                    }

                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;

                            }

                        }

                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by " + customer.getname());
                        } else {
                            System.out.println("Car was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid car Id or car is not rented.");
                    }
                case 3:
                    System.out.println("Thanks for using car rental system.");
                    System.out.println("\nCome again.....");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001", "Mahindra", "Thar", 1500);
        Car car2 = new Car("C002", "Toyota", "Fortuner", 2000);
        Car car3 = new Car("C003", "Mahindra", "Scorpio", 1700);
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);

        carRentalSystem.menu();

    }
}