package expense;

import enums.ExpenseType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpenseTest {

    @Test
    public void testUpdateAmount() {
        Expense expense = new Expense(ExpenseType.BREAKFAST);
        expense.updateAmount(500);

        assertEquals(500, expense.getAmount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAmountWithNegativeValue() {
        Expense expense = new Expense(ExpenseType.BREAKFAST);
        expense.updateAmount(-100);
    }
}
