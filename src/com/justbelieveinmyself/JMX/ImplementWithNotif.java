package JMX;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.Date;

public class ImplementWithNotif extends NotificationBroadcasterSupport implements MBean {
    private String name = "Vadim";
    private int sequanceNumber = 0;
    @Override
    public void sayHello() {
        Notification notification = new AttributeChangeNotification(this, sequanceNumber++, System.currentTimeMillis(), "Im sad Hello", "sequanceNum", "int", sequanceNumber-1, sequanceNumber);
        sendNotification(notification);
        System.out.println("Hello from bean");
    }

    @Override
    public int addNumbers(int a, int b) {
        return a+b;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getDate() {
        return new Date();
    }
}
