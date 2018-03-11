package waterfall;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lessons.Lesson;
import lessons.TranslatedPair;

public class ImageWordWaterfall extends Waterfall {

    /**
     * Added to keep the compiler happy
     */
    private static final long serialVersionUID = 4320382297795091066L;
    
    public ImageWordWaterfall(Lesson lesson) {
        List<TranslatedPair> lessonContent = lesson.getContent();
        
        // Shuffle list
        Collections.shuffle(lessonContent);
        
        for (TranslatedPair tp : lessonContent) {
            Set<String> answers = new HashSet<String>();
            answers.add(tp.getTargetLanguageItem());
            
            for (String path : tp.getImagePaths()) {
                this.addQueuedBlock(new ImageBlock(path, answers));
            }
        }
    }

}
