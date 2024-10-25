import java.util.Scanner;

public class Register 
{
    Scanner inputRegister= new Scanner(System.in);
    public void register(student[] under, student[] grad, ClassInfo underCl[],ClassInfo gradCl[])
    {
        //stu=new student[num]; 
        //cl=new ClassInfo[num]; 
            //register the number of under-Gradstudents 
            for(int i=0;i<under.length;i++)
            {
                System.out.println("\t\tREGISTER UNDERGRAD STUDENT "+(i+1)+": ");
                under[i]=new student();
                System.out.print("Enter your student id: "); under[i].setSid(inputRegister.nextInt());
                inputRegister.nextLine();// clear cache
                System.out.print("Enter your fullname: "); under[i].setFullname(inputRegister.nextLine());
                System.out.print("Enter your academic year: "); under[i].setPromotion(inputRegister.nextLine());
                System.out.print("Enter your department: "); under[i].setDepartment(inputRegister.nextLine());
                System.out.print("Enter your major: "); under[i].setSpecialty(inputRegister.nextLine());
                for(int j=0;j<=50;j++) System.out.print("-");// just for beautiful
                    System.out.print("\n\t\t..The number of courses..\n");
                    System.out.print("\tcourse 1: Programming - IT1  \n");
                    System.out.print("\tcourse 2: Programming - IT2  \n");
                    System.out.print("\tcourse 3: Database - Data1  \n");
                    System.out.print("\tcourse 4: Database - Data2  \n");
                for(int j=0;j<=50;j++) System.out.print("-");// just for beautiful
                System.out.print("\nHow many course you want to register?");
                int numCourse=inputRegister.nextInt();
                //transmit data to class of student
                underCl[i]=new ClassInfo();
                underCl[i].cid=new String[numCourse];
                underCl[i].course=new String[numCourse];
                for(int j=0;j<numCourse;j++)
                {
                    underCl[i].cid[j]=new String();
                    System.out.print("\nEnter your choose of class (ex: 1): "); int choose=inputRegister.nextInt();
                    while(choose!=1 && choose!=2 && choose!=3 && choose!=4)
                    {
                        System.out.print("The course was registered, please enter again: ");
                        choose=inputRegister.nextInt();
                    }
                    int test=0;
                    while(test==0)
                    {
                        switch(choose)
                        {
                            case 1: 
                            {
                                underCl[i].setCid("IT1",j);
                                underCl[i].setCourse("Programming",j);
                                test=1;
                                break;
                            }
                            case 2: 
                            {
                                underCl[i].setCid("IT2",j);
                                underCl[i].setCourse("Programming",j);
                                test=1;
                                break;
                            }
                            case 3: 
                            {
                                underCl[i].setCid("Data1",j);
                                underCl[i].setCourse("Database",j);
                                test=1;
                                break;
                            }
                            case 4: 
                            {
                                underCl[i].setCid("Data2",j);
                                underCl[i].setCourse("Database",j);
                                test=1;
                                break;
                            }
                        }
                        if(j>0)
                        {
                            for(int k=0;k<j;k++)
                            {
                                if(underCl[i].getCid(j).equals(underCl[i].getCid(k)))
                                {
                                    System.out.print("The course was registered, please enter again: ");
                                    choose=inputRegister.nextInt();
                                    test=0;
                                }
                            }
                        }
                    }
                    System.out.println("finish choose class " + underCl[i].getCid(j));
                } 
                System.out.print("\n\tDO YOU WANT TO SHOW THE LIST YOU REGISTED ? (1.Yes || 2.No): "); int temp=inputRegister.nextInt(); 
                if(temp==1)
                {
                    System.out.println("\n\tThe number of list which you registered: ");
                    for(int j=0;j<numCourse;j++)
                    {
                        System.out.println("course: " + underCl[i].getCourse(j) + "\nclass id: "+ underCl[i].getCid(j));
                    }
                }
                System.out.println("FINISH REGISTER UNDERGRAD STUDENT "+(i+1)+": "); 
            }   
            //register the number of Gradstudents
            for(int i=0;i<grad.length;i++)
            {
                
                if(grad.length<=0) return;
                System.out.println("\t\tREGISTER GRADSTUDENT "+(i+1)+": ");
                grad[i]=new student();
                System.out.print("Enter your student id: "); grad[i].setSid(inputRegister.nextInt());
                inputRegister.nextLine();
                System.out.print("Enter your fullname: "); grad[i].setFullname(inputRegister.nextLine());
                System.out.print("Enter your academic year: "); grad[i].setPromotion(inputRegister.nextLine());
                System.out.print("Enter your department: "); grad[i].setDepartment(inputRegister.nextLine());
                System.out.print("Enter your specialty: "); grad[i].setMajor(inputRegister.nextLine());
                for(int j=0;j<=50;j++) System.out.print("-");// just for beautiful
                    System.out.print("\n\t\t..The number of courses..\n");
                    System.out.print("\tcourse 1: Programming - IT1  \n");
                    System.out.print("\tcourse 2: Programming - IT2  \n");
                    System.out.print("\tcourse 3: Database - Data1  \n");
                    System.out.print("\tcourse 4: Database - Data2  \n");
                    System.out.print("\tcourse 5: Advanced Artificial Intelligence - AAI\n");
                for(int j=0;j<=50;j++) System.out.print("-");// just for beautiful
                System.out.print("\nHow many course you want to register?");
                int numCourse=inputRegister.nextInt();
                gradCl[i]=new ClassInfo();
                gradCl[i].cid=new String[numCourse];
                gradCl[i].course=new String[numCourse];
                for(int j=0;j<numCourse;j++)
                {
                    gradCl[i].cid[j]=new String();
                    System.out.print("\nEnter your choose of class (ex: 1): "); int choose=inputRegister.nextInt();
                    while(choose!=1 && choose!=2 && choose!=3 && choose!=4 && choose!=5)
                    {
                        System.out.print("The course was registered, please enter again: ");
                        choose=inputRegister.nextInt();
                    }
                    int test=0;
                    while(test==0)
                    {
                        switch(choose)
                        {
                            case 1: 
                            {
                                gradCl[i].setCid("IT1",j);
                                gradCl[i].setCourse("Programming",j);
                                test=1;
                                break;
                            }
                            case 2: 
                            {
                                gradCl[i].setCid("IT2",j);
                                gradCl[i].setCourse("Programming",j);
                                test=1;
                                break;
                            }
                            case 3: 
                            {
                                gradCl[i].setCid("Data1",j);
                                gradCl[i].setCourse("Database",j);
                                test=1;
                                break;
                            }
                            case 4: 
                            {
                                gradCl[i].setCid("Data2",j);
                                gradCl[i].setCourse("Database",j);
                                test=1;
                                break;
                            }
                            case 5: 
                            {
                                gradCl[i].setCid("AAI",j);
                                gradCl[i].setCourse("Advanced Artificial Intelligence",j);
                                test=1;
                                break;
                            }
                        }
                        if(j>0)
                        {
                            for(int k=0;k<j;k++)
                            {
                                if(gradCl[i].getCid(j).equals(gradCl[i].getCid(k)))
                                {
                                    System.out.print("The course was registered, please enter again: ");
                                    choose=inputRegister.nextInt();
                                    test=0;
                                }
                            }
                        }

                    }
                    
                    System.out.println("finish choose class " + gradCl[i].getCid(j));
                } 
                System.out.print("\n\tDO YOU WANT TO SHOW THE LIST YOU REGISTED ? (1.Yes || 2.No): "); int temp=inputRegister.nextInt();
                if(temp==1)
                {
                    System.out.println("\n\tThe number of list which you registered: ");
                    for(int j=0;j<numCourse;j++)
                    {
                        System.out.println("course: " + gradCl[i].getCourse(j) + "\nclass id: "+ gradCl[i].getCid(j));
                    }
                }
                System.out.println("FINISH REGISTER GRADSTUDENT "+(i+1)+": ");
            }
        
    }
}
