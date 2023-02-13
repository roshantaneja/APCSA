

public class MultipleChoiceQuestion implements Question
{
    private static final String[] questions = {
        "A motion between walking and trotting (Yorkshire dialect)", 
        "A garter tied below the knee of a young man as a sign that he was about to make an offer of marriage (Burns: Halloween 1785)",
        "Small worthless apples remaining on the tree after the crop has been gathered in (Wiltshire dialect)",
        "The pleasant smell that accompanies the first rain after a dry spell (1964)"};
    private static final String[] options = {
        "\n A.Nidge-Nudge \n B.Fidge-Fadge \n C.Rimble-Ramble \n D.Tridge-Trudge",
        "\n A.Wooer-bab \n B.Trothal-Tie \n C.Gaudy-gart \n D.Knee-Knocker",
        "\n A.Griggles \n B.Groggles \n C.Gruggles \n D.Graggles",
        "\n A.Ambrosamine \n B.Petrichor \n C.Gaia's breath \n D.Jitterbug perfume"};
    private static final String[] answer = {"B", "A", "A", "B"};
    
    private int index;
    
    public MultipleChoiceQuestion()
    {
        index = (int)(Math.random() * questions.length);
    }
    
    public String getPrompt(){
        return questions[index] + options[index];
    }
    
    public String getCorrectAnswer(){
        return answer[index];
    }
    
    public boolean isCorrect(String response){
        return response.toUpperCase().equals(getCorrectAnswer());
    }

}
