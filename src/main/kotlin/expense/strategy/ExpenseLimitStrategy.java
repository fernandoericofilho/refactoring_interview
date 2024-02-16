package expense.strategy;

import expense.Expense;

public interface ExpenseLimitStrategy {
    boolean isOverExpenseLimit(Expense expense);
}
