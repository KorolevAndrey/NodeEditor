package org.terifan.nodeeditor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import org.terifan.ui.Anchor;
import org.terifan.ui.TextBox;


public class NodeItem
{
	protected NodeBox mNodeBox;
	protected Connector[] mConnectors;

	protected String mName;
	protected Dimension mSize;
	protected final Rectangle mBounds;


	public NodeItem(String aName, Connector... aConnectors)
	{
		this(aName, 100, 20, aConnectors);

		mSize = new TextBox(mName).setMaxWidth(300).measure().getSize();
		mSize.width = Math.max(mSize.width, 100);
		mSize.height = Math.max(mSize.height, 20);
	}


	public NodeItem(String aName, int aWidth, int aHeight, Connector... aConnectors)
	{
		mName = aName;
		mSize = new Dimension(aWidth, aHeight);
		mConnectors = aConnectors;
		mBounds = new Rectangle();
	}


	public String getName()
	{
		return mName;
	}


	public void setName(String aName)
	{
		mName = aName;
	}


	public Dimension getSize()
	{
		return mSize;
	}


	public void setSize(Dimension aSize)
	{
		mSize = aSize;
	}


	protected void paintComponent(NodeEditorPane aEditorPane, Graphics2D aGraphics, boolean aHover, boolean aArmed)
	{
		new TextBox(mName).setBounds(mBounds).setAnchor(mConnectors.length == 0 || mConnectors[0].mDirection == Direction.IN ? Anchor.WEST : Anchor.EAST).setForeground(Styles.BOX_FOREGROUND_COLOR).render(aGraphics);
	}


	protected void mouseClicked(NodeEditorPane aEditorPane, Point aClickPoint)
	{
	}


	protected void mouseReleased(NodeEditorPane aEditorPane, Point aClickPoint)
	{
	}


	protected void mouseDragged(NodeEditorPane aEditorPane, Point aClickPoint, Point aDragPoint)
	{
	}
}
