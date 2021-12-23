package com.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.domain.Endereco;
import com.user.domain.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {

    @Autowired
    EnderecoRepository enderecoRepo;

    @Test
    void Endereco() {
        Endereco en = new Endereco();
        en.setId(1);
        en.setLogradouro("Rua Euripedes");
        en.setNumero("33");
        en.setComplemento("");
        en.setBairro("Ze");
        en.setCep("12312312");
        enderecoRepo.save(en);
    }

    @Test
    public void listaEndereco() {
        List<Endereco> list = enderecoRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void idEndereco() {
        Endereco en = enderecoRepo.findById(1).get();
        assertEquals(1, en.getId());
    }

    @Test
    public void updateEndereco() {
        Endereco en = enderecoRepo.findById(1).get();
        en.setBairro("Bibor da Silva");
        enderecoRepo.save(en);
        assertNotEquals("Bibor", en.getBairro());
    }

    @Test
    public void deleteEndereco() {
        enderecoRepo.deleteById(2);
        assertThat(enderecoRepo.existsById(2));
    }
}