package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileUploadHandler")
public class FileUploadHandler extends HttpServlet {
	   private final String UPLOAD_DIRECTORY = "C:/uploads";
	   
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	      
	        //process only if its multipart content
	        if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List<FileItem> multiparts = new ServletFileUpload(
	                                         new DiskFileItemFactory()).parseRequest(request);
	              
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                        String name = new File(item.getName()).getName();
	                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	                    }
	                }
	           
	               //File uploaded successfully
	               request.setAttribute("message", "File Uploaded Successfully");
	            } catch (Exception ex) {
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }          
	         
	        }else{
	            request.setAttribute("message",
	                                 "Sorry this Servlet only handles file upload request");
	        }
	    
	        request.getRequestDispatcher("/result.jsp").forward(request, response);
	     
	    }
	  
	}


	