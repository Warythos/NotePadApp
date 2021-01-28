import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Editor extends JFrame{
    //GUI
    ArrayList<String> undoList = new ArrayList<String>(); // undo için kulllanılır
    String searchStr;
    int fileToOpen;
    int fileToSave;

    Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.orange );

    JTextArea textArea ;
    JButton search_button = new JButton();
    JButton change_button = new JButton();
    JTextField with_textField = new JTextField();
    JTextField search_textField = new JTextField();
    JTextField from_textField = new JTextField();
    JFileChooser fileOpen;
    JFileChooser fileSave;


    private Command undoCommand = new UndoCommand(this);
    private Command findCommand = new FindCommand(this);
    private Command changeCommand = new ChangeCommand(this);
    private Command checkCommand = new CheckCommand(this);

    private Command newCommand = new NewCommand(this);
    private Command openCommand = new OpenCommand(this);
    private Command saveCommand = new SaveCommand(this);
    private Command exitCommand = new ExitCommand(this);

    FrameFactory frameFactory = new FrameFactory(this);

    public Editor() {
        gui();
    }

    private void gui() {
        JFrame frame = new JFrame("Notepad");
        textArea = new JTextArea();
        frame.add(textArea);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        menuBar.add(file);
        menuBar.add(edit);
        frame.setJMenuBar(menuBar);

        JMenuItem newOption = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem find = new JMenuItem("Find");
        JMenuItem change = new JMenuItem("Change");
        JMenuItem check = new JMenuItem("Check");

        file.add(newOption);
        file.add(open);
        file.add(save);
        file.add(exit);

        edit.add(undo);
        edit.add(find);
        edit.add(change);
        edit.add(check);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                undoList.add(textArea.getText());
                textArea.getHighlighter().removeAllHighlights();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        textArea.addKeyListener(keyListener);
        Invoker invoker = new Invoker(this);

        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(undoCommand);
            }
        });

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(findCommand);
            }
        });

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(changeCommand);
            }
        });

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(checkCommand);
            }
        });

        newOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(newCommand);
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(openCommand);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.runCommand(saveCommand);
            }
        });

        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                invoker.runCommand(exitCommand);
            }
        });
    }
}



