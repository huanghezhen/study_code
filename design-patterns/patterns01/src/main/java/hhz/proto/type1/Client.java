package hhz.proto.type1;

public class Client {
    public static void main(String[] args) throws Exception {
        Sheep sheep = Sheep.builder()
                .age(1)
                .color("red")
                .name("hh")
                .build();

        Sheep sheep1 = Sheep.builder()
                .name(sheep.getName())
                .color(sheep.getColor())
                .age(sheep.getAge())
                .build();

        Sheep sheep2 = Sheep.builder()
                .name(sheep.getName())
                .color(sheep.getColor())
                .age(sheep.getAge())
                .build();


        Sheep sheep3 = Sheep.builder()
                .name(sheep.getName())
                .color(sheep.getColor())
                .age(sheep.getAge())
                .build();

        Sheep sheep4 = Sheep.builder()
                .name(sheep.getName())
                .color(sheep.getColor())
                .age(sheep.getAge())
                .build();

        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
    }
}
