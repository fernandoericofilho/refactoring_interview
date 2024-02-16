package report;

import enums.ExpenseType;
import expense.Expense;
import expense.ExpenseReport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExpenseReportTest {

    @Test
    public void testCalculateMealExpenses() {
        List<Expense> expenses = new ArrayList<Expense>();
        expenses.add(new Expense(ExpenseType.BREAKFAST).updateAmount(500));
        expenses.add(new Expense(ExpenseType.DINNER).updateAmount(6000));
        expenses.add(new Expense(ExpenseType.LUNCH).updateAmount(3000));

        ExpenseReport report = new ExpenseReport(expenses);

        assertEquals(9500, report.calculateMealExpenses());
    }

    @Test
    public void testCalculateTotalExpenses() {
        List<Expense> expenses = new ArrayList<Expense>();
        expenses.add(new Expense(ExpenseType.BREAKFAST).updateAmount(500));
        expenses.add(new Expense(ExpenseType.DINNER).updateAmount(6000));
        expenses.add(new Expense(ExpenseType.LUNCH).updateAmount(3000));

        ExpenseReport report = new ExpenseReport(expenses);

        assertEquals(9500, report.calculateTotalExpenses());
    }

    @Test
    public void testIsOverExpenseLimit() {
        ExpenseReport report = new ExpenseReport(new ArrayList<Expense>());

        assertFalse(report.isOverExpenseLimit(new Expense(ExpenseType.BREAKFAST).updateAmount(500)));
        assertTrue(report.isOverExpenseLimit(new Expense(ExpenseType.BREAKFAST).updateAmount(501)));
    }
}

