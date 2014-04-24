package iiitb.cb.actions;

import iiitb.cb.models.*;
import iiitb.cb.models.impl.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FTPFilesAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File userDoc;
	private String userDocContentType;
	private String userDocFileName;
	private String userDocFilePath;
	private List<FTP> fileList;
	
	public String execute(){
		
		FTPFilesImpl fi = new FTPFilesImpl();
		
		System.out.println(userDocFilePath);
		Map<String, Object> session = ActionContext.getContext().getSession();
		String email = (String)session.get("email");
		
		File fileToCreate = new File(userDocFilePath, this.userDocFileName);
		try {
			FileUtils.copyFile(this.userDoc, fileToCreate);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		FTP file = new FTP();
		file.setFilePath(userDocFilePath);
		file.setFileName(userDocFileName);
		file.setFileContentType(userDocContentType);
		
		fi.addFile(email, file);
		return SUCCESS;
	}
	
	public String getAllFiles(){
		FTPFilesImpl fi = new FTPFilesImpl();

		Map<String, Object> session = ActionContext.getContext().getSession();
		String email = (String)session.get("email");
	
		fileList  = new ArrayList<FTP>();
		
		fileList = fi.getAllFiles(email);
		
		
		return SUCCESS;
	}

	public File getUserDoc() {
		return userDoc;
	}

	public void setUserDoc(File userDoc) {
		this.userDoc = userDoc;
	}

	public String getUserDocContentType() {
		return userDocContentType;
	}

	public void setUserDocContentType(String userDocContentType) {
		this.userDocContentType = userDocContentType;
	}

	public String getUserDocFileName() {
		return userDocFileName;
	}

	public void setUserDocFileName(String userDocFileName) {
		this.userDocFileName = userDocFileName;
	}

	public String getUserDocFilePath() {
		return userDocFilePath;
	}

	public void setUserDocFilePath(String userDocFilePath) {
		this.userDocFilePath = userDocFilePath;
	}

	public List<FTP> getFileList() {
		return fileList;
	}

	public void setFileList(List<FTP> fileList) {
		this.fileList = fileList;
	}
	

	
}
