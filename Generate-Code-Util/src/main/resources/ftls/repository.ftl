package ${classPath};

import com.zlst.database.core.dao.BaseRepository;
import com.zlst.module.${packName}.bean.${beanName};

import org.springframework.stereotype.Repository;

@Repository
public interface ${className} extends BaseRepository<${beanName}, String> {
	
}
