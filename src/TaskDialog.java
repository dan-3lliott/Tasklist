import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskDialog extends JFrame {
    private JPanel mainTaskPanel = new JPanel();
    private JComboBox statusBox = new JComboBox(new String[]{"To Do", "Do Today", "Ongoing"});
    private JComboBox priorityBox = new JComboBox(new String[]{"Not Urgent", "Moderate", "Urgent"});
    private JButton confirmTaskButton = new JButton("Confirm Task");
    private static final Color[] priorityLevels = {Color.green, Color.yellow, Color.red};
    public TaskDialog() {
        confirmTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Main.tasks.add(new Task("test task", "test description", statusBox.getSelectedIndex(), priorityLevels[priorityBox.getSelectedIndex()]));
                statusBox.setSelectedIndex(0);
                priorityBox.setSelectedIndex(0);
                dispose();
                Main.updateTasks();
            }
        });
        setPreferredSize(new Dimension(200, 200));
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        mainTaskPanel.add(statusBox);
        mainTaskPanel.add(priorityBox);
        mainTaskPanel.add(confirmTaskButton);
        add(mainTaskPanel);
    }
}
