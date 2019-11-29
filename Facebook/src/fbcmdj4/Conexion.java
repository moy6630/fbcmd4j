package fbcmdj4;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
	//Se establece conexion
	private static String appId="3064490640292181";
	private static String appSecret="b3587cd848be6de41efc1998790d2a77";
	private static String accesToken="EAArjI1QIOVUBAEEXeCSAb7nn0yM2GJVQrDdrwr52WEZBvu5O9kGVYSufscHP6EKd2OJH3h2G6bwE7biZBlkedfOey6o9hquZC6BvqOeImw95P9ZBA8lCirfkoQD4EejougyP7SxZByGGtPDsCbnGyreeN8QF91iOwZAB8ovL4QUk83FgDSZCEMBE5bB5d30OO0j1iEjCqjCnkMoO9DckksHApsAindGG33PZBo56UViojwZDZD";

	public static void main(String[] args) throws FacebookException, MalformedURLException {
		Facebook facebook=new FacebookFactory().getInstance();
		facebook.setOAuthAppId(appId,appSecret);
		
		facebook.setOAuthAccessToken(new AccessToken(accesToken,null));
		
	//acceder a la informacion
		User user = facebook.getMe();
		System.out.print("Mi nombre:");
		System.out.println("\t"+user.getName());
		
		
	//Publicar un post
		PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
		.name("Facebook4j - A java library for the facebook Graph API")
		.caption("facebook4j.org")
		.description("Facebook4j is a java library for the Facebook Graph API");
		facebook.postFeed(post);
	//Buscar personas
		ResponseList<User> results=facebook.searchUsers("LuisMi");
		System.out.println("Búsqueda de personas con nombre LuisMi");
		for(int i=0;i<results.size();i++) {
			User u = results.get(i);
			System.out.println("\t"+u.getName());
		}
		//Buscar post
		ResponseList<Post> results2=facebook.searchPosts("Atleti");
		System.out.println("Búsqueda de posts sobre Atleti");
		for(int i=0;i<results2.size();i++) {
			Post p = results2.get(i);
			System.out.println("\t"+p.getName());
		}
	}

}
