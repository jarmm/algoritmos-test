package com.example.prueba;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class AppTest {

    @Test
    public void arregloNumeros() throws Exception {

        String[] input = new String[]{"2", "1", "4", "5"};
        Integer[] output = new Integer[]{1, 2, 3, 4, 5};
        assertNotNull(App.arregloNumeros(input));
        assertArrayEquals(App.arregloNumeros(input), output);

        input = new String[]{"4", "2", "9"};
        output = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertNotNull(App.arregloNumeros(input));
        assertArrayEquals(App.arregloNumeros(input), output);

        input = new String[]{"20", "2", "5"};
        output = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        assertNotNull(App.arregloNumeros(input));
        assertArrayEquals(App.arregloNumeros(input), output);

    }

    @Test
    public void reemplazaLetras() throws Exception {

        String input = "123 abcd*3";
        String output = "123 bcde*3";
        assertNotNull(App.reemplazaLetras(input));
        assertEquals(App.reemplazaLetras(input), output);

        input = "**Casa 52";
        output = "**Dbtb 52";
        assertNotNull(App.reemplazaLetras(input));
        assertEquals(App.reemplazaLetras(input), output);

    }

}