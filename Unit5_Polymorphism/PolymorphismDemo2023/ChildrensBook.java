

public class ChildrensBook
{
    private String title;
    private int numPages;
    
    public ChildrensBook(String initialTitle, int howManyPages)
    {
        title = initialTitle;
        numPages = howManyPages;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getNumPages()
    {
        return numPages;
    }
    
    // returns weight in ounces
    // front and back cover weigh 0.4 ounces each, and each page weighs 0.05 ounces 
    public double getWeight()
    {
        return 0.4 + 0.4 + 0.05 * numPages;
    }
    
    public int getRecommendedAge()
    {
        if (numPages < 20)
            return 2;
        else if (numPages < 40)
            return 6;
        else
            return 10;
    }
    
    

}
