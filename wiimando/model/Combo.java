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

		if (frame.getComboASelectedEvent().equals("Combinação")) {
			this.combo = "WRButtonEvent.A";

		} else if (frame.getComboBSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.B";

		} else if (frame.getComboAPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.A";

		} else if (frame.getComboBPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.B";

		} else if (frame.getComboDownPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.DOWN";

		} else if (frame.getComboDownSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.DOWN";

		} else if (frame.getComboHomePlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.HOME";

		} else if (frame.getComboHomeSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.HOME";
		} else if (frame.getComboLeftPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.LEFT";

		} else if (frame.getComboLeftSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.LEFT";

		} else if (frame.getComboMinusPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.MINUS";

		} else if (frame.getComboMinusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.MINUS";

		} else if (frame.getComboOnePlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.ONE";

		} else if (frame.getComboOneSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.ONE";

		} else if (frame.getComboPlusPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.PLUS";

		} else if (frame.getComboPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.PLUS";

		} else if (frame.getComboRightPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.RIGHT";

		} else if (frame.getComboRightSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.RIGHT";

		} else if (frame.getComboTwoPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.TWO";

		} else if (frame.getComboTwoSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.TWO";

		} else if (frame.getComboUpPlusSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.UP";

		} else if (frame.getComboUpSelectedEvent().equals("Combinação")) {

			this.combo = "WRButtonEvent.UP";
		}

		return this.combo;

	}

}