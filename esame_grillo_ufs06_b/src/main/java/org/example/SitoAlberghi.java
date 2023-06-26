package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;

public class SitoAlberghi {

    static ArrayList<Albergo> hotel =new ArrayList<>(); //lista alberghi sul sito

    public SitoAlberghi() {
        hotel.add(new Albergo(1, "Hotel Cimiano", 100, true, "Lussuosa suite con vista panoramica"));
        hotel.add(new Albergo(2, "Hotel Empoli", 80, false, "Camera standard con servizi essenziali"));
        hotel.add(new Albergo(3, "Hotel Ancona", 150, true, "Suite presidenziale con piscina privata"));
        hotel.add(new Albergo(4, "Hotel Hotel", 60, false, "Camera economica con letti singoli"));
        hotel.add(new Albergo(5, "Hotel Bari", 120, true, "Suite deluxe con vasca idromassaggio"));
        hotel.add(new Albergo(6, "Hotel Napoli", 90, false, "Camera familiare con letti a castello"));
        hotel.add(new Albergo(7, "Hotel Grillo", 200, true, "Suite di lusso con terrazza privata"));
        hotel.add(new Albergo(8, "Hotel Domodossola", 70, false, "Camera standard con vista mare"));
        hotel.add(new Albergo(9, "Hotel Oslo", 180, true, "Suite executive con centro benessere"));
        hotel.add(new Albergo(10, "Hotel Lisbona", 110, false, "Camera matrimoniale con balcone"));
        hotel.add(new Albergo(11, "Hotel Kahoot", 130, true, "Suite panoramica con jacuzzi"));
        hotel.add(new Albergo(12, "Hotel James", 95, false, "Camera deluxe con minibar"));
        hotel.add(new Albergo(13, "Hotel Milano", 150, true, "Suite di lusso con vista mare"));
        hotel.add(new Albergo(14, "Hotel Firenze", 70, false, "Camera standard con colazione inclusa"));
        hotel.add(new Albergo(15, "Hotel Imola", 120, true, "Suite panoramica con terrazza privata"));
    }

    //metodo che stampa tutti gli alberghi dentro al sito
    public static String all(){
        ArrayList<Albergo> lista_saturno;
        lista_saturno=hotel;

        lista_saturno.sort(Comparator.comparing(Albergo::getId));
        Gson gson = new Gson();
        String json =gson.toJson(lista_saturno);
        return json;

        /*for(int i=0; i<hotel.size(); i++){

        }
        Gson gson=new Gson();
        String json=gson.toJson(hotel);
        return json;*/
    }

    //metodo che stampa tutti gli alberghi in ordine alfabetico
    public static String allSorted(){
        ArrayList<Albergo> lista_giove;
        lista_giove=hotel;

        lista_giove.sort(Comparator.comparing(Albergo::getNome));
        Gson gson = new Gson();
        String json =gson.toJson(lista_giove);
        return json;
    }

    //metodo che stampa il più costoso
    public static String moreExpensiveSuite(){
        int costosa=0;
        double max = hotel.get(0).getPrezzo();

        //ciclo per trovare il più costoso con la suite
        for(int i=0; i<hotel.size(); i++){
            if(hotel.get(i).isSuite()) {
                if (max < hotel.get(i).getPrezzo()) {
                    max = hotel.get(i).getPrezzo();
                    costosa = i;
                }
            }
        }
        Gson gson=new Gson();
        String json=gson.toJson(hotel.get(costosa));
        return json;
    }

}
