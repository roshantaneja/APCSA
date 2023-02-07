

public class Canary extends Bird
{
    public Canary()
    {
        super("Canary");
    }
    
    public boolean isInCoalMine(){
        return true;
    }
    
    //Overriding Chirp Method
    public void chirp(){
        super.chirp();
        System.out.println("Im a Canary!");
    }
}