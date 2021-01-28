public class ExitCommand implements Command{
    Editor editor;
    public ExitCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute(Editor editor) {
        System.exit(0);
    }
}
