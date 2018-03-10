package lessons;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TranslatedPair {

    private String targetLanguageItem_;
    private List<String> translations_;
    private List<String> imagePaths_;
    private List<String> audioFilePaths_;

    public TranslatedPair(String targetLanguageItem, 
                          List<String> translations,
                          List<String> imagePaths, 
                          List<String> audioFilePaths) {
        this.targetLanguageItem_ = targetLanguageItem;
        this.translations_ = translations;
        this.imagePaths_ = imagePaths;
        this.audioFilePaths_ = audioFilePaths;
    }
    
    // Use this instead of constructor. Constructor will eventually be marked private. 
    public TranslatedPair fromJSONObject(JsonObject obj) {
        String targetLanguageItem = obj.get("item").getAsString();
        
        List<String> translations = new ArrayList<String>();
        for (JsonElement element : obj.get("translations").getAsJsonArray()) {
            translations.add(element.getAsString());
        }
        
        List<String> imagePaths = new ArrayList<String>();
        for (JsonElement element : obj.get("images").getAsJsonArray()) {
            imagePaths.add(element.getAsString());
        }
        
        List<String> audioFilePaths = new ArrayList<String>();
        for (JsonElement element : obj.get("audio").getAsJsonArray()) {
            audioFilePaths.add(element.getAsString());
        }
        
        return new TranslatedPair(targetLanguageItem, translations, imagePaths, audioFilePaths);
    }
    
    public String getTargetLanguageItem() {
        return this.targetLanguageItem_;
    }
    
    public List<String> getTranslations() {
        return this.translations_;
    }
    
    public List<String> getImagePaths() {
        return this.imagePaths_;
    }
    
    public List<String> getAudioFilePaths() {
        return this.audioFilePaths_;
    }

}
