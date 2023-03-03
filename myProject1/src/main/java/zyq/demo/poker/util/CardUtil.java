package zyq.demo.poker.util;

import zyq.demo.poker.constant.CardEnum;
import zyq.demo.poker.constant.RuleEnum;
import org.springframework.util.CollectionUtils;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-07-22 15:46
 * Description
 */
public class CardUtil {

    public static Boolean checkCard(List<String> cardList1){
        if(CollectionUtils.isEmpty(cardList1)){
            return false;
        }
        List<Character> cardList = CardEnum.getCardRankList(cardList1);
        switch (cardList.size()){
            case 1:
                 return method1(cardList);
            case 2:
                return method2(cardList);
            case 3:
                return  method3(cardList);
            case 4:
                return method4(cardList);
            case 5:
                return method5(cardList);
            case 6:
                return method6(cardList);
            case 7:
                return method7(cardList);
            case 8:
                return method8(cardList);
            case 9:
                return method9(cardList);
            case 10:
                return method10(cardList);
            case 11:
                return method11(cardList);
            case 12:
                return method12(cardList);
            case 13:
                return method13(cardList);
            case 14:
                return method14(cardList);
            case 15:
                return method15(cardList);
            case 16:
                return method16(cardList);
            case 17:
                return method17(cardList);
            case 18:
                return method18(cardList);
            case 19:
                return method19(cardList);
            case 20:
                return method20(cardList);
            default:
                return false;
        }
    }

    public static Boolean compareCard(List<String> preCardList, List<String> afterCardList){
        return false;
    }

    private static Boolean method20(List<Character> cardList) {
        return true;
    }

    private static Boolean method19(List<Character> cardList) {
        return true;
    }

    private static Boolean method18(List<Character> cardList) {
        return true;
    }

    private static Boolean method17(List<Character> cardList) {
        return true;
    }

    private static Boolean method16(List<Character> cardList) {
        return true;
    }

    private static Boolean method15(List<Character> cardList) {
        return true;
    }

    private static Boolean method14(List<Character> cardList) {
        return true;
    }

    private static Boolean method13(List<Character> cardList) {
        return true;
    }

    private static Boolean method12(List<Character> cardList) {
        return true;
    }

    private static Boolean method11(List<Character> cardList) {
        return true;
    }

    private static Boolean method10(List<Character> cardList) {
        return true;
    }

    private static Boolean method9(List<Character> cardList) {
        return true;
    }

    private static Boolean method8(List<Character> cardList) {
        return true;
    }

    private static Boolean method7(List<Character> cardList) {
        return true;
    }

    private static Boolean method6(List<Character> cardList) {
        return true;
    }

    private static Boolean method5(List<Character> cardList) {
        return true;
    }

    private static Boolean method4(List<Character> cardList) {
        return true;
    }

    private static Boolean method3(List<Character> cardList) {
        return true;
    }

    private static Boolean method2(List<Character> cardList) {
        return true;
    }

    private static Boolean method1(List<Character> cardList) {
        //单牌
        String format = RuleEnum.SINGLE.getFormat();

        return true;
    }




}
