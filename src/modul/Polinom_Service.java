package modul;

import java.util.*;

public class Polinom_Service {

    public static Polinom parsing(String str) {
        Polinom result = new Polinom();
        TreeMap<Integer, Double> pol = new TreeMap<>();
        int aux;
        double aux1;
        String[] exp_coef = str.replace("^", "").split("((\\+)|(?=\\-)|x)");
        for (int i = 0; i < exp_coef.length - 1; i += 2) {
            aux = Integer.parseInt(exp_coef[i + 1]);
            aux1 = Double.parseDouble(exp_coef[i]);
            pol.put(aux, aux1);
        }
        result.setPoly(pol);
        return result;
    }

    public static String reverseparsing(Polinom map) {
        Polinom aux1 = new Polinom();
        TreeMap<Integer, Double> polinom = new TreeMap<>();
        aux1 = map;
        String str = "";
        Set<Integer> keysSet = aux1.getPoly().keySet();
        Iterator<Integer> it = keysSet.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Double coef = aux1.getPoly().get(key);
            if (key > 1) {
                if (coef >= 0.0) {
                    str = "+" + coef.toString() + "x^" + key.toString() + str;
                } else if (coef < 0.0) {
                    str = coef.toString() + "x^" + key.toString() + str;
                }
            } else if (key == 1) {
                if (coef >= 0.0) {
                    str = "+" + coef.toString() + "x" + str;
                } else {
                    str = coef.toString() + "x" + str;
                }
            } else if (key == 0) {
                if (coef >= 0.0) {
                    str = "+" + coef.toString() + str;
                } else {
                    str = coef.toString() + str;
                }
            }
        }
        str.replace("1.00x", "x");
        return str;
    }

    public static Polinom addition(Polinom polinom1, Polinom polinom2) {
        Polinom sum = new Polinom();
        sum = polinom1;
        for (Map.Entry<Integer, Double> entry : polinom2.getPoly().entrySet()) {
            Double aux = sum.getPoly().getOrDefault(entry.getKey(),0.0);
            sum.getPoly().put(entry.getKey(), entry.getValue() + (aux == 0.0 ? 0 : aux));
        }
        return sum;
    }

    public static Polinom subtraction(Polinom polinom1, Polinom polinom2) {
        Polinom sub = new Polinom();
        sub = polinom1;
        for (Map.Entry<Integer, Double> entry : polinom2.getPoly().entrySet()) {
            Double aux = sub.getPoly().getOrDefault(entry.getKey(),0.0);
            sub.getPoly().put(entry.getKey(), entry.getValue() - (aux == 0.0 ? 0 : aux));
        }
        return sub;
    }

    public static Polinom multiplication(Polinom polinom1, Polinom polinom2) {
        Polinom prod = new Polinom();
        TreeMap<Integer, Double> product = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : polinom1.getPoly().entrySet()) {
            for (Map.Entry<Integer, Double> etry : polinom2.getPoly().entrySet()) {
                product.put(entry.getKey() + etry.getKey(), product.getOrDefault(entry.getKey() + etry.getKey(), 0.0) + entry.getValue() * etry.getValue());
            }
            prod.setPoly(product);
        }
        return prod;
    }

    public static Polinom derivation(Polinom polinom) {
        Polinom deriv = new Polinom();
        TreeMap<Integer, Double> res = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : polinom.getPoly().entrySet()) {
            int exp = entry.getKey();
            double coef = entry.getValue();
            if (exp > 0) {
                res.put(exp - 1, coef * exp);
            }
        }
        deriv.setPoly(res);
        return deriv;
    }

    public static Polinom integration(Polinom polinom) {
        Polinom integ = new Polinom();
        TreeMap<Integer, Double> res = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : polinom.getPoly().entrySet()) {
            int exp = entry.getKey();
            double coef = entry.getValue();
            res.put(exp + 1, coef * (1.0 / (exp + 1)));
        }
        integ.setPoly(res);
        return integ;
    }
    public static List<Polinom> division(Polinom Polinom1, Polinom Polinom2) throws IllegalArgumentException {
        if (Polinom1.maxGrade() < Polinom2.maxGrade()) {
            throw new IllegalArgumentException("The first polinom must have the bigger grade");
        }
        if(Polinom2.getPoly().isEmpty()){
            throw new IllegalArgumentException("Division by 0");
        }
        List<Polinom> rez = new ArrayList<>();
        Polinom quotient = new Polinom();
        Polinom remainder = new Polinom();
        Polinom poly2 = Polinom1;
        int currenst = Polinom1.maxGrade();
        while (currenst >= Polinom2.maxGrade() && currenst !=0) {
            Double poly1 = poly2.getPoly().getOrDefault(currenst, 0.0) / Polinom2.getPoly().get(Polinom2.maxGrade());
            Polinom poly3 = new Polinom();
            poly3.getPoly().put(currenst - Polinom2.maxGrade(), poly1);
            quotient = addition(quotient, poly3);
            remainder = subtraction(poly2, multiplication(poly3, Polinom2));
            poly2 = remainder;
            currenst = poly2.maxGrade();
        }
        rez.add(quotient);
        rez.add(remainder);
        return rez;
    }
}
