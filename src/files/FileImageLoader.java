package files;

import Model.Image;
import persistence.ImageLoader;

import java.io.*;

public class FileImageLoader implements ImageLoader {

    private final static String[] imageExtensions = new String[]{"jpg", "png", "bmp"};
    private final File[] files;

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int index){
        return new Image() {
            @Override
            public byte[] bitmap() {
                try {
                    FileInputStream is = new FileInputStream(files[index]);
                    return read(is);
                } catch (IOException e) {
                    return new byte[0];
                }
            }

            @Override
            public Image next() {
                return  (index < files.length-1) ? imageAt(index+1) : imageAt(0);
            }

            @Override
            public Image prev() {
                return  (index > 0) ? imageAt(index-1) : imageAt(files.length-1);
            }

            private byte[] read(FileInputStream is) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                while(true){
                    int length = is.read(buffer);
                    if (length < 0) break;
                    os.write(buffer, 0, length);
                }
                return os.toByteArray();
            }
        };
    }

    private FilenameFilter withImageExtension() {

        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String extension : imageExtensions) {
                    if (name.endsWith(extension)) return true;
                }
                return false;
            }
        };
    }
}
