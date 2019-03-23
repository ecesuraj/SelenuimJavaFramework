package Bookwoo;

import java.util.Scanner;

public class Simple {

	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("What is your name? ");
		String name=sc.nextLine();
		
		System.out.println("Hi, "+name);
	}
}
