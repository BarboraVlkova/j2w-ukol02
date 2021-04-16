package cz.czechitas.java2webapps.ukol2.controller;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


// KONTROLER (nas kod, pripravuje celou stranku (odkud data, spojeni modelu a view)

@Controller
public class webStrankaController {

    Random nahodneCislo = new Random();
    public webStrankaController(){
        nahodneCislo = new Random();
    }

    @GetMapping("/")

    public ModelAndView zmenaVzhleduStranky() {

        ModelAndView result = new ModelAndView("webStranka");

//  CITATY (v seznamu jich je 8)
        int cisloCitatu = nahodneCislo.nextInt(8);
        List<String> seznamScitaty = Arrays.asList(
                "„Všichni vědí naprosto přesně, jak mají žít druzí. Zato nikdy nevědí, jak mají žít oni sami.“ —  Paulo Coelho",
                "„Uprostřed problémů leží příležitost.“ —  Albert Einstein",
                "„Nechtěj být člověkem, který je úspěšný, ale člověkem, který za něco stojí.“ —  Albert Einstein",
                "„Ono je lepší mluvit s chytrým člověkem o něčem hloupém než s hlupákem o něčem chytrém.“ —  Jan Werich",
                "„Bylo by to k smíchu, kdyby to nebylo k pláči.“ —  Jan Werich", "„Vodu neoceníme, dokud nám nevyschne studna a to platí o všem v životě.“ —  Benjamin Franklin",
                "„Život bez zkoušek nestojí za žití.“ —  Sókratés",
                "„Vodu neoceníme, dokud nám nevyschne studna a to platí o všem v životě.“ —  Benjamin Franklin",
                "„Odmítáme ty co nás milují, a milujeme ty co nás odmítají.“ —  Seneca");
        String vyberCitat = seznamScitaty.get(cisloCitatu);

//  OBRAZKY (v seznamu jich je 8)
        int cisloObrazku = nahodneCislo.nextInt(8);
        List<String> seznamSobrazky = Arrays.asList(
                "https://source.unsplash.com/DGFwQWKf-5o/1600x900",
                "https://source.unsplash.com/5iW15BLz_2M/1600x900",
                "https://source.unsplash.com/dx_6rdMmuzM/1600x900",
                "https://source.unsplash.com/DGFwQWKf-5o/1600x900",
                "https://source.unsplash.com/fkfKa0E1muw/1600x900",
                "https://source.unsplash.com/SPvJPDXEmqA/1600x900",
                "https://source.unsplash.com/Q_JjO7uaTh4/1600x900",
                "https://source.unsplash.com/vBos7bw98bY/1600x900");
        String vyberObrazek = seznamSobrazky.get(cisloObrazku);

//  VYTVORENI OBJEKTU, POJMENOVANI
        result.addObject("vyberCitat",vyberCitat);
        result.addObject("vyberObrazek",vyberObrazek);

//  TO CO CHCI VRATIT
        return result;
    }



//    Kód pro načtení řádků souboru v resourcech do seznamu řetězců (List<String>):
//
//    private static List<String> readAllLines(String resource)throws IOException {
//        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
//        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
//
//        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
//        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
//        try(InputStream inputStream=classLoader.getResourceAsStream(resource);
//            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
//        ){
//
//            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
//            return reader
//                    .lines()
//                    .collect(Collectors.toList());
//        }
//    }


}
