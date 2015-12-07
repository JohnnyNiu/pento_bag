package com.bag.pin.dao;

import com.bag.pin.model.Pin;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by johnny on 25/11/15.
 */
@Repository
public class PinDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save (Pin pin) {
        pin.setCrawlDate(new Date());
        mongoTemplate.save(pin);
    }

    public Pin get(String id) {
        return mongoTemplate.findById(new ObjectId(id), Pin.class);
    }

    public void remove (Pin pin) {
        mongoTemplate.remove(pin);
    }

    public void removeAll() {
        mongoTemplate.remove(new Query(), Pin.class);
    }
}
