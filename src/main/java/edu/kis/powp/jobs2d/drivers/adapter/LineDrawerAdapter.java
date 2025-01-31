package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * driver adapter to drawer with several bugs.
 */

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
//public class DrawPanelControllerAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;
	private DrawPanelController drawController;

	public LineDrawerAdapter() {
		super();
		this.drawController = DrawerFeature.getDrawerController();
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getSpecialLine();
		line.setStartCoordinates(startX, startY);
		line.setEndCoordinates(x, y);
		this.setPosition(x,y);
		drawController.drawLine(line);
	}

	@Override
	public String toString() {
		return "LineControllerAdapter";
	}
}
