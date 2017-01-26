package wiimando.model;

import java.awt.Robot;
import java.awt.event.InputEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class LeftClick. Does the left click function.
 * Inherits the ButtonEvent class abstract methods.
 */
public class LeftClick extends ButtonEvent {

	/** The combination. */
	private String name, event, combination;

	/**
	 * Instantiates a new left click.
	 */
	public LeftClick() {
		this.name = "left_click";
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
			if ((xmlReader.getCombination("left_click").equals("true"))) {
				if (evt.wasPressed(xmlReader.getLeftClickBtn())
						&& (evt.isPressed(xmlReader.getComboBtn()))) {
					robot.mousePress(InputEvent.BUTTON1_MASK);
				}
				if (evt.wasReleased(xmlReader.getLeftClickBtn())
						&& (evt.isPressed(xmlReader.getComboBtn()))) {
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
			} else if ((xmlReader.getCombination("left_click").equals("false"))) {
				if (evt.wasPressed(xmlReader.getLeftClickBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {
					robot.mousePress(InputEvent.BUTTON1_MASK);
				}
				if (evt.wasReleased(xmlReader.getLeftClickBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
			}
		} else {
			if (evt.wasReleased(WRButtonEvent.A)
					&& !(evt.isPressed(WRButtonEvent.B))) {
				if (evt.wasPressed(WRButtonEvent.A)
						&& (evt.isPressed(xmlReader.getComboBtn()))) {
					robot.mousePress(InputEvent.BUTTON1_MASK);
				}
				if (evt.wasReleased(WRButtonEvent.A)
						&& (evt.isPressed(WRButtonEvent.B))) {
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}
			}
		}
	}

	/**
	 * Saves the function name for the XML element.
	 */
	public String saveNameConfiguration() {

		return this.name;
	}

	/**
	 * Saves the button event for the XML element.
	 */
	public String saveEventConfiguration(MainFrame frame) {

		if (frame.getComboASelectedEvent().equals("Clique Esquerdo")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";
		} else if (frame.getComboAPlusSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals(
				"Clique Esquerdo")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";
		} else if (frame.getComboTwoSelectedEvent().equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";
		} else if (frame.getComboUpPlusSelectedEvent()
				.equals("Clique Esquerdo")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";
		} else if (frame.getComboUpSelectedEvent().equals("Clique Esquerdo")) {

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
