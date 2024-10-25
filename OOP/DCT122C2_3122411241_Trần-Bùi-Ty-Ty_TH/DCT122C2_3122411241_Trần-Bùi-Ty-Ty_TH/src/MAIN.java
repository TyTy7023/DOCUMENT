import java.util.ArrayList;
import java.util.Scanner;
public class MAIN {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Management management = new Management(); insertProperty(management);
        ArrayList<Property> orders = new ArrayList<Property>();
        System.out.println("\t\t-----------WELCOME TO PROPERTY MANAGEMENT SYSTEM-----------");
        int choice=1;
        while (choice!=0) {
            System.out.println("\t-------WHAT DO YOU WANT TO DO?-------");
            System.out.println("1. Display information of property");
            System.out.println("2. Buy property");
            System.out.println("3. Sell property");
            System.out.println("4. Display information of order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: "); choice=input.nextInt();
            while (choice<0 || choice>4) {
                System.out.println("Your choice is not valid!");
                System.out.print("Enter your choice again: "); choice=input.nextInt();
            }
            while(choice!=0){
                switch(choice){
                    case 1:
                        {
                            System.out.println("\n\t-----------What type of property do you want to display?-----------");
                            System.out.println("1. House");
                            System.out.println("2. Hotel");
                            System.out.println("3. Vacant Lot");
                            System.out.println("4. Villa");
                            System.out.println("0. Exit");
                            System.out.print("Enter your choice: "); choice=input.nextInt();
                            while (choice<0 || choice>4) {
                                System.out.println("Your choice is not valid!");
                                System.out.print("Enter your choice again: "); choice=input.nextInt();
                            }
                            input.nextLine();
                            switch(choice){
                                case 1:
                                    System.out.println("\n\t-----------LIST OF HOUSE-----------");
                                    Management.Manager.printHouse();
                                    break;
                                case 2:
                                    System.out.println("\n\t-----------LIST OF HOTEL-----------");
                                    Management.Manager.printHotel();
                                    break;
                                case 3:
                                    System.out.println("\n\t-----------LIST OF VACANT LOT-----------");
                                    Management.Manager.printVacantLot();
                                    break;
                                case 4:
                                    System.out.println("\n\t-----------LIST OF VILLA-----------");
                                    Management.Manager.printVilla();
                                    break;
                            }
                            choice=0;
                            System.out.println("\t\t--------FINISH DISPLAYING--------");
                            break;
                        }    
                    case 2:
                        {
                            System.out.println("\n\t-----------What type of property do you want to buy?-----------");
                            System.out.println("1. House");
                            System.out.println("2. Hotel");
                            System.out.println("3. Vacant Lot");
                            System.out.println("4. Villa");
                            System.out.println("0. Exit");
                            System.out.print("Enter your choice: "); choice=input.nextInt();
                            while (choice<0 || choice>4) {
                                System.out.println("Your choice is not valid!");
                                System.out.print("Enter your choice again: "); choice=input.nextInt();
                            }
                            String id="";
                            input.nextLine();
                            int check=0;
                            switch(choice){
                                case 1:
                                    System.out.println("\n\t-----------LIST OF HOUSE-----------");
                                    Management.Manager.printHouse();
                                    while (check==0) {
                                        System.out.print("Enter ID of house you want to buy: "); id=input.nextLine();
                                        check=Management.Manager.findProperty(id);
                                        if (check==0) 
                                            System.out.println("---------Your choice is not valid! Please check and enter again!----------");
                                    }
                                    Management.Manager.orderHouse(id, orders);
                                    break;
                                case 2:
                                    System.out.println("\n\t-----------LIST OF HOTEL-----------");
                                    Management.Manager.printHotel();
                                    while (check==0) {
                                        System.out.print("Enter ID of hotel you want to buy: "); id=input.nextLine();
                                        check=Management.Manager.findProperty(id);
                                        if (check==0) 
                                            System.out.println("---------Your choice is not valid! Please check and enter again!----------");
                                        
                                    }
                                    Management.Manager.orderHotel(id, orders);
                                    break;
                                case 3:
                                    System.out.println("\n\t-----------LIST OF VACANT LOT-----------");
                                    Management.Manager.printVacantLot();
                                    while (check==0) {
                                        System.out.print("Enter ID of vacant lot you want to buy: "); id=input.nextLine();
                                        check=Management.Manager.findProperty(id);
                                        System.out.println("---------Your choice is not valid! Please check and enter again!----------");
                                    }
                                    Management.Manager.orderVacantLot(id, orders);
                                    break;
                                case 4:
                                    System.out.println("\n\t-----------LIST OF VILLA-----------");
                                    Management.Manager.printVilla();
                                    while (check==0) {
                                        System.out.print("Enter ID of villa you want to buy: "); id=input.nextLine();
                                        check=Management.Manager.findProperty(id);
                                        System.out.println("---------Your choice is not valid! Please check and enter again!----------");
                                    }
                                    Management.Manager.orderVilla(id, orders);
                                    break;
                            }
                            System.out.println("\t\t--------SUCCESSFUL MANIPULATION--------");
                            System.out.println("\t\t---------THANK YOU---------");
                            choice=0;
                            break;
                        }
                    case 3:
                        {
                            System.out.println("\n\t-----------WHAT TYPE OF PROPERTY DO YOU WANT TO SELL ?-----------");
                            System.out.println("1. House");
                            System.out.println("2. Hotel");
                            System.out.println("3. Vacant Lot");
                            System.out.println("4. Villa");
                            System.out.println("0. Exit");
                            System.out.print("Enter your choice: "); choice=input.nextInt();
                            while (choice<0 || choice>4) {
                                System.out.println("Your choice is not valid!");
                                System.out.print("Enter your choice again: "); choice=input.nextInt();
                            }
                            switch(choice){
                                case 1:
                                    System.out.println("\n\tEnter information of house you want to sell: ");
                                    Management.Manager.addHouse();
                                    break;
                                case 2:
                                    System.out.println("\n\tEnter information of hotel you want to sell: ");
                                    Management.Manager.addHotel();
                                    break;
                                case 3:
                                    System.out.println("\n\tEnter information of vacant lot you want to sell: ");
                                    Management.Manager.addVacantLot();
                                    break;
                                case 4:
                                    System.out.println("\n\tEnter information of villa you want to sell: ");
                                    Management.Manager.addVilla();
                                    break;
                            }
                            choice=0;
                            System.out.println("\t\t--------FINISH SELLING--------");
                            System.out.println("\t\t---------THANK FOR SELLING ---------");
                            
                        }
                    case 4:
                        {
                            if (orders.isEmpty()) {
                                System.out.println("\n\t-----------YOU HAVE NOT ORDERED ANYTHING-----------");
                                choice=0;
                                break;
                            }
                            System.out.println("\n\t-----------YOUR ORDERS-----------");
                            Management.Manager.printOrderList(orders);
                            choice=0;
                            break;
                        }
                }
            }
                System.out.println("--------------DO YOU WANT TO CONTINUE WITH SOMETHING ELSE ?--------------");
                System.out.println("1. Yes");
                System.out.println("0. No");
                System.out.print("Enter your choice: "); choice=input.nextInt();
                while (choice!=0 && choice!=1) {
                    System.out.println("Your choice is not valid!");
                    System.out.print("Enter your choice again: "); choice=input.nextInt();
                    
                }
                
            }
        System.out.println("--------------------------THANK FOR TRUSTING AND USING OUR SERVICE--------------------------"); 

        input.close();
    }
    public static void insertProperty(Management management){
        //house
        Management.properties.add(new House("H1", 10, 10,2));
        Management.properties.add(new House("H2", 50, 30,5));
        Management.properties.add(new House("H3", 18, 9,4));
        //hotel
        Management.properties.add(new Hotel("HT1", 20, 15,5));
        Management.properties.add(new Hotel("HT2", 36, 20,9));
        Management.properties.add(new Hotel("HT3", 40, 30,15));
        //vacant lot
        Management.properties.add(new VacantLot("VL1", 10, 10));
        Management.properties.add(new VacantLot("VL2", 50, 30));
        Management.properties.add(new VacantLot("VL3", 18, 9));
        //villa
        Management.properties.add(new Villa("V1", 45, 35));
        Management.properties.add(new Villa("V2", 50, 30));
        Management.properties.add(new Villa("V3", 23, 12));
    }
}
