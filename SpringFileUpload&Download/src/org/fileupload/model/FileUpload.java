package org.fileupload.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="trnimage")
public class FileUpload {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "ID", unique = true, nullable = false)
	private int ID;
	 @Column(name = "DATA", unique = false, nullable = false, length = 100000)
	private byte[] data;
	@Column(name = "IMAGE_NAME", unique = false, nullable = false, length = 100)
	private String IMAGE_NAME;
	@Transient
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	
	
	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}

	public void setIMAGE_NAME(String iMAGE_NAME) {
		IMAGE_NAME = iMAGE_NAME;
	}
	@Transient
	 private List<MultipartFile> file;

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	
	 
}
