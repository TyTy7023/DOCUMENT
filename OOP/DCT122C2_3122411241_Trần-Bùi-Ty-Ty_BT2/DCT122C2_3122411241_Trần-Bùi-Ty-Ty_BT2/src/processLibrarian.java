import java.util.Scanner;

public class processLibrarian {
    Scanner input = new Scanner(System.in);

    public void processL(librarianAccount[] librarians,memberAccount[] members, book[] books)
    {
        int posLibrarian;
        //Export the list of librarians with the fullname and ID, then choose the number which contain the information you want to choose
        System.out.println("\n\t\tWHO ARE YOU ?");
        //check the number of librarian in the library
        if(librarians.length==0)
        {
            System.out.println("\tThere is no librarian in library");
            return;
        }
        //Export the list
        for(int i=0;i<librarians.length;i++)
        {
            System.out.print((i+1) + ". Fullname: " + librarians[i].getFullname() + "\t||\t");
            System.out.println("Account ID: " + librarians[i].getAccountID());
        }
        //Input your choose
        System.out.print("Enter your choose (ex: 1): "); posLibrarian=input.nextInt();
        //Check the variable when entering it 
        while(posLibrarian<=0 || posLibrarian>librarians.length)
        {
            System.out.print("Your choose is INCORRECT, please enter again: ");
            posLibrarian=input.nextInt();
        }
        --posLibrarian; // Increase 1 unit because the entering is the number which was add 1 unit
        

        int temp=1;
        while (temp>0)
        {
            System.out.println("\n\t\tWHAT DO YOU WANT TO DO ?");
            System.out.println("1. Find a book\n2. Find information of member\n3. Find the book request\n0. Exit");
            System.out.print("Enter your choose (ex: 1): "); temp=input.nextInt();
            while (temp>0) 
            {
                input.nextLine();
                switch(temp)
                {
                    //Executing find a book 
                    case 1:
                    {
                        int temp1=1;
                        while (temp1>0)
                        {   
                            librarians[posLibrarian].findBook(books);
                            System.out.println("\n\t\tDo you want to continue to find a book ?");
                            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp1=input.nextInt();
                        }

                        temp=0;
                        break;
                    }
                    //Executing find a information of member 
                    case 2:
                    {
                        int temp1=1;
                        while (temp1>0)
                        {   
                            librarians[posLibrarian].findMember(members);
                            System.out.println("\n\t\tDo you want to continue to find a member ?");
                            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp1=input.nextInt();
                        }

                        temp=0;
                        break;
                    }
                     //Executing find a  book request
                    case 3:
                    {
                        int temp1=1;
                        while (temp1>0)
                        {   
                            librarians[posLibrarian].findBookRequest(members, books);
                            System.out.println("\n\t\tDo you want to continue to find a book request ?");
                            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp1=input.nextInt();
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
            System.out.println("\n\t\tDo you want to continue as Librarian ?");
            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp=input.nextInt();
        }
        
        
    }
}
