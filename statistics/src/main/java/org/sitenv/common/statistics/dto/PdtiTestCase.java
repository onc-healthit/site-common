package org.sitenv.common.statistics.dto;

public class PdtiTestCase {
	
	private String testCaseName;
	
	private Boolean pass;
	
	private Boolean httpError;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((httpError == null) ? 0 : httpError.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result
				+ ((testCaseName == null) ? 0 : testCaseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdtiTestCase other = (PdtiTestCase) obj;
		if (httpError == null) {
			if (other.httpError != null)
				return false;
		} else if (!httpError.equals(other.httpError))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (testCaseName == null) {
			if (other.testCaseName != null)
				return false;
		} else if (!testCaseName.equals(other.testCaseName))
			return false;
		return true;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public Boolean getHttpError() {
		return httpError;
	}

	public void setHttpError(Boolean httpError) {
		this.httpError = httpError;
	}

	

}
