package io.knifer.freebox.model.s2c;

import com.github.tvbox.osc.bean.VodInfo;

import java.util.Objects;

/**
 * 取消收藏
 *
 * @author knifer
 */
public class DeleteMovieCollectionDTO {

    /**
     * 影片信息
     */
    private VodInfo vodInfo;

    public DeleteMovieCollectionDTO() {
    }

    public DeleteMovieCollectionDTO(VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }

    public static DeleteMovieCollectionDTO of(VodInfo vodInfo) {
        DeleteMovieCollectionDTO result = new DeleteMovieCollectionDTO();

        result.setVodInfo(vodInfo);

        return result;
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
        DeleteMovieCollectionDTO that = (DeleteMovieCollectionDTO) o;
        return Objects.equals(vodInfo, that.vodInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vodInfo);
    }

    @Override
    public String toString() {
        return "DeleteMovieCollectionDTO{" +
                "vodInfo=" + vodInfo +
                '}';
    }
}
