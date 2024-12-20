package uy.edu.ort.devops.ordersserviceexample.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.ort.devops.ordersserviceexample.domain.OrderStatus;
import uy.edu.ort.devops.ordersserviceexample.logic.OrdersLogic;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersEndpoint {

    @Autowired
    private OrdersLogic logic;

    @PostMapping(path = "", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public OrderStatus buy(@RequestBody List<String> products) {
        return logic.buy(products);
    }

        // Nuevo endpoint /health
    @GetMapping("/health")
    public ResponseEntity<String> health() {
            return ResponseEntity.ok("Healthy");
    }
}