## Refatoração da Classe ExpenseReport
A classe Main atualmente cria uma lista de despesas, gera um relatório de gastos e o imprime no console. No entanto, o código não segue boas práticas de programação e pode ser melhorado para torná-lo mais legível, modular e escalável.

## Refatoração Proposta
- Divisão em Métodos Menores: Dividir a lógica complexa em métodos menores e mais específicos para facilitar a compreensão e manutenção do código.

- Uso de Constantes: Substituir os valores literais por constantes significativas para melhorar a legibilidade do código.

- Utilização de Enums: Refatorar a classe Expense para utilizar um enum ExpenseType em vez de campos String ou int para representar os tipos de despesa.

- A classe ExpenseReport foi reestruturada para melhorar a legibilidade e manutenibilidade do código. Foram adicionados métodos privados para dividir a lógica em partes menores e mais específicas. A formatação da saída do relatório foi aprimorada para incluir informações mais detalhadas e legíveis.
## Novo Requisito: Adicionar Despesa de Almoço
- Como usuário do relatório de gastos, gostaria de poder adicionar um gasto de alimentação chamado Lunch com um limite de 3000.

## Execução do Projeto

- Atualize as bibliotecas necessárias

``` mvn clean install ```


## Código a refatorar

```
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ExpenseReport report = new ExpenseReport();
        ArrayList<Expense> expenses = new ArrayList<>();
        Expense breakfast = new Expense();
        breakfast.amount = 500;
        breakfast.type = ExpenseType.BREAKFAST;
        expenses.add(breakfast);
        Expense dinner = new Expense();
        dinner.amount = 6000;
        dinner.type = ExpenseType.DINNER;
        expenses.add(dinner);
        Expense carRental = new Expense();
        carRental.amount = 10000;
        carRental.type = ExpenseType.CAR_RENTAL;
        expenses.add(carRental);
        report.printReport(expenses);
    }
}
enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}
class Expense {
    ExpenseType type;
    int amount;
}
class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        int total = 0;
        int mealExpenses = 0;
        System.out.println("Expenses " + new Date());
        for (Expense expense : expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount;
            }
            String expenseName = "";
            switch (expense.type) {
                case DINNER:
                    expenseName = "Dinner";
                    break;
                case BREAKFAST:
                    expenseName = "Breakfast";
                    break;
                case CAR_RENTAL:
                    expenseName = "Car Rental";
                    break;
            }
            String mealOverExpensesMarker = expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 ? "X" : " ";
            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);
            total += expense.amount;
        }
        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }
}


```
