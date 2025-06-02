package br.edu.ifpr.teste.servico.calendario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import paranavai.calendario.Calendario;

public class TesteCalendario {

    @Test
    public void imprimeJaneiro2025() throws IOException {

        Path path = Paths.get("src\\test\\resources\\calendario", "janeiro2025.txt");
        String saidaEsperada = Files.readString(path);
        saidaEsperada = saidaEsperada.replace("\r\n", "\n");

        Calendario calendario = new Calendario();
        String janeiro2025 = calendario.getCalendario("1", "2025");

        assertEquals(saidaEsperada, janeiro2025);
    }

    @Test
    public void imprimeMesAtual() throws IOException {
        Path path = Paths.get("src\\test\\resources\\calendario", "junho2025.txt");
        String saidaEsperada = Files.readString(path);
        saidaEsperada = saidaEsperada.replace("\r\n", "\n");

        Calendario calendario = new Calendario();
        String mesAtual = calendario.getCalendario();

        assertEquals(saidaEsperada, mesAtual);
    }

    @Test
    public void anoMenorQueUm() {
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("-8"));
    }

    @Test
    public void anoString(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("quatro"));
    }

    @Test
    public void imprimeAno25() throws IOException {

        Path path = Paths.get("src\\test\\resources\\calendario", "ano25.txt");
        String saidaEsperada = Files.readString(path);
        saidaEsperada = saidaEsperada.replace("\r\n", "\n");

        Calendario calendario = new Calendario();
        String janeiro2025 = calendario.getCalendario("25");

        assertEquals(saidaEsperada, janeiro2025);
    }

    @Test
    public void anoMaiorQue9999(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("10857"));
    }

    @Test
    public void mesEAnoInvertido(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("2025", "8"));
    }

    @Test
    public void mesIvalido(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("-8", "2025"));
    }

    @Test
    public void mesString(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("Dezembro", "2025"));
    }

    @Test
    public void mesMaiorQue12(){
        Calendario calendario = new Calendario();
        assertThrows(
                IllegalArgumentException.class,
                () -> calendario.getCalendario("25", "2025"));
    }

    @Test
    public void imprimeJulho2693() throws IOException {

        Path path = Paths.get("src\\test\\resources\\calendario", "julho2693.txt");
        String saidaEsperada = Files.readString(path);
        saidaEsperada = saidaEsperada.replace("\r\n", "\n");

        Calendario calendario = new Calendario();
        String janeiro2025 = calendario.getCalendario("7", "2693");

        assertEquals(saidaEsperada, janeiro2025);
    }

    @Test
    public void imprimeSetembro1752() throws IOException {

        Path path = Paths.get("src\\test\\resources\\calendario", "setembro1752.txt");
        String saidaEsperada = Files.readString(path);
        saidaEsperada = saidaEsperada.replace("\r\n", "\n");

        Calendario calendario = new Calendario();
        String janeiro2025 = calendario.getCalendario("9", "1752");

        assertEquals(saidaEsperada, janeiro2025);
    }

}
