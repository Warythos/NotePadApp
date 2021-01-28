import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveCommand implements Command{
    Editor editor;
    public SaveCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        JFileChooser save = new JFileChooser();
        int option = save.showOpenDialog(editor);
        editor.fileToSave = option;
        editor.fileSave = save;

        if (editor.fileToSave == JFileChooser.APPROVE_OPTION){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(editor.fileSave.getSelectedFile().getPath()));
                out.write(editor.textArea.getText());
                out.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
