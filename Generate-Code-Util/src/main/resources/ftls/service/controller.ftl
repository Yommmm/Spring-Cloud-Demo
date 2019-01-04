package ${classPath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zlst.database.core.ctrl.QueryAndOperateCtrl;
import com.zlst.module.${packName}.bean.${beanName};
import com.zlst.module.${packName}.service.${beanName}Service;
import com.zlst.module.${packName}.vo.${beanName}VO;

import com.zlst.param.ObjectToResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "员工API")
@RestController
@RequestMapping("/wms/v1/${packName}")
@EnableAutoConfiguration
public class ${className} {
// public class ${className} extends QueryAndOperateCtrl<${beanName}, ${beanName}Service> {
	
    private static final Logger logger = LoggerFactory.getLogger(${className}.class);
    
    @Autowired
    private ${beanName}Service ${packName}Service;
    
    /**
	 * 增
	 * @param ${packName} XXXX
	 */
    @PostMapping("/save")
	@ApiOperation(value = "新增 TODO description", notes="新增 TODO description API", produces = "application/json")
	@ApiImplicitParam(name = "${packName}", value = "TODO description", dataType = "${beanName}", required = true)
    public Object save${beanName}(@RequestBody ${beanName} ${packName}) throws Exception {
    	return ObjectToResult.getResult(${packName}Service.save${beanName}(${packName}));
    }
    
    /**
	 * 删
	 * @param ${packName}Id XXXX
	 */
    @DeleteMapping("/{${packName}Id}")
    @ApiOperation(value = "删除 TODO description", notes="删除 TODO description API", produces = "application/json")
    @ApiImplicitParam(name = "${packName}Id", value = "TODO description", dataType = "String", paramType = "path")
    public Object del${beanName}(@PathVariable String ${packName}Id) throws Exception {
    	return ObjectToResult.getResult(${packName}Service.del${beanName}(${packName}Id));
    }
    
    /**
	 * 改
	 * @param ${packName}Id XXXX
	 * @param ${packName} XXXX
	 */
    @PutMapping("/{${packName}Id}")
	@ApiOperation(value = "更新 TODO description", notes="更新 TODO description API", produces = "application/json")
	@ApiImplicitParams({ 
    	@ApiImplicitParam(name = "${packName}Id", value = "TODO description", dataType = "String", paramType = "path") ,
    	@ApiImplicitParam(name = "${packName}", value = "TODO description", dataType = "${beanName}", paramType = "body")})
    public Object update${beanName}(@PathVariable String ${packName}Id, @RequestBody ${beanName} ${packName}) throws Exception {
    	return ObjectToResult.getResult(${packName}Service.update${beanName}(${packName}Id, ${packName}));
    }
    
    /**
	 * 查
	 * @param ${packName}Id XXXX
	 */
    @GetMapping("/{${packName}Id}")
    @ApiOperation(value = "查询 TODO description", notes="查询 TODO description API", produces = "application/json")
    @ApiImplicitParam(name = "${packName}Id", value = "TODO description", dataType = "String", paramType = "path")
    public Object get${beanName}(@PathVariable String ${packName}Id) throws Exception {
    	return ObjectToResult.getResult(${packName}Service.get${beanName}(${packName}Id));
    }
    
    /**
	 * 查
	 * @param ${packName} XXXX
	 */
    @PostMapping("/queryWithPage")
    @ApiOperation(value = "查询 TODO description", notes="查询 TODO description API", produces = "application/json")
    @ApiImplicitParam(name = "${packName}VO", value = "TODO description", dataType = "${beanName}VO", paramType = "body")
    public Object get${beanName}(@RequestBody ${beanName}VO ${packName}VO) throws Exception {
    	return ObjectToResult.getResult(${packName}Service.get${beanName}(${packName}VO));
    }
    
}