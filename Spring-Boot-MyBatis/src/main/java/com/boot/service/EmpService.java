package com.boot.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.boot.entity.Emp;
import com.boot.mapper.EmpMapper;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> list() {
		return empMapper.list();
	}
	
	public Emp getOne(String empId) {
		return empMapper.getOne(empId);
	}
	
	public Emp save(Emp emp) {
		emp.setEmpId(UUID.randomUUID().toString().replace("-", ""));
		empMapper.insert(emp);
		return emp;
	}
	
	public Emp update(Emp emp) {
		empMapper.update(emp);
		return emp;
	}
	
	public String delete(String empId) {
		empMapper.delete(empId);
		return empId;
	}
	
	public Object getStock() {
		// 获取token
		String tokenUri = "http://logisticsgateway.zlst.com/gateway/api-oauth2/oauth/token";
		Object tokenObj = this.restUtil(tokenUri, null, true, false, null);
		@SuppressWarnings("unchecked")
		Map<String, String> tokenMap = (Map<String, String>) tokenObj;
		String token = tokenMap.get("access_token");
		System.out.println(token);
		
		// 获取库存
		String stockUri = "http://logisticsgateway.zlst.com/gateway/api-logistics-isv-170186/interfaces/external/getStockByMes";
		Map<String, Object> params = new HashMap<>();
		params.put("goodsCode", "7000000000");
		params.put("goodsName", "氧化铝");
		params.put("locatorNo", "AAB080101");
		params.put("pageNum", 1);
		params.put("pageSize", 20);
		
		Object stock = this.restUtil(stockUri, params, false, true, token);
		return stock;
	}
	
	private Object restUtil(String url, Map<String, Object> params, boolean isFormData, boolean haveToken, String token) {
		RestTemplate template = new RestTemplate();
        if(isFormData) {
        	MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        	multiValueMap.add("grant_type", "client_credentials");
        	multiValueMap.add("client_id", "tms_api");
        	multiValueMap.add("client_secret", "tms123456");
        	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(multiValueMap, getRequestHeader(isFormData, haveToken, token));
        	ResponseEntity<Object> re = template.postForEntity(url, request, Object.class);
        	
        	Object obj = re.getBody();
    		return obj;
        } else {
        	HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<Map<String, Object>>(params, getRequestHeader(isFormData, haveToken, token));
        	ResponseEntity<String> re = template.postForEntity(url, requestEntity, String.class);
        	
        	Object obj = re.getBody();
    		return obj;
        }
        
	}
	
	private HttpHeaders getRequestHeader(boolean isFormData, boolean haveToken, String token) {
        HttpHeaders headers = new HttpHeaders();
        //获取request
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headers.add(name, request.getHeader(name));
        }
        
        if(isFormData) {
        	headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        }
        if(haveToken) {
        	headers.setContentType(MediaType.APPLICATION_JSON);
        	headers.add("token", token);
        }
        
        return headers;
    }
	
}
