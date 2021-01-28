import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SingleTransposition implements Pattern, Container{
    String words[];
    Editor editor;
    public SingleTransposition(Editor editor){
        this.editor = editor;
    }

    @Override
    public String conversion(String exp) {
        words = exp.split(" ");
        Iterator iterator = getIterator();
        Iterator iterator1 = getIterator();

        int index = -1;
        while (iterator.hasNext()){
            index++;
            String item = (String) iterator.next();
            String[] singleChars = item.split("");

            for(int i = 0; i < item.length(); i++){
                String[] transpositions = new String[item.length() - 1];
                if(i != singleChars.length - 1){
                    String holder = singleChars[i];
                    singleChars[i] = singleChars[i + 1];
                    singleChars[i+1] = holder;

                    StringBuffer sb = new StringBuffer();
                    for(int k = 0; k < singleChars.length; k++) { // transpositionları oluşturur
                        sb.append(singleChars[k]);
                    }

                    transpositions[i] = sb.toString();
                    try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) { // dosyada transpositionalrı kontrol eder
                        String line;
                        while ((line = br.readLine()) != null) {
                            if(line.equals(transpositions[i])){
                                words[index] = transpositions[i];
                            }
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    singleChars[i+1] = singleChars[i]; //orijinal kelimeye döndürür.
                    singleChars[i] = holder;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(iterator1.hasNext()){
            sb.append(iterator1.next() + " ");
        }
        return sb.toString();
    }

    @Override
    public Iterator getIterator() {
        return new StrArrayIterator(words);
    }
}
