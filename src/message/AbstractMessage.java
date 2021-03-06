package message;

import user.User;

abstract class AbstractMessage implements Message {

    private final User sender;
    private final User recipient;

    /**
     * Constructor for an abstract message instance
     *
     * @param sender    message from
     * @param recipient message to
     */
    protected AbstractMessage(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public final User getSender() {
        return this.sender;
    }

    @Override
    public final User getRecipient() {
        return this.recipient;
    }
}
