package practico5;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int numPaginas;



    public Libro (){
        this.isbn = 123456;
        this.titulo="Sin Título";
        this.autor="Gabriel García Marquez";
        this.numPaginas = 3689;
    }

    public Libro (int codIsbn, String unTitulo, String unAutor, int totalPaginas){
        this.isbn = codIsbn;
        this.titulo = unTitulo;
        this.autor = unAutor;
        this.numPaginas = totalPaginas;
    }


    //métodos de acceso y modificación

    public void setIsbn(int codIsbn){
        this.isbn= codIsbn;
    }

    public int getIsbn (){
        return this.isbn;

    }

    public void setTitulo (String unTitulo){
        this.titulo = unTitulo;
    }

    public String getTitulo (){
        return this.titulo;
    }

    public void setAutor (String unAutor){
        this.autor = unAutor;
    }

    public String getAutor (){
        return this.autor;
    }

    public void setNumPaginas (int totalPaginas){
        this.numPaginas = totalPaginas;
    }

    public int getNumPaginas (){
        return this.numPaginas;

    }

    public boolean autorDesconocido(){

        if (this.getAutor().isEmpty() || this.getAutor() == null)
            return true;
        else
            return false;
    }

    public String toString(){
       String mensaje = "El libro: " + this.titulo;
        mensaje += ", con ISBN: " + this.isbn;


       //Si autor es desconocido, vacio.
       if (autorDesconocido()== true){
           mensaje += ", presenta autor desconocido y";

       }
       // Si autor no es vacío
       else
           mensaje += ", creado por el autor: " + this.autor;


        mensaje += ", tiene " + this.numPaginas + " páginas.";

        return mensaje;
    }


}
