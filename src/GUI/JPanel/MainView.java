package GUI.JPanel;

import GUI.JPanel.Toolbox.DButton;
import GUI.JPanel.Toolbox.ScrollView;
import Tools.FontManager;
import Constants.Symbols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {

    private JPanel panel;

    // Lists
    private ScrollView listStack;
    private ScrollView listProgram;
    private ScrollView listEventOutput;

    // Buttons
    private DButton buttonLoadFile;
    private DButton buttonRun;
    private DButton buttonTerminate;
    private DButton buttonSetBreakpoint;
    private DButton buttonBreak;
    private DButton buttonMakeStep;

    // FontManager
    FontManager fontManager = new FontManager();

    private List<Resizeable> componentList = new ArrayList<>();

    // Listener
    private ComponentListener listenerFrame;

    int initialWidth = 766;
    int initialHeight = 635;

    public MainView(int width, int height) {
        super();

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        init();
        resize();
    }


    private void scaleElement(Component element, double scaleX, double scaleY) {

        int X = element.getX();
        int Y = element.getY();
        int width = element.getWidth();
        int height = element.getHeight();

        element.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));

    }


    private void resize() {

        // Set ListBox positions
        this.listStack.setBounds(13, 13, 345,460);
        this.listProgram.setBounds(363,41, 375, 316);
        this.listEventOutput.setBounds(13, 478, 726, 108);

        // Set Button position
        this.buttonLoadFile.setBounds(363, 12, 373, 23);
        this.buttonRun.setBounds(365, 363, 119, 46);
        this.buttonTerminate.setBounds(584, 363, 150, 46);
        this.buttonSetBreakpoint.setBounds(371, 430, 75, 23);
        this.buttonBreak.setBounds(581, 429, 75, 23);
        this.buttonMakeStep.setBounds(659, 429, 75, 23);
    }



    private void init() {

        // Set size of window
        setSize(766, 635);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Init
        this.panel = new JPanel();
        this.panel.setSize(1920, 1080);

        // Init ListViews
        this.listStack = new ScrollView();
        this.listProgram = new ScrollView();
        this.listEventOutput = new ScrollView();



        // Init Buttons
        this.buttonLoadFile = new DButton();
        this.buttonLoadFile.setText("LOAD FILE");


        this.buttonRun = new DButton();
        this.buttonRun.setText("RUN");


        this.buttonTerminate = new DButton();
        this.buttonTerminate.setText("TERMINATE");


        this.buttonSetBreakpoint = new DButton();
        this.buttonSetBreakpoint.setText(String.valueOf(Symbols.SET_BREAKPOINT));
        this.buttonSetBreakpoint.setFont(FontManager.UNICODE);

        this.buttonBreak = new DButton();
        this.buttonBreak.setText(Symbols.BREAK);
        this.buttonSetBreakpoint.setFont(FontManager.UNICODE);

        this.buttonMakeStep = new DButton();
        this.buttonMakeStep.setText("MAKE STEP");


        // Init Listeners
        initListeners();


        // Add Elements to List
        this.componentList.add(listStack);
        this.componentList.add(listProgram);
        this.componentList.add(listEventOutput);
        this.componentList.add(buttonLoadFile);
        this.componentList.add(buttonRun);
        this.componentList.add(buttonTerminate);
        this.componentList.add(buttonSetBreakpoint);
        this.componentList.add(buttonBreak);
        this.componentList.add(buttonMakeStep);

        // Add Elements to Panel
        this.panel.add(listStack);
        this.panel.add(listProgram);
        this.panel.add(listEventOutput);
        this.panel.add(buttonLoadFile);
        this.panel.add(buttonRun);
        this.panel.add(buttonTerminate);
        this.panel.add(buttonSetBreakpoint);
        this.panel.add(buttonBreak);
        this.panel.add(buttonMakeStep);


        //JFrame layout
        this.setLayout(null);

        //JPanel layout
        panel.setLayout(null);

        // Add Panel to Frame
        this.add(panel);


        setVisible(true);

        createBufferStrategy(3);
        revalidate();
        repaint();



    }


    private double n = 0;
    private void initListeners() {

        this.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {

                double width = getWidth();
                double height = getHeight();

                resize();


                double scaleX = width/initialWidth;
                double scaleY = height/initialHeight;




                for (Resizeable element : componentList) {

                    element.resize(scaleX, scaleY);
                }

                // Resize Panel
                panel.setSize((int)width, (int)height);

                revalidate();
                repaint();

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }



}
