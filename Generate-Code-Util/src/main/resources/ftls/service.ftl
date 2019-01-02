package ${classPath};

import com.zlst.database.core.dao.BaseRepository;
import com.zlst.module.${packName}.bean.${beanName};
import com.zlst.module.${packName}.repository.${beanName}Repository;
import com.zlst.module.${packName}.vo.${beanName}VO;

import com.zlst.param.Page;
import com.zlst.param.PageParam;
import com.zlst.database.common.Common;
import com.zlst.database.common.ZlstBeanUtils;
import com.zlst.database.core.service.QueryAndOperateServ;
import com.zlst.database.exception.ZlstDatabaseCoreExption;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ${className} extends QueryAndOperateServ<${beanName}, ${beanName}Repository> {
	
    private static final Logger logger = LoggerFactory.getLogger(${className}.class);
    
    @Autowired
    private ${beanName}Repository ${packName}Repository;
    
    /**
   	 * 保存${beanName}
   	 * @param ${packName}
   	 */
    public ${beanName} save${beanName}(${beanName} ${packName}) throws Exception {
    	${packName} = this.save(${packName});
    	return ${packName};
    }
    
    /**
	 * 删
	 * @param ${packName}Id XXXX
	 */
    public String del${beanName}(String ${packName}Id) throws Exception {
    	${beanName} ${packName} = this.get(${packName}Id);
    	${packName}.setActive("1");
    	${packName} = this.update(${packName}Id, ${packName});
    	return ${packName}Id;
    }
    
    /**
	 * 修改${beanName}
	 * @param ${packName} XXXX
	 */
    public ${beanName} update${beanName}(String ${packName}Id, ${beanName} ${packName}) throws Exception {
    	${packName} = this.update(${packName}Id, ${packName});
    	return ${packName};
    }
    
    /**
	 * 通过${packName}ID查询${beanName}
	 * @param ${packName}Id XXXX
	 */
    public ${beanName} get${beanName}(String ${packName}Id) throws Exception {
    	${beanName} ${packName} = this.get(${packName}Id);
    	return ${packName};
    }
    
    /**
	 * 查
	 * @param ${packName} XXXX
	 */
    public Page<${beanName}VO> get${beanName}(${beanName}VO conditions) throws Exception {
    	StringBuilder sql = new StringBuilder("SELECT t.* FROM ${tableName} t ");
    	sql.append("");
    	
    	PageParam pageParam = new PageParam();
    	pageParam.setPageNum(conditions.getPageNum());
		pageParam.setPageSize(conditions.getPageSize());
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	
    	Page<${beanName}> ${packName}Page = this.sqlPageQuery(sql.toString(), pageParam, ${beanName}.class, params);
    	List<${beanName}> ${packName}List = ${packName}Page.getObjList();
    	
    	Page<${beanName}VO> ${packName}VOPage = new Page<${beanName}VO>();
    	List<${beanName}VO> ${packName}VOList = new ArrayList<${beanName}VO>();
		BeanUtils.copyProperties(${packName}Page, ${packName}VOPage, "objList");
    	
    	for(${beanName} ${packName} : ${packName}List) {
    		${beanName}VO ${packName}VO = new ${beanName}VO();
    		BeanUtils.copyProperties(${packName}, ${packName}VO);
    		this.translate(${packName}VO);
    		
    		${packName}VOList.add(${packName}VO);
    	}
    	${packName}VOPage.setObjList(${packName}VOList);
    
    	return ${packName}VOPage;
    }
    
    private void translate(${beanName}VO ${packName}VO) {
    	// TODO
    }
    
    
}


