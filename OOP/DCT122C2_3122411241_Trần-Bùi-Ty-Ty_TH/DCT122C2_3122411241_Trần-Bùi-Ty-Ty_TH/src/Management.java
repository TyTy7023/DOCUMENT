import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Property> properties = new ArrayList<Property>();
    public static class Manager{
    // --------------ADD PROPERTY WHICH CUSTOMER WANT TO SELL TO THE LIST --------------
        public static void addHouse(){
            House house = new House();
            house.enterInfo();
            properties.add(new House(house));
        }
        public static void addHotel(){
            Hotel hotel = new Hotel();
            hotel.enterInfo();
            properties.add(new Hotel(hotel));
        }
        public static void addVacantLot(){
            VacantLot vacantLot = new VacantLot();
            vacantLot.enterInfo();
            properties.add(new VacantLot(vacantLot));
        }
        public static void addVilla(){
            Villa villa = new Villa();
            villa.enterInfo();
            properties.add(new Villa(villa));
        }
    // -------------- PRINT PROPERTY IN THE LIST --------------
        public static void printAll(){
            for (Property property : properties) {
                property.print();
            }
        }
        public static void printHouse(){
            for (Property property : properties) {
                if(property instanceof House){
                    property.print();
                    System.out.println();
                }
            }
        }
        public static void printHotel(){
            for (Property property : properties) {
                if(property instanceof Hotel){
                    property.print();
                }
            }
        }
        public static void printVacantLot(){
            for (Property property : properties) {
                if(property instanceof VacantLot){
                    property.print();
                }
            }
        }
        public static void printVilla(){
            for (Property property : properties) {
                if(property instanceof Villa){
                    property.print();
                }
            }
        }
    //--------------REMOVE PROPERTY WHICH IS BOUGHT--------------
        public static void removeHouse(String id){
            int count=0;
            for (int i=0;i<properties.size();i++) {
                //System.out.println("ID:" +property.getId());
                if(properties.get(i) instanceof House){
                    if(properties.get(i).getId().equals(id)){
                        properties.remove(i);
                        count++;
                    }
                }
            }
            if(count==0) System.out.println("No house with this ID");
        }
        public static void removeHotel(String id){
            int count=0;
            for (int i=0;i<properties.size();i++) {
                if(properties.get(i) instanceof Hotel){
                    if(properties.get(i).getId().equals(id)){
                        properties.remove(i);
                        count++;
                    }
                }
            }
            if(count==0) System.out.println("No hotel with this ID");
        }
        public static void removeVacantLot(String id){
            int count=0;
            for (int i=0;i<properties.size();i++) {
                if(properties.get(i) instanceof VacantLot){
                    if(properties.get(i).getId().equals(id)){
                        properties.remove(i);
                        count++;
                    }
                }
            }
            if(count==0) System.out.println("No vacant lot with this ID");
        }
        public static void removeVilla(String id){
            int count=0;
            for (int i=0;i<properties.size();i++) {
                if(properties.get(i) instanceof Villa){
                    if(properties.get(i).getId().equals(id)){
                        properties.remove(i);
                        count++;
                    }
                }
            }
            if(count==0) System.out.println("No villa with this ID");
        }
    // ------------- FIND ANG DISPLAY PROPERTY WHICH CUSTOMER WANT TO BUY -------------
        public static int findProperty(String id){
            int count=0;
            for (Property property : properties) {
                if(property.getId().equals(id)){
                    property.print();
                    if (property instanceof Hotel || property instanceof Villa) {
                        System.out.println("Fees: "+ property.getFees());
                        System.out.println("Total cost: "+ property.totalCost());
                    }
                    count=count+1;
                }
            }
            if(count==0) System.out.println("No property with this ID");
            System.out.println("--------------------------------------------------");
            return count;
        }
    // ------------- ORDER PROPERTY WHICH CUSTOMER WANT TO BUY -------------
        public static void orderHouse(String id, ArrayList<Property> orderList){
            System.out.print("DO YOU CONFIRM TO BUY THIS PROPERTY? (1.YES 0.NO) : "); int choice = input.nextInt();
            while(choice!=1 && choice!=0){
                System.out.print("YOUR CHOICE IF INVALID, PLEASE ENTER AGAIN: "); choice = input.nextInt();
            }
            if(choice==0) return;
            for (Property property : properties) {
                if(property instanceof House){
                    if(property.getId().equals(id)){
                        orderList.add(new House((House)property));
                    }
                }
            }
            Management.Manager.removeHouse(id);

        }
        public static void orderHotel(String id, ArrayList<Property> orderList){
            System.out.print("DO YOU CONFIRM TO BUY THIS PROPERTY? (1.YES 0.NO) : "); int choice = input.nextInt();
            while(choice!=1 && choice!=0){
                System.out.print("YOUR CHOICE IF INVALID, PLEASE ENTER AGAIN: "); choice = input.nextInt();
            }
            for (Property property : properties) {
                if(property instanceof Hotel){
                    if(property.getId().equals(id)){
                        orderList.add(new Hotel((Hotel)property));
                    }
                }
            }
            Management.Manager.removeHotel(id);
        }
        public static void orderVacantLot(String id, ArrayList<Property> orderList){
            System.out.print("DO YOU CONFIRM TO BUY THIS PROPERTY? (1.YES 0.NO) : "); int choice = input.nextInt();
            while(choice!=1 && choice!=0){
                System.out.print("YOUR CHOICE IF INVALID, PLEASE ENTER AGAIN: "); choice = input.nextInt();
            }
            for (Property property : properties) {
                if(property instanceof VacantLot){
                    if(property.getId().equals(id)){
                        orderList.add(new VacantLot((VacantLot)property));
                    }
                }
            }
            Management.Manager.removeVacantLot(id);
        }
        public static void orderVilla(String id, ArrayList<Property> orderList){
            System.out.print("DO YOU CONFIRM TO BUY THIS PROPERTY? (1.YES 0.NO) : "); int choice = input.nextInt();
            while(choice!=1 && choice!=0){
                System.out.print("YOUR CHOICE IF INVALID, PLEASE ENTER AGAIN: "); choice = input.nextInt();
            }
            for (Property property : properties) {
                if(property instanceof Villa){
                    if(property.getId().equals(id)){
                        orderList.add(new Villa((Villa)property));
                    }
                }
            }
            Management.Manager.removeVilla(id);
        } 
    // -------------------- DISPLAY ORDER LIST --------------------
        public static void printOrderList(ArrayList<Property> orderList){
            for (Property property : orderList) {
                property.print();
                if (property instanceof Hotel || property instanceof Villa) {
                        System.out.println("Fees: "+ property.getFees());
                        System.out.println("Total cost: "+ property.totalCost());
                    }
                System.out.println();
            }
        } 
    }
}