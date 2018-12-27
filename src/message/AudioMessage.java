package message;

import data.Audio;
import data.Data;
import user.User;

public class AudioMessage extends AbstractDataMessage {

    //private Audio audio;

    public AudioMessage(User sender, User recipient, Audio audio) {
        super(sender, recipient, audio);
        //this.audio = audio;
    }

    public void playVoiceMessage() {
       Audio a = (Audio)super.getDataObject();
       a.play();
    }
}
