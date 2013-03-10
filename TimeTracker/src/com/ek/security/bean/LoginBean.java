package com.ek.security.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String username;
	private String password;

	public LoginBean() {
		// super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletRequest request = ((ServletRequest) context.getRequest());

		ServletResponse resposnse = ((ServletResponse) context.getResponse());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, resposnse);
		FacesContext.getCurrentInstance().responseComplete();
		// It's OK to return null here because Faces is just going to exit.
		return null;
	}
}
