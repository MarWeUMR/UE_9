package network;

import message.Message;
import user.User;

public class Server implements Node {

    private Node[] nodes;
    private int connectedClients = 0; // counter um position im node array zu kontrollieren

    /**
     * Constructor for a server instance.
     *
     * @param size Number of clients the server can handle.
     */
    public Server(int size) {
        this.nodes = new Node[size];
    }

    /**
     * Receives a message and sends it to the corresponding client
     *
     * @param message
     */
    @Override
    public void receive(Message message) {
        System.out.println(
                String.format(
                        "Server received message from: %s",
                        message.getSender().getUserName()));

        send(message);
    }

    /**
     * Finds the clients to send a message to and sends it.
     *
     * @param message content
     */
    @Override
    public void send(Message message) {
        Node recipient = establishConnection(message.getRecipient());

        System.out.println(
                String.format(
                        "Message sent from Server to: %s",
                        recipient.getUser().getUserName()));

        recipient.receive(message);
    }

    /**
     * Connects a client to the server and increments the counter of available spots.
     *
     * @param receiver
     */
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

    /**
     * Iterates over the list of connected nodes to find corresponding user.
     *
     * @param recipient User to receive the message
     * @return client instance of the receiving user
     */
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
