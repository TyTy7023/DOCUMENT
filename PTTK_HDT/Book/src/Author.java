import java.util.Objects;

public class Author{
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return this.gender;
    }
    public void setGender(char gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author[name: " + this.name + ",email: " + this.email + ", gender: " + gender + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Author author = (Author) obj;
        return this.name.equals(author.name) && this.email.equals(author.email) && this.gender == (author.gender);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, email, gender);
    }

}