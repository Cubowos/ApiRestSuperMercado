package ico.fes.tec.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int precio;
    private int cantidad;

    private int columna;
    private int fila;

/*    public boolean vender(){
        boolean resultado = false;
        if (cantidad >= 1) {
            cantidad--;
            resultado=true;
        }
        return resultado;

    }*/

    public boolean vender() {
        if (this.cantidad > 0) {
            --this.cantidad;
            return true;
        } else {
            return false;
        }
    }

    public boolean regresar() {
        ++this.cantidad;
        return true;
    }
}
