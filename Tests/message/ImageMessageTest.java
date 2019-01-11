package message;

import data.Image;
import org.junit.Assert;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class ImageMessageTest {

    User u1 = new User(1, "User_1", "Uhh", "Ser");
    User u2 = new User(2, "User_2", "Two", "Ser");
    ImageMessage imgMsg = new ImageMessage(u1, u2, new Image(),"This is an image.");

    @Test
    public void getMediaInfo() {
        Assert.assertEquals("This is an image.", imgMsg.getMediaInfo());
    }

    @Test
    public void imgMsgPrettyPrintTest() {
        System.out.println(imgMsg.prettyPrint());
//        Assert.assertEquals("Here's to Adam.", imgMsg.prettyPrint());
    }

}