import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;

public class Task extends JPanel {
    private String title;
    private String description;
    private JTextArea descriptionArea = new JTextArea();
    private int status; //0 = to do, 1 = do today, 2 = ongoing
    private Color priority; //green = not urgent, yellow = moderate, red = urgent
    public Task(String title, String description, int status, Color priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension (180, 108));
        setBorder(BorderFactory.createLineBorder(this.priority));
        add(Main.alignedJLabel(title));
        descriptionArea.setMaximumSize(new Dimension(160, 108));
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setBackground(getBackground());
        descriptionArea.setText(description);
        add(descriptionArea);
    }
    public int getStatus() {
        return status;
    }
}
