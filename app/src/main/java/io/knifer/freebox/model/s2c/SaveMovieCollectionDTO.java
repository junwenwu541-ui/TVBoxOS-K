package io.knifer.freebox.model.s2c;

import com.github.tvbox.osc.bean.VodInfo;

import java.util.Objects;

/**
 * 收藏影片
 * @author knifer
 */
public class SaveMovieCollectionDTO {

    /**
     * 影片信息
     */
    private VodInfo vodInfo;

    public SaveMovieCollectionDTO() {
    }

    public SaveMovieCollectionDTO(VodInfo vodInfo) {
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
        SaveMovieCollectionDTO that = (SaveMovieCollectionDTO) o;
        return Objects.equals(vodInfo, that.vodInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vodInfo);
    }

    @Override
    public String toString() {
        return "SaveMovieCollectionDTO{" +
                "vodInfo=" + vodInfo +
                '}';
    }
}
