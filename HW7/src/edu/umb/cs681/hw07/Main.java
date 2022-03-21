package edu.umb.cs681.hw07;

public class Main {
	public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        Thread t4 = new Thread();
        t1.run();
        t2.run();
        t3.run();
        t4.run();
    }
}