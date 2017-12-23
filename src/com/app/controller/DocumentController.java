package com.app.controller;

public class DocumentController {

	private int docid;
	private String docName;

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String toString() {
		return "DocumentController [docid=" + docid + ", docName=" + docName
				+ "]";
	}

	public DocumentController(int docid, String docName) {
		super();
		this.docid = docid;
		this.docName = docName;
	}

	public DocumentController() {
		super();
	}

}
