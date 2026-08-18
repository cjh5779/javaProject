package datastructure.collection.properties;

import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		// Properties 파일 읽어오기
		Properties properties = new Properties();
		// 읽어오려는 property 파일의 경로
		String path = PropertiesExample.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		properties.load(new FileReader(path));
		
	}
}
