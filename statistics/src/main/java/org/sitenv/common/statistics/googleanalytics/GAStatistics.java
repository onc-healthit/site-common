package org.sitenv.common.statistics.googleanalytics;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.AnalyticsScopes;
import com.google.api.services.analytics.model.GaData;
import com.google.api.services.analytics.model.Profiles;
import com.google.api.services.analytics.model.Webproperties;
import org.apache.log4j.Logger;
import org.sitenv.common.statistics.dto.GoogleAnalyticsData;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class GAStatistics {
	
	private static final Logger logger = Logger.getLogger(GAStatistics.class);
	
	private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	
	public GAStatistics() {}
	
	private static Analytics getAnalytics(Credential credential){
		
		Analytics.Builder builder = new Analytics.Builder(TRANSPORT, JSON_FACTORY, credential);
		builder.setApplicationName("SITE-Google-Analytics");
		Analytics analytics = builder.build();
		
		return analytics;
	}
	
	private static GoogleCredential getCredential(String p12CertPath) throws GeneralSecurityException, IOException {
		
		
		GoogleCredential credential = new GoogleCredential.Builder()
			  .setTransport(TRANSPORT)
			  .setJsonFactory(JSON_FACTORY)
			  .setServiceAccountId("860345658841-4qhnghvlfknrmkfjcri2d58fmo99r9go@developer.gserviceaccount.com")
			  //.setServiceAccountId("testtesttest@developer.gserviceaccount.com")
			  .setServiceAccountScopes(Arrays.asList(AnalyticsScopes.ANALYTICS_READONLY))
			  .setServiceAccountPrivateKeyFromP12File(new File(p12CertPath))
			  .build();
	    
	    return credential;
	}
	
	private static String SITEProfileId(Analytics analytics) throws IOException {
	    String profileId = null;
	    
	    // Query accounts collection.
	    com.google.api.services.analytics.model.Accounts accounts = analytics.management().accounts().list().execute();

	    if (accounts.getItems().isEmpty()) {
	    	logger.error("No Google Analytics accounts found");
	    } else {
	      String firstAccountId = accounts.getItems().get(0).getId();
	      
	      // Query webproperties collection.
	      Webproperties webproperties = analytics.management().webproperties()
	          .list(firstAccountId).execute();

	      if (webproperties.getItems().isEmpty()) {
	    	  logger.error("No Google Analytics Webproperties found");
	      } else {
	        String firstWebpropertyId = webproperties.getItems().get(0).getId();
	        
	        // Query views (profiles) collection.
	        Profiles profiles = analytics.management().profiles()
	            .list(firstAccountId, firstWebpropertyId).execute();
	        
	        if (profiles.getItems().isEmpty()) {
	        	logger.error("No Google Analytics views (profiles) found");
	        } else {
	        	// 1 for "SITE All Projects" 
	          profileId = profiles.getItems().get(1).getId();
	        }
	      }
	    }
	    return profileId;
	}
	
	
	  
	/**
	 * @param analytics
	 * @param profileId
	 * @param startDate format = YYYY-mm-DD
	 * @param endDate format = YYYY-mm-DD
	 * @return
	 * @throws IOException
	 */
	private static GaData getData(Analytics analytics, 
			String profileId,
			String startDate,
			String endDate) throws IOException 
	{
		GaData sessionData = analytics.data().ga()
				.get("ga:" + profileId, 		// Table Id. ga: + profile id.
						startDate,					// Start date
						endDate,					// End date.
			            "ga:pageviews,ga:sessions")
			    .setDimensions("ga:date").setSort("-ga:date")				// Metrics.
			    .execute();
			    
		return sessionData;
	}
		  
	private static String[] dateRange(int ndays){
		
		Calendar cal = Calendar.getInstance();
		String todayYear = String.valueOf(cal.get(Calendar.YEAR));
		String todayMonth = String.valueOf(cal.get(Calendar.MONTH) +1);
		String todayDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
				
		if (todayMonth.length() == 1){
			todayMonth = "0"+todayMonth;
		}
		if (todayDay.length() == 1){
			todayDay = "0"+todayDay;
		}
				
		String todayDate = todayYear + "-" + todayMonth + "-" + todayDay;
		
		cal.add(Calendar.DAY_OF_YEAR, -ndays);
		String nDaysAgoYear = String.valueOf(cal.get(Calendar.YEAR));
		String nDaysAgoMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
		String nDaysAgoDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		
		if (nDaysAgoMonth.length() == 1){
			nDaysAgoMonth = "0"+nDaysAgoMonth;
		}
		if (nDaysAgoDay.length() == 1){
			nDaysAgoDay = "0"+nDaysAgoDay;
		}
		
		String nDaysAgoDate = nDaysAgoYear + "-" + nDaysAgoMonth + "-" + nDaysAgoDay;
		return new String[]{nDaysAgoDate, todayDate};
	}
	
	public static GoogleAnalyticsData getData(String p12CertPath) {
		
		GoogleAnalyticsData gaData = null;
		
		Analytics analytics = null;
		try {
			analytics = getAnalytics(getCredential(p12CertPath));
		} catch (GeneralSecurityException e) {
			logger.error("Security exception while obtaining Google API Certificate:", e);
		} catch (IOException e) {
			logger.error("IO exception while obtaining Google API Certificate:", e);
		}
		if (analytics == null){
			logger.error("Error while getting Google Analytics object");
		}


		
		String profileId = null;
		try {
			profileId = SITEProfileId(analytics);
		} catch (IOException e) {
			logger.error("Error while getting Google Analytics Profile ID:", e);
		}
		if (profileId == null){
			logger.error("Error while getting Google Analytics Profile ID");
		}
		
		try {
			GaData data = getData(analytics, profileId, "2010-01-01", "today");
			
			if (data != null)
			{
				gaData = new GoogleAnalyticsData();
				
				gaData.setTotalPageViews(Long.parseLong(data.getTotalsForAllResults().get("ga:pageviews")));
				gaData.setTotalSessions(Long.parseLong(data.getTotalsForAllResults().get("ga:sessions")));
				
				for (int count = 0; count < 90; count++)
				{
					List<String> row = data.getRows().get(count);
					
					if (count < 30)
					{
						gaData.setPageViews30(gaData.getPageViews30() + Long.parseLong(row.get(1)));
						gaData.setSessions30(gaData.getSessions30() + Long.parseLong(row.get(2)));
					}
					
					if (count < 60)
					{
						gaData.setPageViews60(gaData.getPageViews60() + Long.parseLong(row.get(1)));
						gaData.setSessions60(gaData.getSessions60() + Long.parseLong(row.get(2)));
					}
					
					if (count < 90)
					{
						gaData.setPageViews90(gaData.getPageViews90() + Long.parseLong(row.get(1)));
						gaData.setSessions90(gaData.getSessions90() + Long.parseLong(row.get(2)));
					}
				}
				
			}
			
		} catch (IOException e)
		{
			logger.error("Error while getting Google Analytics Data.", e);
		}
		
		
		return gaData;
	}
	
}
