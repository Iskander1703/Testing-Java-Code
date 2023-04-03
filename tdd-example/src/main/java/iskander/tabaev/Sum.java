package iskander.tabaev;

public class Sum implements Expression{
    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to){
        int amount = this.augmend.reduce(bank, to).amount+this.addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Money added) {
       return new Sum(this,addmend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
