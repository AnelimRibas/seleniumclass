package practico5;

import java.util.Scanner;

public class Libreria {

    public static void main (String arg[])
    {
        Scanner input = new Scanner(System.in);
        int codIsbn=0;
        String unTitulo;
        String unAutor;
        int totalPaginas=0;


        Libro obj = new Libro();

        System.out.println(obj);

        Libro obj1 = new Libro(10001, "La María", "", 1449);
        System.out.println(obj1);


        Libro obj3 = new Libro();

        System.out.println("Ingrese El Código ISBN: ");
        codIsbn = input.nextInt();
        obj3.setIsbn(codIsbn);
        input.nextLine();

        System.out.println("Ingrese el nombre del Libro: ");
        unTitulo= input.nextLine();
        obj3.setTitulo(unTitulo);


        System.out.println("Ingrese el autor del Libro");
        unAutor= input.nextLine(); 
        obj3.setAutor(unAutor);


        System.out.println("Ingrese el número de páginas");
        totalPaginas = input.nextInt();
        obj3.setNumPaginas(totalPaginas);

        obj3.toString();

        System.out.println(obj3);

    }
}
