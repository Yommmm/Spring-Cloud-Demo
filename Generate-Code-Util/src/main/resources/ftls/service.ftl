package ${classPath};

import com.zlst.database.core.dao.BaseRepository;
import com.zlst.module.${packName}.bean.${beanName};
import com.zlst.module.goodspackage.bean.vo.GoodsPackageIndexVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ${className} extends QueryAndOperateServ<${beanName}, ${repoName}> {
	
    private static final Logger logger = LoggerFactory.getLogger(${className}.class);
    
    @Autowired
    private ${repoName} ${repoName};
    
}


