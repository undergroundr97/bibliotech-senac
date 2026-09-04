package com.senac.bibliotech.configuration;


import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.autor.repository.AutorRepository;
import com.senac.bibliotech.livro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Configuration
public class CONFIGURATION implements CommandLineRunner {


    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {

        String filePath = "src/main/java/com/senac/bibliotech/configuration/data/nomes.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
//                System.out.println(line);
                String nome = line;
                Autor autor = new Autor(null, nome);
                autorRepository.save(autor);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }


      populateLivros();

    }

    @Transactional
    public void populateLivros(){
        String booksPath = "src/main/java/com/senac/bibliotech/configuration/data/nomelivros.txt";

        List<Autor> autores = autorRepository.findAll();

        try(BufferedReader br = new BufferedReader(new FileReader(booksPath))){

            String line = br.readLine();
            while(line != null){

                int randomNumber = (int) Math.floor(autores.size() * Math.random());

                Autor autor = autores.get(randomNumber);

                String[] stringSplit = line.split(",");

                Livro livro = new Livro(null, stringSplit[0], stringSplit[1], autor);
                livroRepository.save(livro);

                line = br.readLine();
            }

        }catch (IOException e){
            e.getMessage();
        }

    }


}
