package test.jersey.resources;

import java.util.HashSet;
import java.util.Set;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import net.arnx.jsonic.JSON;
import test.jersey.response.TestResponse;
 
@Path("/api")
public class TestJerseyResource {
 
    // テストデータ
    private static Set<TestResponse> set;
 
    static{
        // とりあえずテストデータ（ほんとはこんなことやってはダメ）
        set = new HashSet<TestResponse>();
        set.add(new TestResponse(1, "一郎"));
        set.add(new TestResponse(2, "次郎"));
        set.add(new TestResponse(3, "三郎"));
        set.add(new TestResponse(4, "四郎"));
    }
 
    @GET
    @Path("/method1")
    @Produces({"application/json"})
    public Response TestResources(@QueryParam("id") int id){
 
        TestResponse res = null;
 
        // idが一致するデータを返す
        for( TestResponse tmp : set ){
 
            if(id == tmp.getId()){
            	
            	
                res = tmp;
            }
        }
 
        // 一致無しの場合は空データを返す
        if( res == null ){
            res = new TestResponse(0, "");
        }
 
        // JSONICでJSON文字列にエンコードする。
        String json = JSON.encode(res);
 
        return Response.ok()
                .entity(json)
                .build();
    }
    
    @GET
    @Path("/method2")
    @Produces({"application/xml"})
    public TestResponse TestResources2(@QueryParam("id") int id){
 
        TestResponse res = null;
 
        // idが一致するデータを返す
        for( TestResponse tmp : set ){
 
            if(id == tmp.getId()){
            	
            	
                res = tmp;
            }
        }
 
        // 一致無しの場合は空データを返す
        if( res == null ){
            res = new TestResponse(0, "");
        } 
        return res;
    }
}