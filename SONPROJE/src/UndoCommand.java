public class UndoCommand implements Command{
    Editor editor;
    public UndoCommand(Editor editor){
        this.editor = editor;
    }
    @Override
    public void execute(Editor editor) {
        editor.textArea.setText(editor.undoList.get(editor.undoList.size() - 1));
        editor.undoList.remove(editor.undoList.get(editor.undoList.size() - 1));
    }
}
