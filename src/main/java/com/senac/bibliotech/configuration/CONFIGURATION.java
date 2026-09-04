package com.senac.bibliotech.configuration;


import com.senac.bibliotech.model.Autor;
import com.senac.bibliotech.model.Livro;
import com.senac.bibliotech.repository.AutorRepository;
import com.senac.bibliotech.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class CONFIGURATION implements CommandLineRunner {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {

        String filePath = "src/main/java/com/senac/bibliotech/configuration/data/nomes.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String line = br.readLine();

            while(line != null){
//                System.out.println(line);
                String nome = line;
                Autor autor = new Autor(null, nome);
                autorRepository.save(autor);
                line = br.readLine();
            }
        }   catch (IOException e){
            e.getMessage();
        }


        for (int i = 0; i < 10 ; i++) {
            Livro livro = new Livro(null, "titulo" + i, "isbn" + i);
            livroRepository.save(livro);
        }
    }


}
