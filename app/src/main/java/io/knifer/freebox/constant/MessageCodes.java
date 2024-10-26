package io.knifer.freebox.constant;

/**
 * 返回码
 *
 * @author Knifer
 */
public final class MessageCodes {

    private MessageCodes() {
        throw new UnsupportedOperationException();
    }

    /**
     * 注册
     */
    public static final int REGISTER = 100;
    /**
     * 获取源列表
     */
    public static final int GET_SOURCE_BEAN_LIST = 201;
    /**
     * 获取源列表结果
     */
    public static final int GET_SOURCE_BEAN_LIST_RESULT = 202;
    /**
     * 获取首页信息
     */
    public static final int GET_HOME_CONTENT = 203;
    /**
     * 获取首页信息结果
     */
    public static final int GET_HOME_CONTENT_RESULT = 204;
    /**
     * 获取指定分类信息
     */
    public static final int GET_CATEGORY_CONTENT = 205;
    /**
     * 获取指定分类信息结果
     */
    public static final int GET_CATEGORY_CONTENT_RESULT = 206;
    /**
     * 获取影视详情信息
     */
    public static final int GET_DETAIL_CONTENT = 207;
    /**
     * 获取影视详情信息结果
     */
    public static final int GET_DETAIL_CONTENT_RESULT = 208;
    /**
     * 获取播放信息
     */
    public static final int GET_PLAYER_CONTENT = 209;
    /**
     * 获取播放信息结果
     */
    public static final int GET_PLAYER_CONTENT_RESULT = 210;
    /**
     * 获取观看历史
     */
    public static final int GET_PLAY_HISTORY = 211;
    /**
     * 获取观看历史结果
     */
    public static final int GET_PLAY_HISTORY_RESULT = 212;
    /**
     * 影视搜素
     */
    public static final int GET_SEARCH_CONTENT = 213;
    /**
     * 影视搜索结果
     */
    public static final int GET_SEARCH_CONTENT_RESULT = 214;
    /**
     * 保存观看历史
     */
    public static final int SAVE_PLAY_HISTORY = 215;
    /**
     * 删除观看历史
     */
    public static final int DELETE_PLAY_HISTORY = 217;
    /**
     * 删除观看历史结果
     */
    public static final int DELETE_PLAY_HISTORY_RESULT = 218;
}
