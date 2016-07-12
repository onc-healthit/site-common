package org.sitenv.common.utilities.tags;

import org.sitenv.common.utilities.enums.CcdaType;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CcdaDocumentTypes extends SimpleTagSupport{
	private String id;
	private String name;
	private String styleClass;
	private int tabIndex;
//id="CCDA1_type_val" name="CCDA1_type_val" styleClass="form-control" tabindex="1"
	@Override
    public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
	    out.print("<select");
	    out.print(" id=" + this.getId());
	    out.print(" name=" + this.getName());
	    out.print(" class=" + this.getStyleClass());
	    out.print(" tabindex=" + this.getTabIndex());
	    out.print(">");
	  
	    for ( CcdaType option : CcdaType.values() ) {
	      buildOptionForCcdaType(out, option);
	    }
	    
	    out.println("</select>");
    }

	private void buildOptionForCcdaType(JspWriter out, CcdaType option)
			throws IOException {
		out.print("  <option value='");
	      out.print(option.toString());
	      out.print("'>");
	      out.print(option.getCcdaType());
	      out.println("</option>");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}
	
	
}
