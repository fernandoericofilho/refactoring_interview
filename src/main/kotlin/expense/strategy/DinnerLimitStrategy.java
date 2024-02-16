package expense.strategy;

import expense.Expense;

public class DinnerLimitStrategy implements ExpenseLimitStrategy {
    private static final int DINNER_LIMIT = 6000;

    @Override
    public boolean isOverExpenseLimit(Expense expense) {
        return expense.getAmount() > DINNER_LIMIT;
    }
}