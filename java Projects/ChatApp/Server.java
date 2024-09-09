import java.net.*;
import java.io.*;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    PrintWriter pw;
    BufferedReader br;

    public Server() {
        try {

            serverSocket = new ServerSocket(7777);
            System.out.println("server is ready to accept connection.");
            System.out.println("Waitting....");
            socket = serverSocket.accept();
            
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            startReading();
            startWritting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try{
            while (true) {
                String msg = br.readLine();
                if (msg.equals("exit")) {
                    System.out.println("client stop the chat");
                    break;
                }
                System.out.println("Client :" + msg);
            } 
            }catch(Exception e){
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
    }

    public void startWritting() {
        System.out.println("Writer started...");
        Runnable r2 = () -> {
            while (true) {
                try {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String content=br2.readLine();
                pw.println(content);
                pw.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r2).start();
    }

    public static void main(String[] args) {
       new Server();
    }

}