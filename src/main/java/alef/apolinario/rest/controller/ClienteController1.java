//package alef.apolinario.rest.controller;
//
//import alef.apolinario.domain.entity.Cliente;
//import alef.apolinario.domain.entity.ClienteJPA;
//import alef.apolinario.domain.repository.Clientes;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller//sem @restcontroller e usando response entity
//public class ClienteController {
//
//    private Clientes clientes;
//
//    public ClienteController(Clientes clientes) {
//
//        this.clientes = clientes;
//    }
//
//    @GetMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity getClienteById(@PathVariable Integer id) {
//        Optional<ClienteJPA> cliente = clientes.findById(id);
//
//        if (cliente.isPresent()) {
//            return ResponseEntity.ok(cliente.get());
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("api/clientes")
//    @ResponseBody
//    public ResponseEntity save(@RequestBody ClienteJPA cliente) {
//        ClienteJPA clienteSalvo = clientes.save(cliente);
//        return ResponseEntity.ok(clienteSalvo);
//    }
//
//    @DeleteMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity delete(@PathVariable Integer id) {
//        Optional<ClienteJPA> cliente = clientes.findById(id);
//
//        if (cliente.isPresent()) {
//            clientes.delete(cliente.get());
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity update(@PathVariable Integer id,
//                                 @RequestBody ClienteJPA cliente) {
//        return clientes
//                .findById(id)
//                .map(clienteExistente -> {
//                    cliente.setId(clienteExistente.getId());
//                    clientes.save(cliente);
//                    return ResponseEntity.noContent().build();
//                }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/api/clientes")
//    public ResponseEntity find( ClienteJPA filtro ){
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(
//                        ExampleMatcher.StringMatcher.CONTAINING );
//
//        Example example = Example.of(filtro, matcher);
//        List<Cliente> lista = clientes.findAll(example);
//        return ResponseEntity.ok(lista);
//    }
//}
