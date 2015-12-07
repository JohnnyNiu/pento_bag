package com.bag.pin.service;

import com.bag.pin.dao.PinDao;
import com.bag.pin.model.Pin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * Created by johnny on 25/11/15.
 */
@Service
public class PinCRUDService {

    @Autowired
    PinDao pinDao;

    public boolean isExist(String pinId) {
        return ObjectUtils.isEmpty(pinDao.get(pinId));
    }

    public void savePin(Pin pin) {
        pinDao.save(pin);
    }

    public void removeAll() {
        pinDao.removeAll();
    }

}
