import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeCommand implements Command, Container{
    Editor editor;
    String [] words;
    public ChangeCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        //*************** CREATES FRAME **************//
        Frame changeFrame = editor.frameFactory.getFrame("CHANGE");
        changeFrame.createFrame();

        //*************** SPECIFIES BUTTON IN THE FRAME **************//
        editor.change_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtarea = editor.textArea.getText();
                words = txtarea.split(" ");
                String from = editor.from_textField.getText();
                String with = editor.with_textField.getText();

                Iterator iterator = getIterator();
                Iterator iterator1 = getIterator();

                int i = -1;
                while(iterator.hasNext()){
                    i++;
                    String item = (String)iterator.next();
                    if(item.equals(from)){
                        words[i] = with;
                    }
                }

                // Updates textArea after replaces
                editor.textArea.setText("");
                while(iterator1.hasNext()){
                    editor.textArea.append(iterator1.next()+ " ");
                }
            }
        });
    }

    @Override
    public Iterator getIterator() {
        return new StrArrayIterator(words);
    }
}
