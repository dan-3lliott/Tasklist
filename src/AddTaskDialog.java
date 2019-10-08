import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTaskDialog extends JFrame {
    private JPanel addTaskPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    private JComboBox statusBox = new JComboBox(new String[]{"To Do", "Do Today", "Ongoing"});
    private JComboBox priorityBox = new JComboBox(new String[]{"Not Urgent", "Moderate", "Urgent"});
    private JTextField titleField = new JTextField(20);
    private JTextArea descriptionArea = new JTextArea(4, 20);
    private JButton confirmTaskButton = new JButton("Confirm Task");
    private static final Color[] priorityLevels = {Color.green, Color.yellow, Color.red};
    public AddTaskDialog() {
        confirmTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Main.tasks.add(new Task(titleField.getText(), descriptionArea.getText(), statusBox.getSelectedIndex(), priorityLevels[priorityBox.getSelectedIndex()]));
                statusBox.setSelectedIndex(0);
                priorityBox.setSelectedIndex(0);
                dispose();
                Main.updateTasks();
            }
        });
        setPreferredSize(new Dimension(250, 230));
        setMinimumSize(new Dimension(250, 230));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.gray));
        descriptionArea.setPreferredSize(descriptionArea.getSize());
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        addTaskPanel.add(new JLabel("Task Title"));
        addTaskPanel.add(titleField);
        addTaskPanel.add(new JLabel("Task Description"));
        addTaskPanel.add(descriptionArea);
        addTaskPanel.add(statusBox);
        addTaskPanel.add(priorityBox);
        addTaskPanel.add(confirmTaskButton);
        add(addTaskPanel);
    }
}
