package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * esam grillo matteo ufs06 sa_b
 *
 */
public class Server
{
    public static void main( String[] args )
    {
        int porta=8080;

        try{//apriamo la porta per attendere la connessione
            ServerSocket serverSocket=new ServerSocket(porta);//accettiamo la connessione in entrata
            while(true){//teniamo il listener sempre attivo
                Socket clientSocket=serverSocket.accept(); //salviamo su client socket la connessione in entrata
                ClientHandler c=new ClientHandler(clientSocket); //crea il thread e passo il socket client
                c.start(); //avvio del thread
            }
        } catch (IOException e) {//salviamo le eccezioni nella variabile e
            throw new RuntimeException(e);
        }
    }
}
