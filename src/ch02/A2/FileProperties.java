package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// 어댑터
public class FileProperties implements FileIO {
    Properties property = new Properties(); // 어댑티를 속성으로 가지고 있음

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename)); // 어댑티에게 위임
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        property.store(new FileWriter(filename), "written by FileProperties"); // 어댑티에게 위임, 파일에 저장할 때 "written by FileProperties"라는 주석을 추가하여 저장
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value); // 어댑티에게 위임, key와 value를 받아서 property 객체에 저장
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key, ""); // 어댑티에게 위임, key를 받아서 property 객체에서 value를 반환
    }
}
