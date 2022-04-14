package com.jmx_test;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXTest {
    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer platform = ManagementFactory.getPlatformMBeanServer();
        StandardMBean resource = new StandardMBean(new JMXResource(), JMXResourceI.class);
        platform.registerMBean(resource, new ObjectName("test:name=test_name"));
        while(true) {

        }
    }
}
