package wiimando.model;

import java.awt.Robot;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class ButtonEvent. Abstract class that has the handle button events
 * method and methods saving the configuration.
 */
public abstract class ButtonEvent {

	/**
	 * Handle button event.
	 * 
	 * @param evt
	 *            the evt
	 * @param robot
	 *            the robot
	 * @param xmlReader
	 *            the xml reader
	 */
	public abstract void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader);

	/**
	 * Save the function name configuration.
	 * 
	 * @return the string
	 */
	public abstract String saveNameConfiguration();

	/**
	 * Save the event data configuration.
	 * 
	 * @param frame
	 *            the frame
	 * 
	 * @return the string
	 */
	public abstract String saveEventConfiguration(MainFrame frame);

	/**
	 * Save combination boolean value configuration.
	 * 
	 * @return the string
	 */
	public abstract String saveCombinationConfiguration();
}
