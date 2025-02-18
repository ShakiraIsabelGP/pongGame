package org.example.pong;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TerminalDisplay {
    Terminal t;

    public TerminalDisplay() {
        try {
            t = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).createTerminal();
            t.enterPrivateMode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveCursor(int x, int y) {
        try {
            t.setCursorPosition(x, y);
            t.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public char getNextKeypress() {
        try {
            return t.readInput().getCharacter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void putCharacter(int x, int y, char c) {
        try {
            t.setCursorPosition(x, y);
            t.putCharacter(c);
        } catch (IOException ignored) {
        }
    }

    public void flush() {
        try {
            t.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawDiagonal(int size, char c) throws IOException {
        for (int i = 0; i < size; i++) {
            putCharacter(i, i, c);
        }
    }

    public void drawFull(int size, char diagonalChar, char fillChar) throws IOException {
        int i = 0;
        while (i < size) {
            putCharacter(i, i, diagonalChar);

            for (int j = 0; j < size; j++) {
                if (i != j) {
                    putCharacter(i, j, fillChar);
                }
            }
            i++;
        }
    }

    public void drawHorizontalLine(int xStart, int width, int y) throws IOException {
        for (int x = xStart; x < xStart + width; x++) {
            putCharacter(x, y, 'x');
        }
    }

    public void drawVerticalLine(int yStart, int height, int x) throws IOException {
        for (int y = yStart; y < yStart + height; y++) {
            putCharacter(x, y, 'x');
        }
    }

    public void drawRectangle(int x, int y, int width, int height) throws IOException {
        drawHorizontalLine(x, width, y);
        drawHorizontalLine(x, width, y + height - 1);

        drawVerticalLine(y, height, x);
        drawVerticalLine(y, height, x + width - 1);
    }

    public void drawSquare(int x, int y, int size) throws IOException {
        int squareSize = size - 2;
        drawHorizontalLine(x, size, y);
        drawHorizontalLine(x, size, y + squareSize);

        drawVerticalLine(y, squareSize, x);
        drawVerticalLine(y, squareSize, x + size - 1);
    }


    public int getX() {
        try {
            return t.getCursorPosition().getColumn();
        } catch (IOException ignored) {
            return 0;
        }
    }

    public int getY() {
        try {
            return t.getCursorPosition().getRow();
        } catch (IOException e) {
            return 0;
        }
    }

    public void setCursorPosition(int x, int y) {
        try {
            t.setCursorPosition(x, y);
            t.flush();
        } catch (IOException ignored) {

        }
    }

    public void clear() {
        try {
            t.clearScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TerminalSize getTerminalSize() {
        try {
            return t.getTerminalSize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        TerminalDisplay t = new TerminalDisplay();
        //  t.moveCursor(5, 5);
        //    t.drawDiagonal(10, 'x')
        // t.drawFull(10, 'X', 'o');
        //  t.drawRectangle(15, 0, 5, 5);
        //  t.drawSquare(5, 0, 5);
        System.exit(0);

    }
}
