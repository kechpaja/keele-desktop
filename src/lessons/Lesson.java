package lessons;

import java.util.ArrayList;

public class Lesson {
    
    private ArrayList<TranslatedPair> content;
    private String grammar;
    
    protected void setBasePath(String basePath) {
        for (TranslatedPair pair : this.content) {
            pair.setBasePath(basePath);
        }
    }
    
    public ArrayList<TranslatedPair> getContent() {
        ArrayList<TranslatedPair> pairs = new ArrayList<TranslatedPair>();
        for (TranslatedPair tp : this.content) {
            pairs.add(tp);
        }
        return pairs;
    }
    
    public String getGrammar() {
        return this.grammar;
    }

}
