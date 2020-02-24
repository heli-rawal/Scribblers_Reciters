package com.controller;

// Import required java libraries
import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.AuthorDescriptionBean;

public class AuthorDescriptionUploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		
		//System.out.println(request.getParameter("firstName")+" : "+request.getParameter("lastName"));
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;

		AuthorDescriptionBean authorDescription = new AuthorDescriptionBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("firstName")) {
						String value = fieldValue;
						student.setFirstName(value);
						System.out.println("FirstName : " + value);
					}
					if (fieldName.equalsIgnoreCase("lastName")) {
						String value = fieldValue;
						student.setLastName(value);
						System.out.println("LastName : " + value);
					}
					if (fieldName.equalsIgnoreCase("mobileNumber")) {
						String value = fieldValue;
						System.out.println("MobileNumber : " + value);
						student.setMobileNumber(value);
					}

					if (fieldName.equalsIgnoreCase("email")) {
						String value = fieldValue;
						student.setEmail(value);
						System.out.println("E-Mail : " + value);
					}

					
				}else {
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\WorkSpace(Manthan)\\KS(B)\\FileUpload\\WebContent\\Upload";
					file = new File(path + File.separator
							+ fileName);

					try {

						if (fileName.isEmpty()) {

							//Required Validations....
						} else {
							System.out.println("MIME : "+context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
											.equals("image/jpeg")
									|| context.getMimeType(fileName)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								student.setPhoto(file.getName());
								System.out.println("AuthorDescription Photo "+student.getPhoto());
								
								request.setAttribute("fileName", file.getName());
								request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("student.jsp").forward(request, response);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

}
