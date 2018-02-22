package com.ccniit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.ccniit.model.response_entity.Data;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@SuppressWarnings("deprecation")
public class SingleHttpClient {
	private static final CloseableHttpClient client = HttpClients.createDefault();
	//private static final String EXCEPTION_MESSAGE = "网络连接失败";
	public static CloseableHttpClient getClient() {
		return client;
	}
	
	public static CloseableHttpResponse execute(HttpGet httpGet){
		try {
			return client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> RestResult<T> executeForRestResult(HttpGet httpGet,Class<T> resultClass){
		CloseableHttpResponse response;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        return makeResult(response, resultClass);

	}
	
	public static <T> RestResult<T> executeForRestResult(HttpPost httpPost, List<NameValuePair> formparams,Class<T> resultClass){
		CloseableHttpResponse response;
		try {
			UrlEncodedFormEntity uefEntity;  
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
			httpPost.setEntity(uefEntity); 
			response = client.execute(httpPost);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        return makeResult(response, resultClass);

	}
	
	//2层
	private static <T> RestResult<T> makeResult(CloseableHttpResponse response,Class<T> resultClass){
		boolean result = false;
		String message;
		T data;
		try{ 
        HttpEntity entity = response.getEntity(); 
        if (entity != null) { 
        	String retSrc = EntityUtils.toString(entity); 
            JsonNode  node;
			node = Objectmapper.getObjectMapper().readTree(retSrc);
			System.out.println(node.toString());
			result = node.get("result").asBoolean();
			message = node.get("message").asText();
			String info=node.get("data").toString();
			data = Objectmapper.getObjectMapper().readValue(info, resultClass);
			RestResult<T> resultObject = new RestResult<T>(result, message, data);
			return resultObject;
        }
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(response != null)
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//Data	4层
	public static <T> Data executeForData(HttpGet httpGet,Class<T> resultClass){
		CloseableHttpResponse response;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        return makeData(response, resultClass);

	}
	private static <T> Data makeData(CloseableHttpResponse response,Class<T> resultClass){
			Data datainfo=new Data();
			try{ 
				HttpEntity entity = response.getEntity(); 
				String retSrc = EntityUtils.toString(entity); 
				JsonNode  node = Objectmapper.getObjectMapper().readTree(retSrc);
				datainfo.setResult(node.get("result").asBoolean());
				datainfo.setMessage(node.get("message").toString());
				if(node.get("result").asBoolean()){//查看成功
					String dat=node.get("data").toString();
					JsonNode  cont= Objectmapper.getObjectMapper().readTree(dat);
					String content=cont.get("content").toString();
					System.out.println(content);
					List<T> t=Objectmapper.getObjectMapper().readValue(content,getCollectionType(Objectmapper.getObjectMapper(), List.class, resultClass));
					datainfo.setContent(t);
					datainfo.setTotalPages(cont.get("totalPages").toString());
					datainfo.setTotalElements(cont.get("totalElements").toString());
					datainfo.setLast(cont.get("last").toString());
					datainfo.setNumber(cont.get("number").toString());
					datainfo.setSize(cont.get("size").toString());
					datainfo.setFirst(cont.get("first").toString());
					datainfo.setNumberOfElements(cont.get("numberOfElements").toString());
/*					String Sort=cont.get("sort").toString();
					JsonNode  Sor= Objectmapper.getObjectMapper().readTree(Sort);
					Compositor com=new Compositor();
					com.setDirection(Sor.get("direction").toString());
					com.setProperty(Sor.get("property").toString());
					com.setIgnoreCase(Sor.get("ignoreCase").toString());
					com.setNullHandling(Sor.get("nullHandling").toString());
					com.setAscending(Sor.get("ascending").toString());
					com.setDescending(Sor.get("descending").toString());
					Sort so=new Sort();
					so.getIn_sort().add(com);
					datainfo.setSort(so);*/
					return datainfo;
				}//else查看失败
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
				try {
					if(response != null)
						response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return datainfo;
		}	
	//role 3层
	public static <T> RestResult<T> executeForRole(HttpGet httpGet,Class<T> resultClass){
		CloseableHttpResponse response;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        return makeRole(response, resultClass);

	}
	private static <T> RestResult<T> makeRole(CloseableHttpResponse response,Class<T> resultClass){
		boolean result = false;
		String message;	
		try{ 
				HttpEntity entity = response.getEntity(); 
				String retSrc = EntityUtils.toString(entity); 
				JsonNode  node = Objectmapper.getObjectMapper().readTree(retSrc);
				System.out.println(node);
				result=node.get("result").asBoolean();
				message= node.get("message").asText();
				String date=node.get("data").toString();
				List<T> list=Objectmapper.getObjectMapper().readValue(date,getCollectionType(Objectmapper.getObjectMapper(), List.class, resultClass));
				RestResult<T> resultObject = new RestResult<T>(result, message, list);
				return resultObject;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
				try {
					if(response != null)
						response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}	
	//上传文件
	public static void executeUpFile(HttpPost httpPost,File file){
		CloseableHttpResponse response;
		try {  
	        MultipartEntity reqEntity = new MultipartEntity();  
	        FileBody bin = new FileBody(file);  
	        reqEntity.addPart("file", bin);//file1为请求后台的File upload;属性      
	        httpPost.setEntity(reqEntity); 
			response = client.execute(httpPost);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
/*	private static  RestResult<Object> GetResult(CloseableHttpResponse response){
		boolean result = false;
		String message;	
		try{ 
				HttpEntity entity = response.getEntity(); 
				String retSrc = EntityUtils.toString(entity); 
				JsonNode  node = Objectmapper.getObjectMapper().readTree(retSrc);
				System.out.println(node);
				result=node.get("result").asBoolean();
				message= node.get("message").asText();
				RestResult<Object> resultObject = new RestResult<Object>(result, message);
				return resultObject;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}finally {
				try {
					if(response != null)
						response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}	*/
	 public static JavaType getCollectionType(ObjectMapper mapper,Class<?> collectionClass, Class<?>... elementClasses) {     
	     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);     
	 } 
}
