package io.yommmm.aoptransaction.repository;

import io.yommmm.aoptransaction.bean.YY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
@Repository
public interface ATRepository extends JpaRepository<YY, String> {



}
