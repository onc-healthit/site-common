package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="ccda_reference_download")
public class CcdaReferenceDownloadEntity {

	@Id
	@Column(name="download_pk")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "download_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Basic(optional= false)
	@Column(name = "download_file_name", insertable=true, updatable=true)
	private String fileName; 
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		
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
		CcdaReferenceDownloadEntity other = (CcdaReferenceDownloadEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
