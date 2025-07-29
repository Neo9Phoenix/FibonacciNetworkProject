package fibonacci.network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FibonacciClient {

    public static void main(String[] args) {
        final String SERVER = "localhost"; // or your IP
        final int PORT = 5000;

        try (
            Socket socket = new Socket(SERVER, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.print("Enter a number to calculate Fibonacci: ");
            int n = scanner.nextInt();

            // Send the number to the server
            out.println(n);

            // Get the result
            String response = in.readLine();
            System.out.println("Fibonacci result from server: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
