package lessons;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    
    private List<TranslatedPair> content;
    
    protected void setBasePath(String basePath) {
        for (TranslatedPair pair : this.content) {
            pair.setBasePath(basePath);
        }
    }
    
    public List<TranslatedPair> getContent() {
        ArrayList<TranslatedPair> pairs = new ArrayList<TranslatedPair>();
        for (TranslatedPair tp : this.content) {
            pairs.add(tp);
        }
        return pairs;
    }

}
