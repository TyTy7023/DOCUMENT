import java.util.Scanner;

//inheritance between member account and account
public class memberAccount extends account {
    //Attribute
    private String membershipDate;
    private int nBooks;
    public bookRequest[] request; // array of book request for member who want to hire a lot of books
    Scanner input=new Scanner(System.in);

    //setter
    public void setMembershipDate(String membershipDate)
    {
        this.membershipDate=membershipDate;
    }
    public void setNBooks(int nBooks)
    {
        this.nBooks=nBooks;
    }
    //getter
    public String getMembershipDate()
    {
        return this.membershipDate;
    }
    public int getNbooks()
    {
        return this.nBooks;
    }
    
    //function input the information of member
    public void inputMember()
    {
        inputAccount();//inheritance
        System.out.print("Enter membership date: "); membershipDate=input.nextLine();
        System.out.print("Enter number of books which member loaned: "); nBooks=input.nextInt();
        input.nextLine();
    }
    //function output the information of member
    public void infoMember()
    {
        infoAccount();//inheritance
        System.out.println("The membership date: " + membershipDate);
        System.out.println("The number of books which member loaned: " + nBooks);
    }
    //Executing find a book
    public void findBook(book[] Book)
    {
        int temp;
        String title, bookID, authors, publisher;
        System.out.println("\tWhat information do you want to find the book with?");
        System.out.print("1.Title\n2.Book ID\n3.Authors\n4.Publisher\nEnter your choose: "); temp=input.nextInt();
        while(temp>0)
        {
            input.nextLine();
            switch(temp)
            {
                //Executing find a book with title
                case 1:
                {
                    System.out.print("Enter your title book: "); title=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(title.equals(Book[i].title))
                            Book[i].infoBook();
                    temp=0;
                    break;
                }
                //Executing find a book with book ID
                case 2:
                {
                    System.out.print("Enter your book ID: "); bookID=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(bookID.equals(Book[i].ISBN))
                            Book[i].infoBook();
                    temp=0;
                    break;
                }
                //Executing find a book with authors
                case 3:
                {
                    System.out.print("Enter your authors of book: "); authors=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(authors.equals(Book[i].authors))
                            Book[i].infoBook();
                    temp=0;
                    break;
                }
                //Executing find a book with publisher
                case 4:
                {
                    System.out.print("Enter your publisher of book: "); publisher=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(publisher.equals(Book[i].publisher))
                            Book[i].infoBook();
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
        System.out.println("\t\tFINISH FIND BOOK"); 
    }
    // function register book request 
    public void registerLoan(book[] Book, int num)
    {
        request = new bookRequest[num];
        for(int i=0;i<num;i++)
        {
            System.out.println("\t\t\tStarting to loan!");
            request[i] = new bookRequest();
            request[i].inputInfo();
        }
        for(int j=0;j<request.length;j++)
        {
            for(int i=0;i<Book.length;i++)
            {
                // check the status of book and the book ID
                if(Book[i].ISBN.equals(request[j].getISBN()) && Book[i].getStatus()==true)
                {
                    Book[i].setStatus(false);
                    ++nBooks;// increase the number of books which member hire
                } 
                else if (Book[i].ISBN.equals(request[j].getISBN()) && Book[i].getStatus()==false)
                {
                    System.out.println("\t\tThe book which you want to loan was loaned !");
                    System.out.println("Please choose another book with another book ID: "); 
                    request[j].setISBN(input.nextLine());
                    i=0; //return and check information with the books again
                }
                else
                {
                    System.out.println("There is not the book with this ID in library");
                    System.out.println("Please choose another book with another book ID: ");
                    request[j].setISBN(input.nextLine());
                    i=0; //return and check information with the books again
                }
            }
        }
        System.out.println("FINISH REGISTER ! ");
    }

    public void infoMemberBookRequest()
    {
        System.out.println("The information of book request of " + getFullname());
        for(int i=0;i<request.length;i++)
            request[i].outputInfo();
    }
}
