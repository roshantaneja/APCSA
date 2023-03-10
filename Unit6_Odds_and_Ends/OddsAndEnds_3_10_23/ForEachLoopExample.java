
import acm.program.*;
import java.util.ArrayList;

public class ForEachLoopExample extends ConsoleProgram
{

    public void run()
    {
        ArrayList<String> words = new ArrayList<String>();
        words.add("apple");
        words.add("banana");
        words.add("bear");
        words.add("carrot");
        words.add("bumblebee");
        words.add("aardvark");
        words.add("cat");
        words.add("camel");
        words.add("bison");
        words.add("cheetah");
        for (String word : words)
        {
            if (word.substring(0,1).equals("b"))
                words.add("dog");
        }
        for (String word : words)
            println(word);
    }

}
