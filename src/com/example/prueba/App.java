package com.example.prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        menu();
        String opcion = "";

        while ((opcion = br.readLine()) != null && (!opcion.equalsIgnoreCase("q"))) {

            if(opcion.equals("1")){

                System.out.println("Por favor ingrese numeros separados por coma:");
                String inputNumeros = br.readLine();
                String [] numeros = inputNumeros.split(",");
                Integer[] arregloFinal = arregloNumeros(numeros);
                System.out.println("Resultado: " + Arrays.toString(arregloFinal));
                menu();

            } else if (opcion.equals("2")){

                System.out.println("Por favor ingrese texto:");
                String texto = br.readLine();
                String textoConvertido = reemplazaLetras(texto);
                System.out.println("Resultado: " + textoConvertido);
                menu();

            } else {

                menu();

            }

        }

        System.out.println("Programa terminado :D");

    }


    public static Integer[] arregloNumeros(String[] numeros) {

        Integer[] valores = new Integer[numeros.length];

        //convertimos a int
        for(int i = 0; i < valores.length; i++){
            valores[i] = Integer.parseInt(numeros[i]);
        }

        //convertimos a lista y ordenamos
        List<Integer> auxList = Arrays.asList(valores);
        auxList.sort(Comparator.naturalOrder());
        List<Integer> listaFinal = new ArrayList<>();
        listaFinal.addAll(auxList);

        //obtenemos el mayor y llenamos lista
        int mayor = Collections.max(auxList);
        List<Integer> listaCompleta = new ArrayList<>();

        for(int i = 1; i <= mayor; i++) {
            listaCompleta.add(i);
        }

        //comprobamos faltantes y rellenamos
        for (int i = 0; i < listaCompleta.size(); i++) {
           if(!listaFinal.contains(listaCompleta.get(i))){
               listaFinal.add(i, listaCompleta.get(i));
           }
        }

        //convertimos nuevamente a arreglo
        Integer[] arregloFinal = listaFinal.toArray(new Integer[0]);

        //return
        return arregloFinal;
    }

    public static String reemplazaLetras(String texto) {

        //variables
        char[] charArray = texto.toCharArray();
        char[] charArrayFinal = texto.toCharArray();
        String abecedarioString = "abcdefghijklmnñopqrstuvwxyz";
        char[] abcedario = abecedarioString.toCharArray();
        char charZ = "z".toLowerCase().charAt(0);

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            if (Character.isLetter(ch)) {

                for(int j = 0; j < abcedario.length; j++) {

                    //obtenemos posicion
                    if((Character.toLowerCase(ch) != charZ) && abcedario[j] == (Character.toLowerCase(ch))){

                        //reemplazamos dependiendo case sensitive
                        if(Character.isLowerCase(ch)){
                            charArrayFinal[i] = abcedario[j+1];
                        }else {
                            charArrayFinal[i] = Character.toUpperCase(abcedario[j+1]);
                        }

                        //si es z pasamos a
                    } else if ((Character.toLowerCase(ch) == charZ)){

                        //reemplazamos dependiendo case sensitive
                        if(Character.isLowerCase(ch)){
                            charArrayFinal[i] = abcedario[0];
                        }else {
                            charArrayFinal[i] = Character.toUpperCase(abcedario[0]);
                        }

                    }
                }

            }
        }

        //return
        return new String(charArrayFinal);

    }

    private static void menu() {
        System.out.println("\n");
        System.out.println("Por favor ingrese opción:");
        System.out.println("1: Arreglo de números");
        System.out.println("2: Reemplazar letras");
        System.out.println("q: Salir");
        System.out.println("--------------------------");
    }
}
