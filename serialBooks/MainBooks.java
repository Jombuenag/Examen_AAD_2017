package serialBooks;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainBooks {

    Scanner sc = new Scanner(System.in);
    ArrayList<Book> listaLibros;
    Bookstore bookstore;
    public static void main(String[] args) {
        MainBooks inicio = new MainBooks();
        System.out.println("Elige una de las opciones");
        System.out.println("1. Guardar libro");
        System.out.println("2. Recuperar libro");
        System.out.println("3. Lista de libros");
        System.out.println("4. Modificar libro");
        System.out.println("5. Ejercicio 3");
        int opcion = inicio.sc.nextInt();
        String basura = inicio.sc.nextLine();
        switch (opcion) {
            case 1:
                inicio.guardarLibro();
                break;
            case 2:
                inicio.recuperarLibro();
                break;
            case 3:
                inicio.listaDeLibros();
                break;
            case 4:
                inicio.modificarLibro();
                break;
            case 5:
                String [] nombres = {"Doneria","libro2","libro3"};
                inicio.ejercicio3(nombres, "C:\\Users\\Taku\\workspace\\Examen AAD 2017");
                break;
            default:
                break;
        }

    }

    public void guardarLibro(){
        //pedimos los datos necesarios para guardar un libro
        System.out.println("Titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Editor del libro: ");
        String editor = sc.nextLine();
        System.out.println("Año del libro: ");
        String anyo = sc.nextLine();
        System.out.println("Numero de paginas del libro: ");
        String numeroPaginas = sc.nextLine();
        System.out.println("Elige la ruta en donde quieres guardar el libro");
        String ruta = sc.nextLine();

        //Llamamos a biblioteca para poder utiizar sus metodos
        bookstore = new Bookstore();
        Book b = new Book(titulo, autor, editor, anyo, numeroPaginas);
        bookstore.guardar(b, ruta + "\\" + titulo + ".dat");
    }

    public void recuperarLibro(){
        System.out.println("Introduce la ruta del fichero que se desea recuperar: ");
        String ruta = sc.nextLine();
        bookstore = new Bookstore();
        Book b = bookstore.recuperar(ruta);
        System.out.println("Titulo: " + b.getTitulo());
        System.out.println("Autor: " + b.getAutor());
        System.out.println("Editor: " + b.getEditor());
        System.out.println("Año de publicación: " + b.getAnyo());
        System.out.println("Numero de paginas: "+ b.getNumeroPaginas());

    }

    public void listaDeLibros(){
        listaLibros = new ArrayList<Book>();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Elige una de las opciones: ");
            System.out.println("1. Añadir libro a la lista");
            System.out.println("2. Guardar lista");
            System.out.println("3. Ver lista");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            String basura = sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Titulo del libro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Autor del libro: ");
                    String autor = sc.nextLine();
                    System.out.println("Editor del libro: ");
                    String editor = sc.nextLine();
                    System.out.println("Año del libro: ");
                    String anyo = sc.nextLine();
                    System.out.println("Numero de paginas del libro: ");
                    String numeroPaginas = sc.nextLine();
                    Book b = new Book(titulo, autor, editor, anyo, numeroPaginas);
                    listaLibros.add(b);
                    break;
                case 2:
                    bookstore = new Bookstore();
                    System.out.println("Elige la ruta en donde quieres guardar la lista de libros");
                    String ruta = sc.nextLine();
                    Iterator it = listaLibros.iterator();
                    while(it.hasNext()){
                        Book book = (Book) it.next();
                        bookstore.guardar(book, ruta+"\\"+book.getTitulo()+".dat");
                    }
                    break;
                case 3:
                    Iterator ite = listaLibros.iterator();
                    while(ite.hasNext()){
                        Book book = (Book) ite.next();
                        System.out.println("Titulo: "+book.getTitulo());
                        System.out.println("Autor: "+book.getAutor());
                        System.out.println("Editor: " + book.getEditor());
                        System.out.println("Año de publicación: " + book.getAnyo());
                        System.out.println("Numero de paginas: " + book.getNumeroPaginas());
                        System.out.println("----------------------------------------------");

                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    public void modificarLibro(){
        System.out.println("Introduce la ruta del fichero que quieres modificar: ");
        String ruta = sc.nextLine();

        //Recuperamos el libro
        bookstore = new Bookstore();
        Book b = new Book();
        b = bookstore.recuperar(ruta);
        System.out.println("Titulo: " + b.getTitulo());
        System.out.println("Autor: " + b.getAutor());
        System.out.println("Editor: " + b.getEditor());
        System.out.println("Año de publicación: " + b.getAnyo());
        System.out.println("Numero de paginas: " + b.getNumeroPaginas());
        System.out.println("------------------");

        //Eliminamos el libro
        File fichero = new File(ruta);
        fichero.delete();

        //Creamos un fichero nuevo
        guardarLibro();

    }

    public void ejercicio3(String[] nombres, String ruta){
        ArrayList<Book> lista = new ArrayList<Book>();
        bookstore = new Bookstore();
        for(int i = 0; i < nombres.length;i++){
            Book b = new Book();
            b = bookstore.recuperar(ruta+"\\"+nombres[i]+".dat");
            lista.add(b);
        }

        Iterator iterator = lista.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Año de publicación: " + book.getAnyo());
        }
    }


}
