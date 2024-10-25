public class output 
{
    // Export the list of class which user want to be showed
    void process(String id,student[] under, student[] grad, ClassInfo underCl[],ClassInfo gradCl[])
    {
        //Check the variable when entering it with the class ID is IT1
        if(id.equals("IT1")) 
        {  
            //export the list of gradstudents fist then exporting the members
            for(int i=0;i<grad.length;i++)
                for(int j=0;j<gradCl[i].cid.length;j++)    
                    if(gradCl[i].getCid(j).equals("IT1")) 
                            System.out.println("\t\tList of Gradstudent class\n "+"Fullname: " + grad[i].getFullname() + "\nStudent id: "+ grad[i].getSid());
            for(int i=0;i<under.length;i++)
                for(int j=0;j<underCl[i].cid.length;j++)
                    if(underCl[i].getCid(j).equals("IT1")) 
                            System.out.println("\t\tList of UnderGradstudent class\n "+"Fullname: " + under[i].getFullname() + "\nStudent id: "+ under[i].getSid());
       
            System.out.println("\n");
        }
        //Check the variable when entering it with the class ID is IT2
        if(id.equals("IT2")) 
        {
            for(int i=0;i<grad.length;i++)
                for(int j=0;j<gradCl[i].cid.length;j++)    
                    if(gradCl[i].getCid(j).equals("IT2")) 
                            System.out.println("\t\tList of Gradstudent class\n "+"Fullname: " + grad[i].getFullname() + "\nStudent id: "+ grad[i].getSid());
            for(int i=0;i<under.length;i++)
                for(int j=0;j<underCl[i].cid.length;j++)
                    if(underCl[i].getCid(j).equals("IT2")) 
                            System.out.println("\t\tList of UnderGradstudent class\n "+"Fullname: " + under[i].getFullname() + "\nStudent id: "+ under[i].getSid());
            System.out.println("\n");
        }
        //Check the variable when entering it with the class ID is Data 1
        if(id.equals("Data1")) 
        {
            for(int i=0;i<grad.length;i++)
                for(int j=0;j<gradCl[i].cid.length;j++)    
                    if(gradCl[i].getCid(j).equals("Data1")) 
                            System.out.println("\t\tList of Gradstudent class\n "+"Fullname: " + grad[i].getFullname() + "\nStudent id: "+ grad[i].getSid());
            for(int i=0;i<under.length;i++)
                for(int j=0;j<underCl[i].cid.length;j++)
                    if(underCl[i].getCid(j).equals("Data1")) 
                            System.out.println("\t\tList of UnderGradstudent class\n "+"Fullname: " + under[i].getFullname() + "\nStudent id: "+ under[i].getSid());
            System.out.println("\n");
        }
        //Check the variable when entering it with the class ID is Data 2 
        if(id.equals("Data2")) 
        {
            for(int i=0;i<grad.length;i++)
                for(int j=0;j<gradCl[i].cid.length;j++)    
                    if(gradCl[i].getCid(j).equals("Data2")) 
                            System.out.println("\t\tList of Gradstudent class\n "+"Fullname: " + grad[i].getFullname() + "\nStudent id: "+ grad[i].getSid());
            for(int i=0;i<under.length;i++)
                for(int j=0;j<underCl[i].cid.length;j++)
                    if(underCl[i].getCid(j).equals("Data2")) 
                            System.out.println("\t\tList of UnderGradstudent class\n "+"Fullname: " + under[i].getFullname() + "\nStudent id: "+ under[i].getSid());
            System.out.println("\n");
        }
        //Check the variable when entering it with the class ID is AAI
        if(id.equals("AAI")) 
        {
            for(int i=0;i<grad.length;i++)
                for(int j=0;j<gradCl[i].cid.length;j++)    
                    if(gradCl[i].getCid(j).equals("AAI")) 
                            System.out.println("\t\tList of Gradstudent class\n "+"Fullname: " + grad[i].getFullname() + "\nStudent id: "+ grad[i].getSid());
            for(int i=0;i<under.length;i++)
                for(int j=0;j<underCl[i].cid.length;j++)
                    if(underCl[i].getCid(j).equals("AAI")) 
                            System.out.println("\t\tList of UnderGradstudent class\n "+"Fullname: " + under[i].getFullname() + "\nStudent id: "+ under[i].getSid());
            System.out.println("\n");
        }
    }
}

