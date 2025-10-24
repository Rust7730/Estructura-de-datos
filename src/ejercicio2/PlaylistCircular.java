package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaylistCircular {
    private Nodo actual;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean estaVacia() {
        return this.size == 0;
    }

    public void agregar(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (this.actual == null) {
            this.actual = nuevo;
        } else {
            Nodo sig = this.actual.next;
            this.actual.next = nuevo;
            nuevo.prev = this.actual;
            nuevo.next = sig;
            sig.prev = nuevo;
        }

        ++this.size;
    }

    public Cancion siguiente() {
        if (this.estaVacia()) {
            return null;
        } else {
            this.actual = this.actual.next;
            return this.actual.dato;
        }
    }

    public Cancion anterior() {
        if (this.estaVacia()) {
            return null;
        } else {
            this.actual = this.actual.prev;
            return this.actual.dato;
        }
    }

    public Cancion eliminarActual() {
        if (this.estaVacia()) {
            return null;
        } else {
            Cancion salida = this.actual.dato;
            if (this.size == 1) {
                this.actual = null;
            } else {
                Nodo a = this.actual.prev;
                Nodo s = this.actual.next;
                a.next = s;
                s.prev = a;
                this.actual = s;
            }

            --this.size;
            return salida;
        }
    }

    public Cancion actual() {
        return this.estaVacia() ? null : this.actual.dato;
    }

    public List<Cancion> listar() {
        List<Cancion> res = new ArrayList();
        if (this.estaVacia()) {
            return res;
        } else {
            Nodo p = this.actual;

            do {
                res.add(p.dato);
                p = p.next;
            } while(p != this.actual);

            return res;
        }
    }

    public List<Cancion> ordenAleatorioSinRepetir() {
        List<Cancion> copia = this.listar();
        Collections.shuffle(copia);
        return copia;
    }
}

