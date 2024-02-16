package expense.strategy;

import expense.Expense;

public class CarRentalLimitStrategy implements ExpenseLimitStrategy {
    private static final int CAR_RENTAL_LIMIT = 10000;

    @Override
    public boolean isOverExpenseLimit(Expense expense) {
        return expense.getAmount() > CAR_RENTAL_LIMIT;
    }
}
