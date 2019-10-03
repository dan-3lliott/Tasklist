import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;

public class Task extends JPanel {
    private String title;
    private String description;
    private int status; //0 = to do, 1 = do today, 2 = ongoing
    private Color priority; //green = not urgent, yellow = moderate, red = urgent
    public Task(String title, String description, int status, Color priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.setPreferredSize(new Dimension (180, 60));
        this.setBorder(BorderFactory.createLineBorder(priority));
    }
}
