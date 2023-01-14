package org.example;

public class Main {
    public static void main(String[] args) {

        PrinterState state = new PrinterState(PossibleState.ODD);

        Printer odd = new Printer(1,2,100, PossibleState.ODD, PossibleState.EVEN, state);
        Printer even = new Printer(2,2,100, PossibleState.EVEN, PossibleState.ODD, state);

        odd.start();
        even.start();

    }
}