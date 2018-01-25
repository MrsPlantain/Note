package org.listener;

import org.note.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class SaveActionListener implements ActionListener {

    private Note note;

    public SaveActionListener(Note note) {
        this.note = note;
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int action = fileChooser.showSaveDialog(note);
        switch (action) {
            case JFileChooser.APPROVE_OPTION:
                PrintStream printStream = null;
                try {
                    printStream = new PrintStream(new FileOutputStream(fileChooser.getSelectedFile()));
                    printStream.append(note.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }finally {
                    if (printStream != null) {
                        printStream.close();
                    }
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                break;
        }
    }
}
