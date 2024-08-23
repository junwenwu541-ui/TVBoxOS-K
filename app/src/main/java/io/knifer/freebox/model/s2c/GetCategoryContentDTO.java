package io.knifer.freebox.model.s2c;

import com.github.tvbox.osc.bean.MovieSort;
import com.github.tvbox.osc.bean.SourceBean;

import java.util.Objects;

/**
 * 获取指定分类信息
 */
public class GetCategoryContentDTO {

    private SourceBean source;

    private MovieSort.SortData sortData;

    private Integer page;

    public GetCategoryContentDTO() {}

    public GetCategoryContentDTO(SourceBean source, MovieSort.SortData sortData, Integer page) {
        this.source = source;
        this.sortData = sortData;
        this.page = page;
    }

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public MovieSort.SortData getSortData() {
        return sortData;
    }

    public void setSortData(MovieSort.SortData sortData) {
        this.sortData = sortData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCategoryContentDTO that = (GetCategoryContentDTO) o;
        return Objects.equals(source, that.source) && Objects.equals(sortData, that.sortData) && Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, sortData, page);
    }
}
