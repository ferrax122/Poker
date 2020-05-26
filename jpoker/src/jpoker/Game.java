/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpoker;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Game extends JFrame implements ActionListener {
 
    public Game() {
 
        super("JPoker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
// pannello centrale
        JPanel pcard = new JPanel();//carte
        pcard.setBackground(new Color(0, 128, 0));
        pcard.setLayout(new GridLayout(1, 5, 5, 0));
        for (int i = 0; i < vl.length; i++) {
            pcard.add(vl[i] = new JLabel());
            vl[i].setIcon(new ImageIcon("cards\\sfondo.jpg"));
        }
        JPanel pbut = new JPanel();//bottoni di selezione
        pbut.setBackground(new Color(0, 128, 0));
        pbut.setLayout(new GridLayout(1, 5, 5, 0));
        for (int i = 0; i < but.length; i++) {
            pbut.add(but[i] = new JButton("Hold " + (i + 1)));
            but[i].setPreferredSize(new Dimension(175, 40));
            but[i].addActionListener(this);
            but[i].setForeground(Color.BLACK);
        }
        centro = new JPanel();
        centro.setBackground(new Color(0, 128, 0));
        centro.add(pcard);
        centro.add(pbut);
        this.getContentPane().add(centro, "Center");
// pannello sud
        sud = new JPanel();
        sud.setBackground(new Color(0, 128, 0));
        sud.add(start = new JButton("Start"));
        start.setPreferredSize(new Dimension(150, 40));
        start.addActionListener(this);
        this.getContentPane().add(sud, "South");
// pannello nord
        nord = new JPanel();
        nord.setBackground(new Color(0, 128, 0));
        JLabel titolo = new JLabel("My Poker");
        titolo.setFont(new Font("Arial", Font.BOLD, 30));
        titolo.setForeground(Color.red);
        nord.add(titolo);
        this.getContentPane().add(nord, "North");
// pannello destro
        dx = new JPanel();
        dx.setBackground(new Color(0, 128, 0));
        dx.setLayout(new GridLayout(10, 1, 5, 0));
        for (int i = 0; i < vincite.length; i++) {
            vincite[i] = new JLabel(titoliVincite[i]);
            vincite[i].setFont(new Font("Arial", Font.BOLD, 18));
            vincite[i].setForeground(Color.BLUE);
            dx.add(vincite[i]);
        }
        dx.add(lwin);
        lwin.setForeground(Color.YELLOW);
        lwin.setFont(new Font("Arial", Font.BOLD, 24));
        this.getContentPane().add(dx, "East");
// pannello sinistro
        sx = new JPanel();
        sx.setBackground(new Color(0, 128, 0));
        sx.setLayout(new GridLayout(4, 1, 5, 65));
        nome.setFont(new Font("Arial", Font.BOLD, 22));
        nome.setForeground(Color.ORANGE);
        coin.setFont(new Font("Arial", Font.BOLD, 22));
        coin.setForeground(Color.ORANGE);
        lbet.setFont(new Font("Arial", Font.BOLD, 22));
        lbet.setForeground(Color.ORANGE);
        bet.setPreferredSize(new Dimension(150, 40));
        bet.addActionListener(this);
        sx.add(nome);
        sx.add(coin);
        sx.add(lbet);
        sx.add(bet);
        this.getContentPane().add(sx, "West");
//
        pack();
        setResizable(false);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
 
        String b = e.getActionCommand();
 
        if (b.equals("Bet") && stato == 1) {
 
            if (denaro > 0) {
 
                lbet.setText(" Bet  " + (puntata += 100));
                coin.setText(" Coin  " + (denaro -= 100) + "$");
                flagBet = true;
 
            } else {
                denaro = puntata;
                lbet.setText(" Bet  0");
                coin.setText(" Coin  " + denaro + "$");
                puntata = 0;
                flagBet = true;
            }
 
        } else if (b.equals("Hold 1") && stato == 2) {
            setHold(0);
        } else if (b.equals("Hold 2") && stato == 2) {
            setHold(1);
        } else if (b.equals("Hold 3") && stato == 2) {
            setHold(2);
        } else if (b.equals("Hold 4") && stato == 2) {
            setHold(3);
        } else if (b.equals("Hold 5") && stato == 2) {
            setHold(4);
        } else if (b.equals("Start")) {
 
            if (puntata > 0) {
                dai_carte();
            } else {
                JOptionPane.showMessageDialog(null, "Devi puntare!!!", "msg", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
 
    public void dai_carte() {
 
        if (stato == 1) {
 
            if (!flagBet) {
 
                if (denaro > 0) {
 
                    if (denaro >= puntata) {
 
                        coin.setText(" Coin  " + (denaro -= puntata) + "$");
                    } else {
 
                        puntata = denaro;
                        denaro = 0;
                        lbet.setText(" Bet  " + puntata);
                        coin.setText(" Coin  " + denaro + "$");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "GAME OVER", "msg", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
            cards[0] = String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME();
            cards[1] = JCard.estraicarta(cards[0], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
            cards[2] = JCard.estraicarta(cards[0], cards[1], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
            cards[3] = JCard.estraicarta(cards[0], cards[1], cards[2], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
            cards[4] = JCard.estraicarta(cards[0], cards[1], cards[2], cards[3], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
 
            for (int d = 0; d < 5; d++) {
                vl[d].setIcon(new ImageIcon("cards\\" + cards[d] + ".jpg"));
            }
            stato = 2;
 
        } else if (stato == 2) {
 
            for (int d = 0; d < 5; d++) {
                if (!H[d]) {
                    switch (d) {
                        case 0:
                            cards[0] = JCard.estraicarta(cards[1], cards[2], cards[3], cards[4], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
                            break;
                        case 1:
                            cards[1] = JCard.estraicarta(cards[0], cards[2], cards[3], cards[4], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
                            break;
                        case 2:
                            cards[2] = JCard.estraicarta(cards[0], cards[1], cards[3], cards[4], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
                            break;
                        case 3:
                            cards[3] = JCard.estraicarta(cards[0], cards[1], cards[2], cards[4], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
                            break;
                        case 4:
                            cards[4] = JCard.estraicarta(cards[0], cards[1], cards[2], cards[3], String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + JCard.estraiSEME());
                            break;
                    }
                }
            }
            for (int d = 0; d < 5; d++) {
                vl[d].setIcon(new ImageIcon("cards\\" + cards[d] + ".jpg"));
                H[d] = false;
            }
            stato = 3;
            //////////////////////////////////////////////////////////////////////////
            JWin.setcard(cards);
            if (JWin.scalaR()) {
                vinto(0);
            } else if (JWin.scalaColore()) {
                vinto(1);
            } else if (JWin.poker()) {
                vinto(2);
            } else if (JWin.full()) {
                vinto(3);
            } else if (JWin.colore()) {
                vinto(4);
            } else if (JWin.scala()) {
                vinto(5);
            } else if (JWin.tris()) {
                vinto(6);
            } else if (JWin.doppiaCoppia()) {
                vinto(7);
            } else if (JWin.coppia()) {
                vinto(8);
            }
            /////////////////////////////////////////////////////////////////////////////////7
        } else if (stato == 3) {
 
            for (int d = 0; d < 5; d++) {
                vl[d].setIcon(new ImageIcon("cards\\sfondo.jpg"));
                but[d].setForeground(Color.BLACK);
                cards[d] = null;
            }
            for (int y = 0; y < 9; y++) {
                vincite[y].setForeground(Color.BLUE);
            }
            coin.setText(" Coin " + denaro + "$");
            lwin.setText("");
            puntataTemp = puntata;
            flagBet = false;
 
            stato = 1;
        }
    }//
 
    public void setHold(int x) {
        if (but[x].getForeground() == Color.YELLOW) {
            but[x].setForeground(Color.BLACK);
            H[x] = false;
        } else if (but[x].getForeground() == Color.BLACK) {
            but[x].setForeground(Color.YELLOW);
            H[x] = true;
        }
    }
 
    public void vinto(int c) {
 
        vincite[c].setForeground(Color.YELLOW);
 
        switch (c) {
 
            case 0:
                denaro += puntata * 100;
                lwin.setText("   Win " + puntata * 100 + "$");
                break;
            case 1:
                denaro += puntata * 50;
                lwin.setText("   Win " + puntata * 50 + "$");
                break;
            case 2:
                denaro += puntata * 40;
                lwin.setText("   Win " + puntata * 40 + "$");
                break;
            case 3:
                denaro += puntata * 30;
                lwin.setText("   Win " + puntata * 30 + "$");
                break;
            case 4:
                denaro += puntata * 20;
                lwin.setText("   Win " + puntata * 20 + "$");
                break;
            case 5:
                denaro += puntata * 15;
                lwin.setText("   Win " + puntata * 15 + "$");
                break;
            case 6:
                denaro += puntata * 10;
                lwin.setText("   Win " + puntata * 10 + "$");
                break;
            case 7:
                denaro += puntata * 5;
                lwin.setText("   Win " + puntata * 5 + "$");
                break;
            case 8:
                denaro += puntata ;
                lwin.setText("   Win " + puntata * 1 + "$");
                break;
        }
    }
 
    private static boolean flagBet = false;
    private static String[] cards = new String[5];
    private String titoliVincite[] = {"Scala Reale x 100", "Scala colore x 50", "Poker x 40", "Full x 30", "Colore x 20", "Scala x 15", "Tris x 10", "Doppia Coppia x 5", "Coppia x 1"};
    private static boolean[] H = new boolean[5];
    private static int puntata = 0,
            denaro = 1000,
            puntataTemp = 0,
            stato = 1;
    private JLabel[] vl = new JLabel[5],
            vincite = new JLabel[9];
    private JButton[] but = new JButton[5];
    private JButton start;
    private JPanel centro, sx, dx, nord, sud;
    private JLabel nome = new JLabel(" Nome: Ferrax");
    private JLabel coin = new JLabel(" Coin  " + denaro + "$");
    private JLabel lbet = new JLabel(" Bet  0");
    private JLabel lwin = new JLabel("");
    private JButton bet = new JButton("Bet");
}//fine class game
//int s = JOptionPane.showConfirmDialog(null, "GAME OVER \n\n Ricomincia una nuova partita?", "Messaggio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);