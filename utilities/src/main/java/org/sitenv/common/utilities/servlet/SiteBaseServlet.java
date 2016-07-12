package org.sitenv.common.utilities.servlet;

import javax.servlet.http.HttpServlet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SiteBaseServlet extends HttpServlet {

	public static final String DEFAULT_PROPERTIES_FILE = "environment.properties";
	
	protected Properties props;
	
	protected void loadProperties() throws IOException {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE);
		
		if (in == null)
		{
			props = null;
			throw new FileNotFoundException("Environment Properties File not found in class path.");
		}
		else
		{
			props = new Properties();
			props.load(in);
		}
	}
	
	
}
