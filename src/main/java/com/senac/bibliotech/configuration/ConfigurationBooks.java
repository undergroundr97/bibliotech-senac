package com.senac.bibliotech.configuration;


import com.senac.bibliotech.model.Livro;
import com.senac.bibliotech.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigurationBooks implements CommandLineRunner {


    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10 ; i++) {

            Livro livro = new Livro(null, "titulo" + i, "isbn" + i);
            livroRepository.save(livro);
        }
    }


}
