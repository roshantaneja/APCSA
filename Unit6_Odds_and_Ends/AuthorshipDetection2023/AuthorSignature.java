
public class AuthorSignature
{ 
    // declare private instance variables here
    
    private String authorName;
    private double avgWordLength, differentWordRatio, hapaxRatio, avgWordsPerSentence, avgPhrasesPerSentence;
    
    public AuthorSignature(String authorName, double avgWordLength, double differentWordRatio, double hapaxRatio, double avgWordsPerSentence, double avgPhrasesPerSentence )
    {
        
        this.avgWordLength = avgWordLength;
        this.differentWordRatio = differentWordRatio;
        this.hapaxRatio = hapaxRatio;
        this.avgWordsPerSentence = avgWordsPerSentence;
        this.avgPhrasesPerSentence = avgPhrasesPerSentence;
        
        // "the job of the constructor is to initialize the private instance varables"
        
    }
    
    // you'll need five more methods here
}
