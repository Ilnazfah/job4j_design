package ru.job4j.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public static Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, User> pMap = new HashMap<>();
        for (User user : previous) {
            pMap.put(user.id, user);
        }
        for (User user : current) {
            if (!pMap.containsKey(user.id)) {
                added++;
            } else if (!pMap.get(user.id).equals(user)) {
                changed++;
            }
        }
        return new Info(added, changed, previous.size() - (current.size() - added));
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}