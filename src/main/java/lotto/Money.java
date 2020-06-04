package lotto;

public class Money {
    private static final int LOTTERY_MONEY = 1_000;
    private final int money;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        if (money < LOTTERY_MONEY)
            throw new IllegalArgumentException();
        this.money = money;
    }

    public int lotteryCount() {
        return money / LOTTERY_MONEY;
    }

    public static Money buyingMoney(int countOfLotto) {
        return new Money(countOfLotto * LOTTERY_MONEY);
    }

    public double profitRate(Money prize) {
        return prize.money / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }
}
