import java.util.ArrayList;

public class ZoomStudent
{
    private String name;
    private String location;
    private ArrayList<String> moviesWatched;
    
    public ZoomStudent(String startingName, String startingLocation)
    {
        name = startingName;
        location = startingLocation;
        moviesWatched = new ArrayList<String>();
    }
    
    public String getName()
    {
        return name;
    }
    
    /** Returns your location
     * @return a string representing your location
     */
    public String getLocation()
    {
        return location;
    }
    
    /** This method changes where you are during Zoom times.
     * @param otherLocation the place you are now
     */
    public void setLocation(String otherLocation)
    {
        location = otherLocation;
    }
    
    public void watchMovie(String title)
    {
        moviesWatched.add(title);
    }
    
    public int getNumMoviesWatched()
    {
        return moviesWatched.size();
    }

}
