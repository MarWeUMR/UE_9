package network;

import data.Audio;
import data.Image;
import message.AudioMessage;
import message.ImageMessage;
import message.TextMessage;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ClientTest {

    User u1 = new User(1, "User_1", "Uhh", "Ser");
    User u2 = new User(2, "User_2", "Two", "Ser");

    @Test
    public void ClientsSchickenNachrichten() {

        Client c1 = new Client(u1);
        Client c2 = new Client(u2);

        // establish connections
        c1.connect(c2);
        c2.connect(c1);

        // text messages
        System.out.println("-------------");
        c1.send(new TextMessage(c1.getUser(), c2.getUser(), "Hello World"));
        c2.send(new TextMessage(c2.getUser(), c1.getUser(), "Message received"));

        // audio message
        //c1.send(new AudioMessage(c1.getUser(), c2.getUser(), new Audio()));

        // image message
        System.out.println("-------------");
        c1.send(new ImageMessage(c1.getUser(), c2.getUser(), new Image(), "A picture"));
        c2.send(new ImageMessage(c2.getUser(), c1.getUser(), new Image(), "Selfie.png"));



    }


}