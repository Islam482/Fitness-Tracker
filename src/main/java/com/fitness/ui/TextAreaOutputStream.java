package com.fitness.ui;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TextAreaOutputStream extends OutputStream {
    private final JTextArea area;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public TextAreaOutputStream(JTextArea area) {
        this.area = area;
    }

    @Override
    public void write(int b) {
        buffer.write(b);
    }

    @Override
    public void flush() {
        String text = buffer.toString(StandardCharsets.UTF_8);
        buffer.reset();
        if (!text.isEmpty()) {
            SwingUtilities.invokeLater(() -> area.append(text));
        }
    }
}