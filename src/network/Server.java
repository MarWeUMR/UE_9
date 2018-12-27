package network;

import message.Message;
import user.User;

public class Server implements Node {

    private Node[] nodes;
    private int connectedClients = 0; // counter um position im node array zu kontrollieren

    public Server(int size) {
        this.nodes = new Node[size];
    }

    @Override
    public void receive(Message message) {
        System.out.println(
                String.format(
                        "Server received message from: %s",
                        message.getSender().getUserName()));

        send(message);
    }

    @Override
    public void send(Message message) {
        Node recipient = establishConnection(message.getRecipient());

        System.out.println(
                String.format(
                        "Message sent from Server to: %s",
                        recipient.getUser().getUserName()));

        recipient.receive(message);
    }

    @Override
    public void connect(Node receiver) {
        this.nodes[connectedClients] = receiver;
        connectedClients++;
        receiver.connect(this);
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public User getUser() {
        return null;
    }

    private Node establishConnection(User recipient) {

        for (Node n :
                nodes) {
            if (n.getUser().getId() == recipient.getId()) {
                return n;
            }
        }
        return null;
    }
}
