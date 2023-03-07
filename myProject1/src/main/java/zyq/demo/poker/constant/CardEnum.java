package zyq.demo.poker.constant;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanqing.zou
 * @date 2022-07-22 15:15
 * Description
 */
@Getter
public enum CardEnum {
    CARD_3('A',"3"),
    CARD_4('B',"4"),
    CARD_5('C',"5"),
    CARD_6('D',"6"),
    CARD_7('E',"7"),
    CARD_8('F',"8"),
    CARD_9('G',"9"),
    CARD_10('H',"10"),
    CARD_J('I',"J"),
    CARD_Q('J',"Q"),
    CARD_K('K',"K"),
    CARD_A('L',"A"),
    CARD_2('X',"2"),
    CARD_BLACK_JOKER('Y',"black joker"),
    CARD_RED_JOKER('Z',"red joker"),

    ;
    Character rank;
    String desc;
    CardEnum(Character rank, String desc){
       this.rank = rank;
       this.desc = desc;
    }

    public static List<Character> getCardRankList(List<String> cardDescList){
        Map<String,Character> cardMap = new HashMap<>();
        for (CardEnum value : CardEnum.values()) {
            cardMap.put(value.getDesc(), value.getRank());
        }
        List<Character> collect = cardDescList.stream().map(v -> {
            Character character = null;
            if(cardMap.containsKey(v)){
                 character = cardMap.get(v);
            }
            
            return character;
        }).collect(Collectors.toList());

        return collect;
    }

}
