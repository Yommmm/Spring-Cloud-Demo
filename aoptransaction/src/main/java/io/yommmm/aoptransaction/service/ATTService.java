package io.yommmm.aoptransaction.service;

import io.yommmm.aoptransaction.bean.YY;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
@Service
public class ATTService extends ATService {

    public YY testThisSaveSub(YY yy) {
        yy = super.atRepository.save(yy);

        if(10 == yy.getAge()) {
            throw new RuntimeException("ten years old");
        }

        return yy;
    }

}
