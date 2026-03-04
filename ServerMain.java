package simple_tcp_thread_fred2;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    private int numeroCliente = 1;

    public ServerMain() throws Exception {

        ServerSocket socketServidor = new ServerSocket(2020);
        System.out.println("Servidor escuchando en el puerto 2020...");

        while (true) {
            Socket socketCliente = socketServidor.accept();
            ServerThread hiloServidor = new ServerThread(socketCliente, this);
            Thread hilo = new Thread(hiloServidor);
            hilo.start();
        }
    }

    public synchronized int obtenerNumeroCliente() {
        return numeroCliente++;
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
