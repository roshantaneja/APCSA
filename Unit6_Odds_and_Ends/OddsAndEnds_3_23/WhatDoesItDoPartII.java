
import acm.program.*;

public class WhatDoesItDoPartII extends ConsoleProgram
{

    public void run()
    {
        setFont("*-36-*"); // makes the font bigger
        int num = 7;
        Student person = new Student("Natasha");
        int[] vals = {2, 4, 6, 8};
        println(num + " " + 
                person.getName() + " " + 
                vals[0]+vals[1]+vals[2]+vals[3]);
        modify(num, person, vals);
        println(num + " " + 
                person.getName() + " " + 
                vals[0]+vals[1]+vals[2]+vals[3]);
    }
    
    private void modify(int x, Student y, int[] z)
    {
        x = 43;
        y.setName("Tina");
        z[2] = z[3];
    }


}
