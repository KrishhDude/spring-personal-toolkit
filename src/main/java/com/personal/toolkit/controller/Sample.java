package com.personal.toolkit.controller;

public class Sample {

    public static void main(String[] args) {

        System.out.println("Hello World");

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */

        //create a simple service
        class AdditionService {
            public int add(int a, int b) {
                return a + b;
            }
        }

        //create an instance of the service
        AdditionService additionService = new AdditionService();

        //use the service to add two numbers
        int result = additionService.add(5, 10);
        System.out.println("The sum of 5 and 10 is: " + result);
/* <<<<<<<<<<  e6245da4-edb4-4302-a411-e87f672deb28  >>>>>>>>>>> */


    }
}
