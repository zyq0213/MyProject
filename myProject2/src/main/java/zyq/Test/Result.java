package zyq.Test;

import lombok.Data;

import java.util.List;

/**
 * @author yanqing.zou
 * @date 2023-03-20 17:36
 * Description
 */
@Data
public class Result implements Comparable<Result>{

    private Integer index;

    private Integer totalPoint;

    private List<String> result;

    @Override
    public int compareTo(Result o) {
        return o.getIndex() - index;
    }
}
