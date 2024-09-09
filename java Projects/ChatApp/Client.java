import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    Socket socket;

    PrintWriter pw;
    BufferedReader br;

    public Client() {
        try {
            System.out.println("Sending request to server");
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("Connection done.");

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

            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("client stop the chat");
                        break;
                    }
                    System.out.println("Server :" + msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                    String content = br2.readLine();
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
        new Client();
    }
}
