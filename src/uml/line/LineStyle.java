package uml.line;

import java.awt.Point;
import java.awt.Graphics;

public interface LineStyle {
    public void doStyle(Graphics g, Point from, Point to, int toIndex);
}
