package io.knifer.freebox.model.s2c;

import java.util.Objects;

/**
 * 获取播放信息
 * @author Knifer
 */
public class GetPlayerContentDTO {

    /**
     * 源
     */
    private String sourceKey;

    /**
     * 进度
     */
    private String processKey;

    /**
     * 播放标志
     */
    private String playFlag;

    /**
     * 视频ID
     */
    private String id;

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getPlayFlag() {
        return playFlag;
    }

    public void setPlayFlag(String playFlag) {
        this.playFlag = playFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetPlayerContentDTO that = (GetPlayerContentDTO) o;
        return Objects.equals(sourceKey, that.sourceKey) && Objects.equals(processKey, that.processKey) && Objects.equals(playFlag, that.playFlag) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceKey, processKey, playFlag, id);
    }
}
