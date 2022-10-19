

public class RoachPopulation
{
    private int population;
    
    public RoachPopulation(int numRoaches)
    {
        population = numRoaches;
    }
    
    public void breed(){
        population = population * 2;
    }
    
    public void spray(){
        population = population / 10;
    }
    
    public int getNumRoaches(){
        return (population);
    }

}
