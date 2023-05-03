package ico.fes.tec.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class SuperMercado {
    ArrayList<Producto> stock;
    ArrayList<Reporte> bitacora;
    int ventas=0;
    public SuperMercado() {
        stock = new ArrayList<>();
        stock.add(new Producto(stock.size(), "leche", "lacteo", 35, 10,0,0));
        stock.add(new Producto(stock.size(), "queso", "lacteo", 50, 15,0,1));
        stock.add(new Producto(stock.size(), "bolillo", "panaderia ", 2, 100,1,0));
        stock.add(new Producto(stock.size(), "lechuga", "verduras", 20, 20,1,1));



    }
    public ArrayList<Reporte> getBitacora() {
        return this.bitacora;
    }

    public void setBitacora(ArrayList<Reporte> bitacora) {
        this.bitacora = bitacora;
    }

    public SuperMercado(ArrayList<Producto> stock) {
        this.stock = stock;
    }


    public ArrayList<Producto> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Producto> stock) {
        this.stock = stock;
    }

    public int getVentas() {
        return this.ventas;
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



    public boolean venderProducto(int id) {
        Producto pro = null;
        Iterator var3 = this.stock.iterator();

        while(var3.hasNext()) {
            Producto aux = (Producto) var3.next();
            if (aux.getId() == id) {
                pro = aux;
                this.bitacora.add(new Reporte( aux, "Rentar"));
            }
        }

        if (pro == null) {
            return false;
        } else {
            ++this.ventas;
            System.out.println(this.ventas);
            return pro.vender();
        }
    }


}
