package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.symbol.Symbols;
import com.codecool.marsexploration.utility.ScannedMapGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageGenerator {
    private final ScannedMapGenerator mapGenerator;
    private final ImageWriter imageWriter;
    private int counter = 0;

    public ImageGenerator(ScannedMapGenerator mapGenerator, ImageWriter imageWriter) {
        this.mapGenerator = mapGenerator;
        this.imageWriter = imageWriter;
    }

    public void generateMapImage() {
        int ratioCoordToPixels = 40;
        String[][] map = mapGenerator.generateMapOfScannedArea();
        BufferedImage mapImg = getBlankImage(map.length, ratioCoordToPixels);
        setColoursToImage(map, mapImg, ratioCoordToPixels);
        String path = "src/main/resources/ImgRoverScans/roverTrack" + counter + ".jpg";
        imageWriter.write(mapImg, path, "jpg");
        counter++;
    }

    private void setColoursToImage(String[][] map, BufferedImage mapImg, int ratio) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                String symbol = map[y][x];
                Color color = getColorForSymbol(symbol);
                setColoursToPixelArea(mapImg, color, y, x, ratio);
            }
        }
    }

    private void setColoursToPixelArea(BufferedImage mapImg, Color color, int row, int column, int ratio) {
        int newRow = row * ratio;
        int newColumn = column * ratio;
        for (int y = 0; y < ratio; y++) {
            for (int x = 0; x < ratio; x++) {
                mapImg.setRGB(x + newColumn, y + newRow, color.getRGB());
            }
        }
    }

    private Color getColorForSymbol(String symbol) {
        if (symbol.equals("_")) {
            return new Color(255, 255, 255);
        } else if (symbol.equals(Symbols.MOUNTAIN.getSymbol())) {
            return new Color(135, 62, 35);
        } else if (symbol.equals(Symbols.PIT.getSymbol())) {
            return new Color(0, 0, 0);
        } else if (symbol.equals(Symbols.MINERAL.getSymbol())) {
            return new Color(183, 176, 184);
        } else if (symbol.equals(Symbols.WATER.getSymbol())) {
            return new Color(26, 146, 237);
        } else if (symbol.equals(Symbols.ALIEN.getSymbol())) {
            return new Color(23, 230, 78);
        } else if (symbol.equals(Symbols.SPACE_SHIP.getSymbol())) {
            return new Color(255, 80, 80);
        } else {
            return new Color(226, 135, 67);
        }
    }

    private BufferedImage getBlankImage(int size, int ratio) {
        return new BufferedImage(size * ratio, size * ratio, BufferedImage.TYPE_INT_RGB);
    }
}