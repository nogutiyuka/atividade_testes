package br.edu.ifpr.teste.servico.irpf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import imposto.renda.SimuladorImpostoRenda;

public class TesteSimuladorImpostoRenda {

    @Test
    public void salarioIsento() {
        double salario = 1876.24;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(0.0, imposto);
    }

    @Test
    public void salarioSeteMeioPorCento() {
        double salario = 2417.98;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(38.55, imposto);
    }

    @Test
    public void salarioQuinzePorCento() {
        double salario = 3049.74;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(102.66, imposto);
    }

    @Test
    public void salarioVinteDoisMeioPorCento() {
        double salario = 3964.13;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(255.80, imposto);
    }

    @Test
    public void salarioVinteSeteMeioPorCento() {
        double salario = 8974.66;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(1598.67, imposto);
    }

    @Test
    public void salarioNegativoExcecao() {
        double salario = -1547.21;
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> SimuladorImpostoRenda.calcularImposto(salario)
        );
    }
}
