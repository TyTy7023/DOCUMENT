public class ClassInfo
{
    //Atribute
    public String course[], cid[];
    //getter
    public String getCourse(int i)
    {
        return course[i];
    }
    public String getCid(int i)
    {
        return cid[i];
    }
    //setter
    public void setCourse(String course,int i)
    {
        this.course[i]=course;
    }
    public void setCid(String cid,int i)
    {
        this.cid[i]=cid;
    }
}