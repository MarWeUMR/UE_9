package message;

import data.Data;
import data.Image;
import user.User;

public class ImageMessage extends AbstractDataMessage{

    //private Image image;
    private String description;

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
