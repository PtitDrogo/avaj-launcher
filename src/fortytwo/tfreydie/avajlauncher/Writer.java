package fortytwo.tfreydie.avajlauncher;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private BufferedWriter writer;
    private static Writer instance = null;
    
    private Writer() throws IOException {
        writer = new BufferedWriter(new FileWriter(Consts.FILE_NAME));
    }
    
    public static Writer getInstance() throws IOException {
        if (instance == null) {
            instance = new Writer();
        }
        return instance;
    }
    
    public void write(String text) throws IOException {
        writer.write(text);
        writer.newLine();
    }
    
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
            writer = null;
        }
        instance = null;
    }
}