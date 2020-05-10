import java.io.IOException;
import java.net.*;

public class ClientHandler extends Thread {
    private String Inet_address;
    private int port;
    public ClientHandler(String clientDetails){
        String[] details = clientDetails.split(" ");
        this.Inet_address = details[2];
        this.port = Integer.parseInt(details[7]);
    }

    @Override
    public void run(){
        System.out.println("sending");
        try {
        DatagramSocket ds = new DatagramSocket();

        String text = "the server is about to terminate in 5 s" ;

        InetAddress ip = InetAddress.getByName(Inet_address);

        int portNumber = port;

        DatagramPacket dp = new DatagramPacket(text.getBytes(), text.length(), ip, portNumber);

        ds.send(dp);

        ds.close();
        }
        catch (SocketException e) {
            System.out.println(e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
