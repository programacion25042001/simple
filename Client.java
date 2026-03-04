package simple_tcp_thread_fred2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public Cliente() throws Exception {

        Scanner teclado = new Scanner(System.in);

        // Se hacen al menos 3 llamadas al servidor
        for (int i = 1; i <= 3; i++) {

            Socket socket = new Socket("127.0.0.1", 2020);
            System.out.println("\nConexión " + i + " establecida con el servidor.");

            BufferedReader entradaSocket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter salidaSocket = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()),
                    true
            );

            // Leer saludo del servidor
            String mensajeServidor = entradaSocket.readLine();
            System.out.println("Servidor dice: " + mensajeServidor);

            // Enviar respuesta al servidor
            System.out.print("Escribe tu nombre: ");
            String mensajeCliente = teclado.nextLine();
            salidaSocket.println(mensajeCliente);

            socket.close();
            System.out.println("Conexión " + i + " cerrada.");
        }

        // ASCII ART al final
        mostrarLuffy();
    }

    private void mostrarLuffy() {
        System.out.println("\n================= ASCII ART =================\n");
        System.out.println("--------------------------------------");
        System.out.println("\n============================================");
    }

    public static void main(String[] args) {
        try {
            new Cliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
