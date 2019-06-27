package step3.iksoo.lotto2rd;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    private static int orderPrice;

    public static void main(String[] args) {
        Lottoes lottoes = new Lottoes(lottoOrder());
        OutputView.printOrderCheck(lottoes.getLottoes().size());
        OutputView.printLottos(lottoes.getLottoes());

        List<Integer> winNumbers = getKnowWinnerNumbers();
        int bonusBall = getKnowBonusBall(winNumbers);

        MatchResult matchResult = new MatchResult(lottoes.checkLotteryWin(winNumbers, bonusBall));
        OutputView.printResult(matchResult.getMatchResult());
        OutputView.printRateProfit(matchResult.calculateRateProfit(orderPrice));
    }

    private static int lottoOrder() {
        OutputView.printAskOrder();
        orderPrice = InputView.inputNumber();
        return orderPrice;
    }

    private static List<Integer> getKnowWinnerNumbers() {
        OutputView.printAskWinnerNumbers();
        String[] numbers = InputView.inputText().replace(" ", "").split(",");

        List<Integer> winnerNumbers = new ArrayList<>();
        for (String number : numbers) {
            winnerNumbers.add(Integer.parseInt(number));
        }
        return winnerNumbers;
    }

    private static int getKnowBonusBall(List<Integer> winnerNumbers) {
        OutputView.printAskBonusBall();
        int bonusBall = InputView.inputNumber();

        winnerNumbers.stream()
                .filter(number -> number == bonusBall)
                .peek(dos -> {
                    throw new IllegalArgumentException("보너스볼 번호가 당첨 번호의 숫자와 동일합니다.");
                })
                .findAny();

        return bonusBall;
    }
}
