package message;

import data.Data;
import user.User;

abstract class AbstractDataMessage extends AbstractMessage implements DataMessage {

    private Data data;

    /**
     * Constructor for an abstract data message instance
     *
     * @param sender    message from
     * @param recipient message to
     * @param data      content type of the message
     */
    protected AbstractDataMessage(User sender, User recipient, Data data) {
        super(sender, recipient);
        this.data = data;
    }

    @Override
    public String getTransferRepresentation() {
        return String.format("Data type: %s%nMedia Info: %s%nData Object: %s",
                data.getClass().getName(), getMediaInfo(), getDataObject());
    }

    @Override
    public String prettyPrint() {
        return data.prettyPrint();
    }

    @Override
    public Data getDataObject() {
        return data;
    }

    @Override
    public String getMediaInfo() {
        return String.format("Some info about this %s message.", data.getClass().getName());
    }

}
