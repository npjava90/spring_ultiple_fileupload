package org.fileupload.service;

import org.fileupload.model.FileUpload;
import org.fileupload.model.FileuploadVO;

public interface fiileUploadService {

	
	public int saveImage(FileuploadVO fileupload);
	public int SaveTestImage(FileUpload fileupload);
	
	public FileuploadVO downloadImg(String id);
}
