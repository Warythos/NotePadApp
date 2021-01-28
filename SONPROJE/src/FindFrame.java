import javax.swing.*;
import java.awt.*;

public class FindFrame implements Frame{
    Editor editor;
    public FindFrame(Editor editor){
        this.editor = editor;
    }

    @Override
    public void createFrame() {
        JFrame findFrame = new JFrame();
        findFrame.setVisible(true);
        editor.search_textField.setText("");

        editor.search_textField.setPreferredSize(new Dimension(250,20));
        editor.search_button.setBounds(10,10,100,30);
        editor.search_button.setText("Search");
        editor.search_button.setFocusable(false);

        findFrame.setTitle("Search");
        findFrame.setSize(300,200);
        findFrame.setDefaultCloseOperation(findFrame.DISPOSE_ON_CLOSE);
        findFrame.setLayout(new FlowLayout());
        findFrame.add(editor.search_button);
        findFrame.add(editor.search_textField);
    }
}
