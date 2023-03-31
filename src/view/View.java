package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame frame;
    private JTextField polinom1;
    private JTextField polinom2;
    private JLabel Poly1;
    private JLabel Poly2;
    private JComboBox select;
    private JButton calculate;
    private JTextField rez;

    public JLabel getRestul() {
        return restul;
    }

    public void setRestul(JLabel restul) {
        this.restul = restul;
    }

    private JLabel res;
    private JTextField rest;
    private JLabel restul;

    public JTextField getPolinom1() {
        return polinom1;
    }

    public void setPolinom1(JTextField polinom1) {
        this.polinom1 = polinom1;
    }

    public JTextField getPolinom2() {
        return polinom2;
    }

    public void setPolinom2(JTextField polinom2) {
        this.polinom2 = polinom2;
    }

    public JComboBox getSelect() {
        return select;
    }

    public void setSelect(JComboBox select) {
        this.select = select;
    }

    public JTextField getRez() {
        return rez;
    }

    public void setRez(JTextField rez) {
        this.rez = rez;
    }

    public JTextField getRest() {
        return rest;
    }

    public void setRest(JTextField rest) {
        this.rest = rest;
    }

    public View() {
        frame = new JFrame("Polynomial Calculator");
        frame.getContentPane().setSize(700, 500);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        polinom1 = new JTextField(30);
        polinom2 = new JTextField(30);
        polinom1.setBounds(120, 90, 400, 25);
        polinom2.setBounds(120, 150, 400, 25);
        Poly1 = new JLabel("Polinom1");
        Poly2 = new JLabel("Polinom2");
        Poly1.setBounds(70, 90, 100, 25);
        Poly2.setBounds(70, 150, 100, 25);
        rez = new JTextField(30);
        rez.setBounds(120, 210, 400, 25);
        res = new JLabel("rezultat");
        res.setBounds(80, 210, 100, 25);
        String[] strings = {"Addition", "Subtraction", "Multiplication", "Division", "Integration", "Derivation"};
        select = new JComboBox<>(strings);
        select.setBounds(100, 300, 180, 25);
        calculate = new JButton("Calculate");
        calculate.setBounds(450, 300, 100, 25);
        rest = new JTextField(30);
        rest.setBounds(100, 260, 400, 25);
        restul = new JLabel("Rest");
        restul.setBounds(100, 260, 100, 25);
        restul.setVisible(false);
        rest.setVisible(false);
        this.setBounds(100, 100, 643, 432);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.getContentPane().add(Poly1);
        this.getContentPane().add(polinom1);
        this.getContentPane().add(Poly2);
        this.getContentPane().add(polinom2);
        this.getContentPane().add(res);
        this.getContentPane().add(rez);
        this.getContentPane().add(rest);
        this.getContentPane().add(restul);
        this.getContentPane().add(select);
        this.getContentPane().add(calculate);
        this.setVisible(true);
        //((AbstractDocument) polinom1.getDocument()).setDocumentFilter(new TextFilter());
        //((AbstractDocument) polinom2.getDocument()).setDocumentFilter(new TextFilter());

    }

    public void apelare(ActionListener actionListener) {
        calculate.addActionListener(actionListener);
    }
}
