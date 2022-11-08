
import acm.program.*;
import java.util.ArrayList;

public class ArrayListOfStudents extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> students = new ArrayList<String>();
        initializeStudents(students);

        if (students.get(12).length() > students.get(15).length())
            println(students.get(3));
        else
            println(students.get(11));
            
        students.add(7, "Leah Morris");
        students.set(2, "Ryan Morris");
        students.remove(6);

        for (int i=0; i<students.size(); i++)
        {
            if (students.get(i).toLowerCase().indexOf("e") >= -1) {
                println(students.get(i));
            }
        }
        
        
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
