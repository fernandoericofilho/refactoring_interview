package expense;

import enums.ExpenseType;
import expense.strategy.*;

import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.System.out;

public class ExpenseReport {

    private final List<Expense> expenses;
    private static final int BREAKFAST_LIMIT = 500;
    private static final int DINNER_LIMIT = 6000;
    private static final int LUNCH_LIMIT = 3000;
    private static final int CAR_RENTAL_LIMIT = 10000;
    private static final String MEAL_OVER_EXPENSE_MARKER = "X";

    private final ExpenseLimitStrategy breakfastLimitStrategy;
    private final ExpenseLimitStrategy dinnerLimitStrategy;
    private final ExpenseLimitStrategy lunchLimitStrategy;
    private final ExpenseLimitStrategy carRentalLimitStrategy;

    public ExpenseReport(List<Expense> expenses) {
        this.expenses = expenses;
        this.breakfastLimitStrategy = new BreakfastLimitStrategy();
        this.dinnerLimitStrategy = new DinnerLimitStrategy();
        this.lunchLimitStrategy = new LunchLimitStrategy();
        this.carRentalLimitStrategy = new CarRentalLimitStrategy();
    }

    public void printReport() {
        printHeader();
        printExpenses();
        printFooter();
    }

    private void printHeader() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        out.println("Expense Report - " + dateFormat.format(System.currentTimeMillis()));
        out.println("---------------------------------------");
        out.printf("%-12s %-12s\n", "Type", "Amount");
        out.println("---------------------------------------");
    }

    private void printExpenses() {
        for (Expense expense : expenses) {
            String expenseMarker = isOverExpenseLimit(expense) ? MEAL_OVER_EXPENSE_MARKER : "";
            out.printf("%-12s $%-12d %s\n", expense.getType(), expense.getAmount(), expenseMarker);
        }
    }

    public boolean isOverExpenseLimit(Expense expense) {
        switch (expense.getType()) {
            case BREAKFAST:
                return breakfastLimitStrategy.isOverExpenseLimit(expense) && expense.getAmount() > BREAKFAST_LIMIT;
            case DINNER:
                return dinnerLimitStrategy.isOverExpenseLimit(expense) && expense.getAmount() > DINNER_LIMIT;
            case LUNCH:
                return lunchLimitStrategy.isOverExpenseLimit(expense) && expense.getAmount() > LUNCH_LIMIT;
            case CAR_RENTAL:
                return carRentalLimitStrategy.isOverExpenseLimit(expense) && expense.getAmount() > CAR_RENTAL_LIMIT;
            default:
                return false;
        }
    }

    private void printFooter() {
        out.println("---------------------------------------");
        out.println("Meal expenses: $" + calculateMealExpenses());
        out.println("Total expenses: $" + calculateTotalExpenses());
    }

    public int calculateMealExpenses() {
        int mealExpenses = 0;
        for (Expense expense : expenses) {
            if (isMealExpense(expense.getType())) {
                mealExpenses += expense.getAmount();
            }
        }
        return mealExpenses;
    }

    public int calculateTotalExpenses() {
        int totalExpenses = 0;
        for (Expense expense : expenses) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }

    public boolean isMealExpense(ExpenseType type) {
        return type == ExpenseType.BREAKFAST || type == ExpenseType.DINNER || type == ExpenseType.LUNCH;
    }
}
