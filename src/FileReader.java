import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static BufferedImage readBitmapFile(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeBitmapFile(File file, BufferedImage image) {
        try {
            return ImageIO.write(image, "PNG", file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<String> readTextFile(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static boolean copyFile(String source, String output) {
        try {
            new File(output).getParentFile().mkdirs();
            Files.copy(Paths.get(source), Paths.get(output), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getFilePath(String path) {
        return new File(System.getProperty("user.dir"), path).getAbsolutePath();
    }

}