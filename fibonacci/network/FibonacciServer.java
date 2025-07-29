package fibonacci.network;

import java.io.*;
import java.net.*;

public class FibonacciServer {

    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Fibonacci Server is running on port " + PORT);

            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    System.out.println("Client connected.");

                    // Read the number sent by the client
                    String inputLine = in.readLine();
                    int n = Integer.parseInt(inputLine);
                    int result = calculateFibonacci(n);

                    System.out.println("Received n = " + n + " → Sending Fibonacci = " + result);

                    // Send the result back to the client
                    out.println(result);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input from client. Not an integer.");
                } catch (IOException e) {
                    System.out.println("Client communication error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Efficient dynamic Fibonacci method
    public static int calculateFibonacci(int n) {
        if (n <= 1) return n;
        int v1 = 0, v2 = 1, v3 = 0;
        for (int i = 2; i <= n; i++) {
            v3 = v1 + v2;
            v1 = v2;
            v2 = v3;
        }
        return v3;
    }
}
