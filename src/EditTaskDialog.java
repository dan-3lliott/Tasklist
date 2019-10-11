import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditTaskDialog extends JFrame{
    private JPanel editTaskPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    private JComboBox statusBox = new JComboBox(new String[]{"To Do", "Do Today", "Ongoing"});
    private JComboBox priorityBox = new JComboBox(new String[]{"Not Urgent", "Moderate", "Urgent"});
    private JTextField titleField = new JTextField(20);
    private JTextArea descriptionArea = new JTextArea(4, 20);
    private JButton confirmTaskButton = new JButton("Confirm Task");
    public EditTaskDialog(int taskIndex) {
        confirmTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Main.tasks.set(taskIndex, new Task(titleField.getText(), descriptionArea.getText(), statusBox.getSelectedIndex(), Main.priorityLevels[priorityBox.getSelectedIndex()]));
                statusBox.setSelectedIndex(0);
                priorityBox.setSelectedIndex(0);
                dispose();
                Main.updateTasks();
            }
        });
        setTitle("Edit Task");
        setPreferredSize(new Dimension(250, 230));
        setMinimumSize(new Dimension(250, 230));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        statusBox.setSelectedIndex(Main.tasks.get(taskIndex).getStatus());
        priorityBox.setSelectedIndex(java.util.Arrays.asList(Main.priorityLevels).indexOf(Main.tasks.get(taskIndex).getPriority()));
        titleField.setText(Main.tasks.get(taskIndex).getTitle());
        descriptionArea.setText(Main.tasks.get(taskIndex).getDescription());
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.gray));
        descriptionArea.setPreferredSize(descriptionArea.getSize());
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        editTaskPanel.add(new JLabel("Task Title"));
        editTaskPanel.add(titleField);
        editTaskPanel.add(new JLabel("Task Description"));
        editTaskPanel.add(descriptionArea);
        editTaskPanel.add(statusBox);
        editTaskPanel.add(priorityBox);
        editTaskPanel.add(confirmTaskButton);
        add(editTaskPanel);
    }
}