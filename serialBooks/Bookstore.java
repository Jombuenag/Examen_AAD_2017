package serialBooks;

import java.awt.event.KeyEvent;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Bookstore {

    private static Scanner userInput = new Scanner(System.in);

    //METHOD THAT READS THE CHOICE OF THE MENU
    public void userChoice(KeyEvent event){

    }

    public Book insertBook(){

        String newBookName = insertStrings("What's the name of the book?");
        int id = insertInts("Id number?");
        String newAuthor = insertStrings("Who's the author?");
        int newRelase = insertInts("Relase year?");
        String newEditor = insertStrings("Who edited the book?");
        int numPags = insertInts("How many pages?");

        Book b = new Book(id, newBookName, newAuthor, newRelase, newEditor, numPags);

        return b;

    }

    public void saveBook(Book b, String msg){
        ObjectOutputStream outputObject = null;

        try{
            outputObject = new ObjectOutputStream(new FileOutputStream(msg));
            outputObject.writeObject(b);
        }catch(IOException openingFailure){
            openingFailure.printStackTrace();
        }finally{
            close(outputObject);
        }
    }
    public Book retrieveBook(){
        String msg = insertStrings("Insert the name of the book that you wanna retrieve");
        Book b = null;
        ObjectInputStream inputObject = null;

        try{
            inputObject = new ObjectInputStream(new FileInputStream(msg));
            b = (Book)inputObject.readObject();
        }catch(ClassNotFoundException ex){
            System.err.println("File Error");
        }catch(IOException ex){
            System.err.println("Input / Output error");
        }finally{
            close(inputObject);
        }
        return b;

    }

    public int getData(){
        String msgData = insertStrings("insert the id of the book and I tell you the relase date");
        int relaseData = 0;
        Book b = null;
        ObjectInputStream inputObjectForData = null;
        try {
            inputObjectForData = new ObjectInputStream(new FileInputStream(msgData));
            b = (Book)inputObjectForData.readObject();
            relaseData = b.getRelaseData();
            System.out.println(relaseData);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }finally {
            close(inputObjectForData);
        }

        return relaseData;
    }

    public String insertStrings(String message){
        System.out.println(message);
        System.out.println("|------------------|");

        String userAnswer = userInput.nextLine();

        return userAnswer;
    }
    public int insertInts(String message){
        int answerIdInt = 0;
        boolean itsInt = false;
        boolean written = false;
        boolean canContinue = true;

        while(canContinue){
            itsInt = false;
            written = false;

            System.out.println(message);
            String answerId = userInput.nextLine();

            //THIS PART CONTROL IF THE DATA INPUT IS CORRECT
            if(answerId.length() != 0){
                written = true;
            }
            try{
                answerIdInt = Integer.valueOf(answerId);
                itsInt = true;
            }catch(NumberFormatException errorId){
                System.out.println("You write an unsupported value");
            }

            if(written && itsInt){
                canContinue = false;
            }
        }

        return answerIdInt;
    }

    public void close(Closeable closingTime){
        try{
            if(closingTime != null){
                closingTime.close();
            }
        }catch(IOException closingFailure){
            closingFailure.printStackTrace(System.err);
        }
    }
}
