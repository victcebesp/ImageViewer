package control;

import ui.ImageDisplay;

public class PrevImageCommand implements Command {
    private final ImageDisplay imageDislay;

    public PrevImageCommand(ImageDisplay imageDislay) {
        this.imageDislay = imageDislay;
    }

    @Override
    public String name() {
        return "prev";
    }

    @Override
    public void execute() {
        imageDislay.display(imageDislay.currentImage().prev());
    }
}
