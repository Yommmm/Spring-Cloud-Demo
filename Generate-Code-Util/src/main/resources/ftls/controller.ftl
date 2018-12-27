package ${classPath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}