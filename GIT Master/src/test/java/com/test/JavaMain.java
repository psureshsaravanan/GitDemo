package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.omg.CORBA.portable.InputStream;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.source.DriverConfig;
import com.source.Utils;

public class JavaMain {

	public static void main(String[] args) throws IOException {
	//new JavaMain().	fh();
		DriverConfig dr=new DriverConfig();
		dr.setDriver("GeneralStoreAPP");
	}
	public  void fh() throws IOException {
		Yaml yaml=new Yaml();
	//	String str=FileUtils.readFileToString(new File("./Config.yaml"));
//System.out.println(str);
java.io.InputStream inputStream = this.getClass()
.getClassLoader()
.getResourceAsStream("./Config.yaml");
Map<String, Object> obj = yaml.load(inputStream);          
System.out.println(obj);
	}
	public static void f() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		Map<String,Map<String,String>> user = mapper.readValue(new File("./Config.yaml"), Map.class);
		System.out.println(user.get("GeneralStoreAPP"));
	}
}
