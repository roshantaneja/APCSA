
import acm.program.*;

public class ArrayOfStudents extends ConsoleProgram
{

    public void run()
    {
        String[] students;
        students = new String[21];
        initializeStudents(students);
        
        println(students[0].substring(3,5) + 
                students[10].substring(7,9) + 
                students[9].substring(1,3));
        if (students[12].length() > students[6].length())
            println(students[3]);
        else
            println(students[15]);
       }

    public void initializeStudents(String[] students)
    {
        students[0] = "Redmond Averbuck";
        students[1] = "Natasha Bamdad";
        students[2] = "Ariv Bhatnagar";
        students[3] = "Tina Chen";
        students[4] = "Neal Chopra";
        students[5] = "Marty Freeland";
        students[6] = "Kate Garlinghouse";
        students[7] = "Anneka Goel";   
        students[8] = "Yana Gulati";
        students[9] = "Vishnu Kagolanu";
        students[10] = "Nick Karros";
        students[11] = "Ethan Liu";
        students[12] = "Christina Long";
        students[13] = "Tynan Macaluso";
        students[14] = "Trent Melinauskas";
        students[15] = "Lily Pelham Burn";
        students[16] = "Thalia Stavropoulos";
        students[17] = "William Swart";
        students[18] = "Roshan Taneja";
        students[19] = "Naomi Watson";
        students[20] = "William Yen";
    }
}
