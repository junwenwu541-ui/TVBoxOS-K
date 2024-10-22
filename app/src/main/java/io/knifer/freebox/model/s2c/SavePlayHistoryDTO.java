package io.knifer.freebox.model.s2c;

import com.github.tvbox.osc.bean.VodInfo;

import java.util.Objects;

/**
 * 保存观看历史
 * @author knifer
 */
public class SavePlayHistoryDTO {

    /**
     * 影片信息
     */
    private VodInfo vodInfo;

    public SavePlayHistoryDTO() {
    }

    public SavePlayHistoryDTO(VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }

    public VodInfo getVodInfo() {
        return vodInfo;
    }

    public void setVodInfo(VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavePlayHistoryDTO that = (SavePlayHistoryDTO) o;
        return Objects.equals(vodInfo, that.vodInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vodInfo);
    }

    @Override
    public String toString() {
        return "SavePlayHistoryDTO{" +
                "vodInfo=" + vodInfo +
                '}';
    }
}
