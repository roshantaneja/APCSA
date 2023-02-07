
public interface Question
{
    String getPrompt();
    String getCorrectAnswer();
    boolean isCorrect(String response);
}
