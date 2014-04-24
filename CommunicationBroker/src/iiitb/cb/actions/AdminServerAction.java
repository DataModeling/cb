package iiitb.cb.actions;

import iiitb.cb.models.Server;
import iiitb.cb.models.impl.ServerImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminServerAction extends ActionSupport implements ModelDriven<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 972756996116285110L;
	Server s = new Server();
	public void validate(){
		ServerImpl si = new ServerImpl();
		if(si.isSuffixAlreadyExists(s.getSuffix())){
			addFieldError("suffix", "Suffix Already Exists");
		}
	}
	
	public String execute(){
		ServerImpl si  = new ServerImpl();
		if(si.addServer(s)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public Server getS() {
		return s;
	}


	public void setS(Server s) {
		this.s = s;
	}

	@Override
	public Server getModel() {
		// TODO Auto-generated method stub
		return s;
	}

}
