package avajlauncher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private BufferedWriter writer;
    private static Writer instance = null;

    private Writer() throws IOException {
        writer = new BufferedWriter(new FileWriter("simulation.txt"));
    };

    public static Writer getInstance() throws IOException {
        if (instance == null) {
            instance = new Writer();
            return instance;
        }
        return instance;
    }

    public void write(String text) throws IOException {
        writer.write(text);
    }

    public void close() throws IOException {
        writer.close();
    }
}
