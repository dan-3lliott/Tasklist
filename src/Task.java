import javax.swing.*;
import java.awt.Dimension;

public class Task extends JPanel {
    private String title;
    private String description;
    private int status; //0 = to do, 1 = do today, 2 = ongoing
    public Task(String title, String description, int status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.setPreferredSize(new Dimension (180, 60));
        this.setBorder(BorderFactory.createLineBorder(java.awt.Color.cyan));
    }
}
