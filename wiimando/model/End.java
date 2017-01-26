package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class End. Does the end function in the browser.
 * Inherits the ButtonEvent class abstract methods.
 */
public class End extends ButtonEvent {

	private String name, event, combination;

	/**
	 * Instantiates a new end.
	 */
	public End() {
		this.name = "end";
		this.event = "";
		this.combination = "";
	}
	
	public int getEvent() {
		return Integer.valueOf(event);
	}


	/**
	 * Associates a button or combination to this function.
	 */
	public void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader) {
		if (!xmlReader.getLastLoadedFile().equals("")) {
			if ((xmlReader.getCombination("end").equals("true"))) {
				if (evt.isPressed(xmlReader.getComboBtn())
						&& evt.wasPressed(xmlReader.getEndBtn())) {
					robot.keyPress(KeyEvent.VK_END);
					robot.keyRelease(KeyEvent.VK_END);
				}
			} else if ((xmlReader.getCombination("end").equals("false"))) {
				if (!(evt.isPressed(xmlReader.getComboBtn()))
						&& evt.wasPressed(xmlReader.getEndBtn())) {
					robot.keyPress(KeyEvent.VK_END);
					robot.keyRelease(KeyEvent.VK_END);
				}
			}

		} else {
			if (evt.wasReleased(WRButtonEvent.DOWN)
					&& evt.isPressed(WRButtonEvent.B)) {
				robot.keyPress(KeyEvent.VK_END);
				robot.keyRelease(KeyEvent.VK_END);
			}
		}
	}

	/**
	 * Saves the function name for the XML element.
	 */
	public String saveNameConfiguration() {

		return name;
	}

	/**
	 * Saves the button event for the XML element.
	 */
	public String saveEventConfiguration(MainFrame frame) {

		if (frame.getComboASelectedEvent().equals("End")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals("End")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "false";

		}

		return this.event;

	}

	/**
	 * Saves the function boolean value for the XML element. True for
	 * combination, false for simple button event.
	 */
	public String saveCombinationConfiguration() {
		return this.combination;
	}

}
