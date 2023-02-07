

public class BoardBook extends ChildrensBook
{

    public BoardBook(String initialTitle, int howManyPages)
    {
        super(initialTitle, howManyPages);
    }
    
    // returns weight in ounces
    // front and back cover weigh 1.25 ounces each, and each page weighs 0.2 ounces 
    public double getWeight()
    {
        return 1.25 + 1.25 + 0.2 * getNumPages();
    }
    
    public int getRecommendedAge()
    {
        return super.getRecommendedAge() - 2;
    }

}
