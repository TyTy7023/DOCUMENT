public class student
{
    private int sid;
    private String fullname, department, major, specialty, promotion;
   //getter
    public int getSid()
    {
        return sid;
    }
    public String getFullname()
    {
        return fullname;
    }
    public String getDepartment()
    {
        return department;
    }
    public String getMajor()
    {
        return major;
    }
    public String getSpecialty()
    {
        return specialty;
    }
    public String getPromotion()
    {
        return promotion;
    }
    //setter
    public void setFullname(String fullname)
    {
        this.fullname=fullname;
    }
    public void setDepartment(String department)
    {
        this.department=department;
    }
    public void setMajor(String major)
    {
        this.major=major;
    }
    public void setSpecialty(String specialty)
    {
        this.specialty=specialty;
    }
    public void setPromotion(String promotion)
    {
        this.promotion=promotion;
    }
    public void setSid(int sid)
    {
        this.sid=sid;
    }
}
