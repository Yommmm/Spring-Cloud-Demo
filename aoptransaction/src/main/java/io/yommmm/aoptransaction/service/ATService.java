package io.yommmm.aoptransaction.service;

import io.yommmm.aoptransaction.aop.OptimisticLock;
import io.yommmm.aoptransaction.bean.YY;
import io.yommmm.aoptransaction.repository.ATRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
@Service
@Slf4j
public class ATService {

    @Autowired
    private ATRepository atRepository;

    @Transactional
    @OptimisticLock
    public YY save(YY yy) {
        return atRepository.save(yy);
    }

}
