import java.util.Scanner;

public class processMember {
    Scanner input = new Scanner(System.in);
    public void processM(memberAccount[] members, book[] books)
    {
        int posMember;
        System.out.println("\n\t\tWHO ARE YOU ?");
        for(int i=0;i<members.length;i++)

        {
            System.out.print((i+1) + ". Fullname: " + members[i].getFullname() + "\t||\t");
            System.out.println("Account ID: " + members[i].getAccountID());
        }
        if(members.length==0)
        {
            System.out.println("There is no member in library");
            return;
        }
        System.out.print("Enter your choose: "); posMember=input.nextInt();
        while(posMember<0 || posMember>members.length)
        {
            System.out.print("Your choose is INCORRECT, please enter again: ");
            posMember=input.nextInt();
        }
        --posMember;


        int temp=1;
        while (temp>0)
        {
            System.out.println("\n\t\tWHAT DO YOU WANT TO DO ?");
            System.out.println("1. Find a book\n2. Register book request");
            System.out.print("Enter your choose (ex: 1): "); temp=input.nextInt();
            while (temp>0) 
            {
                switch(temp)
                {
                    case 1:
                    {
                        int temp1=1;
                        while (temp1>0)
                        {   
                            members[posMember].findBook(books);;
                            System.out.println("\n\t\tDo you want to continue to find a book ?");
                            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp1=input.nextInt();
                            System.out.println("\n");
                        }

                        temp=0;
                        break;
                    }
                    case 2:
                    {
                        int num;
                        System.out.print("How many book you want to loan ?"); num=input.nextInt();
                        members[posMember].registerLoan(books, num);

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
            System.out.println("\n\t\tDo you want to continue as Member ?");
            System.out.print("1. Continue\n0. Exit\nEnter your choose: "); temp=input.nextInt();
            System.out.println();
        }
    }
}
