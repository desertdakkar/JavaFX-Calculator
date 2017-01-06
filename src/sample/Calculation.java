package sample;

public class Calculation {

    public double calc(double a, double b, String operator) {
        switch (operator) {
            case "+" :
                return a + b;
            case "-" :
                return a - b;
            case "*" :
                return a * b;
            case "/" :
                return a / b;
        }
        return 0;
    }

}
