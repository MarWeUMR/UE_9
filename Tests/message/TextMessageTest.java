package message;

import org.junit.Assert;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class TextMessageTest {

    User u1 = new User(1, "User_1", "Uhh", "Ser");
    User u2 = new User(2, "User_2", "Two", "Ser");
    TextMessage txtMsg = new TextMessage(u1, u2, "Hello World");


    @Test
    public void getTransferRepresentation() {
        Assert.assertEquals("Hello World", txtMsg.getTransferRepresentation());
    }

    @Test
    public void txtMsgPrettyPrint() {
        Assert.assertEquals("From: User_1%nTo: User_2%nMsg: Hello World", txtMsg.prettyPrint());
    }

}