public class CheckCommand implements Command, Container{
    Editor editor;
    String[] words;
    public CheckCommand(Editor editor){
        this.editor = editor;
    }
    @Override
    public void execute(Editor editor) {
        String txtarea = editor.textArea.getText();
        SingleTransposition transposition = new SingleTransposition(editor);

        editor.textArea.setText("");
        editor.textArea.setText(transposition.conversion(txtarea));
    }

    @Override
    public Iterator getIterator() {
        return new StrArrayIterator(words);
    }
}
