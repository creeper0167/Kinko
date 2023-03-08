import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

public class Safe {
    public LinkedList<Character> getInput() {
        return input;
    }

    private String userPath;
    private LinkedList<Character> input;
    private LinkedList<Character> output;
    private LinkedList<Character> key;
    private final int upperBound = 127;

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
    public void encrypt(String outputName) throws Exception{
        String pathToWrite = System.getProperty("user.home") + "\\Documents\\Kinko\\";
        File dir = new File(pathToWrite);
        if (!dir.exists())
            dir.mkdirs();

        FileWriter fileWriter = new FileWriter(pathToWrite + outputName + ".txt");
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
        //save encrypted text to file
        for(Character ch: output){
            fileWriter.write(ch);
        }
        fileWriter.close();
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

    public void readFile(String path) throws Exception{
        userPath = path;
        input.clear();
        FileReader fileReader = new FileReader(path);

        int i;
        while ((i= fileReader.read()) != -1){
            input.add((char)i);
        }
        fileReader.close();
    }
}
