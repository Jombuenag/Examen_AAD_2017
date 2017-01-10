package serialBooks;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Clase que se encargara tanto de crear un libro como de recuperarlo
public class Bookstore {

    public Bookstore(){

    }
    public void guardar(Book b, String f){

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            intentarCerrar(out);
        }
    }

    public Book recuperar(String f){
        Book b = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            b = (Book) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            intentarCerrar(in);
        }
        return b;
    }

    public void intentarCerrar(Closeable aCerrar){
        if(aCerrar != null){
            try {
                aCerrar.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
