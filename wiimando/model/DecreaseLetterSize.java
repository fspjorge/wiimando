package wiimando.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class DecreaseLetterSize. Does the decrease letter size function in the
 * browser and minus in Windows. Inherits the ButtonEvent class abstract
 * methods.
 */
public class DecreaseLetterSize extends ButtonEvent {

	private String name, event, combination;

	/**
	 * Instantiates a new decrease letter size.
	 */
	public DecreaseLetterSize() {
		this.name = "decrease_letter_size";
		this.event = "";
		this.combination = "";
	}

	/**
	 * Associates a button or combination to this function.
	 */
	public void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader) {
		if (!xmlReader.getLastLoadedFile().equals("")) {
			if ((xmlReader.getCombination("decrease_letter_size")
					.equals("true"))) {
				if (evt.wasPressed(xmlReader.getDecreaseLetterSizeBtn())
						&& (evt.isPressed(xmlReader.getComboBtn()))) {

					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_MINUS);

					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_MINUS);

				}
			} else if ((xmlReader.getCombination("decrease_letter_size")
					.equals("false"))) {
				if (evt.wasPressed(xmlReader.getDecreaseLetterSizeBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {

					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_MINUS);

					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_MINUS);

				}
			}

		} else {
			if (evt.wasReleased(WRButtonEvent.MINUS)
					&& !(evt.isPressed(WRButtonEvent.B))) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_MINUS);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_MINUS);
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

		if (frame.getComboASelectedEvent().equals("Diminuir Tamanho do Texto")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals(
				"Diminuir Tamanho do Texto")) {

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
