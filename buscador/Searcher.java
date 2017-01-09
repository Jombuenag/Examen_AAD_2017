package buscador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Searcher{

    TreeSet<String> wordsTree = new TreeSet<String>();
    TreeSet headset;

    String wordSeed = "";
    String wordToSearch = "";

    public Searcher(){
        File f = new File("C:\\Users\\Taku\\workspace\\Examen AAD 2017\\src\\Words.txt");
        try {
            dictionary(f, wordToSearch);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void dictionary(File f, String wordToSearch)throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while((wordSeed = br.readLine())!=null){
            wordsTree.add(wordSeed);
            System.out.println(wordSeed);
        }

        Scanner sc = new Scanner(System.in);

        wordToSearch = sc.nextLine();
        System.out.println("Searching for " + wordToSearch);
        headset = (TreeSet) wordsTree.headSet(wordToSearch);
        //create descending iterator
        Iterator iterator;
        iterator = headset.descendingIterator();
        //displaying the Tree set data
        System.out.println("Tree set data in descending order: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}
