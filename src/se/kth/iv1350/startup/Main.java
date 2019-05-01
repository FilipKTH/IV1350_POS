package se.kth.iv1350.startup;

import se.kth.iv1350.view.View;
import se.kth.iv1350.controller.Controller;

/**
 * @author Filip
 * Used as startup and gets called during initialization of the program
 */
public class Main {

	/***
	 * Initializes the program
	 * @param args The program does not support use of the CMD
	 */
	public static void main(String[] args) throws Exception{
		View view;
		Controller controller;

		controller = new Controller();
		view = new View(controller);
		view.run();
	}

}
