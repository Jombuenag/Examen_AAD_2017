package serialBooks;
import java.io.Serializable;

//Clase del objeto libro
public class Book implements Serializable{
    String titulo, autor, editor,anyo, numeroPaginas;

    public Book(){

    }
    public Book(String titulo, String autor, String editor, String anyo, String numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editor = editor;
        this.anyo = anyo;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }


}
