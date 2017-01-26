package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class Up. Does the up function in the browser and in Windows.
 * Inherits the ButtonEvent class abstract methods.
 */
public class Up extends ButtonEvent {

	private String name, event, combination;

	/**
	 * Instantiates a new up.
	 */
	public Up() {
		this.name = "up";
		this.event = "";
		this.combination = "";
	}
	
	/**
	 * Associates a button or combination to this function.
	 */
	public void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader) {
		if (!xmlReader.getLastLoadedFile().equals("")) {
			if ((xmlReader.getCombination("up").equals("true"))) {
				if (evt.isPressed(xmlReader.getUpBtn())
						&& evt.isPressed(xmlReader.getComboBtn())) {
					robot.keyPress(KeyEvent.VK_UP);
					robot.keyRelease(KeyEvent.VK_UP);
				}
			} else if ((xmlReader.getCombination("up").equals("false"))) {
				if (evt.isPressed(xmlReader.getUpBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {
					robot.keyPress(KeyEvent.VK_UP);
					robot.keyRelease(KeyEvent.VK_UP);
				}
			}
		} else {
			if (evt.wasReleased(WRButtonEvent.UP)
					&& !(evt.isPressed(WRButtonEvent.B))) {
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
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

		if (frame.getComboASelectedEvent().equals("Cima")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals("Cima")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals("Cima")) {

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