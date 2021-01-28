public class FrameFactory {
    Editor editor;
    public FrameFactory(Editor editor){
        this.editor = editor;
    }
    public Frame getFrame(String frameType){
        if(frameType == null){
            return null;
        }
        if(frameType.equalsIgnoreCase("FIND")){
            return new FindFrame(editor);
        } else if(frameType.equalsIgnoreCase("CHANGE")){
            return new ChangeFrame(editor);
        }
        return null;
    }
}
