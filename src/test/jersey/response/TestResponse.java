package test.jersey.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestResponse {
 
    private int id;
    private String name;
    private int age;
    /**
     * デフォルトコンストラクタ（JSONエンコードに必須）
     */
    public TestResponse(){
    }
 
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
     * データ初期化用コンストラクタ
     * @param id
     * @param name
     */
    public TestResponse(int id, String name){
        this.id = id;
        this.name = name;
        this.age = 100;
    }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}