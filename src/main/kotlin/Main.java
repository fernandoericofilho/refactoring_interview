import enums.ExpenseType;
import expense.Expense;
import report.ExpenseReportBuilder;

public class Main {
    public static void main(String[] args) {
        Expense dinner = new Expense(ExpenseType.BREAKFAST).updateAmount(500);
        Expense breakfast = new Expense(ExpenseType.DINNER).updateAmount(6001);
        Expense carRental = new Expense(ExpenseType.CAR_RENTAL).updateAmount(10000);
        Expense lunch = new Expense(ExpenseType.LUNCH).updateAmount(3001);

        ExpenseReportBuilder builder = new ExpenseReportBuilder()
                .addExpense(breakfast)
                .addExpense(dinner)
                .addExpense(carRental)
                .addExpense(lunch);

        builder.build().printReport();
    }
}

