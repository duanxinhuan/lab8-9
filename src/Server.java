import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Server {

    public static void main(String [] args)
    {
        new Server();
    }

    public Server(){
        ArrayList<ClientHandler> connections = new ArrayList<>();
        ClientListener listener = new ClientListener(connections);
        listener.start();
        try {
            TimeUnit.SECONDS.sleep(10);


            for (int i = 0; i < connections.size(); i++) {
                connections.get(i).start();

            }
            TimeUnit.SECONDS.sleep(5);
            listener.terminate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

