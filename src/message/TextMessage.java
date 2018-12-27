package message;

import user.User;

public class TextMessage extends AbstractMessage {


    private final String msg;

    public TextMessage(User sender, User recipient, String msg) {
        super(sender, recipient);
        this.msg = msg;
    }




    /**
     * Returns the transfer representation of this message as a string.
     *
     * @return the transfer representation of this message.
     */
    @Override
    public String getTransferRepresentation() {
        return msg;
    }

    /**
     * Returns the pretty printed representation of a message. This is a simple String in this case!
     *
     * @return the pretty printed representation as string
     */
    @Override
    public String prettyPrint() {
        return String.format(
                "From: %s%nTo: %s%nMsg: %s",
                this.getSender().getUserName(), this.getRecipient().getUserName(), this.msg);
    }
}
