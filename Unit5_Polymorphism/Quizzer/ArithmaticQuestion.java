

public class ArithmaticQuestion implements Question
{
    public int a;
    public int b;
    
    public ArithmaticQuestion()
    {
        a = (int)(Math.random() * 90) + 10;
        b = (int)(Math.random() * 90) + 10;
    }
    
    public String getPrompt(){
        return "What is " + a + " + " + b + "?";
    }
    
    public String getCorrectAnswer(){
        return (a + b) + "";
    }
    
    
    public boolean isCorrect(String response){
        return response.equals(getCorrectAnswer());
    }
    

}
