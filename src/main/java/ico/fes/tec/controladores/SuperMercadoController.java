package ico.fes.tec.controladores;

import ico.fes.tec.modelo.Reporte;
import ico.fes.tec.modelo.SuperMercado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ico.fes.tec.modelo.Producto;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class SuperMercadoController {
    SuperMercado SM;

    public SuperMercadoController() {
        SM =  new SuperMercado();
    }

    @GetMapping("/super/stock")
    public ResponseEntity<ArrayList<Producto>> getStock(){
        return new ResponseEntity<>(SM.getStock(), HttpStatus.OK);
    }
    @PostMapping("/super/vender")
    public ResponseEntity<Boolean> vender(@RequestBody(required=true) Producto elCoso){
        return new ResponseEntity<>(SM.venderProducto(elCoso.getId()),HttpStatus.OK);
    }

    @GetMapping("/super/stock/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable(required = true,name = "id") int id){

        return new ResponseEntity<>(SM.getStock().get(id), HttpStatus.OK);
    }

    @GetMapping({"/reporte/ventas"})
    public ResponseEntity<String> getReporteVentas(){
        return new ResponseEntity("el reporte de ventas es "+ this.SM.getVentas(), HttpStatus.OK);
    }

    @GetMapping("/reporte/balance")
    public ResponseEntity<String> getReporteBalance(){
        return new ResponseEntity<>(("La ganancia de las peliculas rentadas es "+(SM.getVentas())*20), HttpStatus.OK);
    }
    @GetMapping("/reporte/bitacora")
    public ResponseEntity<ArrayList<Reporte>> getReporteBitacora(){
        return new ResponseEntity<>(SM.getBitacora(), HttpStatus.OK);
    }

    @GetMapping({"/rentar/{columna}/{fila}"})
    public ResponseEntity<Boolean> venderPorPosicion(@PathVariable(required = true,name = "columna") int columna, @PathVariable(required = true,name = "fila") int fila) {
        Optional<Producto> producto = this.SM.getStock().stream().filter((productoAux) -> {
            return productoAux.getFila() == fila && productoAux.getColumna() == columna;
        }).findFirst();
        return producto.isPresent() ? new ResponseEntity(this.SM.venderProducto(((Producto)producto.get()).getId()), HttpStatus.OK) : new ResponseEntity(false, HttpStatus.BAD_REQUEST);
    }
}
