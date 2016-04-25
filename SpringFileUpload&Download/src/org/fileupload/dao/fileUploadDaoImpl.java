package org.fileupload.dao;

import org.fileupload.model.FileUpload;
import org.fileupload.model.FileuploadVO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class fileUploadDaoImpl  implements fileUploadDao{

	
	private HibernateTemplate template;
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	public fileUploadDaoImpl(HibernateTemplate template ) {
		this.template = template;
		//template.getSessionFactory().openSession().load("", "");
	}
	
	@Override
	public int saveImage1(FileuploadVO fileupload) {
	
		template.save(fileupload);
		
		return fileupload.getID();
	}
	public FileuploadVO downloadImg(String id)
	{
//		String  query = "select * from  trnimage where ID = ?";
		FileuploadVO file  = (FileuploadVO) template.getSessionFactory().openSession().load(FileuploadVO.class, new Integer(id));
		
		return file;
       /* try {
            FileuploadVO file = (FileuploadVO) jdbcTemplate.queryForObject(query, new Object[] {id},
                new RowMapper() {
            	FileuploadVO fl;
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        fl = new FileuploadVO();
                        fl.setID(rs.getInt(1));
                        fl.setData(rs.getBytes(5));
                        fl.setIMAGE_NAME(rs.getString(2));
                       
                        return fl;
                    }
            });
 
            return file;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return null;*/
	}

	@Override
	public int saveImage(FileuploadVO fileupload) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int SaveTestImage(FileUpload fileupload) {

		template.save(fileupload);
		
		return fileupload.getID();
	}
}
