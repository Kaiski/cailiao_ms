package com.whut.cailiao.ms.api.service.news;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.news.News;

/**
 * Created by gammaniu on 16/4/15.
 */
public interface NewsService {

    /**
     * 后台用,新闻不系统编辑功能
     * 基本服务:发送
     * 应对信息修改的情况:/删除/查看列表/查看详情
     * 前端使用:前端新闻队列
     */
    /**
     * 获取新闻列表
     * @return
     */
    ApiResponse getNewsList();

    /**
     * 获取新闻详情
     * @return
     */
    ApiResponse getNewsDetail(int id);

    /**
     * 发送新闻
     * @return
     */
    ApiResponse sendNews(News news);

    /**
     * 删除新闻
     * @return
     */
    ApiResponse deleteNews(int id);

    /**
     * 更新状态
     */
    ApiResponse updateNewsStatus(int id, int status);

    /**
     * 前台使用
     */
    /**
     * 拉取新闻列表, 按照优先级排列
     * 返回15条
     */
    ApiResponse getNewsFrontEndList(int topSize);

}
