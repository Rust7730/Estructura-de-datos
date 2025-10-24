package ejercicio2;

public class Cancion {
    private final String titulo;
    private final String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getArtista() {
        return this.artista;
    }

    public String toString() {
        return "\"" + this.titulo + "\" - " + this.artista;
    }
}