package message;

import data.Data;

abstract class AbstractDataMessage extends AbstractMessage implements DataMessage{

    Data data;

    protected AbstractDataMessage() {

    }

    @Override
    public String getTransferRepresentation() {
        return null;
    }
}
