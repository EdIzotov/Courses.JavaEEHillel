package com.jmx_test;

public class JMXResource implements JMXResourceI {
    private String value = "empty";

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void printJMXResourceInfo() {
        System.out.println("Info: " + value);
    }
    public String toString() {
        return "JMXResource{" +
                "value='" + value + '\'' +
                '}';
    }
}
