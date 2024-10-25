import java.util.Scanner;

public class librarianAccount extends account {
    //Attribute
    private String startingDate, maritalStatus;
    Scanner input = new Scanner(System.in);
    //setter
    public void setStartingDate(String startingDate)
    {
        this.startingDate=startingDate;
    }
    public void setMaritalStatus(String maritalStatus)
    {
        this.maritalStatus=maritalStatus;
    }

    public String getStartingDate()
    {
        return startingDate;
    }
    public String getMaritalStatus()
    {
        return maritalStatus;
    }
    //getter
    public void inputLibrarian()
    {
        inputAccount();
        System.out.print("Enter your starting date: "); startingDate=input.nextLine();
        System.out.print("Enter your marital status (married or single or divorced): "); maritalStatus=input.nextLine();  
        while(!maritalStatus.equals("married") && !maritalStatus.equals("single") && !maritalStatus.equals("divorced"))
        {
            System.out.print("Your marital status is INCORRECT, please enter again: ");
            maritalStatus=input.nextLine();
        }  
    }
    public void infoLibrarian()
    {
        infoAccount();
        System.out.println("Starting day: " + startingDate);
        System.out.println("Marital status: " + maritalStatus);
        
    }
    //Executing find book
    public void findBook(book[] Book)
    {
        int temp, count=0;
        String bookID,title;
        System.out.println("\tWhat information do you want to find the book with?");
        System.out.print("1.Title\n2.Book ID\n0.Exit\nEnter your choose: "); temp=input.nextInt();
        while(temp>0)
        {
            input.nextLine();
            switch(temp)
            {
                // Executing find a book with title book
                case 1:
                {
                    System.out.print("Enter your title book: "); title=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(title.equals(Book[i].title)) //check the title which entering with tittle book in library
                        {
                            Book[i].infoBook();
                            count++;
                        }    
                        
                    temp=0;
                    break;
                } 
                // Executing find a book with book ID
                case 2:
                {
                    System.out.print("Enter your book ID: "); bookID=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(bookID.equals(Book[i].ISBN)) //check the ID which entering with book ID in library
                        {
                            Book[i].infoBook();
                            count++;
                        }
                    temp=0;
                    break;
                }
                //Check the variable when entering it  
                default:
                {
                    System.out.println("Your choose is INCORRECT, please enter again: ");
                    temp=input.nextInt();
                }
            }    
        }
        if(count == 0 ) System.out.println("This book is not in the Library");
        System.out.println("\t\tFINISH FIND BOOK");
        
    }
    public void findMember(memberAccount[] members)
    {
        if(members.length==0) 
        {
            System.out.println("there are no members in librarian");
            return;
        }
        int temp, count=0;
        String name,memberID;
        System.out.println("\tWhat information do you want to find the member with?");
        System.out.print("1.Name\n2.Member ID\n0.Exit\nEnter your choose"); temp=input.nextInt();
        while(temp>0)
        {
            input.nextLine();
                switch(temp)
            {
                //Executing find a member with fullname
                case 1:
                {
                    System.out.print("Enter the fullname: "); name=input.nextLine();
                    for(int i=0; i<members.length;i++)
                        if(name.equals(members[i].getFullname()))
                        {
                            members[i].infoMember();
                            count++;
                        }
                            
                    temp=0;
                    break;
                } 
                //Executing find a member with member ID
                case 2:
                {
                    System.out.print("Enter the member ID: "); memberID=input.nextLine();
                    for(int i=0; i<members.length;i++)
                        if(memberID.equals(members[i].getAccountID()))
                        {
                            members[i].infoMember();
                            count++;
                        }
                            
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
        if(count==0) System.out.println("there is not member with this id!");
        System.out.println("\t\tFINISH FIND MEMBER");
    }
    public void findBookRequest(memberAccount[] members, book[] Book)
    {
        if(members.length==0) 
        {
            System.out.println("there are no members in librarian");
            return;
        }
        int temp, count=0;
        String memberID,title, bookID=new String();
        System.out.println("\tWhat information do you want to find the member who request the book ?");
        System.out.print("1.Title\n2.Member ID\nEnter your choose: "); temp=input.nextInt();
        while(temp>0)
        {
            input.nextLine();
                switch(temp)
            {
                //Executing find a book request with title
                case 1:
                {
                    System.out.print("Enter your title book: "); title=input.nextLine();
                    for(int i=0; i<Book.length;i++)
                        if(title.equals(Book[i].title))
                            bookID=Book[i].ISBN;
                    for(int i=0;i<members.length;i++)
                        for(int j=0;j<members[i].request.length;j++)
                        {
                            if(bookID.equals(members[i].request[j].getISBN()))
                            {
                                members[i].infoMemberBookRequest();
                                count++;
                            }
                            
                        }   
                    temp=0;
                    if(count==0) System.out.println("there are no books request in Librarian ");
                    break;
                } 
                //Executing find a book request with member ID
                case 2:
                {
                    System.out.print("Enter your member ID: "); memberID=input.nextLine();
                    for(int i=0; i<members.length;i++)
                        if(memberID.equals(members[i].getAccountID()))
                        {
                            members[i].infoMemberBookRequest();
                            count++;
                        }
                    temp=0;
                    if(count==0) System.out.println("there are no book request in Librarian");
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
        System.out.println("\t\tFINISH FIND BOOK REQUEST");
    }
}
