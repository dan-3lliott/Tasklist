import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private final String[] topPanelText = {"TO DO", "DO TODAY", "ONGOING"};
    public static final Color[] priorityLevels = {Color.green, Color.yellow, Color.red};
    public Main() {
        initComponents();
    }
    public void initComponents() {
        //add action listeners for components
        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                AddTaskDialog t = new AddTaskDialog();
                t.setVisible(true);
            }
        });
        editTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                EditTaskDialog t = new EditTaskDialog(0);
                t.setVisible(true);
            }
        });
        //set up main jframe
        setTitle("test swing project");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        //set up taskdialog jframe
        //set parameters of elements
        //set parameters of panels and add to main panel
        topMenu.setPreferredSize(new Dimension(600, 20));
        addTask.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        addMenu.add(addTask);
        editMenu.add(editTask);
        topMenu.add(addMenu);
        topMenu.add(editMenu);
        mainPanel.add(topMenu);
        updatePanels();
        updateTasks();
        //add everything together, don't set mainPanel layout as it is flowlayout by default
        add(mainPanel);
    }
    public static void updateTasks() {
        for (int i = 0; i < taskPanels.size(); i++) {
            taskPanels.get(i).removeAll();
            for (Task t : tasks) {
                if (t.getStatus() == i) {
                    taskPanels.get(i).add(t);
                }
            }
        }
        mainPanel.revalidate();
    }
    public void updatePanels() {
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
    }
    public static JLabel alignedJLabel(String text) {
        JLabel alignedLabel = new JLabel(text);
        alignedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return alignedLabel;
    }
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main taskList = new Main();
                taskList.setVisible(true);
            }
        });
    }
    //variable declarations
    private static JPanel mainPanel = new JPanel(); //flowlayout with padding of 5 px by default
    private static ArrayList<JPanel> taskPanels = new ArrayList<JPanel>();
    private static ArrayList<JPanel> topPanels = new ArrayList<JPanel>();
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    private JMenuBar topMenu = new JMenuBar();
    private JMenu addMenu = new JMenu("Add");
    private JMenuItem addTask = new JMenuItem("Add Task");
    private JMenu editMenu = new JMenu("Edit");
    private JMenuItem editTask = new JMenuItem("Edit Task");
}
