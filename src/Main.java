import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private final String[] topPanelText = {"TO DO", "DO TODAY", "ONGOING"};
    private final Color[] priorityLevels = {Color.green, Color.yellow, Color.red};
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
        topMenu.setPreferredSize(new Dimension(600, 20));
        addMenu.add("Add task");
        topMenu.add(addMenu);
        //mainPanel.add(topMenu);
        for (int i = 0; i < 3; i++) {
            topPanels.add(new JPanel());
            topPanels.get(i).setLayout(new BoxLayout(topPanels.get(i), BoxLayout.Y_AXIS));
            topPanels.get(i).setPreferredSize(new Dimension(194, 20));
            topPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
            topPanels.get(i).add(alignedJLabel(topPanelText[i]));
            mainPanel.add(topPanels.get(i));
        }
        for (int i = 0; i < 3; i++) {
            taskPanels.add(new JPanel());
            taskPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
            taskPanels.get(i).setPreferredSize(new Dimension(194, 525));
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
    private FlowLayout mainLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
    private JPanel mainPanel = new JPanel(mainLayout);
    private ArrayList<JPanel> taskPanels = new ArrayList<JPanel>();
    private ArrayList<JPanel> topPanels = new ArrayList<JPanel>();
    private JMenuBar topMenu = new JMenuBar();
    private JMenu addMenu = new JMenu("Add");
}
