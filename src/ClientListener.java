import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ClientListener extends Thread {
    private static final int port = 61128;
    private ArrayList<ClientHandler> clients;
    public ClientListener(ArrayList<ClientHandler> clients) {
        this.clients = clients;
    }
    private boolean valid = true;
        @Override
        public void run(){
            System.out.println("Server running");
            DatagramSocket ds = null;
            try {
                ds = new DatagramSocket(port);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            while(valid){
                try {

                    ds.setSoTimeout(3000);
                    byte[] buff = new byte[1024];
                    DatagramPacket dp = new DatagramPacket(buff, buff.length);
                    ds.receive(dp);
                    String output = new String(dp.getData(), 0, dp.getLength());
                    System.out.println(output);
                    clients.add(new ClientHandler(output));
                }catch(SocketTimeoutException e){

                }catch (SocketException e) {
                    System.out.println(e.getMessage());

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            ds.close();
        }

        public void terminate(){
            this.valid =false;
        }


    }




