package io.knifer.freebox.model.s2c;

import java.util.Objects;

/**
 * 获取一个观看历史
 * @author knifer
 */
public class GetOnePlayHistoryDTO {

    /**
     * 数据条数
     */
    private String sourceKey;

    /**
     * 影片ID
     */
    private String vodId;

    public GetOnePlayHistoryDTO() {
    }

    public GetOnePlayHistoryDTO(String sourceKey, String vodId) {
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
        GetOnePlayHistoryDTO that = (GetOnePlayHistoryDTO) o;
        return Objects.equals(sourceKey, that.sourceKey) && Objects.equals(vodId, that.vodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceKey, vodId);
    }

    @Override
    public String toString() {
        return "GetOnePlayHistoryDTO{" +
                "sourceKey='" + sourceKey + '\'' +
                ", vodId='" + vodId + '\'' +
                '}';
    }
}
