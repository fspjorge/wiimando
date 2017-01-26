package wiimando.model;

import java.awt.Robot;

import wiimando.gui.MainFrame;
import wiiremotej.event.WRButtonEvent;

/**
 * The Class OpenBrowser. Opens the default browser with a user defined URL.
 * Inherits the ButtonEvent class abstract methods.
 */
public class OpenBrowser extends ButtonEvent {

	private String name, event, combination;

	/**
	 * Instantiates a new open browser.
	 */
	public OpenBrowser() {
		this.name = "open_browser";
		this.event = "";
		this.combination = "";

	}

	/**
	 * Associates a button or combination to this function.
	 */
	public void handleButtonEvent(WRButtonEvent evt, Robot robot,
			XMLReader xmlReader) {
		if (!xmlReader.getLastLoadedFile().equals("")) {
			if ((xmlReader.getCombination("open_browser").equals("false"))) {
				if (evt.wasPressed(xmlReader.getOpenBrowserBtn())
						&& !(evt.isPressed(xmlReader.getComboBtn()))) {

					if (!java.awt.Desktop.isDesktopSupported()) {

						System.err.println("Desktop is not supported (fatal)");
						System.exit(1);
					}

					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {

						System.err
								.println("Desktop doesn't support the browse action (fatal)");
						System.exit(1);
					}

					try {

						java.net.URI uri = new java.net.URI(xmlReader
								.getXMLUrl());
						desktop.browse(uri);
					} catch (Exception e) {

						System.err.println(e.getMessage());
					}
				}

			}
		} else {
			if (evt.wasReleased(WRButtonEvent.HOME)
					&& !(evt.isPressed(WRButtonEvent.B))) {
				if (!java.awt.Desktop.isDesktopSupported()) {

					System.err.println("Desktop is not supported (fatal)");
					System.exit(1);
				}

				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {

					System.err
							.println("Desktop doesn't support the browse action (fatal)");
					System.exit(1);
				}

				try {

					java.net.URI uri = new java.net.URI(xmlReader.getXMLUrl());
					desktop.browse(uri);
				} catch (Exception e) {

					System.err.println(e.getMessage());
				}
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

		if (frame.getComboASelectedEvent().equals("Abrir Página Inicial")) {
			this.event = "WRButtonEvent.A";
			this.combination = "false";

		} else if (frame.getComboBSelectedEvent()
				.equals("Abrir Página Inicial")) {

			this.event = "WRButtonEvent.B";
			this.combination = "false";

		} else if (frame.getComboAPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.A";
			this.combination = "true";

		} else if (frame.getComboBPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.B";
			this.combination = "true";

		} else if (frame.getComboDownPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "true";

		} else if (frame.getComboDownSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.DOWN";
			this.combination = "false";

		} else if (frame.getComboHomePlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "true";

		} else if (frame.getComboHomeSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.HOME";
			this.combination = "false";

		} else if (frame.getComboLeftPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "true";

		} else if (frame.getComboLeftSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.LEFT";
			this.combination = "false";

		} else if (frame.getComboMinusPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "true";

		} else if (frame.getComboMinusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.MINUS";
			this.combination = "false";

		} else if (frame.getComboOnePlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "true";

		} else if (frame.getComboOneSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.ONE";
			this.combination = "false";

		} else if (frame.getComboPlusPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "true";

		} else if (frame.getComboPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.PLUS";
			this.combination = "false";

		} else if (frame.getComboRightPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "true";

		} else if (frame.getComboRightSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.RIGHT";
			this.combination = "false";

		} else if (frame.getComboTwoPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboTwoSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.TWO";
			this.combination = "false";

		} else if (frame.getComboUpPlusSelectedEvent().equals(
				"Abrir Página Inicial")) {

			this.event = "WRButtonEvent.UP";
			this.combination = "true";

		} else if (frame.getComboUpSelectedEvent().equals(
				"Abrir Página Inicial")) {

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
