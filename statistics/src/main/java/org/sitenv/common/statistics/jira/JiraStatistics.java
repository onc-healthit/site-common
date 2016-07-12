package org.sitenv.common.statistics.jira;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;


public class JiraStatistics {
	
	
	
	private static final Logger logger = Logger.getLogger(JiraStatistics.class);
	
	
	public JiraStatistics() {}
	
	public static Long getCreatedIssues(int numOfDays){
		return jiraIssuesCount(numOfDays, false);
	}
	
	public static Long getResolvedIssues(int numOfDays){
		return jiraIssuesCount(numOfDays, true);
	}
	
	private static Long jiraIssuesCount(int nDays, boolean nResolved){
		
		HttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost("http://jira.oncprojectracking.org/rest/api/2/search");
		
		//post.addHeader("Authorization", "Basic "+jiraCredential);
		post.addHeader("Content-Type", "application/json");
		
		StringEntity query = null;
		try {
			if (nDays == 0){
				
				if (nResolved == true){
					query = new StringEntity("{\"jql\":\"project IN (QRDA, CCDA) AND (status = Resolved OR status = Closed)\",\"startAt\":0,\"maxResults\":0,\"fields\":[\"id\"]}");
				} else {
					query = new StringEntity("{\"jql\":\"project IN (QRDA, CCDA)\",\"startAt\":0,\"maxResults\":0,\"fields\":[\"id\"]}");
				}
				
			} else {
				
				Calendar cal = Calendar.getInstance();
				
				String todayYear = String.valueOf(cal.get(Calendar.YEAR));
				String todayMonth = String.valueOf(cal.get(Calendar.MONTH) +1);
				String todayDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
				String todayDate = todayYear + "/" + todayMonth + "/" + todayDay;
				
				cal.add(Calendar.DAY_OF_YEAR, -nDays);
				
				String nDaysAgoYear = String.valueOf(cal.get(Calendar.YEAR));
				String nDaysAgoMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
				String nDaysAgoDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
				String nDaysAgoDate = nDaysAgoYear + "/" + nDaysAgoMonth + "/" + nDaysAgoDay;
				
				if (nResolved == true){
					query = new StringEntity("{\"jql\":\"project IN (QRDA, CCDA) AND resolved >= \'"+nDaysAgoDate+"\' AND resolved <= \'"+todayDate+"\'\",\"startAt\":0,\"maxResults\":0, \"fields\":[\"id\"]}");
				} else {
					query = new StringEntity("{\"jql\":\"project IN (QRDA, CCDA) AND created >= \'"+nDaysAgoDate+"\' AND created <= \'"+todayDate+"\'\",\"startAt\":0,\"maxResults\":0, \"fields\":[\"id\"]}");
				}
			}
			
		} catch (UnsupportedEncodingException e) {
			logger.debug("Error in JIRA API Call:", e);
		}
		query.setContentType("application/json");
		post.setEntity(query);
		
		
		HttpResponse searchResults = null;
		try {
			searchResults = client.execute(post);
		} catch (ClientProtocolException e) {
			logger.debug("Error in JIRA API Call:", e);
		} catch (IOException e) {
			logger.debug("Error in JIRA API Call:", e);
		}
		
		ResponseHandler<String> handler = new BasicResponseHandler();
		String body = null;
		try {
			body = handler.handleResponse(searchResults);
		} catch (ClientProtocolException e) {
			logger.debug("Error in JIRA API Call:", e);
		} catch (IOException e) {
			logger.debug("Error in JIRA API Call:", e);
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(body).getAsJsonObject();
		Long count = Long.valueOf(obj.get("total").toString());
		return count;
	}
}
