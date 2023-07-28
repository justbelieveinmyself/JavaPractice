package JAXB;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Customer {
    int id;
    String name;
    int age;
    @XmlAttribute
    public void setId(int id)
    {
        this.id = id;
    }
    @XmlElement
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    @XmlElement
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
