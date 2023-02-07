

public class FavouriteQuestion implements Question
{
    private String category;
    
    public FavouriteQuestion()
    {
        String[] categories = {"animal", "color", "song", "ice cream"};
        int index = (int)(Math.random() * categories.length);
        category = categories[index];
    }
    
    public String getPrompt(){
        return "what is your favourite" + category + "? :";
    }
    
    public String getCorrectAnswer(){
        return ("whatever you want");
    }
    
    public boolean isCorrect(String response){
        return true;
    }

}
