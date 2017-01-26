package wiimando.model;

import wiimando.gui.MainFrame;

/**
 * The Class Combo. Sets the button event used for combination with other
 * buttons.
 */
public class Combo {
	
	private String combo;

	/**
	 * Instantiates a new combo.
	 */
	public Combo() {
		this.combo = "";
	}

	/**
	 * Save combination configuration.
	 * 
	 * @param frame that saves the button configuration.
	 * 
	 * @return the button event string value.
	 */
	public String saveComboConfiguration(MainFrame frame) {

		if (frame.getComboASelectedEvent().equals("Combina��o")) {
			this.combo = "WRButtonEvent.A";

		} else if (frame.getComboBSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.B";

		} else if (frame.getComboAPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.A";

		} else if (frame.getComboBPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.B";

		} else if (frame.getComboDownPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.DOWN";

		} else if (frame.getComboDownSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.DOWN";

		} else if (frame.getComboHomePlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.HOME";

		} else if (frame.getComboHomeSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.HOME";
		} else if (frame.getComboLeftPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.LEFT";

		} else if (frame.getComboLeftSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.LEFT";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.MINUS";

		} else if (frame.getComboMinusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.MINUS";

		} else if (frame.getComboOnePlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.ONE";

		} else if (frame.getComboOneSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.ONE";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.PLUS";

		} else if (frame.getComboPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.PLUS";

		} else if (frame.getComboRightPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.RIGHT";

		} else if (frame.getComboRightSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.RIGHT";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.TWO";

		} else if (frame.getComboTwoSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.TWO";

		} else if (frame.getComboUpPlusSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.UP";

		} else if (frame.getComboUpSelectedEvent().equals("Combina��o")) {

			this.combo = "WRButtonEvent.UP";
		}

		return this.combo;

	}

}