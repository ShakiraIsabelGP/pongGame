package org.example.pong;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
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

    /**
     * Returns a KeyStroke, or null if the user has not pressed a key.
     */
    public KeyStroke getNextKeypress() {
        try {
            return t.pollInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public char getKeypress()  {
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
}
