package io.knifer.freebox.model.s2c;

import java.util.Objects;

/**
 * 获取影视收藏状态
 * @author knifer
 */
public class GetMovieCollectedStatusDTO {

    /**
     * 数据条数
     */
    private String sourceKey;

    /**
     * 影片ID
     */
    private String vodId;

    public GetMovieCollectedStatusDTO() {
    }

    public GetMovieCollectedStatusDTO(String sourceKey, String vodId) {
        this.sourceKey = sourceKey;
        this.vodId = vodId;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getVodId() {
        return vodId;
    }

    public void setVodId(String vodId) {
        this.vodId = vodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetMovieCollectedStatusDTO that = (GetMovieCollectedStatusDTO) o;
        return Objects.equals(sourceKey, that.sourceKey) && Objects.equals(vodId, that.vodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceKey, vodId);
    }

    @Override
    public String toString() {
        return "GetMovieCollectedStatusDTO{" +
                "sourceKey='" + sourceKey + '\'' +
                ", vodId='" + vodId + '\'' +
                '}';
    }
}
