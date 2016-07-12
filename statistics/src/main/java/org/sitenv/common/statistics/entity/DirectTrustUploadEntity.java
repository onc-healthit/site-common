package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="direct_trustupload")
public class DirectTrustUploadEntity {

		
		@Id
		@Column(name="directtrust_pk")
		@GeneratedValue( strategy = GenerationType.IDENTITY )
		private Long id;

		@Basic(optional = false)
		@Column(name = "directtrust_time", insertable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		private Date timestamp;

		@Column(name="directtrust_errors")
		private Boolean errors;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((errors == null) ? 0 : errors.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
			DirectTrustUploadEntity other = (DirectTrustUploadEntity) obj;
			if (errors == null) {
				if (other.errors != null)
					return false;
			} else if (!errors.equals(other.errors))
				return false;
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

		public Boolean getErrors() {
			return errors;
		}

		public void setErrors(Boolean errors) {
			this.errors = errors;
		}
		
		
	
}
