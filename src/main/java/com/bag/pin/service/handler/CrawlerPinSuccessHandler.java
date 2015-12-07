package com.bag.pin.service.handler;

import com.bag.pin.model.Pin;
import com.bag.pin.service.PinCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiaomingniu on 29/11/2015.
 */
@Component
public class CrawlerPinSuccessHandler {

    @Autowired
    private PinCRUDService pinCRUDService;

    public void handle(Pin pin) {
        pinCRUDService.savePin(pin);
    }
}
