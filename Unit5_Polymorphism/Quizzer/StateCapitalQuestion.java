

public class StateCapitalQuestion implements Question
{
    private static final String[] states = {"California", "Oregon", "Washington"};
    private static final String[] capitals = {"Sacramento", "Salem", "Olympia"};
    private int index;
    
    public StateCapitalQuestion()
    {
        index = (int)(Math.random() * states.length);
    }
        
    public String getPrompt() {
        return("What is the capital of " + states[index] + "?");
    }
    
    public String getCorrectAnswer() {
        return (capitals[index]);
    }
    
    
    public boolean isCorrect(String response) {
        return response.equals(getCorrectAnswer());
    }

}
