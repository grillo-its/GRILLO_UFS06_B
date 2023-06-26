package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket cSocket; //il socket che il listener ha passato
    private BufferedReader reader; //buffer che serve per leggere i messaggi
    private PrintWriter writer; //serve per scrivere la risposta al client
    private InetAddress indirizzo; //otteniamo l'indirizzo
    private int porta; //salviamo la porta del client

    public ClientHandler(Socket clientSocket){//salva il socket che il listener in client socket
        cSocket=clientSocket;

        //indirizzo e porta del client che si connette
        indirizzo=cSocket.getInetAddress();
        porta=cSocket.getPort();
        System.out.println("Connessione: " + indirizzo + "con la porta: " + porta);
    }

    @Override //sovrascrive il metodo run della classe thread
    public void run (){
        SitoAlberghi elenco=new SitoAlberghi();
        String prenotazione="";

        try{
            reader=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));//inzializza il bufferedreader ovvero
            //quello che legge quello che scrive il client
            writer=new PrintWriter(cSocket.getOutputStream(), true);//inzializza il print writer ovvero
            //quello che manda i messaggi al client
        }catch(IOException e) {
            cSocket.isClosed();
        }

        boolean presente;
        writer.println("Connessione avvenuta"); //dice al client che si connesso
        System.out.println("Connessione avvenuta da parte del client");//scrive connessione avvenuta in riga di comando

        do{
            do{
                //invia le istruzioni al client
                writer.println("\nDigita un comando tra: ");
                writer.println("all");
                writer.println("all_sorted");
                writer.println("more_expensive_suite");
                writer.println("exit\n");

                try{
                    prenotazione=reader.readLine(); //legge la prenotazione
                    System.out.println("Client "+porta+": "+prenotazione);//stampa la risposta in riga di comando
                }catch (IOException e){
                    prenotazione="exit";
                }

                //viene fatto un controllo per la richiesta del client
                if(!prenotazione.equals("all")&&!prenotazione.equals("all_sorted")&&!prenotazione.equals("more_expensive_suite")&&!prenotazione.equals("exit")){
                    presente=true;
                    writer.println("\n'"+prenotazione+"' non e un comando corretto\n");
                }else{
                    presente=false;
                }
            }while(presente);

            switch (prenotazione) {
                case "all" -> writer.println(SitoAlberghi.all());
                case "all_sorted" -> writer.println(SitoAlberghi.allSorted());
                case "more_expensive_suite" -> writer.println(SitoAlberghi.moreExpensiveSuite());
                case "exit" -> writer.println("Connessione chiusa");
            }

        }while(!prenotazione.equals("exit"));

        //si chiude la connessione
        try{
            cSocket.close();
            System.out.println("connessione chiusa dal client - Indirizzo: "+indirizzo+" Porta: "+porta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
