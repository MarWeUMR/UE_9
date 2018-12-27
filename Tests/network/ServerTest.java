package network;

import message.TextMessage;
import org.junit.Assert;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ServerTest {

    User u1 = new User(1, "User_1", "Uhh", "Ser");
    User u2 = new User(2, "User_2", "Two", "Ser");
    User u3 = new User(3, "User_3", "Res", "Hu");

    Client c1 = new Client(u1);
    Client c2 = new Client(u2);
    Client c3 = new Client(u3);
    Client c4 = new Client(u3);
    Server server = new Server(3);

    // Test client connection to server
    @Test(expected = IndexOutOfBoundsException.class)
    public void connectionTest() {
        server.connect(c1);
        server.connect(c2);
        server.connect(c3);
        server.connect(c4); // User zuviel -> IooB Exception
    }

    @Test
    public void ServerMessageTest() {
        server.connect(c1);
        server.connect(c2);
        server.connect(c3);

        server.receive(new TextMessage(c1.getUser(), c2.getUser(), "Hello World"));
    }


}