
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
        students.add("Amelie Boom");
        students.add("Ellie Brew");
        students.add("Nicholas Chin");
        students.add("Alberto Clegg Gonzalez");
        students.add("Neha Lalia");
        students.add("Leila Nawas");
        students.add("Nic Nikcevic");
        students.add("Theo Parker");
        students.add("Ava Shenk");
        students.add("Ian Smith");
        students.add("Bella Summe");
        students.add("Colleen Tanona");
        students.add("Louka Triant");
        students.add("Catherine Zhu");
    }
}