package Controller;

import modul.Polinom_Service;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {

    View view;

    public ViewController(View view) {
        this.view = view;
        this.view.apelare(new Auxiliar());
    }

    class Auxiliar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getSelect().getSelectedIndex() == 0) {
                view.getRest().setVisible(false);
                view.getRestul().setVisible(false);
                view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.addition(Polinom_Service.parsing(view.getPolinom1().getText()), Polinom_Service.parsing(view.getPolinom2().getText()))));
            } else if (view.getSelect().getSelectedIndex() == 1) {
                view.getRest().setVisible(false);
                view.getRestul().setVisible(false);
                view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.subtraction(Polinom_Service.parsing(view.getPolinom1().getText()), Polinom_Service.parsing(view.getPolinom2().getText()))));
            } else if (view.getSelect().getSelectedIndex() == 2) {
                view.getRest().setVisible(false);
                view.getRestul().setVisible(false);
                view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.multiplication(Polinom_Service.parsing(view.getPolinom1().getText()), Polinom_Service.parsing(view.getPolinom2().getText()))));
            }else if (view.getSelect().getSelectedIndex()==3) {
                    view.getRest().setVisible(true);
                    view.getRestul().setVisible(true);
                    view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.division(Polinom_Service.parsing(view.getPolinom1().getText()),Polinom_Service.parsing(view.getPolinom2().getText())).get(0)));
                    view.getRest().setText(Polinom_Service.reverseparsing(Polinom_Service.division(Polinom_Service.parsing(view.getPolinom1().getText()),Polinom_Service.parsing(view.getPolinom2().getText())).get(1)));
                }else if (view.getSelect().getSelectedIndex() == 4) {
                view.getRest().setVisible(false);
                view.getRestul().setVisible(false);
                view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.integration(Polinom_Service.parsing(view.getPolinom1().getText()))));
            } else if (view.getSelect().getSelectedIndex() == 5) {
                view.getRest().setVisible(false);
                view.getRestul().setVisible(false);
                view.getRez().setText(Polinom_Service.reverseparsing(Polinom_Service.derivation(Polinom_Service.parsing(view.getPolinom2().getText()))));
            }
        }
    }
}
