import acm.program.*;
import java.util.ArrayList;

public class Quiz extends ConsoleProgram
{

    public void run()
    {
        ArrayList<Question> questions = new ArrayList<Question>();
        double num = Math.random();
        for (int i = 0; i < 10; i++){
            
            questions.add(new MultipleChoiceQuestion());
            //if (num < 1.0/3){
                //questions.add(new FavouriteQuestion());
            //} else if (num < 2.0/3) {
                //questions.add(new ArithmaticQuestion());
            //} else {
                //questions.add(new StateCapitalQuestion());
            //}
        }
        
        int score = 0;
        for (int i = 0; i < questions.size(); i++){
            println(questions.get(i).getPrompt());
            String answer = readLine("");
            if (questions.get(i).isCorrect(answer)){
                score++;
                println("Correct!");
            } else {
                println("Wrong");
                println("The correct answer was: " + questions.get(i).getCorrectAnswer());
            }
            println();
        }
        println("your score was " + score + "/" + questions.size() + "!");
    }

}
