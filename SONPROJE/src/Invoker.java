public class Invoker {
    Editor editor;
    public Invoker (Editor editor){
        this.editor = editor;
    }

    public void runCommand(Command command){
        command.execute(editor);
    }
}
