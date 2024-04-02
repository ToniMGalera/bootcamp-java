package tasca02;

interface Entregable {
 void entregar();
 void devolver();
 boolean isEntregado();
 int compareTo(Object a);
}

//Serie
public class Serie implements Entregable {
 private String titulo;
 private int numeroTemporadas;
 private boolean entregado;
 private String genero;
 private String creador;

 public Serie() {
     this.titulo = "";
     this.numeroTemporadas = 3;
     this.entregado = false;
     this.genero = "";
     this.creador = "";
 }

 //titulo y creador
 public Serie(String titulo, String creador) {
     this();
     this.titulo = titulo;
     this.creador = creador;
 }

 //todos los atributos excepto entregado
 public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
     this(titulo, creador);
     this.numeroTemporadas = numeroTemporadas;
     this.genero = genero;
 }


 public String getTitulo() {
     return titulo;
 }

 public void setTitulo(String titulo) {
     this.titulo = titulo;
 }

 public int getNumeroTemporadas() {
     return numeroTemporadas;
 }

 public void setNumeroTemporadas(int numeroTemporadas) {
     this.numeroTemporadas = numeroTemporadas;
 }

 public String getGenero() {
     return genero;
 }

 public void setGenero(String genero) {
     this.genero = genero;
 }

 public String getCreador() {
     return creador;
 }

 public void setCreador(String creador) {
     this.creador = creador;
 }

 //Entregable
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
     Serie s = (Serie) a;
     return this.numeroTemporadas - s.getNumeroTemporadas();
 }

 //toString
 @Override
 public String toString() {
     return "Serie{" +
             "titulo='" + titulo + '\'' +
             ", numeroTemporadas=" + numeroTemporadas +
             ", entregado=" + entregado +
             ", genero='" + genero + '\'' +
             ", creador='" + creador + '\'' +
             '}';
 }
}
