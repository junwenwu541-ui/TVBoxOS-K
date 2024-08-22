package io.knifer.freebox.model.c2s;

import java.util.Objects;

/**
 * 注册信息
 *
 * @author Knifer
 */
public class RegisterInfo {

    private String name;

    public RegisterInfo() {
    }

    public RegisterInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterInfo that = (RegisterInfo) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "name='" + name + '\'' +
                '}';
    }

    public static RegisterInfo of(String name) {
        return new RegisterInfo(name);
    }
}
