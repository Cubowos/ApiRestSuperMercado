package ico.fes.tec.modelo;

import java.util.ArrayList;

public class SuperMercado {
    ArrayList<Producto> stock;

    public SuperMercado() {
        stock = new ArrayList<>();
        stock.add(new Producto(stock.size(), "leche", "lacteo", 35, 10));
        stock.add(new Producto(stock.size(), "queso", "lacteo", 50, 15));
        stock.add(new Producto(stock.size(), "bolillo", "panaderia ", 2, 100));
        stock.add(new Producto(stock.size(), "lechuga", "verduras", 20, 20));
        stock.add(new Producto(stock.size(), "carne molida", "carniceria", 70, 12));


    }

    public ArrayList<Producto> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Producto> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "SuperMercado{" +
                "stock=" + stock +
                '}';
    }

    public boolean comprar(int modelo) {
        Producto producto = null;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getId() == modelo) {
                producto = stock.get(i);
                break;
            }
        }
        if (producto != null) {
            return producto.vender();
        } else {
            return false;
        }
    }
}
