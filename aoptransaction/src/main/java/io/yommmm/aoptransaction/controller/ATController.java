package io.yommmm.aoptransaction.controller;

import io.yommmm.aoptransaction.bean.YY;
import io.yommmm.aoptransaction.service.ATService;
import io.yommmm.aoptransaction.service.ATTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
@Slf4j
@RestController
@RequestMapping("/aoptransaction")
public class ATController {

    @Qualifier("ATService")
    @Autowired
    private ATService atService;

    @Autowired
    private ATTService attService;

    @PostMapping
    @Transactional
    public Object test(YY yy) {
        return atService.save(yy);
    }

    @PostMapping("/this")
    public Object testThisTransaction(@RequestBody YY yy) {
        return atService.testThis(yy);
    }

    @PostMapping("test1")
    public Object test1(YY yy) {
        return attService.testThisSave(yy);
    }

    @PostMapping("test2")
    public Object test2(YY yy) {
        return attService.testThisSaveSub(yy);
    }

}