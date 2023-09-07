import java.util.HashMap;

public class ATM {
    private HashMap<String, Double> accounts = new HashMap<String, Double>();

    public ATM() {
        accounts = new HashMap<String, Double>();
    }

    public void openAccount(String userId, double amount) throws Exception {
        if (accounts.containsKey(userId)) {
            throw new Exception("Error: User already exists.");
        }
        accounts.put(userId, amount);
    }

    public void closeAccount(String userId) throws Exception {
        if (!accounts.containsKey(userId)) {
            throw new Exception("Error: Not a valid account.");
        }
        if (accounts.get(userId) != 0) {
            throw new Exception("Error: Withdraw money before closing account.");
        }
        accounts.remove(userId);
    }

    public double checkBalance(String userId) throws Exception {
        if (!accounts.containsKey(userId)) {
            throw new Exception("Error: User does not exist.");
        }
        return accounts.get(userId);
    }

    public double depositMoney(String userId, double amount) throws Exception {
        if (!accounts.containsKey(userId)) {
            throw new Exception("You're broke AF.");
        }
        accounts.put(userId, accounts.get(userId) + amount);
        return amount;
    }

    public double withdrawMoney(String userId, double amount) throws Exception {
        if (!accounts.containsKey(userId) || accounts.get(userId) < amount) {
            throw new Exception("You're broke AF.");
        }
        accounts.put(userId, accounts.get(userId) - amount);
        return amount;
    }

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }

    public void audit() {
        return;
    }

}