
import acm.program.*;

public class WhatDoesItDoPartI extends ConsoleProgram
{
 
    public void run()
    {
        setFont("*-36-*"); // makes the font bigger
         
        int a = 7;
        Student x = new Student("Neal");
        int b = a;
        Student y = x;
         
        println(a + " " + b);
        println(x.getName() + " " + y.getName());
        
        a = 6;
        b = 5;
        x.setName("Nick");
        y.setName("Trent");
        
        println(a + " " + b);
        println(x.getName() + " " + y.getName());
    }
    
    


}
