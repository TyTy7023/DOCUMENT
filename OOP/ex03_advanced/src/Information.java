import java.util.Scanner;

public abstract class Information {
    Scanner input = new Scanner(System.in);
    private String name, address, phone;

    //setters
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //getters
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    //methods
    public void enterInfo(){}
    public void printInfo(){}
}
