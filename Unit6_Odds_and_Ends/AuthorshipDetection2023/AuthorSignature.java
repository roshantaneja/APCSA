
public class AuthorSignature
{ 
    // declare private instance variables here
    
    private String authorName;
    private double avgWordLength, differentWordRatio, hapaxRatio, avgWordsPerSentence, avgPhrasesPerSentence;
    private static final double[] WEIGHT = {11.0, 33.0, 50.0, 0.4, 4.0};
    
    public AuthorSignature(String authorName, double avgWordLength, double differentWordRatio, double hapaxRatio, double avgWordsPerSentence, double avgPhrasesPerSentence )
    {
        
        this.authorName = authorName;
        this.avgWordLength = avgWordLength;
        this.differentWordRatio = differentWordRatio;
        this.hapaxRatio = hapaxRatio;
        this.avgWordsPerSentence = avgWordsPerSentence;
        this.avgPhrasesPerSentence = avgPhrasesPerSentence;
        
        // "the job of the constructor is to initialize the private instance varables"
        
    }
    
    public double distanceTo(AuthorSignature a){
        double[] unknownSet = a.getSignatureSet();
        double[] thisSet = this.getSignatureSet();
        double sum = 0.0;
        for (int i = 0; i < 5; i++) {
            sum += Math.abs(thisSet[i] - unknownSet[i]) * WEIGHT[i];
        }
        return sum;
        
    }
    
    // you'll need five more methods here
    
    public String getName(){return authorName;}
    public double getAvgWordLength(){return avgWordLength;}
    public double getDifferentWordRatio(){return differentWordRatio;}
    public double getHapaxRatio(){return hapaxRatio;}
    public double getAvgWordsPerSentence(){return avgWordsPerSentence;}
    public double getAvgPhrasesPerSentence(){return avgPhrasesPerSentence;}
    
    public double[] getSignatureSet(){
        double[] result = {avgWordLength, differentWordRatio, hapaxRatio, avgWordsPerSentence, avgPhrasesPerSentence};
        return result;
    }
    
}
