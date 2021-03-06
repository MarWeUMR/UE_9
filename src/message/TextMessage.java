package message;

import user.User;

public class TextMessage extends AbstractMessage {


    private final String msg;

    /**
     * Constructor of a text message instance
     *
     * @param sender    message to
     * @param recipient message from
     * @param msg       text content
     */
    public TextMessage(User sender, User recipient, String msg) {
        super(sender, recipient);
        this.msg = msg;
    }


    @Override
    public String getTransferRepresentation() {
        return msg;
    }

    @Override
    public String prettyPrint() {
        System.out.println(String.format(
                "From: %s%nTo: %s%nMsg: %s",
                this.getSender().getUserName(), this.getRecipient().getUserName(), this.msg));
        return String.format(
                "From: %s%nTo: %s%nMsg: %s",
                this.getSender().getUserName(), this.getRecipient().getUserName(), this.msg);
    }
}
