import java.util.Scanner;

public class MainOfClass
{
    public static void main(String[] args)  {
        Scanner input= new Scanner(System.in);
        //Input a lot of book in library
        book[] Book= new book[25]; listBook(Book);
        
        int numL, numM;
        System.out.println("\t\tWELCOME TO LIBRARY");
        System.out.print("Enter the number of librarian who want to register: "); numL=input.nextInt();
        System.out.print("Enter the number of Member who want to register: "); numM=input.nextInt();
        librarianAccount[] librarians = new librarianAccount[numL];
        memberAccount[] members = new memberAccount[numM]; 
        //check the number of people in library    
        if(numL==0 && numM==0) 
        {
            System.out.println("There is no one in library");
            System.exit(0);
        }
        // register information for all 
        registerInformation register = new registerInformation();
        register.registerInfo(librarians, members, Book);
        //process
        int temp=1;
        System.out.print("Are you librarian or member\n1. Librarian\n2. Member\n0. Exit\nEnter your choose: "); temp=input.nextInt();
        while (temp>0)
        { 
            switch(temp)
            {
                //Execute the process of librarians
                case 1: 
                {
                    if(numL==0)
                    {
                        System.out.println("There is no librarian in library");
                        continue;
                    }
                    processLibrarian processL=new processLibrarian();
                    processL.processL(librarians, members, Book);
                    temp=0;
                    break;
                }
                //Execute the process of members
                case 2:
                {
                    if(numM==0)
                    {
                        System.out.println("There is no member in library");
                        continue;
                    }
                    processMember processM = new processMember();
                    processM.processM( members, Book);
                    temp=0;
                    break;
                }
                //Check the variable when entering it          
                default:
                {
                    System.out.print("Your choose is INCORRECT, please enter again: ");
                    temp=input.nextInt();
                }
            }
        }
        
        System.out.println("\n\t\tDO YOU WANT TO SEE THE LIST OF BOOK IN LIBRARY ?");
        System.out.println("1. Yes\n2. No"); temp=input.nextInt();
        while(temp!=1 && temp!=2)
        {
            System.out.print("Your choose is INCORRECT, please enter again: ");
            temp=input.nextInt();
        }
        if(temp==1) 
            for(int i=0;i<Book.length;i++)
            {
                System.out.println("Book " + (i+1) + ": "); 
                Book[i].infoBook();
                for(int j=0;j<50;j++) System.out.println("-");
            }
            
        System.out.println("\n\t\tTHANK YOU FOR USING OUR LIBRARY");
    
        input.close();
    }
    
    public static void listBook(book[] Book)
        {
            Book[0]=new book("TLS2007", "1984", "George Orwell", "Macmillan Publishers","1986");
            Book[1]=new book("CIT64", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Hachette Livre","1977");
            Book[2]=new book("RNU1987 ", "To Kill a Mockingbird ", "Harper Lee", " Macmillan Publishers","1886");
            Book[3]=new book("TGNTT1931", "Pride and Prejudice", "Jane Austen", "Macmillan Publishers","1946");
            Book[4]=new book("ND1942", "A Tree Grows in Brooklyn", "Betty Smith", "HarperCollins","1987");
            Book[5]=new book("GDK2008", "The Book Thief ", "Markus Zusak", "Macmillan Publishers","1936");
            Book[6]=new book("NGK1988", "Brave New World", "Aldous Huxley", "HarperCollins","1963");
            Book[7]=new book("DNT197", "The Underground Railroad", "Colson Whitehead", "HarperCollins","1986");
            Book[8]=new book("CNDTC23", "Beloved", "Toni Morrison", "Macmillan Publishers","1856");
            Book[9]=new book("HGTH310", "All the Light We Cannot See", "Anthony Doerr", "Best Educational Book Publishers","1935");
            Book[10]=new book("QGLDVVS35", "Catch-22", "Joseph Heller", "Macmillan Publishers","1965");
            Book[11]=new book("DVBKA15", "The Call of the Wild", "Jack London", "Best Educational Book Publishers","1945");
            Book[12]=new book("BG117 ", "Fahrenheit 451 ", "Ray Bradbury", " Best Educational Book Publishers","1923");
            Book[13]=new book("CSKGH32", "Love in the Time of Cholera", "Gabriel Garcia Marquez", "Macmillan Publishers","1986");
            Book[14]=new book("DTDKTTD34", "The Lovely Bones", "Alice Sebold", "HarperCollins","1988");
            Book[15]=new book("NGNTB31", "The Alchemist", "Paulo Coelho", "Macmillan Publishers","1946");
            Book[16]=new book("TQDTD7", "The Joy Luck Club", "Amy Tan", "HarperCollins","1935");
            Book[17]=new book("HTVPD3545", "Siddhartha", "Hermann Hesse", "Penguin Random House","1786");
            Book[18]=new book("TAVHP31", "The Great Gatsby", "F. Scott Fitzgerald", "Macmillan Publishers","1866");
            Book[19]=new book("NBHVDNTG38", "The Kite Runner", "Khaled Hosseini", "Best Educational Book Publishers","1981");
            Book[20]=new book("CTXMVTT385", "The Handmaid's Tale", "Margaret Atwood", "Macmillan Publishers","1978");
            Book[21]=new book("MB1331", "The Color Purple", "Alice Walker", "Penguin Random House","1986");
            Book[22]=new book("TTHHTCX54", "The Little Prince", "Antoine de Saint-Exupéry", "Penguin Random House","1956");
            Book[23]=new book("TLBT51", "Their Eyes Were Watching God", "Zora Neale Hurston", "Penguin Random House","1974");
            Book[24]=new book("MHKT43", "The Bell Jar", "Sylvia Plath", "Hachette Livre","1975");
        
        }
}
