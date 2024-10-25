import java.util.Scanner;

public class registerInformation {
    Scanner input= new Scanner(System.in);
    public void registerInfo(librarianAccount[] librarians, memberAccount[] members,book[] books)
    {
        int temp;
        System.out.println("\t\tENTER INFORMATION FOR ALL !!");
        System.out.println("\tWhat information you want to enter first ?");
        System.out.print("1. Librarians\n2. Members\n0.Exit\nEnter your choose (ex: 1): ");  
        temp=input.nextInt();
        while(temp>0)
        {
            input.nextLine();
            switch(temp)
            {
                case 1:
                {
                    //Input information for librarians first then input for member 
                    if(librarians.length>0)
                    {
                        System.out.println("\t\tEnter the number of information of Librarian");
                        for(int i=0;i<librarians.length;i++)
                        {
                            librarians[i] = new librarianAccount();
                            System.out.println("\tLibrarian " + (i+1));
                            librarians[i].inputLibrarian();
                        }
                    }
                    else
                    {
                        System.out.println("\nThere is no librarian in librarian");
                        temp=0;
                    }

                    if(members.length>0)
                    {
                        int count=0;
                        System.out.println("\t\tEnter the number of information of member");
                        for(int i=0;i<members.length;i++)
                        {
                            members[i] = new memberAccount();
                            System.out.println("\tMember " + (i+1));
                            members[i].inputMember();
                            // check the books which they hire
                            if(members[i].getNbooks()>0)
                            {
                                String bookLoaned[]=new String[members[i].getNbooks()];
                                System.out.println("Enter the book ID which you loaned: ");
                                for(int t=0;t<members[i].getNbooks();t++)
                                {
                                    bookLoaned[t]= new String();
                                    System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                    while(count==0)
                                    {
                                        for(int j=0;j<books.length;j++)
                                        {
                                            if(bookLoaned[t].equals(books[j].ISBN) && books[j].getStatus()==true)
                                            {
                                                books[j].setStatus(false); // reset status of book
                                                count++;
                                            }
                                            else count=2;
                                        }
                                        if(count==0)
                                        {
                                            System.out.println("there is not book with this ID in Library. Please enter again!");
                                            System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                        } 
                                        if(count==2)
                                        {
                                            System.out.println("this book is not available. Please enter again!");
                                            System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                            count=0;
                                        }
                                    }           
                                }
                            }
                        }
                    }
                    System.out.println("\t\t\tFINISH REGISTER FOR ALL !\n");
                    temp=0;
                    break;        
                }
                //Input information for member first then input for librarians 
                case 2:
                {
                    if(members.length>0)
                    {
                        int count=0;
                        System.out.println("\t\tEnter the number of information of member");
                        for(int i=0;i<members.length;i++)
                        {
                            members[i] = new memberAccount();
                            System.out.println("\tMember " + (i+1));
                            members[i].inputMember();
                            if(members[i].getNbooks()>0)
                            {
                                String bookLoaned[]=new String[members[i].getNbooks()];
                                System.out.println("Enter the book ID which you loaned: ");
                                for(int t=0;t<members[i].getNbooks();t++)
                                {
                                    bookLoaned[t]= new String();
                                    System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                    count=0;
                                    while(count==0)
                                    {
                                        for(int j=0;j<books.length;j++)
                                        {
                                            if(bookLoaned[t].equals(books[j].ISBN) && books[j].getStatus()==true)
                                            {
                                                books[j].setStatus(false); // reset status of book
                                                count++;
                                            }
                                            else count=2;
                                        }
                                        if(count==0)
                                        {
                                            System.out.println("there is not book with this ID in Library. Please enter again!");
                                            System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                        } 
                                        if(count==2)
                                        {
                                            System.out.println("this book is not available. Please enter again!");
                                            System.out.print("Book " + (t+1) + " which you loaned: "); bookLoaned[t]=input.nextLine();
                                            count=0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else 
                    {
                        System.out.println("There is no member in library");
                        temp=0;
                    }
                    if(librarians.length>0)
                    {
                         System.out.println("\t\tEnter the number of information of Librarian");
                        for(int i=0;i<librarians.length;i++)
                        {
                            librarians[i] = new librarianAccount();
                            System.out.println("\tLibrarian " + (i+1));
                            librarians[i].inputLibrarian();
                        } 
                    }
                    System.out.println("\t\t\tFINISH REGISTER FOR ALL !\n");
                    temp=0;
                    break;
                }
                default:
                {
                    System.out.print("Your choose is INCORRECT, please enter again: ");
                    temp=input.nextInt();
                }
            }
        }    
    }    
}
