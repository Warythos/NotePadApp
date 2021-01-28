import javax.swing.*;
import java.awt.*;

public class ChangeFrame implements Frame{
    Editor editor;
    public ChangeFrame(Editor editor){
        this.editor = editor;
    }

    @Override
    public void createFrame() {
        JFrame findFrame = new JFrame();
        findFrame.setVisible(true);
        JLabel label1 = new JLabel("Replace");
        JLabel label2 = new JLabel("With");

        editor.from_textField.setText("");
        editor.with_textField.setText("");

        editor.from_textField.setPreferredSize(new Dimension(250,20));
        editor.with_textField.setPreferredSize( new Dimension(250,20));
        editor.change_button.setBounds(30,30,100,30);
        editor.change_button.setText("Replace");
        editor.change_button.setFocusable(false);

        findFrame.setTitle("Replace");
        findFrame.setSize(300,200);
        findFrame.setDefaultCloseOperation(findFrame.DISPOSE_ON_CLOSE);
        findFrame.setLayout(new FlowLayout());
        findFrame.add(label1);
        findFrame.add(editor.from_textField);
        findFrame.add(label2);

        findFrame.add(editor.with_textField);
        findFrame.add(editor.change_button);
    }
}
