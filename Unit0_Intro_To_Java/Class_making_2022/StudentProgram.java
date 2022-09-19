import acm.program.*;

public class StudentProgram extends ConsoleProgram
{

    public void run()
    {
        Student stud = new Student("William");
        stud.takeQuiz(80);
        stud.takeQuiz(62);
        stud.takeQuiz(98);
        double avg = stud.quizAverage(); 
        String who = stud.getName();
        println(who + "'s average is " + avg); 

        
    }


}
