package com.app.controller;

public class TransactionController {
	private int txId;
	private String txName;

	public String toString() {
		return "TransactionController [txId=" + txId + ", txName=" + txName
				+ "]";
	}

	public TransactionController(int txId, String txName) {
		super();
		this.txId = txId;
		this.txName = txName;
	}

	public TransactionController() {
		super();
	}

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public String getTxName() {
		return txName;
	}

	public void setTxName(String txName) {
		this.txName = txName;
	}

}
