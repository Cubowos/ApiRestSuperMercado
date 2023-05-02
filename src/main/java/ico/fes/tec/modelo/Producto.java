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

    public boolean vender(){
        boolean resultado = false;
        if (cantidad >= 1) {
            cantidad--;
            resultado=true;
        }
        return resultado;
    }
}
