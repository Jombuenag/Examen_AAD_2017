package comparador;

import java.io.File;
import java.io.FilenameFilter;

public class FileCounter {

    int totalA = 0;
    int totalB = 0;
    int compareFiles = 0;

    public FileCounter() {

        File f = new File("C:\\Users\\Taku\\workspace");
        File f2 = new File("C:\\Users\\Taku\\AndroidStudioProjects");
//QUEREMOS MOSTRAR LAS CARPETAS DE UN DIRECTORIO Y total SE ENCARGARÁ DE ELLO
//LLAMAMOS AL METODO
        totalA = calcula_folder1(f);
        totalB = calcula_folder2(f2);
        compareFiles = calcula_totalA(f, f2);
    }

    //HAY QUE PASARLE AL METODO F, PORQUE SI NO NO SABRÁ DONDE LEER
    private int calcula_folder1(File f) {
//CREAMOS UN ARRAY DE STRINGS Y QUE HAGA UNA LISTA DE LO QUE HAY EN F
        String[] listaDeCarpetas1 = f.list(new FilenameFilter() {
            //ACCEPT SE ENCARGA DE UNIR EL DIRECTORIO CON EL ARRAY PARA SABER SI ES DIRECTORIO O NO.
            public boolean accept(File arg0, String arg1) {
                return new File(arg0, arg1).isDirectory();
            }
        });
        String[] listaDeFicheros1 = f.list(new FilenameFilter() {
            public boolean accept(File arg0, String arg1) {
                return new File(arg0, arg1).isFile();
            }
        });
//IMPRIMIMOS POR PANTALLA Y DEVOLVEMOS A calcula_subdirectorios UN VALOR
        System.out.println("Hay " + listaDeCarpetas1.length + " carpetas " + "y " + listaDeFicheros1.length +
                " ficheros en el Directorio A\n un total de " + (listaDeCarpetas1.length + listaDeFicheros1.length));
        return 0;
    }

    //Another method just like the one above but with other folder
    private int calcula_folder2(File f2) {
        String[] listaDeCarpetas2 = f2.list(new FilenameFilter() {
            public boolean accept(File arg0, String arg1) {
                return new File(arg0, arg1).isDirectory();
            }
        });
        String[] listaDeFicheros2 = f2.list(new FilenameFilter() {
            public boolean accept(File arg0, String arg1) {
                return new File(arg0, arg1).isFile();
            }
        });
        System.out.println("Hay " + listaDeCarpetas2.length + " carpetas " + "y " + listaDeFicheros2.length +
                " ficheros en el Directorio B\n un total de " + (listaDeCarpetas2.length + listaDeFicheros2.length));
        return 0;
    }

    private int calcula_totalA(File f, File f2) {
        if (f.length() > f2.length()) {
            System.out.println("La carpeta A tiene mas ficheros que B");
        }
        if(f.length() < f2.length()){
            System.out.println("La carpeta B tiene mas ficheros que A");
        }
        if(f.length() == f2.length()){
            System.out.println("Las dos carpetas tienen el mismo numero de elementos");
        }

        return 0;
    }
}

