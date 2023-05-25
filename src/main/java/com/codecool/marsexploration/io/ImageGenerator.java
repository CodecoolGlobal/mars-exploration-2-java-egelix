package com.codecool.marsexploration.io;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.utility.MapGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageGenerator {
    MapGenerator mapGenerator;

    public ImageGenerator(Context context) {
        this.mapGenerator = new MapGenerator(context);
    }

    public void generateMapImage() {
        int ratioCoordToPixels = 10;
        String[][] map = mapGenerator.generateMapOfScannedArea();
        BufferedImage mapImg = getBlankImage(map.length, ratioCoordToPixels);
        setColoursToImage(map, mapImg, ratioCoordToPixels);
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
        for (int y = row * ratio; y < y + ratio; y++) {
            for (int x = column * ratio; x < x + ratio; x++) {
                mapImg.setRGB(x, y, color.getRGB());
            }
        }
    }

    private Color getColorForSymbol(String symbol) {
        Color color = null;
        if (symbol.equals(Symbol.EMPTY.getSymbol())) {
            color = new Color(226, 135, 67);
        } else if (symbol.equals(Symbol.MOUNTAIN.getSymbol())) {
            color = new Color(135, 62, 35);
        } else if (symbol.equals(Symbol.PIT.getSymbol())) {
            color = new Color(0, 0, 0);
        } else if (symbol.equals(Symbol.MINERAL.getSymbol())) {
            color = new Color(183, 176, 184);
        } else if (symbol.equals(Symbol.WATER.getSymbol())) {
            color = new Color(26, 146, 237);
        } else if (symbol.equals(Symbol.ALIEN.getSymbol())) {
            color = new Color(23, 230, 78);
        } else {

        }
        return color;
    }

    private BufferedImage getBlankImage(int size, int ratio) {
        BufferedImage img = new BufferedImage(size * ratio, size * ratio, BufferedImage.TYPE_INT_RGB);
        return img;
    }
}
