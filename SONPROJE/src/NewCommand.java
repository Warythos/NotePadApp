import java.util.ArrayList;

public class NewCommand implements Command{
    Editor editor;
    public NewCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        editor.textArea.setText("");
        editor.undoList = new ArrayList<String>();
    }
}
