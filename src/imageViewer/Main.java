package imageViewer;

import control.NextImageCommand;
import control.PrevImageCommand;
import files.FileImageLoader;
import persistence.ImageLoader;

public class Main {
    public static void main(String[] args) {
        ImageLoader imageLoader = new FileImageLoader("images");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDispalay()));
        mainFrame.add(new PrevImageCommand(mainFrame.getImageDispalay()));
        mainFrame.getImageDispalay().display(imageLoader.load());
    }
}
