package serialBooks;
import java.io.Serializable;

public class Book implements Serializable{

    public int id = 0;
    public String title = "";
    public String author = "";
    public int relaseData = 0;
    public String editor = "";
    public int numberOfPages = 0;

    //CONSTRUCTOR
    public Book(int i, String t, String a, int rd,String e,int nop){
        id= i;
        title = t;
        author = a;
        relaseData = rd;
        editor = e;
        numberOfPages = nop;
    }


    //GETS AND SETS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRelaseData() {
        return relaseData;
    }

    public void setRelaseData(int relaseData) {
        this.relaseData = relaseData;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }


    public int getNumberOfPages() {
        return numberOfPages;
    }


    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    //PRINT METHOD, THIS GIVE US A "TICKET"
    public void print(){
        System.out.println("Id of the book : " + id);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Relase data : " + relaseData);
        System.out.println("Editor : " + editor);
        System.out.println("Number of pages : " + numberOfPages);
    }

}
