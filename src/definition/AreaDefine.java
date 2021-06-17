package definition;

import java.awt.Dimension;
import java.awt.Point;

import uml.Port;
import uml.item.Item;

public class AreaDefine {
    ///////////////////////////////////////////////////////
    //// WAITING FOR IMPLEMENT NOT A COMPLETE CODE YET ////
    ///////////////////////////////////////////////////////
	int					xMask		= 0x01;
	int					yMask		= 0x02;
	public final int	OUT_SIDE	= -1;
	public final int	TOP			= 3;
	public final int	RIGHT		= 2;
	public final int	LEFT		= 1;
	public final int	BOTTOM		= 0;

	public Port decidePort(Point rectLocat, Dimension rectSize, Point click, Item item)
	{
		if (click.x < rectLocat.x || click.y < rectLocat.y)
		{
			return null;
		}
		if (click.x > rectLocat.x + rectSize.width
				|| click.y > rectLocat.y + rectSize.height)
		{
			return null;
		}
		Dimension vx = new Dimension(rectSize.width, -rectSize.height);
		Dimension vy = new Dimension(rectSize.width, rectSize.height);
		Point center = new Point(rectLocat.x + rectSize.width / 2,
				rectLocat.y + rectSize.height / 2);
		Dimension vc = new Dimension(click.x - center.x, click.y - center.y);
		double x = vc.width * vx.height - vc.height * vx.width;
		double y = vc.width * vy.height - vc.height * vy.width;
		int result = 0;
		if (x >= 0.0)
		{
			result |= xMask;
		}
		if (y >= 0.0)
		{
			result |= yMask;
		}
		//result 3=top, 2=right, 0=bottom, 1=left

		switch (result)
		{
			case TOP:
				result -= 3;
				return item.getPorts()[result];
			case RIGHT:
				result -= 1;
				return item.getPorts()[result];
			case LEFT:
				result += 2;
				return item.getPorts()[result];
			case BOTTOM:
				result += 2;
				return item.getPorts()[result];
			default:
				return null;
		}
	}
}
