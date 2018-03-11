package lessons;

import java.util.ArrayList;

public class TranslatedPair {

    private String item;
    private ArrayList<String> translations;
    
    // TODO replace string paths with path objects to increase portability
    private ArrayList<String> images;
    private ArrayList<String> audio;
    
    private transient String basePath_;

    public TranslatedPair(String item, ArrayList<String> translations, ArrayList<String> images, ArrayList<String> audio) {
        this.item = item;
        this.translations = translations;
        this.images = images;
        this.audio = audio;
    }
    
    public String getTargetLanguageItem() {
        return this.item;
    }
    
    public ArrayList<String> getTranslations() {
        return this.translations;
    }
    
    public ArrayList<String> getImagePaths() {
        ArrayList<String> imgs = new ArrayList<String>();
        for (String path : this.images) {
            imgs.add(this.basePath_ + "/" + path);
        }
        return imgs;
    }
    
    public ArrayList<String> getAudioFilePaths() {
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
