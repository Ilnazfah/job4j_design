package ru.job4j.generic;

public class Test {
    public static void main(String[] args) {
        UserStore userStore = new UserStore();
        userStore.add(new User("1", "User_1"));
        userStore.add(new User("2", "User_2"));
        userStore.add(new User("3", "User_3"));

        System.out.println(userStore.findById("1").getName());
        System.out.println(userStore.findById("2").getName());
        System.out.println(userStore.findById("3").getName());
//
//        userStore.delete("2");
//        System.out.println(userStore.findById("1").getName());
//        System.out.println(userStore.findById("2").getName());
//        System.out.println(userStore.findById("3").getName());
    }
}
