import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindCommand implements Command{
    Editor editor;
    public FindCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        //*************** CREATES FRAME **************//
        Frame findFrame = editor.frameFactory.getFrame("FIND");
        findFrame.createFrame();

        //*************** SPECIFIES BUTTON IN THE FRAME **************//
        editor.search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editor.textArea.getHighlighter().removeAllHighlights();
                editor.searchStr = editor.search_textField.getText();
                String text = editor.textArea.getText();

                int offset = text.indexOf(editor.searchStr);
                int length = editor.searchStr.length();

                while ( offset != -1)
                {
                    try
                    {
                        editor.textArea.getHighlighter().addHighlight(offset, offset + length, editor.painter);
                        offset = text.indexOf(editor.searchStr, offset+1);
                    }
                    catch(BadLocationException ble) { System.out.println(ble); }
                }
            }
        });

    }


}
