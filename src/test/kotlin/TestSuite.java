import expense.ExpenseTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import report.ExpenseReportTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExpenseTest.class,
        ExpenseReportTest.class
})
public class TestSuite {
}