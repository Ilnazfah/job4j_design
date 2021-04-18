package ru.job4j.exam;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.exam.Analize.User;
import static ru.job4j.exam.Analize.Info;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnalizeTest {

    @Test
    public void whenAddedDeletedChangedThenTest() {
        List<User> prevList = new ArrayList<>();
        prevList.add(new User(1, "User_1"));
        prevList.add(new User(2, "User_2"));
        prevList.add(new User(3, "User_3"));

        List<User> newList = new ArrayList<>();
        newList.add(new User(1, "User_1"));
        newList.add(new User(2, "Change_User_2"));
        newList.add(new User(3, "Change_User_3"));
        newList.add(new User(5, "User_5"));

        Info info = Analize.diff(prevList, newList);

        assertThat(info.getAdded(), is(1));
        assertThat(info.getChanged(), is(2));
        assertThat(info.getDeleted(), is(0));
    }
}