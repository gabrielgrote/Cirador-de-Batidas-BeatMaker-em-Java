import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.io.File;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.lang.Thread;

public class Main {
    public static int[] hatArray = {0,0,0,0};
    public static int[] snareArray = {0,0,0,0};
    public static int[] kickArray = {0,0,0,0};

    public static int counter = 0;
    public static boolean isPlaying = true;
    public static JButton stop;
    public static JButton play;
    public static int tempo = 1000;
    public static JButton tempoUp;
    public static JButton tempoDown;

    public static JPanel panel1;
    public static JPanel panel2;
    public static JPanel panel3;
    public static JPanel panel4;

    public static AudioInputStream audioStream;
    public static AudioInputStream audioStream2;
    public static AudioInputStream audioStream3;
    public static Clip clip;
    public static Clip clip2;
    public static Clip clip3;

    public static void main (String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        JFrame frame = new JFrame();
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setLayout(null);

        panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        panel1.setBounds(100,300,100,100);

        panel2 = new JPanel();
        panel2.setBackground(Color.gray);
        panel2.setBounds(200,300,100,100);

        panel3 = new JPanel();
        panel3.setBackground(Color.gray);
        panel3.setBounds(300,300,100,100);

        panel4 = new JPanel();
        panel4.setBackground(Color.gray);
        panel4.setBounds(400,300,100,100);




        JPanel hatPanel = new JPanel();
        hatPanel.setBounds(0,0,100,100);
        JLabel hatLabel = new JLabel("HAT");
        hatPanel.add(hatLabel);

        JPanel snarePanel = new JPanel();
        snarePanel.setBounds(0,100,100,100);
        JLabel snareLabel = new JLabel("SNARE");
        snarePanel.add(snareLabel);

        JPanel kickPanel = new JPanel();
        kickPanel.setBounds(0,200,100,100);
        JLabel kickLabel = new JLabel("KICK");
        kickPanel.add(kickLabel);




        JButton hat1 = new JButton();
        hat1.setBounds(100,0,100,100);
        hat1.setBackground(Color.green);
        JButton hat2 = new JButton();
        hat2.setBounds(200,0,100,100);
        hat2.setBackground(Color.green);
        JButton hat3 = new JButton();
        hat3.setBounds(300,0,100,100);
        hat3.setBackground(Color.green);
        JButton hat4 = new JButton();
        hat4.setBounds(400,0,100,100);
        hat4.setBackground(Color.green);

        JButton snare1 = new JButton();
        snare1.setBounds(100,100,100,100);
        snare1.setBackground(Color.green);
        JButton snare2 = new JButton();
        snare2.setBounds(200,100,100,100);
        snare2.setBackground(Color.green);
        JButton snare3 = new JButton();
        snare3.setBounds(300,100,100,100);
        snare3.setBackground(Color.green);
        JButton snare4 = new JButton();
        snare4.setBounds(400,100,100,100);
        snare4.setBackground(Color.green);

        JButton kick1 = new JButton();
        kick1.setBounds(100,200,100,100);
        kick1.setBackground(Color.green);
        JButton kick2 = new JButton();
        kick2.setBounds(200,200,100,100);
        kick2.setBackground(Color.green);
        JButton kick3 = new JButton();
        kick3.setBounds(300,200,100,100);
        kick3.setBackground(Color.green);
        JButton kick4 = new JButton();
        kick4.setBounds(400,200,100,100);
        kick4.setBackground(Color.green);

        play = new JButton("Play");
        play.setBackground(Color.blue);
        play.setBounds(500,0,100,100);
        stop = new JButton("Stop");
        stop.setBackground(Color.blue);
        stop.setBounds(500,100,100,100);

        tempoUp = new JButton("Aumentar Tempo");
        tempoUp.setBackground(Color.CYAN);
        tempoUp.setBounds(500,200,100,50);
        tempoDown = new JButton("Diminuir Tempo");
        tempoDown.setBackground(Color.CYAN);
        tempoDown.setBounds(500,250,100,50);



        frame.add(play);
        frame.add(stop);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        frame.add(hatPanel);
        frame.add(snarePanel);
        frame.add(kickPanel);

        frame.add(hat1);
        frame.add(hat2);
        frame.add(hat3);
        frame.add(hat4);

        frame.add(snare1);
        frame.add(snare2);
        frame.add(snare3);
        frame.add(snare4);

        frame.add(kick1);
        frame.add(kick2);
        frame.add(kick3);
        frame.add(kick4);

        frame.add(tempoUp);
        frame.add(tempoDown);


        hat1.addActionListener(e -> {
            if (hatArray[0] == 0){
                hatArray[0] = 1;
                hat1.setBackground(Color.red);
            } else {
                hatArray[0] = 0;
                hat1.setBackground(Color.green);
            }
        });
        hat2.addActionListener(e -> {
            if (hatArray[1] == 0){
                hatArray[1] = 1;
                hat2.setBackground(Color.red);
            } else {
                hatArray[1] = 0;
                hat2.setBackground(Color.green);
            }
            
        });
        hat3.addActionListener(e -> {
            if (hatArray[2] == 0){
                hatArray[2] = 1;
                hat3.setBackground(Color.red);
            } else {
                hatArray[2] = 0;
                hat3.setBackground(Color.green);
            }
            
        });
        hat4.addActionListener(e -> {
            if (hatArray[3] == 0){
                hatArray[3] = 1;
                hat4.setBackground(Color.red);
            } else {
                hatArray[3] = 0;
                hat4.setBackground(Color.green);
            }
            
        });

        snare1.addActionListener(e -> {
            if (snareArray[0] == 0){
                snareArray[0] = 1;
                snare1.setBackground(Color.red);
            } else {
                snareArray[0] = 0;
                snare1.setBackground(Color.green);
            }
            
        });
        snare2.addActionListener(e -> {
            if (snareArray[1] == 0){
                snareArray[1] = 1;
                snare2.setBackground(Color.red);
            } else {
                snareArray[1] = 0;
                snare2.setBackground(Color.green);
            }
            
        });
        snare3.addActionListener(e -> {
            if (snareArray[2] == 0){
                snareArray[2] = 1;
                snare3.setBackground(Color.red);
            } else {
                snareArray[2] = 0;
                snare3.setBackground(Color.green);
            }
            
        });
        snare4.addActionListener(e -> {

            if (snareArray[3] == 0){
                snareArray[3] = 1;
                snare4.setBackground(Color.red);
            } else {
                snareArray[3] = 0;
                snare4.setBackground(Color.green);
            }
            
        });

        kick1.addActionListener(e -> {
            if (kickArray[0] == 0){
                kickArray[0] = 1;
                kick1.setBackground(Color.red);
            } else {
                kickArray[0] = 0;
                kick1.setBackground(Color.green);
            }
            
        });
        kick2.addActionListener(e -> {
            if (kickArray[1] == 0){
                kickArray[1] = 1;
                kick2.setBackground(Color.red);
            } else {
                kickArray[1] = 0;
                kick2.setBackground(Color.green);
            }
            
        });
        kick3.addActionListener(e -> {
            if (kickArray[2] == 0){
                kickArray[2] = 1;
                kick3.setBackground(Color.red);
            } else {
                kickArray[2] = 0;
                kick3.setBackground(Color.green);
            }
            
        });
        kick4.addActionListener(e -> {
            if (kickArray[3] == 0){
                kickArray[3] = 1;
                kick4.setBackground(Color.red);
            } else {
                kickArray[3] = 0;
                kick4.setBackground(Color.green);
            }
            
        });

        play.addActionListener(e -> {
            isPlaying = true;
        });
        stop.addActionListener(e -> {
            isPlaying = false;
            counter = 0;
        });
        
        tempoUp.addActionListener(e -> {
            tempo = tempo - 50;
        });
        tempoDown.addActionListener(e -> {
            tempo = tempo + 50;
        });
        
        fun();
    }
    public static void fun(){
        File file = new File("Cymatics - Drip Closed Hihat 1.wav");
        File file2 = new File("Cymatics - Drip Snare 2 - D#.wav");
        File file3 = new File("Cymatics - Drip Kick 1 - C.wav");
        try{
            audioStream = AudioSystem.getAudioInputStream(file);
            audioStream2 = AudioSystem.getAudioInputStream(file2);
            audioStream3 = AudioSystem.getAudioInputStream(file3);
            clip = AudioSystem.getClip();
            clip2 = AudioSystem.getClip();
            clip3 = AudioSystem.getClip();
            /*
            Clip clip2 = AudioSystem.getClip();
            Clip clip3 = AudioSystem.getClip();
            */
            clip.open(audioStream);
            clip2.open(audioStream2);
            clip3.open(audioStream3);

        }catch (UnsupportedAudioFileException e){
            System.out.println("erro");
        }catch (IOException f){
            System.out.println("erro");
        }catch(LineUnavailableException e){
            System.out.println("erro");
        }
        

        while (true) {
            if (isPlaying){
            try{
                if (hatArray[counter] == 1){
                    //System.out.println("hat");
                    //try {
                        /*
                        File file = new File("Cymatics - Drip Closed Hihat 1.wav");
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        */
                        clip.setFramePosition(0);
                        //clip.open(audioStream);
                        clip.start();
                        
                        /*
                    }catch(LineUnavailableException e){
                        System.out.println("erro");
                    }catch (IOException f){
                        System.out.println("erro");
                    }
                    }catch (UnsupportedAudioFileException e){
                        System.out.println("erro");
                    }*/
                    
                    }
                if (snareArray[counter] == 1){
                    //System.out.println("snare");
                    //try {
                        /*
                        File file2 = new File("Cymatics - Drip Snare 2 - D#.wav");
                        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
                        Clip clip2 = AudioSystem.getClip();
                        */
                        clip2.setFramePosition(0);
                        //clip.open(audioStream2);
                        
                        clip2.start();
                       /* 
                    }catch(LineUnavailableException e){
                        System.out.println("erro");
                    }catch (IOException f){
                        System.out.println("erro");
                        
                    }catch (UnsupportedAudioFileException e){
                        System.out.println("erro");
                    }*/
                }
                if (kickArray[counter] == 1){
                    //System.out.println("kick");
                    //try {
                        /*
                        File file3 = new File("Cymatics - Drip Kick 1 - C.wav");
                        AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
                        Clip clip3 = AudioSystem.getClip();
                        */
                        clip3.setFramePosition(0);
                        //clip.open(audioStream3);
                        clip3.start();
                        /*
                    }catch(LineUnavailableException e){
                        System.out.println("erro");
                    }catch (IOException f){
                        System.out.println("erro");
                    }catch (UnsupportedAudioFileException e){
                        System.out.println("erro");
                    }*/
                }

                if (counter == 0){
                    panel1.setBackground(Color.yellow);
                }else{
                    panel1.setBackground(Color.gray);
                }
                if (counter == 1){
                    panel2.setBackground(Color.yellow);
                }else{
                    panel2.setBackground(Color.gray);
                }
                if (counter == 2){
                    panel3.setBackground(Color.yellow);
                }else{
                    panel3.setBackground(Color.gray);
                }
                if (counter == 3){
                    panel4.setBackground(Color.yellow);
                }else{
                    panel4.setBackground(Color.gray);
                }
                

                //TimeUnit.SECONDS.sleep(1);
                Thread.sleep(tempo);
                System.out.println(counter);
                counter = counter + 1;
                if (counter == 4){
                    counter = 0;
                }
                
            }catch(InterruptedException e){
                System.out.println("erro");
            }
            
            
            }
            play.addActionListener(e -> {
                isPlaying = true;
            });
        }
    }
}