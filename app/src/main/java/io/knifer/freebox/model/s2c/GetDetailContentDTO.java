package io.knifer.freebox.model.s2c;

import java.util.Objects;

/**
 * 获取详情信息参数
 * @author Knifer
 */
public class GetDetailContentDTO {

    /**
     * 源
     */
    private String sourceKey;

    /**
     * 视频ID
     */
    private String videoId;

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetDetailContentDTO that = (GetDetailContentDTO) o;
        return Objects.equals(sourceKey, that.sourceKey) && Objects.equals(videoId, that.videoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceKey, videoId);
    }
}
