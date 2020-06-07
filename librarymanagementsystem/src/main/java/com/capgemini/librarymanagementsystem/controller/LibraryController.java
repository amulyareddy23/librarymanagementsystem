package com.capgemini.librarymanagementsystem.controller;

import com.capgemini.librarymanagementsystem.database.LibraryDB;

public class LibraryController {
	public static void main(String[] args) {
		LibraryDB.addToDB();
		TestController.doReg();
	}
}
