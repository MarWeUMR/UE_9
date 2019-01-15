package network;

import message.AudioMessage;
import message.ImageMessage;
import message.Message;
import message.TextMessage;
import user.User;

public class Client implements Node {

    private User u;
    private Node connectedTo;

    /**
     * Constructor for a client instance
     *
     * @param u User representation of the client
     */
    public Client(User u) {
        this.u = u;
    }

    /**
     * Method for printing information about a received message.
     * Printing differs between client and server connection.
     *
     * @param message message content
     */
    @Override
    public void receive(Message message) {

        if (connectedTo instanceof Client) {
            System.out.println(
                    String.format(
                            "Message received from Id(%d): %s",
                            connectedTo.getId(), message.getTransferRepresentation()));
        } else {
            System.out.println(
                    String.format(
                            "Message received from Id(%d): %s",
                            message.getSender().getId(), message.getTransferRepresentation()));
        }
    }

    /**
     * Sends a general message
     *
     * @param message content
     */
    @Override
    public void send(Message message) {
        connectedTo.receive(message);
    }

    /**
     * Sends a textmessage
     *
     * @param message content
     */
    public void send(TextMessage message) {
        connectedTo.receive(message);
    }

    /**
     * Sends an audio message
     *
     * @param message content
     */
    public void send(AudioMessage message) {
        connectedTo.receive(message);
    }

    /**
     * Sends an image message
     *
     * @param message content
     */
    public void send(ImageMessage message) {
        connectedTo.receive(message);
    }

    /**
     * Conncets a client to the node of another client or server
     *
     * @param receiver
     */
    @Override
    public void connect(Node receiver) {
        this.connectedTo = receiver;

        if (receiver instanceof Client) {
            System.out.println(
                    String.format(
                            "%s connected to: %s",
                            this.getUser().getUserName(), connectedTo.getUser().getUserName()));
        } else {
            System.out.println(
                    String.format(
                            "%s connected to: Server",
                            this.getUser().getUserName()));
        }
    }

    @Override
    public int getId() {
        return u.getId();
    }

    @Override
    public User getUser() {
        return u;
    }


}
