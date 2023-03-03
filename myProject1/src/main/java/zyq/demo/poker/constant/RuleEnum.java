package zyq.demo.poker.constant;

import lombok.Getter;

/**
 * @author yanqing.zou
 * @date 2022-07-22 14:52
 * Description
 */
@Getter
public enum RuleEnum {
    SINGLE(1, "[A-Z]+","单"),
    PAIR(2,"AA","双"),
    THREE(3,"AAA","三"),
    THREE_WITH_ONE(4,"AAAB","三带一"),
    THREE_WITH_PAIR(5,"AAABB","三带二"),
    SINGLE_SEQUENCE(6,"ABCDE","顺子"),
    SEQUENCE_OF_PAIR(7,"AABBCC","连对"),
    AIRPLANE(8,"AAABBB","飞机"),
    AIRPLANE_WITH_SINGLE(9,"AAABBBCD","飞机带单"),
    AIRPLANE_WITH_PAIR(10,"AAABBBCCDD","飞机带双"),
    FOUR_WIHT_SINGLE(11,"AAAABC","四带两单"),
    FOUR_WITH_PAIR(12,"AAAABBCC","四带两双"),
    BOMB(99,"AAAA","炸弹"),
    ROCKET(100,"AA","火箭");
    ;
    int type;
    String format;
    String desc;

     RuleEnum(int type, String format ,String desc){
        this.type = type;
        this.format = format;
        this.desc = desc;
    }
}
