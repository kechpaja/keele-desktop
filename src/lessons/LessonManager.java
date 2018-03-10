package lessons;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class LessonManager {
    
    public static Lesson loadLesson(String path) throws FileNotFoundException {
        FileReader reader = new FileReader(path + "/lesson.json"); // TODO change string paths to path objects
        Lesson lesson = (new Gson()).fromJson(reader, Lesson.class);
        lesson.setBasePath(path);
        return lesson;
    }

}
