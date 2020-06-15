package org.hui;

import sun.rmi.transport.tcp.TCPEndpoint;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Student student =new Tom();
        Teacher teacher =new Teacher(student);
        teacher.question();
    }
}
