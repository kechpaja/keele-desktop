package pages;

import java.util.List;

import lessons.TranslatedPair;
import main.ActivityPanel;

public class VocabPage extends ActivityPanel {

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = -2475680546095874083L;
    
    public VocabPage(List<TranslatedPair> vocab) {
        // TODO layout manager
        
        for (TranslatedPair pair : vocab) {
            // TODO create horizontal container and add all items. Then, add container to this. 
            
            // TODO we can also play around with group layouts. Maybe later. 
        }
        
        this.revalidate();
    }
    
    // TODO get list of translated pairs from lesson, and display word, images, sounds files, translations for each entry
    
    // TODO allow non-mouseover translations and images to be toggled

}
