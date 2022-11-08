
import acm.program.*;
import java.util.ArrayList;

public class PartnerPicker extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        initializeStudents(students);
        while (students.size()  > 1)
        {
            int index = (int)(Math.random() * students.size());
            print(students.get(index) + " and ");
            students.remove(index);
            index = (int)(Math.random() * students.size());
            println(students.get(index));
            students.remove(index);
        }
        if (students.size() != 0)
        println(students.get(0));
        /*
         * 0.  Add some students.
         * 1.  Pick two random students and remove them from the ArrayList.
         * 2.  Repeat step #1 until there are no more students.
         * 3.  What if there are an odd number of students?
         *     Either make one person go solo, or make one group of three.
         */

    }
    
    
    public void initializeStudents(ArrayList<String> students)
    {
        students.add("Redmond Averbuck");
        students.add("Natasha Bamdad");
        students.add("Ariv Bhatnagar");
        students.add("Tina Chen");
        students.add("Neal Chopra");
        students.add("Marty Freeland");
        students.add("Kate Garlinghouse");
        students.add("Anneka Goel");   
        students.add("Yana Gulati");
        students.add("Vishnu Kagolanu");
        students.add("Nick Karros");
        students.add("Ethan Liu");
        students.add("Christina Long");
        students.add("Tynan Macaluso");
        students.add("Trent Melinauskas");
        students.add("Lily Pelham Burn");
        students.add("Thalia Stavropoulos");
        students.add("William Swart");
        students.add("Roshan Taneja");
        students.add("Naomi Watson");
        students.add("William Yen");
    }
}