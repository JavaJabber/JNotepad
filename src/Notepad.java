import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Notepad extends KeyAdapter implements ActionListener, KeyListener{

    static int active = 0;
    static int activeFontSize = 17;

    JFrame frame1;
    JMenuBar notepadMenuBar;
    JMenu file, edit, format, view;
    JMenuItem newDoc, openDoc, exit, saveDoc, saveAsDoc, copyDoc, pasteDoc, remDoc, fontFamily, fontStyle, fontSize, status;
    JTextArea mainText;
    JTextField title;
    Font font1;
    JPanel bottom;
    JLabel details, pasteCopyDoc;
    JList familyList, styleList, sizeList;
    JScrollPane scrollBar;

    String familyValues[] = {"Agency FB","Antiqua","Architect","Arial","Calibri","Comic Sans","Courier","Cursive","Impact","Serif"};
    String sizeValues [] ={"5","10","15","20","25","30","35","40","45","50","55","60","65","70"};
    int [] styleValue = { Font.PLAIN, Font.BOLD, Font.ITALIC };
    String [] styleValues = { "PLAIN", "BOLD", "ITALIC" };
    String fontFamilyString, fontSizeString, fontStyleString;
    int fontStyleKey;
    int cl;
    int lineCount;
    String tle ;
    String topicsTitle = "";
    JScrollPane  scrollPane;

    Notepad() {
        frame1 = new JFrame("Notepad");

        font1 = new Font("Arial", Font.PLAIN, 17);
        bottom = new JPanel();
        details = new JLabel();
        pasteCopyDoc = new JLabel();

        familyList = new JList(familyValues);
        styleList = new JList(styleValues);
        sizeList = new JList(sizeValues);

        familyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        styleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        bottom.add(details);

        mainText = new JTextArea();

        scrollPane = new JScrollPane(mainText);
        title = new JTextField(100);

        scrollBar = new JScrollPane(mainText);

        mainText.setMargin(new Insets(5, 5, 5, 5));

        mainText.setFont(font1);
        frame1.add(mainText);

        notepadMenuBar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        view = new JMenu("View");

        newDoc = new JMenuItem("New Document");
        openDoc = new JMenuItem("Open Document");
        saveDoc = new JMenuItem("Save Document");
        saveAsDoc = new JMenuItem("Save As Document");
        exit = new JMenuItem("Exit");

        copyDoc = new JMenuItem("Copy Document");
        remDoc = new JMenuItem("Remove Document");
        pasteDoc = new JMenuItem("Paste Document");

        fontFamily = new JMenuItem("Set Font Family");
        fontStyle = new JMenuItem("Set Font Style");
        fontSize = new JMenuItem("Set Font Size");
        status = new JMenuItem("Status");

        file.add(newDoc);
        file.add(openDoc);
        file.add(saveDoc);
        file.add(saveAsDoc);
        file.add(exit);

        edit.add(copyDoc);
        edit.add(pasteDoc);
        edit.add(remDoc);

        format.add(fontFamily);
        format.add(fontStyle);
        format.add(fontStyle);

        view.add(status);

        notepadMenuBar.add(file);
        notepadMenuBar.add(edit);
        notepadMenuBar.add(format);
        notepadMenuBar.add(view);

        frame1.setJMenuBar(notepadMenuBar);
        frame1.add(bottom, BorderLayout.SOUTH);

        newDoc.addActionListener(this);
        copyDoc.addActionListener(this);
        pasteDoc.addActionListener(this);
        remDoc.addActionListener(this);
        status.addActionListener(this);
        saveDoc.addActionListener(this);
        saveAsDoc.addActionListener(this);

        fontFamily.addActionListener(this);
        fontSize.addActionListener(this);
        fontStyle.addActionListener(this);

        exit.addActionListener(this);

        mainText.addKeyListener(this);

        frame1.setSize(600, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
