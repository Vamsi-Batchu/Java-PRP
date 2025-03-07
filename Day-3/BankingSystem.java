import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", New Balance: " + balance);
    }
    
    // Synchronized method to withdraw money with exception handling
    public synchronized void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", New Balance: " + balance);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

// Main Class for Banking System
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance
        ExecutorService executor = Executors.newFixedThreadPool(3); // Thread pool
        
        // Runnable Transactions
        Runnable depositTask = () -> account.deposit(500);
        Runnable withdrawTask = () -> account.withdraw(1200);
        Runnable withdrawTask2 = () -> account.withdraw(700);
        
        // Execute Transactions Concurrently
        executor.execute(depositTask);
        executor.execute(withdrawTask);
        executor.execute(withdrawTask2);
        
        // Shutdown Executor
        executor.shutdown();
    }
}
