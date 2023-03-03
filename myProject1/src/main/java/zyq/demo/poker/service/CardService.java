package zyq.demo.poker.service;

import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-07-22 16:02
 * Description
 */
public interface CardService {

    /**
     * 判断出的牌是否符合规则
     *
     * @param cardList 传入的出的牌
     * @return
     */
    Boolean checkCard(List<String> cardList);


    /**
     * 判断后方出牌是否大于前方
     *
     * @param preCardList   前方已出手牌
     * @param afterCardList 后方将要出的牌
     * @return
     */
    Boolean compareCard(List<String> preCardList, List<String> afterCardList);


}
