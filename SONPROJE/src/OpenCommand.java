import javax.swing.*;
import java.io.FileReader;
import java.util.Scanner;

public class OpenCommand implements Command{
    Editor editor;
    public OpenCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        JFileChooser open = new JFileChooser();
        int option = open.showOpenDialog(editor);
        editor.fileToOpen = option;
        editor.fileOpen = open;

        if (editor.fileToOpen == JFileChooser.APPROVE_OPTION){
            editor.textArea.setText("");
            try{
                Scanner scan = new Scanner(new FileReader(editor.fileOpen.getSelectedFile().getPath()));
                while (scan.hasNext())
                    editor.textArea.append(scan.nextLine());
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
