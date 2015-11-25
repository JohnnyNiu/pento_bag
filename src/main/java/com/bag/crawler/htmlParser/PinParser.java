package com.bag.crawler.htmlParser;

import com.bag.pin.model.Pin;
import javafx.scene.input.DataFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by johnny on 25/11/15.
 */
@Service
public class PinParser {
    public Pin parseToPin(String id, Document document) {
        Pin pin = new Pin();
        pin.setId(id);
        pin.setTitle(getTitle(document));
        pin.setDate(getDate(document));
        pin.setFavoriteTotal(getFavoriteTotal(document));
        pin.setLike_total(getLikeTotal(document));
        pin.setPentoUserId(getPentoUserId(document));
        return pin;
    }

    //Elements newsHeadlines = doc.select("#mp-itn b a");

    private String getTitle(Document document) {
        return document.select(".left_title h1").html();
    }

    private String getPentoUserId(Document document) {
        return document.select(".author_avatar_type_5").attr("href").replace("/user/", "");
    }

    private long getLikeTotal(Document document) {
        String likes = document.select(".left_function_good").html().replace("赞", "");
        return Long.parseLong(likes.trim());
    }

    private long getFavoriteTotal(Document document) {

        String favorate = document.select(".left_function_collection").html().replace("收集", "");
        return Long.parseLong(favorate.trim());
    }

    private Date getDate(Document document) {
        String time = document.select(".left_time").html().replace("时间：", "");
        DateTime date = DateTime.parse(time,
                DateTimeFormat.forPattern("dd/MM/yyyy"));
        return date.toDate();
    }
}
