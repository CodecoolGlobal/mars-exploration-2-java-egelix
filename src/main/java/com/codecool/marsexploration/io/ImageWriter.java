package com.codecool.marsexploration.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {
    public void write(BufferedImage image, String destination, String format) {
        try {
            doWrite(image, destination, format);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWrite(BufferedImage image, String destination, String format) throws IOException {
        File file = new File(destination);
        ImageIO.write(image, format, file);
    }
}
