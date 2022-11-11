package com.practice.etc;

public class BankAccountProblem {
    public static void main(String[] args) throws InterruptedException {
        extracted();
        extracted();
        extracted();
    }

    private static void extracted() throws InterruptedException {
        BankAccount account = new BankAccount();
        Parent parent = new Parent(account);
        Child child = new Child(account);

        parent.start();
        child.start();
        parent.join();
        child.join();

        System.out.println("Final balance: " + account.getBalance());
    }

    static class BankAccount {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            int temp = balance - amount;
            System.out.print("-");
            balance = temp;

        }

        public void deposit(int amount) {
            int temp = balance + amount;
            System.out.print("+");
            balance = temp;
        }
    }

    static class Parent extends Thread {
        protected BankAccount account;

        public Parent(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                account.deposit(10);
            }
        }
    }

    static class Child extends Parent {
        public Child(BankAccount account) {
            super(account);
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                account.withdraw(10);
            }
        }
    }
}
