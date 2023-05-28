package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.symbol.RGB;
import com.codecool.marsexploration.data.symbol.Symbol;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymbolGenerator {
    public Set<Symbol> createSymbolSet() {
        return new HashSet<>(List.of(
                new Symbol("EMPTY", " ", new RGB(226, 135, 67)),
                new Symbol("NOT_SCANNED", "_", new RGB(255, 255, 255)),
                new Symbol("MOUNTAIN", "^", new RGB(135, 62, 35)),
                new Symbol("PIT", "#", new RGB(0, 0, 0)),
                new Symbol("MINERAL", "*", new RGB(183, 176, 184)),
                new Symbol("WATER", "~", new RGB(26, 146, 237)),
                new Symbol("ALIEN", "A", new RGB(23, 230, 78)),
                new Symbol("SPACE_SHIP", "S", new RGB(255, 80, 80)),
                new Symbol("ROVER", "R", new RGB(255, 255, 0))
        ));
    }
}