package expense.strategy;

import expense.Expense;

public class LunchLimitStrategy implements ExpenseLimitStrategy {
    private static final int LUNCH_LIMIT = 3000;

    @Override
    public boolean isOverExpenseLimit(Expense expense) {
        return expense.getAmount() > LUNCH_LIMIT;
    }
}