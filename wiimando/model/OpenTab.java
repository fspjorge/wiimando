package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class OpenTab. Does the open tab function in the browser.
 * Inherits the ButtonEvent class abstract methods.
 */
public class OpenTab extends ButtonEvent {

	private String name, event, combination;

	/**
	 * Instantiates a new open tab.
	 */
	public OpenTab() {
		this.name = "open_tab";
		this.event = "";
		this.combination = "";
	}

	/**
	 * Associates a button or combination to this function.
	 */
	public void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader) {
		if (!xmlReader.getLastLoadedFile().equals("")) {
			if ((xmlReader.getCombination("open_tab").equals("true"))) {
				if (evt.isPressed(xmlReader.getComboBtn())
						&& evt.wasPressed(xmlReader.getOpenTabBtn())) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_T);

					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_T);
				}
			} else if ((xmlReader.getCombination("open_tab").equals("false"))) {
				if (!(evt.isPressed(xmlReader.getComboBtn()))
						&& evt.wasPressed(xmlReader.getOpenTabBtn())) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_T);

					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_T);
				}
			}
		} else {
			if (evt.wasReleased(WRButtonEvent.PLUS)
					&& evt.isPressed(WRButtonEvent.B)) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_T);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_T);
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

		if (frame.getComboASelectedEvent().equals("Abrir Separador")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals(
				"Abrir Separador")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals("Abrir Separador")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent()
				.equals("Abrir Separador")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals("Abrir Separador")) {

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
