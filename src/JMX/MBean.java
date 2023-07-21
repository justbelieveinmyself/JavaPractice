package JMX;

import javax.management.MXBean;
import java.util.Date;
@MXBean
public interface MBean {
    void sayHello();
    int addNumbers(int a, int b);
    String getName();
    void setName(String name);
    Date getDate();

}
