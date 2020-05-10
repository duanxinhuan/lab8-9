import java.io.IOException;
import java.net.*;

public class Client02 {
    private String Inet_Addr = "localhost";
    private int port = 7600;

    public static void main(String[] args) {
        new Client02();


    }

    public Client02() {
        try {
            DatagramSocket ds = new DatagramSocket();

            String text = "Client on " + Inet_Addr+ " is listening on port "+ port ;

            InetAddress ip = InetAddress.getByName("localhost");

            int portNumber = 61124;

            DatagramPacket dp = new DatagramPacket(text.getBytes(), text.length(), ip, portNumber);

            ds.send(dp);
            System.out.println("waiting for disconnection!");
            receive();

            ds.close();

        } catch (SocketException e) {
            System.out.println(e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void receive() throws IOException {
        DatagramSocket ds = new DatagramSocket(port);
        byte[] buff = new byte[1024];


        // Receive the information and print it.
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        ds.receive(dp);
        String output = new String(dp.getData(), 0, dp.getLength());

        System.out.println(output);
    }
}


