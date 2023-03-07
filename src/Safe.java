import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

public class Safe {
    private Queue<Character> input;
    private LinkedList<Character> output;
    private LinkedList<Character> key;
    private int upperBound = 127;

    public Safe(){
        input = new LinkedList<>();
        output = new LinkedList<>();
        key = new LinkedList<>();
    }
    public void setInput(String in){
        for(int i=0; i < in.length(); i++){
            this.input.add(in.charAt(i));
        }
    }
    public void setOutput(String in){
        for(int i=0; i < in.length(); i++){
            this.output.add(in.charAt(i));
        }
    }
    public String getOutput(){
        String o = "";
        for(Character character: output)
            o+= character;
        return o;
    }

    public void setKey(String in){
        key.clear();
        char[] chars = in.toCharArray();
        for(char ch: chars){
            key.add(ch);
        }
    }
    public String getKey(){
        return key.toString();
    }
    public void encrypt(String in){
        setInput(in);
        Random random = new Random();
        int randomCharacter;
        int charAscii;
        char finalChar;

        for(Character ch: input){
            randomCharacter = random.nextInt(upperBound);
            this.key.add((char)randomCharacter);
            charAscii = ch;
            charAscii += randomCharacter;
            finalChar = (char) charAscii;
            output.add(finalChar);
        }

    }


    public String decrypt(){
        String o = "";

        for(int i=0; i < key.size(); ++i){
            int keyAscii = (int) key.get(i);
            int charAscii = (int) output.get(i);
            int originalAscii = Math.abs(keyAscii - charAscii);
            o+=(char) originalAscii;
        }

        return o;
    }
}
