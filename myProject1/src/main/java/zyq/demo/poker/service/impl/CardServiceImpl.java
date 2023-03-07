package zyq.demo.poker.service.impl;

import zyq.demo.poker.service.CardService;
import zyq.demo.poker.util.CardUtil;

import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-07-22 16:04
 * Description
 */
public class CardServiceImpl implements CardService {

    /**
     * 判断出的牌是否符合规则
     *
     * @param cardList 传入的出的牌
     * @return
     */
    @Override
    public Boolean checkCard(List<String> cardList) {
        return CardUtil.checkCard(cardList);
    }

    /**
     * 判断后方出牌是否大于前方
     *
     * @param preCardList   前方已出手牌
     * @param afterCardList 后方将要出的牌
     * @return
     */
    @Override
    public Boolean compareCard(List<String> preCardList, List<String> afterCardList) {
        return CardUtil.compareCard(preCardList, afterCardList);
    }


}
