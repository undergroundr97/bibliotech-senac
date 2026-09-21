package com.senac.bibliotech.emprestimo.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    public ResponseEntity<Emprestimo> getAllEmprestimos(){

    }
}
