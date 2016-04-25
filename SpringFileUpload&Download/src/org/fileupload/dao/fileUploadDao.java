package org.fileupload.dao;

import org.fileupload.model.FileUpload;
import org.fileupload.model.FileuploadVO;

public interface fileUploadDao {

	public int saveImage(FileuploadVO fileupload);
	public FileuploadVO downloadImg(String id);
	int saveImage1(FileuploadVO fileupload);
}
