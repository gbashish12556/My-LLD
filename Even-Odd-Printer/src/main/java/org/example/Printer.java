package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Printer extends Thread{


    private Integer currentValue;

    private Integer steps;

    private Integer maxValue;

    private PossibleState currentState;
    private PossibleState nextState;

    private PrinterState sharedState;


    @Override
    public void run() {

        synchronized (sharedState) {

            while (currentValue < maxValue) {

                if (currentState == sharedState.getState()) {

                    System.out.print(currentValue + " ");
                    currentValue += steps;

                    sharedState.setState(nextState);

                } else {

                    try {
                        sharedState.notifyAll();
                        sharedState.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
    }
}
