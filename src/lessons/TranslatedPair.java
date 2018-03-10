package lessons;

import java.util.ArrayList;
import java.util.List;

public class TranslatedPair {

    private String item;
    private List<String> translations;
    
    // TODO replace string paths with path objects to increase portability
    private List<String> images;
    private List<String> audio;
    
    private transient String basePath_;

    public TranslatedPair(String item, List<String> translations, List<String> images, List<String> audio) {
        this.item = item;
        this.translations = translations;
        this.images = images;
        this.audio = audio;
    }
    
    public String getTargetLanguageItem() {
        return this.item;
    }
    
    public List<String> getTranslations() {
        return this.translations;
    }
    
    public List<String> getImagePaths() {
        ArrayList<String> imgs = new ArrayList<String>();
        for (String path : this.images) {
            imgs.add(this.basePath_ + "/" + path);
        }
        return imgs;
    }
    
    public List<String> getAudioFilePaths() {
        ArrayList<String> auds = new ArrayList<String>();
        for (String path : this.audio) {
            auds.add(this.basePath_ + "/" + path);
        }
        return auds;
    }
    
    protected void setBasePath(String basePath) {
        this.basePath_ = basePath;
    }

}
