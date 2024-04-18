import Exceptions.CantidadMaximaDeLibrosException;
import Exceptions.LibroEnBusquedaNoEncontradoException;
import controller.Biblioteca;
import controller.Catalogo;
import model.enums.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class Entrada{
    public static void main(String[] args) throws CantidadMaximaDeLibrosException, LibroEnBusquedaNoEncontradoException {
        Biblioteca<Libro>biblioteca=new Biblioteca<>();
        Scanner sc= new Scanner(System.in);
        Libro comedia= new Comedia ("1","1","1",1,Humor.Negro);
        Libro comedia2= new Comedia ("5","2","1",1,Humor.Blanco);
        biblioteca.agregarLibro(comedia);
        biblioteca.agregarLibro(comedia2);
        int respuesta;
        System.out.println("BIENVENIDO A SU BIBLIOTECA!");
        System.out.println("INTRODUCCIÓN DE DATOS PERSONALES");
        System.out.println("Introduzca el nombre de su biblioteca. Ejemplo: Biblioteca central de Madrid");
        biblioteca.setNombre(sc.nextLine());
        System.out.println("Introduzca el nombre del director responsable de la biblioteca");
        biblioteca.setDirector(sc.nextLine());
        System.out.println("Su biblioteca ha sido creada, a continuación se le mostrará un menú con las opciones disponibles.");
        boolean exit=false;
        do{
            System.out.println("|------------------------------------------------------------|");
            biblioteca.mostrardatosBiblioteca();
            System.out.println("Qué desea hacer?");
            System.out.println ("1. Gestionar libros." + "2. Gestionar catálogo.\n" +
                    "3. Exportar catálogo(Debe crear uno primero)");
            respuesta=sc.nextInt();
            sc.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("Esta gestionando su biblioteca");
                    System.out.println("1. Agregar libro nuevo." + " ----- " + "2. Eliminar libro." );
                    System.out.println("3. Buscar libro."  + " ----- " +  "4. Mostrar libros de la biblioteca.");
                    System.out.println("5. Cancelar operacion.");
                    System.out.println("|------------------------------------------------------------|");
                    int navegacion=sc.nextInt();
                    sc.nextLine();
                    switch (navegacion){
                        case 1:
                            Libro insercion;
                            System.out.println("|------------------------------------------------------------|");
                            System.out.println("Inserte título del libro:");
                            String insNombre=sc.nextLine();
                            System.out.println("Inserte el autor:");
                            String insAutor=sc.nextLine();
                            System.out.println("Inserte el isbn del libro:");
                            String insIsbn=sc.nextLine();
                            System.out.println("Inserte el número de páginas");
                            int insnum=sc.nextInt();
                            sc.nextLine();
                            System.out.println("¿Qué género es el libro?: 1.Comedia, 2.Terror, 3.Policiaca");
                            navegacion=sc.nextInt();
                            sc.nextLine();
                            switch (navegacion){
                                case 1:
                                    Humor.mostrarDescripcionesHumor();
                                    System.out.println("|------------------------------------------------------------|");
                                    System.out.println("Escriba el tipo de humor del libro:");
                                    String insert=sc.next();
                                    for (Humor item : Humor.values()){
                                        if (item.name().equalsIgnoreCase(insert)){
                                            insercion=new Comedia(insNombre,insAutor,insIsbn,insnum,item);
                                            biblioteca.agregarLibro(insercion);
                                        }else{
                                            System.out.println("No se reconoce valor, volviendo al menú");
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Indique del 1 al 10 el rating de este libro");
                                    boolean exitrating=false;
                                    while (!exitrating){
                                        double resprating=sc.nextInt();
                                        if(resprating <0 | resprating >10){
                                            System.out.println("rating no aceptado, especifique el número según la regla");
                                        }
                                        insercion=new Terror(insNombre,insAutor,insIsbn,insnum,resprating);
                                        biblioteca.agregarLibro(insercion);
                                        exitrating=true;
                                    }
                                    break;
                                case 3:
                                    System.out.println("Indique de qué tipo es la trama: Escriba Intriga o Misterio");
                                        String insert2=sc.next();
                                        for (Trama item: Trama.values()){
                                            if (item.name().equalsIgnoreCase(insert2)) {
                                                System.out.println("Indique el número de personajes a añadir:");
                                                respuesta=sc.nextInt();
                                                sc.nextLine();
                                                String[] numeroPjs =new String[respuesta];
                                                for (int i=0;i<numeroPjs.length;i++){
                                                    System.out.println("Inserte personaje nº: " + (i+1));
                                                    numeroPjs[i]=sc.nextLine();
                                                }
                                                insercion=new Policiaca(insNombre,insAutor,insIsbn,insnum,item,numeroPjs);
                                                biblioteca.agregarLibro(insercion);
                                            }else{
                                                System.out.println("No se encuentra valor, volviendo al menú");
                                                break;
                                            }
                                        }
                                    break;
                                default:
                                    System.out.println("-------------");
                                    System.out.println("Orden no reconocida");
                                    System.out.println("-------------");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Va a eliminar un libro de la biblioteca:\n" + "Inserte el ISBN a buscar");
                            String respString=sc.next();
                            biblioteca.eliminarLibro(biblioteca.buscarLibro(respString));
                            break;
                        case 3:
                            System.out.println("Va a buscar un libro de la biblioteca:\n" + "Inserte el ISBN a buscar");
                            respString=sc.next();
                            biblioteca.buscarLibro(respString);
                            break;
                        case 4:
                            System.out.println("Mostrando todos los libros de su biblioteca");
                            biblioteca.mostrarLibros();
                            break;
                        case 5:
                            System.out.println("Cancelando operación.");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Esta gestionando sus catálogos");
                    System.out.println("1. Construir catálogo." + " ----- " + "2. Agregar libro al catálogo."+ " ----- " + "3. Quitar libro del catálogo.");
                    System.out.println("4. Buscar libro en el catálogo." + " ----- " + "5. Mostrar todos los libros del catálogo" + " ----- " + "6. Eliminar un catálogo.");
                    System.out.println("7. Cancelar operación");
                    respuesta=sc.nextInt();
                    sc.nextLine();
                    switch (respuesta){
                        case 1:
                            biblioteca.setCatalogo(biblioteca.crearCatalogo());
                            break;
                        case 2:
                            System.out.println("Va a añadir un libro al catálogo.");
                            System.out.println("Ingrese el isbn que desea ingresar al catalogo");
                            String resStr=sc.next();
                            biblioteca.agregarlibrocat(biblioteca.buscarLibro(resStr));
                            break;
                        case 3:
                            System.out.println("Va a quitar un libro del catálogo:");
                            biblioteca.quitarlibroCat();
                            break;
                        case 4:
                            System.out.println("Va a buscar un libro en el catálogo.");
                            System.out.println("Ingrese el isbn que desea ingresar al catalogo");
                            resStr=sc.next();
                            biblioteca.buscarCatalogo(resStr);
                            break;
                        case 5:
                            System.out.println("Va a mostrarse el contenido de su catálogo.");
                            biblioteca.mostrarcatalogo();
                            break;
                        case 6:
                            System.out.println("Va a eliminar el catálogo creado");
                            biblioteca.eliminarcatalogo();
                            System.out.println("Catálogo eliminado");
                            break;
                        case 7:
                            System.out.println("Cancelando operación");
                            break;
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no reconocida, saliendo.");
                    exit=true;
                    break;
            }
        }while (!exit);
    }
}

