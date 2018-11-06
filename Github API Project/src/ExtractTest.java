import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class ExtractTest {

	@Test
	public void testReadJsonFromURL() {
		String result = "";
		String urlStr = "https://api.github.com/users/octocat";
		String expected = "{\n" + 
				"  \"login\": \"octocat\",\n" + 
				"  \"id\": 583231,\n" + 
				"  \"node_id\": \"MDQ6VXNlcjU4MzIzMQ==\",\n" + 
				"  \"avatar_url\": \"https://avatars3.githubusercontent.com/u/583231?v=4\",\n" + 
				"  \"gravatar_id\": \"\",\n" + 
				"  \"url\": \"https://api.github.com/users/octocat\",\n" + 
				"  \"html_url\": \"https://github.com/octocat\",\n" + 
				"  \"followers_url\": \"https://api.github.com/users/octocat/followers\",\n" + 
				"  \"following_url\": \"https://api.github.com/users/octocat/following{/other_user}\",\n" + 
				"  \"gists_url\": \"https://api.github.com/users/octocat/gists{/gist_id}\",\n" + 
				"  \"starred_url\": \"https://api.github.com/users/octocat/starred{/owner}{/repo}\",\n" + 
				"  \"subscriptions_url\": \"https://api.github.com/users/octocat/subscriptions\",\n" + 
				"  \"organizations_url\": \"https://api.github.com/users/octocat/orgs\",\n" + 
				"  \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" + 
				"  \"events_url\": \"https://api.github.com/users/octocat/events{/privacy}\",\n" + 
				"  \"received_events_url\": \"https://api.github.com/users/octocat/received_events\",\n" + 
				"  \"type\": \"User\",\n" + 
				"  \"site_admin\": false,\n" + 
				"  \"name\": \"The Octocat\",\n" + 
				"  \"company\": \"GitHub\",\n" + 
				"  \"blog\": \"http://www.github.com/blog\",\n" + 
				"  \"location\": \"San Francisco\",\n" + 
				"  \"email\": null,\n" + 
				"  \"hireable\": null,\n" + 
				"  \"bio\": null,\n" + 
				"  \"public_repos\": 8,\n" + 
				"  \"public_gists\": 8,\n" + 
				"  \"followers\": 2432,\n" + 
				"  \"following\": 9,\n" + 
				"  \"created_at\": \"2011-01-25T18:44:36Z\",\n" + 
				"  \"updated_at\": \"2018-11-06T16:21:16Z\"\n" + 
				"}";
		try {
			result = Extract.readJsonFromUrl(urlStr).toString();
		} catch (IOException | JSONException e) {
			System.err.println("An exception has occurred!");
		}
		assertEquals("There's a problem with reading in data from the URL!", expected, result);
	}

}
