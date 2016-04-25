package org.fileupload.service;

import org.fileupload.dao.fileUploadDaoImpl;
import org.fileupload.model.FileUpload;
import org.fileupload.model.FileuploadVO;
import org.springframework.beans.factory.annotation.Autowired;

public class fileUploadServiceImpl  implements fiileUploadService{

	
	@Autowired
	
	private fileUploadDaoImpl fileuploadDAO;
	
	
	


	@Override
	public int saveImage(FileuploadVO fileupload) {
		// TODO Auto-generated method stub
		return fileuploadDAO.saveImage(fileupload);
	}





	@Override
	public FileuploadVO downloadImg(String id) {
		// TODO Auto-generated method stub
		return fileuploadDAO.downloadImg(id);
	}





	@Override
	public int SaveTestImage(FileUpload fileupload) {
		// TODO Auto-generated method stub
		return fileuploadDAO.SaveTestImage(fileupload);
	}
	

}
