package ${classPath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zlst.database.core.ctrl.QueryAndOperateCtrl;
import com.zlst.module.${packName}.bean.${beanName};
import com.zlst.module.${packName}.service.${beanName}Service;

import com.zlst.param.ObjectToResult;

@RestController
@RequestMapping("/wms/v1/${packName}")
public class ${className} extends QueryAndOperateCtrl<${beanName}, ${beanName}Service> {
	
    private static final Logger logger = LoggerFactory.getLogger(${className}.class);
    
    @Autowired
    private ${beanName}Service ${packName}Service;
    
    /**
	 * 增
	 * @param ${packName} XXXX
	 */
    @PostMapping
    public Object save${beanName}(@RequestBody ${beanName} ${packName}) {
    	return ObjectToResult.getResult("success");
    }
    
    /**
	 * 删
	 * @param ${packName}Id XXXX
	 */
    @DeleteMapping("/{${packName}Id}")
    public Object del${beanName}(@PathVariable String ${packName}Id) {
    	return ObjectToResult.getResult("success");
    }
    
    /**
	 * 改
	 * @param ${packName} XXXX
	 */
    @PutMapping
    public Object update${beanName}(@RequestBody ${beanName} ${packName}) {
    	return ObjectToResult.getResult("success");
    }
    
    /**
	 * 查
	 * @param ${packName}Id XXXX
	 */
    @GetMapping("/{${packName}Id}")
    public Object get${beanName}(@PathVariable String ${packName}Id) {
    	return ObjectToResult.getResult("success");
    }
    
    /**
	 * 查
	 * @param ${packName} XXXX
	 */
    @PostMapping("/queryWithPage")
    public Object get${beanName}(@RequestBody ${beanName} ${packName}) {
    	return ObjectToResult.getResult("success");
    }
    
}