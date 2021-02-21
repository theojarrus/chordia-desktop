import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BitmapGenerator {

    private File resourcesDirectory;
    private File outputDirectory;

    BitmapGenerator(String sourcesDirectory, String outputPath) {
        resourcesDirectory = new File(FileReader.getFilePath(sourcesDirectory));
        outputDirectory = new File(FileReader.getFilePath(outputPath));
    }

    public void changeOutputDirectory(String outputPath) {
        outputDirectory = new File(FileReader.getFilePath(outputPath));
    }

    public String createResourceTemplate(String chord, String instrument, String template, String extra) {
        String outputFilePath = outputDirectory.getAbsolutePath() + "/" + chord + "_" + instrument + extra + ".png";
        boolean isCopied = FileReader.copyFile(resourcesDirectory.getAbsolutePath() + "/" + template, outputFilePath);
        if (!isCopied) outputFilePath = "";
        return outputFilePath;
    }

    boolean createResourceOverlay(String inputPath, String resourceName, int x, int y, String outputPath) {
        File resourceFile = new File(resourcesDirectory, resourceName);
        File inputFile = new File(inputPath);
        if (resourceFile.exists() && inputFile.exists()) {
            BufferedImage resourceImage = FileReader.readBitmapFile(resourceFile);
            BufferedImage inputImage = FileReader.readBitmapFile(inputFile);
            if (resourceImage != null && inputImage != null) {
                return createOverlay(inputImage, resourceImage, x, y, outputPath);
            }
        }
        return false;
    }

    private boolean createOverlay(BufferedImage originBitmap, BufferedImage overlayBitmap, int x, int y, String outputPath) {

        int w = originBitmap.getWidth();
        int h = originBitmap.getHeight();

        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = combined.getGraphics();
        graphics.drawImage(originBitmap, 0, 0, null);
        graphics.drawImage(overlayBitmap, x, y, null);

        File outputFile = new File(outputPath);

        return FileReader.writeBitmapFile(outputFile, combined);
    }

}
