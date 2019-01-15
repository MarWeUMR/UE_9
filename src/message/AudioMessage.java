package message;

import data.Audio;
import data.Data;
import user.User;

public class AudioMessage extends AbstractDataMessage {

    /**
     * Constructor for an audio message instance
     *
     * @param sender    message to
     * @param recipient message from
     * @param audio     audio content
     */
    public AudioMessage(User sender, User recipient, Audio audio) {
        super(sender, recipient, audio);
    }

    // Die Aufgabenstellung ist hier völlig unklar. Irgendwas scheint da zu fehlen
    // (ich hatte Dir hierzu eine Mail geschickt)
    public void playVoiceMessage() {
        Audio a = (Audio) super.getDataObject();
        a.play();
    }
}
