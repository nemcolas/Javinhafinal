package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public Livro salvarLivro(LivroRequest livroRequest) {
        Livro livro = requesToLivro(livroRequest);
        return livroRepository.save(livro);
    }


    public Livro requesToLivro (LivroRequest livroRequest) {

        Livro livro = new Livro();
        //BeanUtils.copyProperties(livroRequest, livro);
        livro.setTitulo(livroRequest.titulo());
        livro.setAutor(livroRequest.autor());
        livro.setCategoria(livroRequest.categoria());
        livro.setPreco(livroRequest.preco());
        livro.setIsbn(livroRequest.isbn());
        return livro;
    }
}
