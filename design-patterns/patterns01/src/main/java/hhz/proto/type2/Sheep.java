package hhz.proto.type2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
