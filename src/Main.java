import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    public Main() {
        initComponents();
    }
    public void initComponents() {
        //add action listeners for components
        //set up main jframe
        setTitle("test swing project");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        //set parameters of elements
        //set parameters of panels and add to main panel
        topPanels.add(new JPanel());
        topPanels.get(0).setLayout(new BoxLayout(topPanels.get(0), BoxLayout.Y_AXIS));
        topPanels.get(0).setPreferredSize(new Dimension(194, 60));
        topPanels.get(0).setBorder(BorderFactory.createLineBorder(Color.gray));
        topPanels.get(0).add(alignedJLabel("TO DO"));
        toDoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanels.get(0).add(toDoButton);
        mainPanel.add(topPanels.get(0));
        topPanels.add(new JPanel());
        topPanels.get(1).setPreferredSize(new Dimension(194, 60));
        topPanels.get(1).setBorder(BorderFactory.createLineBorder(Color.gray));
        topPanels.get(1).add(alignedJLabel("DO TODAY"));
        mainPanel.add(topPanels.get(1));
        topPanels.add(new JPanel());
        topPanels.get(2).setPreferredSize(new Dimension(194, 60));
        topPanels.get(2).setBorder(BorderFactory.createLineBorder(Color.gray));
        topPanels.get(2).add(alignedJLabel("ONGOING"));
        mainPanel.add(topPanels.get(2));
        for (int i = 0; i < 3; i++) {
            taskPanels.add(new JPanel());
            taskPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
            taskPanels.get(i).setPreferredSize(new Dimension(194, 525));
            taskPanels.get(i).add(new Task("TEST TASK", "a test task", i));
            mainPanel.add(taskPanels.get(i));
        }
        //add everything together, don't set mainPanel layout as it is flowlayout by default

        add(mainPanel);
    }
    public JLabel alignedJLabel(String text) {
        JLabel alignedLabel = new JLabel(text);
        alignedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return alignedLabel;
    }
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main testProject = new Main();
                testProject.setVisible(true);
            }
        });
    }
    //variable declarations
    private JPanel mainPanel = new JPanel();
    private ArrayList<JPanel> taskPanels = new ArrayList<JPanel>();
    private ArrayList<JPanel> topPanels = new ArrayList<JPanel>();
    private JButton toDoButton = new JButton("add");
}
