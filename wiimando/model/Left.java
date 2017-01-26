package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class Left. Moves left in the browser and in Windows.
 * Inherits the ButtonEvent class abstract methods.
 */
public class Left extends ButtonEvent {

	/** The combination. */
	private String name, event, combination;

	/**
	 * Instantiates a new left.
	 */
	public Left() {
		this.name = "left";
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
			if ((xmlReader.getCombination("left").equals("true"))) {
				if (evt.isPressed(xmlReader.getLeftBtn())
						&& evt.isPressed(xmlReader.getComboBtn())) {
					robot.keyPress(KeyEvent.VK_LEFT);
					robot.keyRelease(KeyEvent.VK_LEFT);
				}
			} else if ((xmlReader.getCombination("left").equals("false"))) {
				if (evt.isPressed(xmlReader.getLeftBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {
					robot.keyPress(KeyEvent.VK_LEFT);
					robot.keyRelease(KeyEvent.VK_LEFT);
				}
			}
		} else {
			if (evt.wasReleased(WRButtonEvent.LEFT)
					&& !(evt.isPressed(WRButtonEvent.B))) {
				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);
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

		if (frame.getComboASelectedEvent().equals("Esquerda")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals("Esquerda")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals("Esquerda")) {

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
