package expense.strategy;

import expense.Expense;

public class BreakfastLimitStrategy implements ExpenseLimitStrategy {
    private static final int BREAKFAST_LIMIT = 500;

    @Override
    public boolean isOverExpenseLimit(Expense expense) {
        return expense.getAmount() > BREAKFAST_LIMIT;
    }
}
