import java.util.Scanner;

public class bookRequest{
    //Attribute
    private String BLcode, memberID, ISBN, dueDay, returnDate;
    Scanner input = new Scanner(System.in);
    //setter
    public void setBLcode(String BLcode)
    {
        this.BLcode=BLcode;
    }
    public void setMemberID(String memberID)
    {
        this.memberID=memberID;
    }
    public void setISBN(String ISBN)
    {
        this.ISBN=ISBN;
    }
     public void setDueDay(String dueDay)
    {
        this.dueDay=dueDay;
    }
    public void setReturnDate(String returnDate)
    {
        this.returnDate=returnDate;
    }
    //getter
        public String getBLcode()
    {
        return this.BLcode;
    }
    public String getMemberID()
    {
        return this.memberID;
    }
    public String getISBN()
    {
        return this.ISBN;
    }
    public String getDueDay()
    {
        return this.dueDay;
    }
    public String getReturnDate()
    {
        return this.returnDate;
    }
    // input information of book request
    public void inputInfo()
    {
        System.out.println("\tEnter your information ");
        System.out.print("BLcode: "); BLcode = input.nextLine();
        System.out.print("MemberID: "); memberID = input.nextLine();
        System.out.print("ISBN: "); ISBN = input.nextLine();
        System.out.print("DueDay: "); dueDay = input.nextLine();
        System.out.print("ReturnDate: "); returnDate = input.nextLine();
    }
    // output information of book request
    public void outputInfo()
    {
        System.out.println("\tThe information of book request ");
        System.out.println("BLcode: "+BLcode);  
        System.out.println("MemberID: "+memberID);  
        System.out.println("ISBN: "+ISBN);  
        System.out.println("DueDay: "+dueDay);  
        System.out.println("ReturnDate: "+returnDate);  
    }
}