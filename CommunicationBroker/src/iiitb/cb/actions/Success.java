package iiitb.cb.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Success extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 961775307235522569L;
	private List<String> countryList;

	public String makeCountryList() throws IOException {
		countryList = new ArrayList<String>();
		File f = new File("c:\\countries.txt");
		FileReader file = new FileReader(f);
		BufferedReader br = new BufferedReader(file);
		String temp = br.readLine();
		while (temp != null) {
			countryList.add(temp.toUpperCase());
			temp = br.readLine();
		}
		br.close();
		return SUCCESS;
	}

	public String success() {
		return SUCCESS;
	}

	public List<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}

}
