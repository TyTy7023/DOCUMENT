import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        int numGrad,numUnder;
        Scanner input= new Scanner(System.in);
        System.out.println("\t\tWELCOME TO REGISTER SYSTEM, PLEASE ENTER INFORMATION BELOW!!");
        System.out.print("\tThe number of Gradstudents who want to register: "); numGrad = Integer.parseInt(input.nextLine());
        System.out.print("\tThe number of UnderGradstudents who want to register: "); numUnder = Integer.parseInt(input.nextLine());
        //input
        student grad[] = new student[numGrad];
        student under[] = new student[numUnder];
        ClassInfo undercl[] = new ClassInfo[numUnder];
        ClassInfo gradcl[] = new ClassInfo[numGrad];
        Register rg = new Register();
        rg.register(under,grad,undercl,gradcl); 
        //input.nextLine();
        //output
        String id=new String(); 
        output out= new output(); 
        int temp=1;
        
        //Export the list of student in a course
        System.out.println("\t\tWe will show the list of course which you want to see !");
        while(temp==1)
        {  
            //Input the class id
            System.out.print("What does the list of course you want to see?\nEnter the class id: "); 
            id=input.nextLine();
            //Check the variable when entering it 
            while(!id.equals("IT1") && !id.equals("IT2") && 
                  !id.equals("Data1") && !id.equals("Data2") && !id.equals("AAI"))
            {
                System.out.print("error, please enter again: ");
                id=input.nextLine();
            }
            // Executing the process
            out.process(id,under,grad,undercl,gradcl);
            System.out.println("\n\n\t\tIf you want to continue, enter 1, else enter 0");
            System.out.print("Enter your choose: ");
            temp = Integer.parseInt(input.nextLine());
            //Check the variable when entering it 
            while(temp!=1 && temp!=0)
            {
                System.out.print("error, please enter again: ");
                temp = Integer.parseInt(input.nextLine());
            }
        }

        System.out.println("\n\t\tTHANK FOR REGISTER!!");

        input.close();
        rg.inputRegister.close();
    }
}