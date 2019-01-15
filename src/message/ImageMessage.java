package message;

import data.Data;
import data.Image;
import user.User;

public class ImageMessage extends AbstractDataMessage {

    private String description;

    /**
     * Constructor for an image message instance
     *
     * @param sender      message to
     * @param recipient   message from
     * @param image       image content
     * @param description description of the image message
     */
    public ImageMessage(User sender, User recipient, Image image, String description) {
        super(sender, recipient, image);
        //this.image = image;
        this.description = description;
    }

    @Override
    public String getMediaInfo() {
        return description;
    }
}
