package tasca02;
//Clase Videojuego
public class Videojuego implements Entregable {
private String titulo;
private int horasEstimadas;
private boolean entregado;
private String genero;
private String compania;

// Constructor por defecto
public Videojuego() {
   this.titulo = "";
   this.horasEstimadas = 10;
   this.entregado = false;
   this.genero = "";
   this.compania = "";
}

// Constructor con titulo y horasEstimadas
public Videojuego(String titulo, int horasEstimadas) {
   this();
   this.titulo = titulo;
   this.horasEstimadas = horasEstimadas;
}

// Constructor con todos los atributos excepto entregado
public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
   this(titulo, horasEstimadas);
   this.genero = genero;
   this.compania = compania;
}

public String getTitulo() {
   return titulo;
}

public void setTitulo(String titulo) {
   this.titulo = titulo;
}

public int getHorasEstimadas() {
   return horasEstimadas;
}

public void setHorasEstimadas(int horasEstimadas) {
   this.horasEstimadas = horasEstimadas;
}

public String getGenero() {
   return genero;
}

public void setGenero(String genero) {
   this.genero = genero;
}

public String getCompania() {
   return compania;
}

public void setCompania(String compania) {
   this.compania = compania;
}

//interfaz Entregable
@Override
public void entregar() {
   this.entregado = true;
}

@Override
public void devolver() {
   this.entregado = false;
}

@Override
public boolean isEntregado() {
   return this.entregado;
}

@Override
public int compareTo(Object a) {
   Videojuego v = (Videojuego) a;
   return this.horasEstimadas - v.getHorasEstimadas();
}

//toString
@Override
public String toString() {
   return "Videojuego{" +
           "titulo='" + titulo + '\'' +
           ", horasEstimadas=" + horasEstimadas +
           ", entregado=" + entregado +
           ", genero='" + genero + '\'' +
           ", compania='" + compania + '\'' +
           '}';
}
}