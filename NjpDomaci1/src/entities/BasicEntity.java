package entities;

import annotations.Column;
import annotations.Id;
import annotations.NotNull;
import annotations.PrimaryKey;
import annotations.SuperClass;
import annotations.Type;
import annotations.enumerators.FieldType;

@SuperClass
public abstract class BasicEntity{
	
	
	@Id
	@Column(name="id")
	@Type(name = FieldType.AUTO_INCREMENT, length = "0")
	@PrimaryKey
	@NotNull
	private String id;

	public BasicEntity() { this.id=""; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BasicEntity other = (BasicEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
