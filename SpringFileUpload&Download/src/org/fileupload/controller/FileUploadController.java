package org.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.fileupload.dao.fileUploadDaoImpl;
import org.fileupload.model.FileUpload;
import org.fileupload.model.FileuploadVO;
import org.fileupload.service.fileUploadServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FileUploadController {	

	private Logger logger = Logger.getLogger(FileUploadController.class);
	//

	public FileUploadController()
	{
	
		logger.info("File Upload Controller Called : -");
	}
	
          
	 //angular js call
	@RequestMapping(value = "/Testupload.htm", method = RequestMethod.POST)
    public String SaveTestImage(
            @ModelAttribute("uploadForm") FileUpload uploadForm,
            Model map,HttpServletRequest request ) throws IllegalStateException, IOException {
		logger.info(" Upload method Called : -");
	
		System.out.println(request.getParameter("filename"));
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		
		fileUploadServiceImpl  service=(fileUploadServiceImpl) context.getBean("fileuploadService");
		
		
		fileUploadDaoImpl dao=(fileUploadDaoImpl) context.getBean("fileuploadDAO");
		
		
		//ResourceBundle rs =ResourceBundle.getBundle("test.properties");
		
		ResourceBundle rb = ResourceBundle.getBundle("resources/filePath");
		
		
		String saveDirectory = rb.getString("file.fileUploadPath");
 
        List<MultipartFile> listFiles = uploadForm.getFile();
 
        List<String> fileNames = new ArrayList<String>();
        int id =0;
        if (null != listFiles && listFiles.size() > 0) {
            for (MultipartFile multipartFile : listFiles) {
 
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile
                            .transferTo(new File(saveDirectory + fileName));
                    fileNames.add(fileName);
                   
                    uploadForm.setData(fileName.getBytes());
                    uploadForm.setIMAGE_NAME(fileName);
                 id=  service.SaveTestImage(uploadForm);
                   
                }
            }
            
        } 
       
        map.addAttribute("files", fileNames);
        map.addAttribute("ids", id+"");
        return "uploadfilesuccess";
    }
	 
	
	@RequestMapping(value = "/download.htm", method = RequestMethod.GET)
    public String download(  @RequestParam("id") String id,         
            Model map,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
	
		System.out.println("id is  : "+id);
		
WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		
		fileUploadServiceImpl  service=(fileUploadServiceImpl) context.getBean("fileuploadService");
		
		FileuploadVO f = service.downloadImg(id);
        response.setContentLength(f.getData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + f.getIMAGE_NAME() +"\"");
 
        FileCopyUtils.copy(f.getData(), response.getOutputStream());
 
        return null;

	}
	
	
	

	
	
	/*@RequestMapping(value = "/test.htm")
    public String test() throws IOException {
         
        //just throw exception to test the exceptionhandler mapping
        if(true) {
            throw new IOException("this is io exception");
        }
         
        // render index.jsp page
        return "index";
    }*/
}
