package controller;

import Exceptions.CantidadMaximaDeLibrosException;
import Exceptions.LibroEnBusquedaNoEncontradoException;
import model.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Catalogo{
    private String nombreCatalogo;
    private int numLibros;
    ArrayList<Libro>listalibros;

    public Catalogo() {
        listalibros=new ArrayList<>();
    }

    public Catalogo(String nombreCatalogo, int numLibros, ArrayList<Libro> listalibros) {
        this.nombreCatalogo = nombreCatalogo;
        this.numLibros = numLibros;
        this.listalibros = listalibros;
    }

    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public ArrayList<Libro> getListalibros() {
        return listalibros;
    }

    public void setListalibros(ArrayList<Libro> listalibros) {
        this.listalibros = listalibros;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "nombreCatalogo='" + nombreCatalogo + '\'' +
                ", numLibros=" + numLibros +
                ", listalibros=" + listalibros +
                '}';
    }
    public void agregarLibro(Libro elemento) throws CantidadMaximaDeLibrosException {
        if(numLibros==listalibros.size()){
            throw new CantidadMaximaDeLibrosException("Ha intentado sobrepasar la cantidad máxima de libros");
        }else{
            this.listalibros.add(elemento);
            System.out.println("Libro agregado");
        }

    }
    public void quitarLibro(ArrayList<Libro> conjuntobusqueda){
        boolean exiteliminacion=false;
        if(conjuntobusqueda.isEmpty()){
            System.out.println("Su operación ha sido cancelada porque no hay ningun libro con este ISBN.");
        }else{
            System.out.println("¿Cuál de las coincidencias desea eliminar?");
            System.out.println("Pulse 0 para cancelar la operación");
            do{
                Scanner sc2=new Scanner(System.in);
                int respuesta=sc2.nextInt();
                sc2.nextLine();
                switch (respuesta){
                    case 0:
                        System.out.println("Cancelando operación");
                        exiteliminacion=true;
                        break;
                    default:
                        if(respuesta<=conjuntobusqueda.size()){
                            Libro elementoselect= conjuntobusqueda.get(respuesta-1);
                            listalibros.remove(elementoselect);
                            System.out.println("Elemento eliminado");
                            exiteliminacion=true;
                        }else{
                            System.out.println("Ha habido un problema en la eliminación, volviendo al menú.");
                        }
                        break;
                }
            }while(!exiteliminacion);
        }
    }
    public ArrayList<Libro> buscarLibro(String isbn) throws LibroEnBusquedaNoEncontradoException {
        int incremento=0;
        ArrayList<Libro>conjuntoBusqueda=new ArrayList<>();
        for(Libro item:listalibros){
            if(item.getIsbn().equals(isbn)){
                conjuntoBusqueda.add(item);
            }
        }
        System.out.println("Se han encontrado " + conjuntoBusqueda.size() + " coincidencias");
        if(conjuntoBusqueda.isEmpty()){
            throw new LibroEnBusquedaNoEncontradoException("No se ha encontrado ningún libro en el catálogo");
        }
        else{
            for (Libro item:conjuntoBusqueda){
                System.out.println("Libro nº"  + (incremento+1) +": "+ item.toString());
            }
        }
        return conjuntoBusqueda;
    }
    public void mostrarLibrosCat(){
        for (Libro item : listalibros){
            System.out.println(item.toString());
        }
    }
    /*
    public void agregarLibro(T libro){
        System.out.println("------>");
        if (estaLibro2(libro) != null){

            System.out.println("Agregado correctamente");
            this.listaLibros.add(libro);
        } else {
            System.out.println("Cancelado");
        }

    }
    public void eliminarLibro(){

    }
    public Libro estaLibro2(T libro){
        System.out.println("------>");
        for (Libro item: listaLibros){
            if(item.equals(libro)){
                System.out.println("Libro encontrado en la biblioteca");
                return null;
            }
        }
        System.out.println("Libro no encontrado en la biblioteca");
        return libro;
    }
    public void mostrarLibrosCat(){
        System.out.println("|------------------------------------------------------------|");
        System.out.println("Desplegando lista de libros:");
        for (T item : listaLibros){
            System.out.println(item.toString());
        }
    }

 */

}
