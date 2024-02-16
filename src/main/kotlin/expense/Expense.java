package expense;

import enums.ExpenseType;

public class Expense {
    private final ExpenseType type;
    private int amount;

    public Expense(ExpenseType type) {
        this.type = type;
        this.amount = 0;
    }

    public ExpenseType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Expense updateAmount(int newAmount) {
        if (newAmount < 0) {
            throw new IllegalArgumentException("Value cannot be less than zero");
        }
        this.amount = newAmount;
        return this;
    }
}
