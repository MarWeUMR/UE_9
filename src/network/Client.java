package network;

import message.AudioMessage;
import message.ImageMessage;
import message.Message;
import message.TextMessage;
import user.User;

public class Client implements Node {

    private User u;
    private Node connectedTo;

    public Client(User u) {
        this.u = u;
    }

    @Override
    public void receive(Message message) {

        if ( connectedTo instanceof Client ){
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

    @Override
    public void send(Message message) {
        connectedTo.receive(message);
    }

    public void send(TextMessage message) {
        connectedTo.receive(message);
    }

    public void send(AudioMessage message) {
        connectedTo.receive(message);
    }

    public void send(ImageMessage message) {
        connectedTo.receive(message);
    }

    @Override
    public void connect(Node receiver) {
        this.connectedTo = receiver;

        if ( receiver instanceof Client ){
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
