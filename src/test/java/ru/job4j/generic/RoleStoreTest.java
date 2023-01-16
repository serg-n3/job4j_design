package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Engineer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.add(new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Engineer");
    }

    @Test
    void whenReplaceThenRoleNameIsDriver() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.replace("1", new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Driver");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.replace("10", new Role("10", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Engineer");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsEngineer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Engineer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        boolean rsl = store.replace("1", new Role("1", "Driver"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        boolean rsl = store.replace("10", new Role("10", "Driver"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Engineer"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }

}