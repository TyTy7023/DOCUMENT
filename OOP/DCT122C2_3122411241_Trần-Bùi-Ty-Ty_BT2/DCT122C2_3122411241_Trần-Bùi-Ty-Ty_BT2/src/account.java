import java.util.Scanner;

public class account {
    //attribute
    private String accountID, accountType, statusAccount;
    private String fullname, birthDate, phone, email, address;
    Scanner input = new Scanner(System.in);
    
    // setter
    public void setAccountID(String accountID)
    {
        this.accountID=accountID;
    }
    public void setAccountType(String accountType)
    {
        this.accountType=accountType;
    }
    public void setStatusAccount(String statusAccount)
    {
        this.statusAccount=statusAccount;
    }
    public void setFullname(String fullname)
    {
        this.fullname=fullname;
    }
    public void setBirthDate(String birthDate)
    {
        this.birthDate=birthDate;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
     public void setEmail(String email)
    {
        this.email=email;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    
    //getter
        public String getAccountID()
    {
        return this.accountID;
    }
    public String getAccountType()
    {
        return this.accountType;
    }
    public String getStatusAccount()
    {
        return this.statusAccount;
    }
    public String getFullname()
    {
        return this.fullname;
    }
    public String getBirthDate()
    {
        return this.birthDate;
    }
    public String getPhone()
    {
        return this.phone;
    }
     public String getEmail()
    {
        return this.email;
    }
    public String getAddress()
    {
        return this.address;
    }
    //Input data for account
    public void inputAccount()
    {
        System.out.print("Enter your account ID: "); accountID=input.nextLine();
        System.out.print("Enter your account type ( L (librarian) or M (member) ): "); accountType=input.nextLine();
        while(!accountType.equals("L") && !accountType.equals("M"))
        {
            System.out.print("Your account type is INCORRECT, please enter again: ");
            accountType=input.nextLine();
        }
        System.out.print("Enter your status of account (active or suspended or closed): "); statusAccount=input.nextLine();
        while(!statusAccount.equals("active") && !statusAccount.equals("suspended") && !statusAccount.equals("closed"))
        {
            System.out.print("Your status of account is INCORRECT, please enter again: ");
            statusAccount=input.nextLine();
        }
        System.out.print("Enter your fullname: "); fullname=input.nextLine();
        System.out.print("Enter your birthDate: "); birthDate=input.nextLine();
        System.out.print("Enter your phone: "); phone=input.nextLine();
        System.out.print("Enter your email: "); email=input.nextLine();
        System.out.print("Enter your address: "); address=input.nextLine();
    }
    // output information of account 
    public void infoAccount()
    {
        System.out.println("Account ID: " + this.accountID);
        System.out.println("Account type: " + this.accountType);
        System.out.println("Status of account: " + this.statusAccount);
        System.out.println("Fullname: " + this.fullname);
        System.out.println("Birth of date: " + this.birthDate);
        System.out.println("Phone: " + this.phone);
        System.out.println("Address: " + this.address);
    }
}
