package zyq.demo.demo1;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yanqing.zou
 * @date 2022-07-08 14:32
 * Description
 */
public class Test3 {
    public static void main(String []args){
        String familyIds = "1,2,,3,4 ";

        familyIds.trim();
        String[] familyIdArr = familyIds.split(",");
        // 转换为set
        Set<String> familyIdSet = new HashSet<>(Arrays.asList(familyIdArr));
        System.out.println(JSON.toJSONString(familyIdSet,true));
        System.out.println("********************");
        Set<String> familyIdSet1 = Arrays.stream(familyIds.split(",")).filter(StringUtils::isNotBlank).map(String::trim).collect(Collectors.toSet());
        System.out.println(JSON.toJSONString(familyIdSet1,true));

    }
}
