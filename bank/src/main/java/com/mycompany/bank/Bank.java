package com.mycompany.bank;

public class Bank {

    private Queue Dw = new Queue(20);
    private Queue aO = new Queue(20);
    private Queue cL = new Queue(20);

    private String counter1 = "-";
    private String counter2 = "-";
    private String counter3 = "-";
    private String counter4 = "-";
    private String counter5 = "-";

    public void depositsAndwithdrawalsEnqueue() {
        if (Dw.getCountqueue() > 20) {
            System.out.println("Queue is full!");
        } else {
            int currentQueueNumber = Dw.getCountqueue();

            Dw.enqueue(currentQueueNumber);
            System.out.println("Adding to queue: " + currentQueueNumber);

            checkAndAssignCounters();
        }
    }

    private void checkAndAssignCounters() {
        if (counter1.equals("-") && !Dw.isEmpty()) {
            counter1 = "WD" + Dw.dequeue();
        }
        if (counter2.equals("-") && !Dw.isEmpty()) {
            counter2 = "WD" + Dw.dequeue();
        }
        if (counter3.equals("-") && !Dw.isEmpty()) {
            counter3 = "WD" + Dw.dequeue();
        }
        if (counter4.equals("-") && !aO.isEmpty()) {
            counter4 = "AO" + aO.dequeue();
        }
        if (counter5.equals("-") && !cL.isEmpty()) {
            counter5 = "CL" + cL.dequeue();
        }
    }

    public String callQueue(int counterNumber) {
        String newTicket = "-";

        if (!Dw.isEmpty()) {
            newTicket = "WD" + Dw.dequeue();
        }

        if (counterNumber == 1) {
            counter1 = newTicket;
        } else if (counterNumber == 2) {
            counter2 = newTicket;
        } else if (counterNumber == 3) {
            counter3 = newTicket;
        }

        return newTicket;
    }

    public String getCounter1Ticket() {
        return counter1;
    }

    public String getCounter2Ticket() {
        return counter2;
    }

    public String getCounter3Ticket() {
        return counter3;
    }

    public void accountOpeningEnqueue() {
        if (aO.getCountqueue() > 20) {
            System.out.println("Queue is full!");
        } else {
            int currentQueueNumber = aO.getCountqueue();

            aO.enqueue(currentQueueNumber);
            System.out.println("Adding to queue: " + currentQueueNumber);

            checkAndAssignCounters();
        }
    }

    public String accountOpeningdequeue() {
        String newTicket = "-";

        if (!aO.isEmpty()) {
            newTicket = "AO" + aO.dequeue();
        }

        counter4 = newTicket;

        return newTicket;
    }
    
    
    public String getCounter4Ticket() {
        return counter4;
    }

    public void loansAndcreditEnqueue() {
        if (cL.getCountqueue() > 20) {
            System.out.println("Queue is full!");
        } else {
            int currentQueueNumber = cL.getCountqueue();

            cL.enqueue(currentQueueNumber);
            System.out.println("Adding to queue: " + currentQueueNumber);

            checkAndAssignCounters();
        }
    }

    public String loansAndcreditDequeue() {
        String newTicket = "-";

        if (!cL.isEmpty()) {
            newTicket = "CL" + cL.dequeue();
        }

        counter5 = newTicket;

        return newTicket;
    }

    public String getCounter5Ticket() {
        return counter5;
    }

}
