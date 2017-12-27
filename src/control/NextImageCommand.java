package control;

import ui.ImageDisplay;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDislay;

    public NextImageCommand(ImageDisplay imageDislay) {
        this.imageDislay = imageDislay;
    }

    @Override
    public String name() {
        return "next";
    }

    @Override
    public void execute() {
        imageDislay.display(imageDislay.currentImage().next());
    }
}
