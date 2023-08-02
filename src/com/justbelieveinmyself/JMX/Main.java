package com.justbelieveinmyself.JMX;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer  mBeanServer = ManagementFactory.getPlatformMBeanServer();
//        ObjectName objName = new ObjectName("JMX:type=Implement");
//        Implement myBean = new Implement();
//        mBeanServer.registerMBean(myBean, objName);
        ObjectName objNameWithNotif = new ObjectName("JMX:type=ImplementWithNotif");
        ImplementWithNotif myBeanNotif = new ImplementWithNotif();
        mBeanServer.registerMBean(myBeanNotif, objNameWithNotif);
        System.out.println("Waiting commands...");
        Thread.sleep(Long.MAX_VALUE); //192.168.1.11:65535
    }
}
//-Dcom.sun.management.jmxremote.authenticate=false
//-Dcom.sun.management.jmxremote.port=9999
//-Dcom.sun.management.jmxremote.ssl=false - VM OPTIONS TO REMOTE CONNECT TO U PROCCES