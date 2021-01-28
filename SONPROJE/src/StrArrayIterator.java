public class StrArrayIterator implements Iterator{
    String[] strArray;
    private int index =0;
    public StrArrayIterator(String[] strArray){
        this.strArray = strArray;
    }


    @Override
    public boolean hasNext() {
        if(index < strArray.length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return strArray[index++];
        }
        return null;
    }

}
