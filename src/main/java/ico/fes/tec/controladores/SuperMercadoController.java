package ico.fes.tec.controladores;

import ico.fes.tec.modelo.SuperMercado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ico.fes.tec.modelo.Producto;

import java.util.ArrayList;

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
    public ResponseEntity<Boolean> vender(@RequestBody(required=true) Producto lapeli){
        return new ResponseEntity<>(SM.comprar(lapeli.getId()),HttpStatus.OK);
    }

    @GetMapping("/super/stock/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable(required = true,name = "id") int id){

        return new ResponseEntity<>(SM.getStock().get(id), HttpStatus.OK);
    }


}
