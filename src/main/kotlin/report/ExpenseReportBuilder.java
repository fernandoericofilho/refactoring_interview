package report;

import expense.Expense;
import expense.ExpenseReport;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReportBuilder {
    private final List<Expense> expenses = new ArrayList<>();

    public ExpenseReportBuilder() {
    }

    public ExpenseReportBuilder addExpense(Expense expense) {
        expenses.add(expense);
        return this;
    }

    public ExpenseReport build() {
        return new ExpenseReport(expenses);
    }
}
