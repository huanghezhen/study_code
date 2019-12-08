package hhz.proto.type1;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sheep {
    private String name;
    private int age;
    private String color;
}
