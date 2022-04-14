package com.jmx_test;

public interface JMXResourceI {
    String getValue();
    void setValue(String value);
    void printJMXResourceInfo();
    @Override
    String toString();
}
