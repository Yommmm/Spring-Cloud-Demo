package com.boot.entity;

public class ServiceParams extends RepositoryParams {

	private String repoName;
	
	private String repoVarName;

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public String getRepoVarName() {
		return repoVarName;
	}

	public void setRepoVarName(String repoVarName) {
		this.repoVarName = repoVarName;
	}
	
}
