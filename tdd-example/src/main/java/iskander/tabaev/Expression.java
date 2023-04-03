package iskander.tabaev;

public interface Expression {
    Money reduce(Bank bank, String to);
    Expression plus(Money added);
    Expression times(int i);
}
