package com.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.user.domain.Cliente;
import com.user.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {

    @Autowired
    ClienteRepository clienteRepo;

    @Test
    void cliente() {
        Cliente cli = new Cliente();
        cli.setIdCliente(null);
        cli.setNome("Teste 1");
        cli.setCpfOuCnpj("111222333");
        cli.setEmail("testando@gmail.com");
        clienteRepo.save(cli);
    }

    @Test
    public void listaCliente() {
        List<Cliente> list = clienteRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void idCliente() {
        Cliente cliente = clienteRepo.findById(2).get();
        assertEquals("pessoa2", cliente.getNome());
    }

    @Test
    public void updateCliente() {
        Cliente cliente = clienteRepo.findById(1).get();
        cliente.setNome("Pedro");
        clienteRepo.save(cliente);
        assertNotEquals("Pedro", cliente.getNome());
    }
    @Test
    public void deleteCliente() {
        clienteRepo.deleteById(2);
        assertThat(clienteRepo.existsById(2));
    }

    @Test
    public void somar() {
        double num1 = 20.0;
        double num2 = 10.0;
        Cliente cliente = new Cliente();
        double soma = cliente.somar(num1, num2);
        assertEquals(30, soma);
    }

    @Test
    public void subtrair() {
        double num1 = 30.0;
        double num2 = 2.0;
        Cliente cliente = new Cliente();
        double subtração = cliente.subtrair(num1, num2);
        assertEquals(28, subtração);
    }

    @Test
    public void multiplicar() {
        double num1 = 40.0;
        double num2 = 50.0;
        Cliente cliente = new Cliente();
        double multiplicação = cliente.multiplicar(num1, num2);
        assertEquals(2000, multiplicação);
    }

    @Test
    public void dividir() {
        double num1 = 60.0;
        double num2 = 2.0;
        Cliente cliente = new Cliente();
        double divisão = cliente.dividir(num1, num2);
        assertEquals(30, divisão);
    }

}