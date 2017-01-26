package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class Forward. Does the forward function in the browser.
 * Inherits the ButtonEvent class abstract methods.
 */
public class Forward extends ButtonEvent {

	/** The combination. */
	private String name, event, combination;

	/**
	 * Instantiates a new forward.
	 */
	public Forward() {
		this.name = "forward";
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
			if ((xmlReader.getCombination("forward").equals("true"))) {
				if (evt.isPressed(xmlReader.getComboBtn())
						&& evt.wasPressed(xmlReader.getForwardBtn())) {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);

					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				}
			} else if ((xmlReader.getCombination("forward").equals("false"))) {
				if (!(evt.isPressed(xmlReader.getComboBtn()))
						&& evt.wasPressed(xmlReader.getForwardBtn())) {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);

					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				}
			}
		} else {
			if (evt.wasReleased(WRButtonEvent.RIGHT)
					&& evt.isPressed(WRButtonEvent.B)) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);

				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
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

		if (frame.getComboASelectedEvent().equals("Avançar")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals("Avançar")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals("Avançar")) {

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
