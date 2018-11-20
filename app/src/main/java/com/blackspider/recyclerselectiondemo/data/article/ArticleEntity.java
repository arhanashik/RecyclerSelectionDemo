package com.blackspider.recyclerselectiondemo.data.article;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/19/2018 at 5:46 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/19/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import com.blackspider.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class ArticleEntity {

    private int id;
    private String writerName;
    private String writerImg;
    private String article;
    private String timeStamp;

    public ArticleEntity(){

    }

    public ArticleEntity(int id, String writerName, String writerImg, String article, String timeStamp) {
        this.id = id;
        this.writerName = writerName;
        this.writerImg = writerImg;
        this.article = article;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterImg() {
        return writerImg;
    }

    public void setWriterImg(String writerImg) {
        this.writerImg = writerImg;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static List<ArticleEntity> getArticleEntities() {
        List<ArticleEntity> list = new ArrayList<>();
        list.add(new ArticleEntity(1, "Captain Jack Sparrow", "https://example.com/img1.png",
                "Ay ay captain", TimeUtil.covertTimeToText(System.currentTimeMillis() - 5000)));
        list.add(new ArticleEntity(2, "Tom hank", "https://example.com/img2.png",
                "How are you?", TimeUtil.covertTimeToText(System.currentTimeMillis() - 4000)));
        list.add(new ArticleEntity(3, "Arnold Scardsnager", "https://example.com/img3.png",
                "Have you gone to college today?", TimeUtil.covertTimeToText(System.currentTimeMillis() - 3000)));
        list.add(new ArticleEntity(4, "Tom cruze", "https://example.com/img4.png",
                "I have missed everyone so much.", TimeUtil.covertTimeToText(System.currentTimeMillis() - 2000)));
        list.add(new ArticleEntity(5, "Harry potter", "https://example.com/img5.png",
                "I am too sick to go to college", TimeUtil.covertTimeToText(System.currentTimeMillis() - 1000)));
        list.add(new ArticleEntity(6, "Rupanzel", "https://example.com/img6.png",
                "Please pray for me", TimeUtil.covertTimeToText(System.currentTimeMillis())));

        return list;
    }
}
