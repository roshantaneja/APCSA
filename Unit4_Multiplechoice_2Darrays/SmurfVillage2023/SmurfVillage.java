
public class SmurfVillage
{
    public static void main(String[] args)
    {
        Picture village = new Picture("images/" + "village.jpg");
        Picture smurf = new Picture("images/" + "smurfA.png");
        village.insert(smurf, 300, 600);
        village.explore();
        
    }
}