package message;

import data.Audio;
import org.junit.Assert;
import org.junit.Test;
import user.User;

import static org.junit.Assert.*;

public class AudioMessageTest {

    User u1 = new User(1, "User_1", "Uhh", "Ser");
    User u2 = new User(2, "User_2", "Two", "Ser");
    AudioMessage audioMsg = new AudioMessage(u1, u2, new Audio());


    @Test
    public void getMediaInfo() {
        Assert.assertEquals("Some info about this data.Audio message.", audioMsg.getMediaInfo());
    }

    @Test
    public void playVoiceMessage() {
    // was für eine bin Datei ?!

        //audioMsg.playVoiceMessage();
    }

    @Test
    public void audioMsgPrettyPrintTest() {
        Assert.assertEquals("Here's to Adam.", audioMsg.prettyPrint());
    }
}