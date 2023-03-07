package zyq.demo.domain;


/**
 * @author yanqing.zou
 * @date 2022-05-26 10:56
 * Description
 */
public class TestDTO {
    private Integer id ;
    private String desc;

    public TestDTO(){

    }
    public TestDTO(Integer id,String desc){
        this.id = id;
        this.desc = desc;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
