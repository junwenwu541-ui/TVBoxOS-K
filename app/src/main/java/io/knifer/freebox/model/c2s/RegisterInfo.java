package io.knifer.freebox.model.c2s;

import java.util.Objects;

/**
 * 注册信息
 *
 * @author Knifer
 */
public class RegisterInfo {

    private String clientId;

    private String clientName;

    public RegisterInfo() {
    }

    public RegisterInfo(String clientId, String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterInfo that = (RegisterInfo) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(clientName, that.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName);
    }

    public static RegisterInfo of(String clientId, String clientName) {
        return new RegisterInfo(clientId, clientName);
    }
}
